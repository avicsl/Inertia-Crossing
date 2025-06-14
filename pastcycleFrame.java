
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

public class pastcycleFrame extends javax.swing.JFrame {

    
    private Queue<Integer> pastCycleScores;
    private Map<JButton, Integer> buttonToScoreIndexMap;
    private Map<JButton, Integer> buttonToScoreMap = new HashMap<>();
    private Map<Integer, String> userAnswers;
    private Map<Integer, String> correctAnswers;
    private Map<Integer, String> questions;
    

    
    public pastcycleFrame(Map<Integer, String> userAnswers, Map<Integer, String> correctAnswers, Map<Integer, String> questions) {
        super ("Math Master");
    this.userAnswers = userAnswers != null ? userAnswers : new HashMap<>();
    this.correctAnswers = correctAnswers != null ? correctAnswers : new HashMap<>();
    this.questions = questions != null ? questions : new HashMap<>();
    initComponents();
    pastCycleScores = new LinkedList<>(optionFrame.getScoreQueue()); //Fetch scores from optionFrame
    buttonToScoreIndexMap = new HashMap<>();
    updateButtonLabels();
    this.setLocation(270, 120); // Set location after components are initialized
}

    private pastcycleFrame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    private void updateButtonLabels() {
        Queue<Integer> scores = optionFrame.getScoreQueue(); // Fetch scores from optionFrame
        JButton[] buttons = {jButton1, jButton2, jButton3};

        int index = 0;
        buttonToScoreMap.clear(); // Clear previous mappings

        LinkedList<Integer> reversedScores = new LinkedList<>();
        for (Integer score : scores) {
            reversedScores.addFirst(score);
        }

        buttonToScoreIndexMap.clear();

        for (JButton button : buttons) {
            if (index < reversedScores.size()) {
                int scoreIndex = reversedScores.size() - 1 - index;
                String gameName = "Past Game";
                button.setText(gameName + " Score: " + reversedScores.get(index));
                button.setEnabled(true);

                buttonToScoreMap.put(button, scoreIndex);

                // Add ActionListener to the button
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jButtonActionPerformed(evt, gameName, scoreIndex);
                    }
                });

                index++;
            } else {
                button.setEnabled(false);
                button.setText(" ");
            }
        }
    }

    private void deleteGame(int index) {
        if (index >= 0 && index < pastCycleScores.size()) {
            // Convert Queue to List to facilitate removal by index
            LinkedList<Integer> scoresList = new LinkedList<>(pastCycleScores);
            scoresList.remove(index);

            // Update the Queue in optionFrame
            Queue<Integer> updatedQueue = new LinkedList<>(scoresList);
            optionFrame.setScoreQueue(updatedQueue);

            pastCycleScores = new LinkedList<>(updatedQueue); // Update local queue

            updateButtonLabels(); // Update the button labels after deletion
            JOptionPane.showMessageDialog(this, "Game deleted");
        }
    }

    private void redoOrDeleteGame(int index) {
        int choice = JOptionPane.showOptionDialog(
            this,
            "Do you want to delete or replay Game?",
            "Choose an Action",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]{"Delete", "Replay"},
            "Redo"
        );

        if (choice == 0) {
            deleteGame(index);
        } else if (choice == 1) {
            // Delete the game and then redirect to gameFrame
            deleteGame(index);
            redoGame();
        }
    }

    private void redoGame() {
        // Implement the logic to restart the game, such as opening a new GameFrame
        JOptionPane.showMessageDialog(this, "Starting a new game...");
        gameFrame gameFrame = new gameFrame(); // Assuming GameFrame class exists
        gameFrame.setVisible(true);
        this.dispose(); // Close the current frame
    }

    private void jButtonActionPerformed(ActionEvent evt, String gameName, int scoreIndex) {
        redoOrDeleteGame(scoreIndex);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(100, 160, 241));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 450, 60));

        jButton2.setBackground(new java.awt.Color(100, 160, 241));
        jButton2.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 450, 60));

        jButton3.setBackground(new java.awt.Color(100, 160, 241));
        jButton3.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 450, 60));

        jButton6.setBackground(new java.awt.Color(246, 135, 27));
        jButton6.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("HOME >");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 170, 30));

        jButton4.setBackground(new java.awt.Color(246, 135, 27));
        jButton4.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("< LAST SUMMARY");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\CS - 2ND YR\\physics 2\\recent history.png")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        Opening Opening = new Opening(); // Assuming GameFrame class exists
        Opening.setVisible(true);
        this.dispose(); // Close the Opening frame
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (userAnswers != null && correctAnswers != null && questions != null) {
            viewsummaryFrame viewsummaryFrame = new viewsummaryFrame(userAnswers, correctAnswers, questions);
            viewsummaryFrame.setVisible(true);
        } else {
            System.out.println("One or more maps are null. Check initialization.");
        }
        this.dispose(); // Close the current optionFrame after showing viewsummaryFrame
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(pastcycleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pastcycleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pastcycleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pastcycleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pastcycleFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
