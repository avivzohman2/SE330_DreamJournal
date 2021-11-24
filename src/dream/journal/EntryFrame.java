/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dream.journal;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author avivzohman
 */
public class EntryFrame extends javax.swing.JFrame {

    /**
     * Creates new form WelcomeFrame
     */
    public EntryFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        javax.swing.JButton btnOK = new javax.swing.JButton();
        labelEntry = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaEntry = new javax.swing.JTextArea();
        javax.swing.JButton btnClear = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dream");

        labelTitle.setText("Title");

        tfTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTitleActionPerformed(evt);
            }
        });

        btnOK.setText("Ok");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        labelEntry.setText("Entry");

        textAreaEntry.setColumns(20);
        textAreaEntry.setRows(5);
        jScrollPane1.setViewportView(textAreaEntry);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        backButton.setText("Home");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEntry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfTitle)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(135, Short.MAX_VALUE)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnClear)
                        .addGap(133, 133, 133))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(labelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(labelEntry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        tfTitle.setText("");
        textAreaEntry.setText("");
        labelTitle.setText("Title");
        labelEntry.setText("Entry");
        labelEntry.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String title = tfTitle.getText();
        String entry = textAreaEntry.getText(); 
        
        //check whether entire dream page is empty and prompt user 
        if (title.isEmpty() && entry.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hold your horses! Don't forget your dream!", "Whoopsies", JOptionPane.ERROR_MESSAGE);
        }
        //check if only the title is empty 
        else if (title.isEmpty()) { 
            JOptionPane.showMessageDialog(null, "Dont' forget your title!", "Whoopsies", JOptionPane.ERROR_MESSAGE);
        }
        //check if entry is empty
        else if (entry.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Don't forget your entry!", "Whoopsies", JOptionPane.ERROR_MESSAGE);
        }
        //check if title matches SQL 30 character constraint
        else if (title.length() > 30) {
            JOptionPane.showMessageDialog(null, "Title cannot exceed 30 characters", "Whoopsies", JOptionPane.ERROR_MESSAGE);
        }
        //check if title matches SQL TINYTEXT datatype
        else if (entry.length() > 255) {
            JOptionPane.showMessageDialog(null, "Entry cannot exceed 255 characters", "Whoopsies", JOptionPane.ERROR_MESSAGE);
        }
        //else title and entry are completed
        //insert title and entry into dreamjournal database
        else {

            try {
                //MySQL connection information
                final String DB_URL = "jdbc:mysql://localhost:3306/dreamjournal";
                final String USERNAME = "root";
                final String PASSWORD = "password";

                Connection conn = null; 
                PreparedStatement psmt = null;
                ResultSet rs;
                //connect to dreamjournal database
                conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                System.out.println("Connected to database successfully");
                
                //SQL query
                String query = "INSERT INTO repository (title, entry) VALUES (?, ?)";
                psmt = conn.prepareStatement(query); 
                
                psmt.setString(1, title); 
                psmt.setString(2, entry);
                
                
                //successful insertion
                if (psmt.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Your dream is logged!");
                    
                    //navigate user to journal after successful dream log
                    JournalFrame journalFrame = new JournalFrame(); 
                    journalFrame.setVisible(true); //open JournalFrame
                    setVisible(false); //close current frame
                }
                //close connection
                conn.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something went wrong!", "Whoopsies", JOptionPane.ERROR_MESSAGE);
            }

        }
 
    }//GEN-LAST:event_btnOKActionPerformed

    private void tfTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTitleActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        IntroFrame introFrame = new IntroFrame(); 
        introFrame.setVisible(true); //open IntroFrame
        setVisible(false); //close current frame
    }//GEN-LAST:event_backButtonActionPerformed

    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("macOS".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EntryFrame entryFrame = new EntryFrame(); 
                entryFrame.setVisible(true);
         
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelEntry;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextArea textAreaEntry;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables
}
