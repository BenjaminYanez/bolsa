package ejerc161;

import java.util.ArrayList;

public class Principal extends javax.swing.JFrame {
    public ArrayList<Valores> valores = new ArrayList<Valores>();
    public ArrayList<Titulos> titulosUser = new ArrayList<Titulos>();
    public BolsaEnBd b = null;
    public InversorP ip1 = null;

    public Principal() {
        initComponents();
        lValor.setVisible( false );
        lCantidad.setVisible( false );
        valor.setVisible( false );
        valor.setEditable( false );
        cantidad.setVisible( false );
        comprar.setVisible( false );
        vender.setVisible( false );
        valorar.setVisible( false );
        resumirInversor.setVisible( false );
        titulosUsuario.setVisible( false );
        b = new BolsaEnBd();
        if ( b.iniciar() ) {
            titulos.removeAll();
            valores = b.leerValores();
            for( Valores v : valores ) {
                titulos.add( v + "\n" );
            }
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lUsuario = new javax.swing.JLabel();
        lClave = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        clave = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        valorar = new javax.swing.JButton();
        lCapital = new javax.swing.JLabel();
        lValor = new javax.swing.JLabel();
        capital = new javax.swing.JTextField();
        valor = new javax.swing.JTextField();
        comprar = new javax.swing.JButton();
        vender = new javax.swing.JButton();
        lCantidad = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        titulos = new java.awt.List();
        titulosUsuario = new java.awt.List();
        resumirBolsa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resumen = new javax.swing.JTextArea();
        resumirInversor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TITULOS");

        lUsuario.setText("Usuario: ");

        lClave.setText("Clave: ");

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        nuevo.setText("Nuevo Inversor");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        valorar.setText("Valorar");
        valorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorarActionPerformed(evt);
            }
        });

        lCapital.setText("Capital: ");

        lValor.setText("Valor Títulos: ");

        comprar.setText("Comprar");
        comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarActionPerformed(evt);
            }
        });

        vender.setText("Vender");
        vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderActionPerformed(evt);
            }
        });

        lCantidad.setText("Cantidad: ");

        titulos.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        titulos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                titulosItemStateChanged(evt);
            }
        });

        titulosUsuario.setFont(new java.awt.Font("Monospaced", 0, 12));
        titulosUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                titulosUsuarioItemStateChanged(evt);
            }
        });

        resumirBolsa.setText("Resumir");
        resumirBolsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumirBolsaActionPerformed(evt);
            }
        });

        resumen.setColumns(20);
        resumen.setRows(5);
        jScrollPane1.setViewportView(resumen);

        resumirInversor.setText("Resumir");
        resumirInversor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumirInversorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 426, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(titulos, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(actualizar)
                        .addGap(68, 68, 68)
                        .addComponent(resumirBolsa)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lValor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lClave)
                                                .addComponent(lUsuario)
                                                .addComponent(lCapital))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(capital, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(nuevo)
                                            .addGap(18, 18, 18)
                                            .addComponent(login)))
                                    .addGap(1, 1, 1)))
                            .addGap(0, 63, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(titulosUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(valorar)
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(resumirInversor)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(comprar)
                                    .addGap(18, 18, 18)
                                    .addComponent(vender)))
                            .addGap(42, 42, 42)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lUsuario)
                            .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lClave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lCapital)
                            .addComponent(capital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(login)
                            .addComponent(nuevo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lValor)
                            .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titulosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lCantidad)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorar)
                            .addComponent(vender)
                            .addComponent(comprar))
                        .addGap(18, 18, 18)
                        .addComponent(resumirInversor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(titulos, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(actualizar)
                            .addComponent(resumirBolsa))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        String passw = "";
        float nCapital = 0;
        for ( char s : clave.getPassword() ){
            passw += s;
        }
        if ( !usuario.getText().isEmpty() && !passw.isEmpty() ) {
            if ( !capital.getText().isEmpty() ) {
                nCapital = Float.parseFloat( capital.getText() );
            }
            b = new BolsaEnBd();
            if ( b.novo( usuario.getText(), passw, nCapital ) ) {
                ip1 = new InversorP( b );
                ip1.setBolsa( b );
                valor.setText(  Float.toString( ip1.valorar() ) );
                lValor.setVisible( true );
                valor.setVisible( true );
                lCantidad.setVisible( true );
                cantidad.setVisible( true );
                comprar.setVisible( true );
                vender.setVisible( true );
                valorar.setVisible( true );
                titulosUsuario.setVisible( true );
                titulosUser = ip1.leerTitulos();
                titulosUsuario.removeAll();
                for( Titulos t : titulosUser ) {
                    titulosUsuario.add( t + "\n" );
                }
                capital.setEditable( false );
                nuevo.setEnabled( false );
                login.setText( "Logout" );
                comprar.setEnabled( false );
                vender.setEnabled( false );
                resumirInversor.setVisible( true );
            }
        }
    }//GEN-LAST:event_nuevoActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String passw = "";
        String log = login.getText();
        if( log.equals( "Login" ) ) {
            for ( char s : clave.getPassword() ){
                passw += s;
            }
            if ( !usuario.getText().isEmpty() && !passw.isEmpty() ) {
                b = new BolsaEnBd();
                if ( b.identificar( usuario.getText(), passw ) ) {
                    ip1 = new InversorP( b );
                    ip1.setBolsa( b );
                    ip1.setLogin( usuario.getText() );
                    capital.setText( Float.toString( b.getCapital() ) );
                    valor.setText(  Float.toString( ip1.valorar() ) );
                    lValor.setVisible( true );
                    valor.setVisible( true );
                    lCantidad.setVisible( true );
                    cantidad.setVisible( true );
                    comprar.setVisible( true );
                    vender.setVisible( true );
                    valorar.setVisible( true );
                    nuevo.setEnabled( false );
                    titulosUsuario.setVisible( true );
                    titulosUser = ip1.leerTitulos();
                    titulosUsuario.removeAll();
                    for( Titulos t : titulosUser ) {
                        titulosUsuario.add( t + "\n" );
                    }
                    capital.setEditable( false );
                    login.setText( "Logout" );
                    comprar.setEnabled( false );
                    vender.setEnabled( false );
                    resumirInversor.setVisible( true );
                }
            }
        }
        else {
            titulosUser.removeAll( titulosUser );
            titulosUsuario.removeAll();
            lValor.setVisible( false );
            lCantidad.setVisible( false );
            valor.setVisible( false );
            valor.setEditable( false );
            cantidad.setVisible( false );
            comprar.setVisible( false );
            vender.setVisible( false );
            valorar.setVisible( false );
            usuario.setText( "" );
            clave.setText( "" );
            capital.setText( "" );
            titulosUsuario.setVisible( false );
            capital.setEditable( true );
            nuevo.setEnabled( true );
            login.setText( "Login" );
            resumen.setText( "" );
        }
    }//GEN-LAST:event_loginActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        if ( b.actualizar() ) {
            valores.removeAll( valores );
            titulos.removeAll();
            valores = b.leerValores();
            for( Valores v : valores ) {
                titulos.add( v + "\n" );
            }
            valor.setText(  Float.toString( ip1.valorar() ) );
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarActionPerformed
        int indice = titulos.getSelectedIndex();
        if ( !cantidad.getText().isEmpty() && indice >= 0 ) {
            int cant = Integer.parseInt( cantidad.getText() );
            Valores v = valores.get( indice );
            if ( indice >= 0 && cant > 0 ) {
                ip1.comprar( v.getId(), cant );
                titulosUser.removeAll( titulosUser );
                titulosUser = ip1.leerTitulos();
                titulosUsuario.removeAll();
                for( Titulos t : titulosUser ) {
                    titulosUsuario.add( t + "\n" );
                }
                valor.setText(  Float.toString( ip1.valorar() ) );
                capital.setText( Float.toString( b.getCapital() ) );
                cantidad.setText( null );
            }
        }
    }//GEN-LAST:event_comprarActionPerformed

    private void venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderActionPerformed
        int indice = titulosUsuario.getSelectedIndex();
        if ( !cantidad.getText().isEmpty() && indice >= 0 ) {
            int cant = Integer.parseInt( cantidad.getText() );
            Titulos t = titulosUser.get( indice );
            if ( indice >= 0 && cant > 0 ) {
                ip1.vender( t.getId_valor(), cant );
                titulosUser.removeAll( titulosUser );
                titulosUser = ip1.leerTitulos();
                titulosUsuario.removeAll();
                for( Titulos t1 : titulosUser ) {
                    titulosUsuario.add( t1 + "\n" );
                }
                valor.setText(  Float.toString( ip1.valorar() ) );
                capital.setText( Float.toString( b.getCapital() ) );
                cantidad.setText( null );
            }
        }
    }//GEN-LAST:event_venderActionPerformed

    private void valorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorarActionPerformed
        valor.setText(  Float.toString( ip1.valorar() ) );
    }//GEN-LAST:event_valorarActionPerformed

    private void titulosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_titulosItemStateChanged
        if ( titulos.getSelectedIndex() >= 0 ) {
            titulosUsuario.select( -1 );
            comprar.setEnabled( true );
            vender.setEnabled( false );
        }
    }//GEN-LAST:event_titulosItemStateChanged

    private void titulosUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_titulosUsuarioItemStateChanged
        if ( titulosUsuario.getSelectedIndex() >= 0 ) {
            titulos.select( -1 );
            comprar.setEnabled( false );
            vender.setEnabled( true );
        }
    }//GEN-LAST:event_titulosUsuarioItemStateChanged

    private void resumirBolsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumirBolsaActionPerformed
        resumen.append( b.resumir() + "\n" );
    }//GEN-LAST:event_resumirBolsaActionPerformed

    private void resumirInversorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumirInversorActionPerformed
        resumen.append( ip1.resumir() + "  Valor Títulos: " + valor.getText() + "\n" );
    }//GEN-LAST:event_resumirInversorActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField capital;
    private javax.swing.JPasswordField clave;
    private javax.swing.JButton comprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCantidad;
    private javax.swing.JLabel lCapital;
    private javax.swing.JLabel lClave;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JLabel lValor;
    private javax.swing.JButton login;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextArea resumen;
    private javax.swing.JButton resumirBolsa;
    private javax.swing.JButton resumirInversor;
    private java.awt.List titulos;
    private java.awt.List titulosUsuario;
    private javax.swing.JTextField usuario;
    private javax.swing.JTextField valor;
    private javax.swing.JButton valorar;
    private javax.swing.JButton vender;
    // End of variables declaration//GEN-END:variables
}
