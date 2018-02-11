/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import AutomataFD.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class CrearAFD extends javax.swing.JFrame {

    private File fautomata;
    private String ruta;
    private BufferedWriter salidaAutomata;
    
    /**
     * Creates new form CrearAFD
     */
    public CrearAFD() {
        initComponents();
        this.setLayout(null);
        ruta = "src/Ficheros/AFD.txt";
        //Fichero autómata
        fautomata = new File(ruta);
        try {
            salidaAutomata = new BufferedWriter(new FileWriter(fautomata));
        } catch (IOException ex) {
            Logger.getLogger(CrearAFD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getRuta() {
        return fautomata.getAbsolutePath();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SimboloTitulo = new javax.swing.JLabel();
        DestinoTitulo = new javax.swing.JLabel();
        EstFinalesTxt = new javax.swing.JLabel();
        estadosFinales = new javax.swing.JTextField();
        origenTxt = new javax.swing.JTextField();
        simboloTxt = new javax.swing.JTextField();
        destinosTxt = new javax.swing.JTextField();
        BAñadirTransicion = new javax.swing.JButton();
        TransicionesTxt = new javax.swing.JLabel();
        OrigenTitulo = new javax.swing.JLabel();
        BFinalizar = new javax.swing.JButton();
        BAddEstadosFinales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SimboloTitulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SimboloTitulo.setText("Símbolo");

        DestinoTitulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DestinoTitulo.setText("Destino");

        EstFinalesTxt.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        EstFinalesTxt.setText("Estados finales");

        BAñadirTransicion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BAñadirTransicion.setText("Añadir");
        BAñadirTransicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAñadirTransicionActionPerformed(evt);
            }
        });

        TransicionesTxt.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        TransicionesTxt.setText("Transiciones");

        OrigenTitulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OrigenTitulo.setText("Origen");

        BFinalizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BFinalizar.setText("Finalizar");
        BFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFinalizarActionPerformed(evt);
            }
        });

        BAddEstadosFinales.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BAddEstadosFinales.setText("Hecho");
        BAddEstadosFinales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddEstadosFinalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EstFinalesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TransicionesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(estadosFinales, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BAddEstadosFinales, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(OrigenTitulo)
                                .addComponent(origenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(SimboloTitulo)
                                .addComponent(simboloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DestinoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(destinosTxt))
                            .addGap(117, 117, 117)
                            .addComponent(BAñadirTransicion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(EstFinalesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadosFinales, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAddEstadosFinales, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(TransicionesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrigenTitulo)
                    .addComponent(SimboloTitulo)
                    .addComponent(DestinoTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(origenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simboloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAñadirTransicion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(BFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAddEstadosFinalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAddEstadosFinalesActionPerformed
        String[] finales = estadosFinales.getText().split(",");
        
        //Fichero automata
        try {
            salidaAutomata.write("EF: ");
            int i;
            for(i=0; i<finales.length-1; i++){
                salidaAutomata.write(finales[i] + " ");
            }
            salidaAutomata.write(finales[i] + "\n");
        } catch (IOException ex) {
            Logger.getLogger(CrearAFD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BAddEstadosFinalesActionPerformed

    private void BAñadirTransicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAñadirTransicionActionPerformed
        //agregamos las transiciones
        int origen = Integer.parseInt(origenTxt.getText());
        char simbolo = simboloTxt.getText().charAt(0);        
        int destino = Integer.parseInt(destinosTxt.getText());
        
        //Fichero automata
        try {
            salidaAutomata.write(origen + " " + simbolo + " " + destino + "\n");
        } catch (IOException ex) {
            Logger.getLogger(CrearAFD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //limpiamos los valores introducidos
        origenTxt.setText("");
        simboloTxt.setText("");
        destinosTxt.setText("");
    }//GEN-LAST:event_BAñadirTransicionActionPerformed

    private void BFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFinalizarActionPerformed
        
        try {
            //Fichero autómata
            salidaAutomata.write("EOF");
            salidaAutomata.close();
        } catch (IOException ex) {
            Logger.getLogger(CrearAFD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BFinalizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAddEstadosFinales;
    private javax.swing.JButton BAñadirTransicion;
    private javax.swing.JButton BFinalizar;
    private javax.swing.JLabel DestinoTitulo;
    private javax.swing.JLabel EstFinalesTxt;
    private javax.swing.JLabel OrigenTitulo;
    private javax.swing.JLabel SimboloTitulo;
    private javax.swing.JLabel TransicionesTxt;
    private javax.swing.JTextField destinosTxt;
    private javax.swing.JTextField estadosFinales;
    private javax.swing.JTextField origenTxt;
    private javax.swing.JTextField simboloTxt;
    // End of variables declaration//GEN-END:variables
}
