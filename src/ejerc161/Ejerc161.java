package ejerc161;

import static ejerc161.BolsaEnBd.connection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

interface Bolsa {
    boolean iniciar();
    boolean actualizar();
    boolean novo( String login, String clave, float capital );
    boolean identificar( String login, String clave );
}

interface Inversor {
    boolean comprar( int id, int cantidade );
    boolean vender( int id, int cantidade );
    float valorar();
}

interface Resumible {
    String resumir();
}

class BolsaEnBd implements Bolsa, Resumible {
    private String login;
    private String clave;
    private float capital;
    static Connection connection;
    private PreparedStatement psAñadirInversor = null;
    private ArrayList<Valores> valores = new ArrayList<Valores>();

    public String resumir() {
        String datos = "Resumen Bolsa" + "\n";
        try {
            Statement consulta = connection.createStatement();
            ResultSet resultado = consulta.executeQuery( "SELECT IFNULL(count(*), 0) as total FROM usuarios" );
            if ( resultado.next() ) {
                datos += "Usuarios: " + Integer.toString( resultado.getInt( "total" ) );
            }
            resultado = consulta.executeQuery( "SELECT IFNULL(count(*), 0) as total, IFNULL(sum(cantidade),0) as totcantidad FROM usuarios_valores" );
            if ( resultado.next() ) {
                datos += "  Acciones: " + Integer.toString( resultado.getInt( "total" ) );
                datos += "  Títulos: " + Integer.toString( resultado.getInt( "totcantidad" ) );
            }
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D." );
        }
        return datos;
    }

    public float getCapital() {
        return capital;
    }

    public void setCapital( float capital ) {
        this.capital = capital;
    }

    public String getClave() {
        return clave;
    }

    public void setClave( String clave ) {
        this.clave = clave;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public Connection getConnection() {
        return this.connection;
    }
    
    public boolean iniciar() {
        boolean conexion = false;
        try {
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3307/bolsa", "root", "root" );
            conexion = true;
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D. 1" );
            conexion = false;
        }
        return conexion; 
    }

    public ArrayList<Valores> leerValores() {
        try {
            Statement consulta = connection.createStatement();
            ResultSet resultado = consulta.executeQuery( "SELECT * FROM valores" );
            while ( resultado.next() ) {
                Valores v = new Valores( resultado.getInt( "id" ), resultado.getString( "nome" ), resultado.getFloat( "prezo" ) );
                valores.add( v );
            }
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D." );
        }
        return valores;
    }

    public boolean actualizar() {
        boolean actualiza = false;
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE valores SET prezo = prezo * ?");
            ps.setDouble(1 , 1 + ( Math.random()*10/100 ) - ( Math.random()*10/100 ) );
            ps.executeUpdate();
/*            if ( this.iniciar() ) {
                actualiza = true; 
            }
            else {
                actualiza = false; 
            } */
            actualiza = true;
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D." );
        }
        return actualiza; 
    }

    public boolean novo( String login, String clave, float capital ) {
        boolean añadido = false;
        if ( !identificar( login ) ) {
            try {
                PreparedStatement psAñadirInversor = connection.prepareStatement("INSERT INTO usuarios( login, clave, capital ) VALUES ( ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);    
                psAñadirInversor.setString( 1, login );
                psAñadirInversor.setString( 2, clave );
                psAñadirInversor.setFloat( 3, capital );
                int filas = psAñadirInversor.executeUpdate();
                if ( filas > 0 ) {
                    this.setLogin( login );
                    this.setClave( clave );
                    this.setCapital( capital );
                    añadido = true;
                }

            } catch (SQLException ex) {
                System.out.println( "Error conexión a B.D. 2" );
            }
        }
        else {
            System.out.println( "El Inversor ya existe" );
        }
        return añadido; 
    }

    public boolean identificar( String login, String clave ) {
        boolean existe = false;
        try {
            Statement consulta = connection.createStatement();
            ResultSet resultado = consulta.executeQuery( "SELECT * FROM usuarios WHERE login='" + login + "' and clave='" + clave + "'" );
            if ( resultado.next() ) {
                this.setLogin( login );
                this.setClave( clave );
                this.setCapital( resultado.getFloat( "capital" ) );
                existe = true;
            }
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D. 3" );
        }
        return existe; 
    }

    public boolean identificar( String login ) {
        boolean existe = false;
        try {
            Statement consulta = connection.createStatement();
            ResultSet resultado = consulta.executeQuery( "SELECT * FROM usuarios WHERE login='" + login + "'" );
            if ( resultado.next() ) {
                existe = true;
            }
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D. 3" );
        }
        return existe; 
    }

}

class InversorP implements Inversor, Resumible {
    private String login;
    private BolsaEnBd bolsa;
    private ArrayList<Titulos> titulosUser = new ArrayList<Titulos>();
    //static Connection connection = null;
    static PreparedStatement psAñadirValor = null;
    static PreparedStatement psModificarValor = null;
    static PreparedStatement psModificarCapital = null;
    static PreparedStatement psValorar = null;
    static PreparedStatement psTitulos = null;

    public InversorP( BolsaEnBd b ) {
        try {
            connection = b.getConnection();
            psAñadirValor = connection.prepareStatement( "INSERT INTO usuarios_valores( login, id_valor, cantidade ) VALUES( ?, ?, ? )", Statement.RETURN_GENERATED_KEYS );
            psModificarValor = connection.prepareStatement( "UPDATE usuarios_valores set cantidade=? where login=? and id_valor=?" );
            psModificarCapital = connection.prepareStatement( "UPDATE usuarios SET capital=capital + ? WHERE login=?" );
            psValorar = connection.prepareStatement( "SELECT SUM( cantidade*prezo ) AS total FROM valores INNER JOIN usuarios_valores on id=id_valor WHERE login=?" );
            psTitulos = connection.prepareStatement( "SELECT * FROM usuarios_valores WHERE login=?" );
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D. 4" );
        } 
    }

    public String resumir() {
        String datos = "Resumen Inversor" + "\n";
        try {
            Statement consulta = connection.createStatement();
            ResultSet resultado = consulta.executeQuery( "SELECT login,capital FROM usuarios" );
            if ( resultado.next() ) {
                datos += "Login: " + resultado.getString( "login" ) + "   Capital: " + Float.toString( resultado.getFloat( "capital" ) );
            }
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D." );
        }
        return datos;
    }

    public BolsaEnBd getBolsa() {
        return bolsa;
    }

    public void setBolsa( BolsaEnBd bolsa ) {
        this.bolsa = bolsa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login  ) {
        this.login = login;
    }

    public boolean comprar( int id, int cantidade ) {
        String idUsuario = this.getLogin();
        try {
            Statement consulta = connection.createStatement();
            ResultSet resultado = consulta.executeQuery( "SELECT prezo FROM valores WHERE id=" + id );
            if ( resultado.next() ) {
                float capital = resultado.getFloat( "prezo" ) * cantidade * -1;
                ResultSet resultado1 = consulta.executeQuery( "SELECT cantidade FROM usuarios_valores WHERE login='" + idUsuario + "' and id_valor=" + id );
                if ( !resultado1.next() ) {
                    psAñadirValor.setString( 1, idUsuario );
                    psAñadirValor.setInt( 2, id );
                    psAñadirValor.setInt( 3, cantidade );
                    int filas = psAñadirValor.executeUpdate();
                }
                else {
                    psModificarValor.setInt( 1, resultado1.getInt( "cantidade" ) + cantidade );
                    psModificarValor.setString( 2, idUsuario );
                    psModificarValor.setInt( 3, id );
                    int filas = psModificarValor.executeUpdate();
                }
                psModificarCapital.setFloat( 1, capital );
                psModificarCapital.setString( 2, idUsuario );
                int filas = psModificarCapital.executeUpdate();
                this.bolsa.setCapital( this.bolsa.getCapital() + capital );
            }
            else {
                System.out.println( "No existe el valor" );
            }
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D. 5" );
        }
        
        return true;
    }
    
    public boolean vender( int id, int cant ) {
        String idUsuario = this.getLogin();
        float prezo = 0;
        try {
            Statement consulta = connection.createStatement();
            ResultSet resultado = consulta.executeQuery( "SELECT prezo FROM valores WHERE id=" + id );
            if ( resultado.next() ) {
                prezo = resultado.getFloat( "prezo" );
                ResultSet resultado1 = consulta.executeQuery( "SELECT cantidade FROM usuarios_valores WHERE login='" + idUsuario + "' and id_valor=" + id );
                if ( resultado1.next() ) {
                    if ( resultado1.getInt( "cantidade" ) <= cant ) {
                        cant = resultado1.getInt( "cantidade" );
                        int filas = consulta.executeUpdate( "DELETE FROM usuarios_valores WHERE login='" + idUsuario + "' and id_valor=" + id );
                    }
                    else {
                        psModificarValor.setInt( 1, resultado1.getInt( "cantidade" ) - cant );
                        psModificarValor.setString( 2, idUsuario );
                        psModificarValor.setInt( 3, id );
                        int filas = psModificarValor.executeUpdate();
                    }
                    float capital = prezo * cant;
                    psModificarCapital.setFloat( 1, capital );
                    psModificarCapital.setString( 2, idUsuario );
                    int filas = psModificarCapital.executeUpdate();
                    this.bolsa.setCapital( this.bolsa.getCapital() + capital );
                }
                else {
                    System.out.println( "El Inversor no posee el valor" );
                }
            }
            else {
                System.out.println( "No existe el valor" );
            }
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D. vender" );
        }
        return true;
    }

    public float valorar() {
        String idUsuario = this.getLogin();
        float valor = 0;
        try {
//            Statement consulta = connection.createStatement();
            psValorar.setString( 1, this.getLogin() );
            ResultSet resultado = psValorar.executeQuery();
            if ( resultado.next() ) {
                valor = resultado.getFloat( "total" );
            }
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D." );
        }
        return valor;
    }

    public ArrayList<Titulos> leerTitulos() {
        try {
            Statement consulta = connection.createStatement();
            ResultSet resultado = consulta.executeQuery( "SELECT valores.nome, usuarios_valores.* FROM valores INNER JOIN usuarios_valores on id=id_valor WHERE login='" + this.getLogin() + "'" );
            while ( resultado.next() ) {
                Titulos t = new Titulos( resultado.getString( "login" ), resultado.getString( "nome" ), resultado.getInt( "id_valor" ), resultado.getInt( "cantidade" ) );
                titulosUser.add( t );
            }
        } catch (SQLException ex) {
            System.out.println( "Error conexión a B.D." );
        }
        return titulosUser;
    }
}

class Valores {
    private int id;
    private String nome;
    private float prezo;

    public Valores( int id, String nome, float prezo ) {
        this.id = id;
        this.nome = nome;
        this.prezo = prezo;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public float getPrezo() {
        return prezo;
    }

    public void setPrezo( float prezo ) {
        this.prezo = prezo;
    }

    @Override
    public String toString(){
        String nomeValor = this.nome.trim();
        int lg = nomeValor.length();
        if ( lg > 20 ) {
            nomeValor = this.nome.substring( 0, 20 );
        }
        String rellena = "";
        for ( int i=lg; i<25; i++ ) {
            rellena += " ";
        }
        return this.nome.trim() + rellena + "Cotización: " + Float.toString( this.prezo );
    }
}

class Titulos {
    String login;
    String nome;
    int id_valor;
    int cantidade;

    public Titulos( String login, String nome, int id_valor, int cantidade ) {
        this.login = login;
        this.nome= nome;
        this.id_valor = id_valor;
        this.cantidade = cantidade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_valor() {
        return id_valor;
    }

    public void setId_valor(int id_valor) {
        this.id_valor = id_valor;
    }

    public int getCantidade() {
        return cantidade;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }

    @Override
    public String toString(){
        String nomeTitulo = this.nome.trim();
        int lg = nomeTitulo.length();
        if ( lg > 20 ) {
            nomeTitulo = this.nome.substring( 0, 20 );
        }
        String rellena = "";
        for ( int i=lg; i<25; i++ ) {
            rellena += " ";
        }
        return this.nome.trim() + rellena + "Cantidade: " + Integer.toString( this.cantidade );
    }
}