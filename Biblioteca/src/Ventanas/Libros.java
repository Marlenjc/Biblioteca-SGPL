/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mar
 */
public class Libros extends javax.swing.JFrame {

     private JTable table;
DefaultTableModel model;
ListSelectionModel lscodigos;

    public Libros() {
       
           initComponents();
         this.setLocationRelativeTo(null);
        
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        SESION = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabLibros = new javax.swing.JTable();
        FONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Lao UI", 1, 18)); // NOI18N
        jLabel3.setText("Sistema de Gestion de Préstamo de Libros");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(153, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(204, 0, 255));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 630, 10));

        SESION.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/CLOSE.png"))); // NOI18N
        SESION.setBorderPainted(false);
        SESION.setContentAreaFilled(false);
        SESION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SESIONActionPerformed(evt);
            }
        });
        getContentPane().add(SESION, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 50, 40));

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 430, -1));

        TabLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TabLibros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 560, 400));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/prestamo.jpg"))); // NOI18N
        getContentPane().add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SESIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SESIONActionPerformed
dispose()       ;
       
        
    }//GEN-LAST:event_SESIONActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
      String [] Titulos={"::..Id..::","::..Titulo..::","::..Editorial..::","::..Autor..::","::..Genero..::","::..Descripcion..::","::..NP..::","::..Existencia..::"};
      String [] Registros= new String[10];
      String sql="Select * From inventario where Titulo like'%"+search.getText() + "%'";
      
      model= new DefaultTableModel(null,Titulos);
      ConexionBD cc=new ConexionBD();
      Connection cn=cc.conexion();
      try{
          Statement st = (Statement) cn.createStatement();
          ResultSet rs = st.executeQuery(sql);
       while (rs.next()) {
                    Registros[0] = rs.getString("IDLibro");
                    Registros[1] = rs.getString("Titulo");
                    Registros[2] = rs.getString("Editorial");
                    Registros[3] = rs.getString("Autor");
                    Registros[4] = rs.getString("Genero");
                    Registros[5] = rs.getString("Descripcion");
                    Registros[6] = rs.getString("Npag");
                    Registros[7] = rs.getString("PRECIO");
                    model.addRow(Registros);
                }
       TabLibros.setModel(model);}
      catch(SQLException e){  JOptionPane.showMessageDialog(null,"Problemas con el Query");}
    	catch(Exception e){ JOptionPane.showMessageDialog(null,"Problemas con java input-Output de datos");  }
    }//GEN-LAST:event_searchKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FONDO;
    private javax.swing.JButton SESION;
    public static javax.swing.JTable TabLibros;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
