/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Funcionalidad.ProcesadorPeliculas;
import Funcionalidad.ProcesadorSalas;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author studi
 */
public final class Cartelera extends javax.swing.JFrame {
   private int cantidadBoletos=0;
   private ArrayList<String[]> pelis;
   private ArrayList<String[]> salas;
    /**
     * Creates new form Menu
     */
    public Cartelera() {
        ProcesadorPeliculas peliculasPro = new ProcesadorPeliculas("peliculas.txt");
        peliculasPro.procesar();
        ProcesadorSalas salasPro = new ProcesadorSalas("salas.txt");
        salasPro.procesar();
        pelis = peliculasPro.getInfoOrdenada();
        salas = salasPro.getInfoOrdenada();
        initComponents();
        super.setTitle("Omega");
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        AgregarAComboboxPelicula();
    }

    void Activar() {
        boletosCant.setEnabled(true);
        jButtonContinuar.setEnabled(true);
    }

    void AgregarAComboboxPelicula() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        for(int i=0;i<pelis.size();i++){
            modelo.addElement(pelis.get(i)[1]);
        }
        
        jComboBoxPeliculas.setModel(modelo);

    }

    void seleccionPelicula() {
        int combo;
        combo = jComboBoxPeliculas.getSelectedIndex();
        if (combo == 1 || combo == 2 || combo == 3 || combo == 4 || combo == 5 || combo == 6) {
            Activar();
        } else {
            boletosCant.setEnabled(false);
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
                ImageIcon i = new ImageIcon("src"+File.separator+"Imagenes"+File.separator+"peli1.jpg");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo;
                modelo = asignaHorarios(1);
                jComboBoxHora.setModel(modelo);
                labelLenguaje.setText(pelis.get(combo-1)[3]);
                break;
            }
            case 2: {
                LimCantidad();
                ImageIcon i = new ImageIcon("src"+File.separator+"Imagenes"+File.separator+"peli2.jpg");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo;
                modelo = asignaHorarios(2);
                jComboBoxHora.setModel(modelo);
                labelLenguaje.setText(pelis.get(combo-1)[3]);
                break;
            }
            case 3: {
                LimCantidad();
                ImageIcon i = new ImageIcon("src"+File.separator+"Imagenes"+File.separator+"peli3.jpg");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo;
                modelo = asignaHorarios(3);
                jComboBoxHora.setModel(modelo);
                labelLenguaje.setText(pelis.get(combo-1)[3]);
                break;
            }
            case 4: {
                LimCantidad();
                ImageIcon i = new ImageIcon("src"+File.separator+"Imagenes"+File.separator+"peli4.jpg");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo;
                modelo = asignaHorarios(4);
                jComboBoxHora.setModel(modelo);
                labelLenguaje.setText(pelis.get(combo-1)[3]);
                break;
            }
            case 5: {
                LimCantidad();
                ImageIcon i = new ImageIcon("src"+File.separator+"Imagenes"+File.separator+"peli5.jpg");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo;
               modelo = asignaHorarios(5);
                jComboBoxHora.setModel(modelo);
                labelLenguaje.setText(pelis.get(combo-1)[3]);
                break;
            }
             case 6: {
                LimCantidad();
                ImageIcon i = new ImageIcon("src"+File.separator+"Imagenes"+File.separator+"peli6.jpg");
                jLabelPelicula.setIcon(i);
                DefaultComboBoxModel modelo;
                modelo = asignaHorarios(6);
                jComboBoxHora.setModel(modelo);
                labelLenguaje.setText(pelis.get(combo-1)[3]);
                break;
            }
            default:
                break;
        }
    }

    void LimCantidad() {
        boletosCant.setText("");
    }

    void limpiar() {
        ImageIcon i = new ImageIcon("");
        jLabelPelicula.setIcon(i);
        boletosCant.setText("");
        buttonGroup1.clearSelection();
        jComboBoxPeliculas.removeAllItems();
        jComboBoxHora.removeAllItems();
    }
    

    void calculo() {
        int precio = 60;
        int Total = 0;

        if ("".equals(boletosCant.getText())) {
            boletosCant.setText("");
        } else {
            cantidadBoletos = Integer.parseInt(boletosCant.getText());
        }
        Total = cantidadBoletos*precio;

    }

    private DefaultComboBoxModel asignaHorarios(int peli){
        DefaultComboBoxModel horarios = new DefaultComboBoxModel();
         horarios.addElement("Seleccione");
         for(int i=0; i<salas.size();i++){
             if(peli == Integer.parseInt(salas.get(i)[2])){
                  horarios.addElement(salas.get(i)[1] + ", Sala "+ salas.get(i)[0]);
             }
         }
        return horarios;
    }
    
    private boolean AsignarBoletos(){
        String entrada= boletosCant.getText();
        try{
            Integer.parseInt(entrada);
            cantidadBoletos = Integer.parseInt(entrada);
            return cantidadBoletos < 9 && cantidadBoletos > 0;
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error al ingresar cantidad de boletos (La cantidad maxima son 8)");
            return false;
        }
    }
    private String rutaAsientos(int pelicula, String horario){
        String resultado = null;
        for(int i=0; i<salas.size();i++){
            if ( pelicula == Integer.parseInt(salas.get(i)[2])){
                if(salas.get(i)[1].equals(horario)){
                    resultado = "Sala"+salas.get(i)[0]; 
                return resultado;
                }
            }
        }
        return resultado;
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
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        boletosCant = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButtonContinuar = new javax.swing.JButton();
        jLabelPelicula = new javax.swing.JLabel();
        labelLenguaje = new javax.swing.JLabel();
        labelLenguaje1 = new javax.swing.JLabel();
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

        jPanel5.setBackground(new java.awt.Color(246, 247, 247));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel12.setText("Cantidad:");

        boletosCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        boletosCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boletosCantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(boletosCant, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(boletosCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel5.setText("Adultos y niños:");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("PRECIOS");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel17.setText("$60");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setText("BOLETOS");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cine Omega");

        jButtonContinuar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButtonContinuar.setText("CONTINUAR");
        jButtonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(195, 195, 195)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(106, 106, 106))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(jButtonContinuar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(15, 15, 15)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabelPelicula.setBackground(new java.awt.Color(246, 247, 247));
        jLabelPelicula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        labelLenguaje.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        labelLenguaje.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLenguaje.setText("lenguaje");

        labelLenguaje1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        labelLenguaje1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLenguaje1.setText("Lenguaje:");

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
                            .addComponent(jLabel3)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(labelLenguaje1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelLenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabelPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(211, Short.MAX_VALUE))
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
                    .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLenguaje)
                    .addComponent(labelLenguaje1))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
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
       // Ticket tiket = new Ticket();
        AsignarBoletos();
        if(AsignarBoletos()){
            System.out.println("Todo bien");
            int numPeli = jComboBoxPeliculas.getSelectedIndex();
            String horario = jComboBoxHora.getItemAt(jComboBoxHora.getSelectedIndex());
            String[] partes = horario.split(",");
           // System.out.println("index peli = " + numPeli );
           // System.out.println(partes[0]);
           //System.out.println(rutaAsientos(numPeli,partes[0]));
           SelectorAsientos lugares= new SelectorAsientos(cantidadBoletos,rutaAsientos(numPeli,partes[0]) ,partes[0],pelis.get(numPeli-1)[1]);
            
            
            //SelectorAsientos lugares= new SelectorAsientos(cantidadBoletos, "Sala1", "10:00");
        }
        
    }//GEN-LAST:event_jButtonContinuarActionPerformed

    private void boletosCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boletosCantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boletosCantActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField boletosCant;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelPelicula;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel labelLenguaje;
    private javax.swing.JLabel labelLenguaje1;
    // End of variables declaration//GEN-END:variables
}
