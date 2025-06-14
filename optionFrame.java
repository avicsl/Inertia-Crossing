
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class optionFrame extends javax.swing.JFrame {

    private int score;
    private Map<Integer, String> userAnswers;
    private Map<Integer, String> correctAnswers;
    private Map<Integer, String> questions;
    private static final int MAX_SCORES = 3;
    private static Queue<Integer> scoreQueue = new LinkedList<>();
    
    public optionFrame(int score, Map<Integer, String> userAnswers, Map<Integer, String> correctAnswers, Map<Integer, String> questions) {
        
        super ("Math Master");
    initComponents();
    this.score = score;
    this.userAnswers = userAnswers;
    this.correctAnswers = correctAnswers;
    this.questions = questions;
    jLabel2.setText("Score: " + score); // Display the score
    saveScore(score);
    this.setLocation(270, 120); // Set location after components are initialized
}

    
    private void saveScore(int score) {
    if (!scoreQueue.contains(score)) {
    if (scoreQueue.size() == MAX_SCORES) {
      scoreQueue.poll(); // Remove oldest score if the queue is full
    }
    scoreQueue.add(score);
  }
}
    
    public static Queue<Integer> getScoreQueue() {
        return new LinkedList<>(scoreQueue); // Return a copy of the scores
    }

    public static void setScoreQueue(Queue<Integer> newScores) {
        scoreQueue = new LinkedList<>(newScores); // Update the scores
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(246, 135, 27));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SUMMARY >");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 150, 30));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(100, 160, 241));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("score");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 420, -1));

        jButton2.setBackground(new java.awt.Color(246, 135, 27));
        jButton2.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("< PLAY AGAIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\CS - 2ND YR\\physics 2\\recent record.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 540));

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
      if (userAnswers != null && correctAnswers != null && questions != null) {
      viewsummaryFrame viewsummaryFrame = new viewsummaryFrame(userAnswers, correctAnswers, questions);
      viewsummaryFrame.setVisible(true);
        } else {
            System.out.println("One or more maps are null. Check initialization.");
        }
        this.dispose(); // Close the current optionFrame after showing viewsummaryFrame
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        gameFrame gameFrame = new gameFrame();
        gameFrame.setVisible(true);
        this.dispose(); // Close the Opening frame
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(optionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(optionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(optionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(optionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new optionFrame(5, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}