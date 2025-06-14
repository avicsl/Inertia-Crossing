package inertia.crossing;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class gameFrame extends javax.swing.JFrame {
    
    
    private Map<Integer, String> userAnswers = new HashMap<>();
    private Map<Integer, String> correctAnswers = new HashMap<>();
    private Map<Integer, String> questions = new HashMap<>();
    private int currentQuestionIndex = 0; // Track the current question index
    private Queue<Integer> pastCycleScores = new LinkedList<>();

    
    public static class Question {
        
        String question;
        String[] choices;
        String correctAnswer;

        public Question(String question, String[] choices, String correctAnswer) {
            this.question = question;
            this.choices = choices;
            this.correctAnswer = correctAnswer;
        }
    }
    
    
    
    public static class CircularLinkedList {
        private ArrayList<Question> questions = new ArrayList<>();
        private Random random = new Random();

        public void addQuestion(Question question) {
            questions.add(question);
        }

        public ArrayList<Question> getShuffledQuestions(int count) {
            Collections.shuffle(questions);
            return new ArrayList<>(questions.subList(0, Math.min(count, questions.size())));
        }
    }
    
    public void setSummaryData(Map<Integer, String> userAnswers, Map<Integer, String> correctAnswers, Map<Integer, String> questions) {
        this.userAnswers = userAnswers;
        this.correctAnswers = correctAnswers;
        this.questions = questions;
    }

    private CircularLinkedList questionList = new CircularLinkedList();
    private ArrayList<Question> currentCycleQuestions = new ArrayList<>();
    private Question currentQuestion;
    private int score = 0;
    private int questionCount = 0;
    private Timer timer;
    private int timeLeft = 10; // 10 seconds timer

    private Clip clip; 

    public gameFrame() {
         super ("Math Master");
        initComponents();
        this.setLocation(270, 120); // Set location after components are initialized
        this.setVisible(true); // Make sure the frame is visible
        loadQuestions(); // Load questions into the list
        startNewCycle(); // Start the first cycle
        playMusic("C:\\Users\\Alvhin\\Downloads\\bgm.wav");
    }

    private void playMusic(String musicFile) {
        try {
            File audioFile = new File(musicFile); // Path to the audio file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip(); // Initialize clip
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music continuously
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }



    private void loadQuestions() {
    
    // Easy Questions
    questionList.addQuestion(new Question("/A proton has what charge?/n", new String[]{"Positive", "Negative", "Neutral", "Zero"}, "Positive"));
    questionList.addQuestion(new Question("Glass rubbed with silk becomes?/n", new String[]{"Positively Charged", "Negatively Charged", "Unchanged", "Neutral"}, "Positively Charged"));
    questionList.addQuestion(new Question("What are the two types of electrc charges/n", new String[]{"Positive and Negative", "Light and Dark", "Hot and Cold", "Small and Large"}, "Positive and Negative"));
    questionList.addQuestion(new Question("Unit of a electric potential is?/n", new String[]{"Volt", "Watt", "Coulomb", "Ampere"}, "Volt"));
    questionList.addQuestion(new Question("Which is an insulator/n", new String[]{"Glass", "Copper", "Gold", "Aluminum"}, "Glass"));
    questionList.addQuestion(new Question("A device that stores electric charge is called?/n", new String[]{"Capacitor", "Battery", "Diode", "Resistor"}, "Capacitor"));
    
    }

    private void startNewCycle() {
    currentCycleQuestions = questionList.getShuffledQuestions(5); // Assuming 10 questions per cycle
    currentQuestionIndex = 0;
    questionCount = 0;
    score = 0;
    displayNextQuestion();
}

    
   
    private void displayNextQuestion() {
        if (questionCount >= currentCycleQuestions.size()) {
            // End of cycle
            if (clip != null) { // Stop music before opening the OptionFrame
                clip.stop();
            }
            transitionToOptionFrame();
        } else {
            currentQuestion = currentCycleQuestions.get(questionCount);
            jLabel1.setText(currentQuestion.question);
            jRadioButton1.setText(currentQuestion.choices[0]);
            jRadioButton2.setText(currentQuestion.choices[1]);
            jRadioButton3.setText(currentQuestion.choices[2]);
            jRadioButton4.setText(currentQuestion.choices[3]);

            buttonGroup1.clearSelection(); // Clear the selection for the next question


        // Reset timer
        timeLeft = 10;
        jLabel3.setText("Seconds left: " + timeLeft);
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
                jLabel3.setText("Seconds left: " + timeLeft);
                if (timeLeft <= 0) {
                    timer.cancel();
                    checkAnswer(null); // Time expired, consider as wrong answer
                }
            }
        }, 1000, 1000);
    }
    }
    
    private void checkAnswer(String selectedAnswer) {
        timer.cancel();
        userAnswers.put(currentQuestionIndex, selectedAnswer != null ? selectedAnswer : "No Answer");
        correctAnswers.put(currentQuestionIndex, currentQuestion.correctAnswer);
        questions.put(currentQuestionIndex, currentQuestion.question);

        if (selectedAnswer == null) {
            JOptionPane.showMessageDialog(this, "Time's up! Correct answer was: " + currentQuestion.correctAnswer);
        } else if (selectedAnswer.equals(currentQuestion.correctAnswer)) {
            score++;
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            JOptionPane.showMessageDialog(this, "Wrong! Correct answer was: " + currentQuestion.correctAnswer);
        }

        currentQuestionIndex++;
        questionCount++;
        displayNextQuestion();
    }
    
    private void transitionToOptionFrame() {
    // Add the current score to the past cycles queue
    if (pastCycleScores.size() >= 5) {
        pastCycleScores.poll(); // Remove the oldest score
    }
    pastCycleScores.offer(score); // Add the new score
    
    optionFrame optionFrameInstance = new optionFrame(score, userAnswers, correctAnswers, questions);
    optionFrameInstance.setVisible(true);
    this.dispose(); 
}

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("jRadioButton1");
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 240, 40));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 417, 220, 30));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("jRadioButton3");
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 230, 20));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("jRadioButton4");
        jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 415, 230, 30));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Question");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 420, 180));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 46, 370, 40));

        jButton1.setBackground(new java.awt.Color(238, 170, 97));
        jButton1.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SUBMIT");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 419, 100, 40));

        jButton6.setBackground(new java.awt.Color(238, 170, 97));
        jButton6.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("<  EXIT");
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 503, 108, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\CS - 2ND YR\\physics 2\\game bg.png")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, -1));

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
    if (jRadioButton1.isSelected()) {
            checkAnswer(jRadioButton1.getText());
        } else if (jRadioButton2.isSelected()) {
            checkAnswer(jRadioButton2.getText());
        } else if (jRadioButton3.isSelected()) {
            checkAnswer(jRadioButton3.getText());
        } else if (jRadioButton4.isSelected()) {
            checkAnswer(jRadioButton4.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Please select an answer.");
        }
    
    buttonGroup1.add(jRadioButton1);
    buttonGroup1.add(jRadioButton2);
    buttonGroup1.add(jRadioButton3);
    buttonGroup1.add(jRadioButton4);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
if (clip != null) { // Stop music before opening the HelpFrame
            clip.stop();
        } 
if (timer != null) {
        timer.cancel();
    }


        Opening Opening = new Opening(); // Assuming GameFrame class exists
        Opening.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}