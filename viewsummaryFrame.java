
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class viewsummaryFrame extends javax.swing.JFrame {

    private int score;
    private Map<Integer, String> userAnswers;
    private Map<Integer, String> correctAnswers;
    private Map<Integer, String> questions;

    
    public viewsummaryFrame(Map<Integer, String> userAnswers, Map<Integer, String> correctAnswers, Map<Integer, String> questions) {
        super ("Math Master");
        initComponents();
        this.score = score;
        this.userAnswers = userAnswers;
        this.correctAnswers = correctAnswers;
        this.questions = questions;
        this.setLocation(270, 120); // Set location after components are initialized
        
        
        displaySummaryButtons();
        
    }
    
    


    private void displaySummaryButtons() {
        jButton3.setText("Question 1");
        jButton4.setText("Question 2");
        jButton5.setText("Question 3");
        jButton6.setText("Question 4");
        jButton7.setText("Question 5");

        jButton3.addActionListener(e -> showQuestionDetails(0));
        jButton4.addActionListener(e -> showQuestionDetails(1));
        jButton5.addActionListener(e -> showQuestionDetails(2));
        jButton6.addActionListener(e -> showQuestionDetails(3));
        jButton7.addActionListener(e -> showQuestionDetails(4));
    }
    
    private void showQuestionDetails(int index) {
        String question = questions.get(index);
        String userAnswer = userAnswers.get(index);
        String correctAnswer = correctAnswers.get(index);

        String message = String.format("Q%d: %s\nYour Answer: %s\nCorrect Answer: %s",
                index + 1, question, userAnswer != null ? userAnswer : "No Answer", correctAnswer);

        JOptionPane.showMessageDialog(this, message, "Question Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private void searchQuestion() {
    String searchInput = jTextField1.getText().trim();
 
    // Use an ArrayList to store matching question indices
    ArrayList<Integer> matchingQuestions = new ArrayList<>();
    
    // Check if the search input is a number
    try {
        Integer.parseInt(searchInput);
        // If it's a number, find all questions containing that number
        for (Map.Entry<Integer, String> entry : questions.entrySet()) {
            int index = entry.getKey();
            String question = entry.getValue();
            
            // Check if the number is part of the question text
            if (question.contains(searchInput)) {
                matchingQuestions.add(index);
            }
        }
    } catch (NumberFormatException e) {
        // If it's not a number, search by the text
        for (Map.Entry<Integer, String> entry : questions.entrySet()) {
            int index = entry.getKey();
            String question = entry.getValue().toLowerCase();
            
            // Check if the search input is contained in the question text
            if (question.contains(searchInput.toLowerCase())) {
                matchingQuestions.add(index);
            }
        }
    }

    // Show all matching questions
    if (!matchingQuestions.isEmpty()) {
        StringBuilder result = new StringBuilder("Matching Questions:\n");
        for (int questionIndex : matchingQuestions) {
            result.append("Question ").append(questionIndex + 1).append(": ").append(questions.get(questionIndex)).append("\n");
        }
        JOptionPane.showMessageDialog(this, result.toString(), "Search Results", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "No matching questions found!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    

    private String formatButtonText(int index) {
        String question = questions.get(index);
        String userAnswer = userAnswers.get(index);
        String correctAnswer = correctAnswers.get(index);
        return String.format("Q%d: %s\nYour Answer: %s\nCorrect Answer: %s",
                index + 1, question, userAnswer != null ? userAnswer : "No Answer", correctAnswer);
    }
    
    private int calculateScore() {
    int score = 0;
    for (int i = 0; i < correctAnswers.size(); i++) {
        if (userAnswers.get(i) != null && userAnswers.get(i).equals(correctAnswers.get(i))) {
            score++;
        }
    }
    return score;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RECORD >");
        jButton1.setActionCommand("SCORE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 140, 30));

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("< SCORE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 140, 30));

        jButton3.setBackground(new java.awt.Color(100, 160, 241));
        jButton3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 450, 30));

        jButton4.setBackground(new java.awt.Color(100, 160, 241));
        jButton4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 450, 30));

        jButton5.setBackground(new java.awt.Color(100, 160, 241));
        jButton5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 450, 30));

        jButton6.setBackground(new java.awt.Color(100, 160, 241));
        jButton6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 450, 30));

        jButton7.setBackground(new java.awt.Color(100, 160, 241));
        jButton7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 450, 30));

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                R(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 370, 30));

        jButton8.setBackground(new java.awt.Color(255, 153, 51));
        jButton8.setFont(new java.awt.Font("Dubai Medium", 1, 10)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\CS - 2ND YR\\physics 2\\game summary.png")); // NOI18N
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
        pastcycleFrame pastcycleFrame = new pastcycleFrame(userAnswers, correctAnswers, questions);
        pastcycleFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    int score = calculateScore(); // Get the actual score
    optionFrame optionFrame = new optionFrame(score, userAnswers, correctAnswers, questions);
    optionFrame.setVisible(true);
    this.dispose();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        searchQuestion();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void R(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R
    if (jTextField1.getText().equals("Search an operation or number from question")) {
        // Clear the text and set color to black
        jTextField1.setText("");
        jTextField1.setForeground(java.awt.Color.BLACK);
    }
    }//GEN-LAST:event_R

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
    if (jTextField1.getText().isEmpty()) {
        // Restore the placeholder text and set color to gray
        jTextField1.setText("Search an operation or number from question");
        jTextField1.setForeground(java.awt.Color.GRAY);
    }
    }//GEN-LAST:event_jTextField1FocusLost

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
            java.util.logging.Logger.getLogger(viewsummaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewsummaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewsummaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewsummaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Map<Integer, String> userAnswers = new HashMap<>();
        Map<Integer, String> correctAnswers = new HashMap<>();
        Map<Integer, String> questions = new HashMap<>();
        
        for (int i = 0; i < 5; i++) {
        questions.put(i, "Question " + (i + 1));
        userAnswers.put(i, "| Answer " + (i + 1));
        correctAnswers.put(i, "| Correct Answer " + (i + 1));
    }
        java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        // Pass the required parameters to the constructor
        viewsummaryFrame summaryFrame = new viewsummaryFrame(userAnswers, correctAnswers, questions);
        summaryFrame.setVisible(true);
    }
});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
