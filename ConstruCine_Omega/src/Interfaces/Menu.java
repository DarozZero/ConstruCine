/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 *
 * @author studi
 */
public final class Menu extends javax.swing.JFrame {
    public int cantidadBoletos=0;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        super.setTitle("Omega");
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        AgregarAComboboxPelicula();
    }

    void Activar() {
        jRadioButtonEfectivo.setEnabled(true);
        jTextFieldCantidadDeBoletos.setEnabled(true);
        jButtonContinuar.setEnabled(true);
    }

    void AgregarAComboboxPelicula() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        modelo.addElement("Viernes 13");
        modelo.addElement("La masacre en texas 3");
        modelo.addElement("Cars 3");
        modelo.addElement("Spider-Man");
        modelo.addElement("Batman");

        jComboBoxPeliculas.setModel(modelo);

    }

    void seleccionPelicula() {
        int combo;
        combo = jComboBoxPeliculas.getSelectedIndex();
        if (combo == 1 || combo == 2 || combo == 3 || combo == 4 || combo == 5) {
            Activar();
        } else {
            jRadioButtonEfectivo.setEnabled(false);
            jTextFieldCantidadDeBoletos.setEnabled(false);
            jButtonContinuar.setEnabled(false);
        }
    }

    void caratulas() {
        int combo;
        combo = jComboBoxPeliculas.getSelectedIndex();
        switch (combo) {
            case 0: {
                ImageIcon i = new ImageIcon("");
                jLabelPelicula.setIcon(i);
                break;
            }
            case 1: {
                LimCantidad();
                ImageIcon i = new ImageIcon("src\\Imagenes\\Viernes13.jpg");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione");
                modelo.addElement("4:00 pm");
                modelo.addElement("6:00 pm");
                modelo.addElement("8:00 pm");
                jComboBoxHora.setModel(modelo);
                break;
            }
            case 2: {
                LimCantidad();
                ImageIcon i = new ImageIcon("src\\Imagenes\\masacre.jpg");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione");
                modelo.addElement("5:00 pm");
                modelo.addElement("7:00 pm");
                modelo.addElement("9:00 pm");
                jComboBoxHora.setModel(modelo);
                break;
            }
            case 3: {
                LimCantidad();
                ImageIcon i = new ImageIcon("src\\Imagenes\\cars.jpg");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione");
                modelo.addElement("12:00 pm");
                modelo.addElement("2:00 pm");
                modelo.addElement("4:00 pm");
                jComboBoxHora.setModel(modelo);
                break;
            }
            case 4: {
                LimCantidad();
                ImageIcon i = new ImageIcon("src\\Imagenes\\spider.jpg");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione");
                modelo.addElement("1:00 pm");
                modelo.addElement("3:00 pm");
                modelo.addElement("6:30 pm");
                jComboBoxHora.setModel(modelo);
                break;
            }
            case 5: {
                LimCantidad();
                ImageIcon i = new ImageIcon("src\\Imagenes\\bat.png");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione");
                modelo.addElement("2:00 pm");
                modelo.addElement("5:00 pm");
                modelo.addElement("8:00 pm");
                jComboBoxHora.setModel(modelo);
                break;
            }
            default:
                break;
        }
    }

    void LimCantidad() {
        jTextFieldCantidadDeBoletos.setText("");
    }

    void limpiar() {
        ImageIcon i = new ImageIcon("");
        jLabelPelicula.setIcon(i);
        jTextFieldCantidadDeBoletos.setText("");
        buttonGroup1.clearSelection();
        jComboBoxPeliculas.removeAllItems();
        jComboBoxHora.removeAllItems();
    }

    void calculo() {
        int precio = 60;
        int Total = 0;

        if ("".equals(jTextFieldCantidadDeBoletos.getText())) {
            jTextFieldCantidadDeBoletos.setText("");
        } else {
            cantidadBoletos = Integer.parseInt(jTextFieldCantidadDeBoletos.getText());
        }
        Total = cantidadBoletos*precio;

    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jComboBoxPeliculas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxHora = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCantidadDeBoletos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jRadioButtonEfectivo = new javax.swing.JRadioButton();
        jButtonContinuar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelPelicula = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(233, 119, 19));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ELIGA SU PELICULA");
        jPanel3.add(jLabel1);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 253, 253));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setForeground(new java.awt.Color(255, 255, 102));

        jComboBoxPeliculas.setBackground(new java.awt.Color(246, 247, 247));
        jComboBoxPeliculas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPeliculasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Peliculas");

        jComboBoxHora.setBackground(new java.awt.Color(246, 247, 247));
        jComboBoxHora.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Hora");

        jPanel1.setBackground(new java.awt.Color(246, 247, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel12.setText("Cantidad:");

        jTextFieldCantidadDeBoletos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadDeBoletosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Forma de pago:");

        jPanel5.setBackground(new java.awt.Color(246, 247, 247));

        jRadioButtonEfectivo.setBackground(new java.awt.Color(255, 102, 0));
        buttonGroup1.add(jRadioButtonEfectivo);
        jRadioButtonEfectivo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jRadioButtonEfectivo.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonEfectivo.setText("Efectivo");
        jRadioButtonEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEfectivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jRadioButtonEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jRadioButtonEfectivo)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jButtonContinuar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButtonContinuar.setText("CONTINUAR");
        jButtonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContinuarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel5.setText("Adultos y niños:");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("PRECIOS");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel17.setText("$60");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setText("BOLETOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(298, 298, 298))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldCantidadDeBoletos)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(288, 288, 288))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonContinuar)
                        .addGap(84, 84, 84))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonContinuar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jTextFieldCantidadDeBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jLabelPelicula.setBackground(new java.awt.Color(246, 247, 247));
        jLabelPelicula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabelPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, java.awt.BorderLayout.LINE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPeliculasActionPerformed
        seleccionPelicula();
        caratulas();
    }//GEN-LAST:event_jComboBoxPeliculasActionPerformed

    private void jButtonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContinuarActionPerformed
        Ticket tiket = new Ticket();
        System.out.println("list0o0o");
        
    }//GEN-LAST:event_jButtonContinuarActionPerformed

    private void jTextFieldCantidadDeBoletosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosActionPerformed

    private void jRadioButtonEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonEfectivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonContinuar;
    public static javax.swing.JComboBox<String> jComboBoxHora;
    public static javax.swing.JComboBox<String> jComboBoxPeliculas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabelPelicula;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JRadioButton jRadioButtonEfectivo;
    public static javax.swing.JTextField jTextFieldCantidadDeBoletos;
    // End of variables declaration//GEN-END:variables
}
