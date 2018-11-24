import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Main extends QuestionAndPlayerManager {

    public QuestionAndPlayerManager quest = new QuestionAndPlayerManager();
    private JPanel Main;
    private JPanel Page1;
    private JPanel Page2;
    private JTextField welcomeToWhoWantsTextField;
    private JPanel Panel1;
    private JPanel Panel2;
    private JButton Player1JButton;
    private JTextField enterTheNamesOfTextField;
    private JPanel Panel3;
    private JPanel Panel4;
    private JTextField namePlayer1;
    private JPanel Panel5;
    private JButton continueButton;
    private JPanel Page3;
    private JPanel Panel6;
    private JPanel Panel7;
    private JTextField explanationSP;
    private JButton beginButton;
    private JPanel Categories;
    private JPanel Panel10;
    private JPanel Panel11;
    private JTextField selectACategory;
    private JButton generalKnowledge;
    private JButton geography;
    private JButton hipHopMusic;
    private JPanel QuestionPage;
    private JTextField question1;
    private JButton option1;
    private JButton option3;
    private JButton option2;
    private JButton option4;
    private JPanel Panel12;
    private JPanel Panel13;
    private JButton askThePublicButton;
    private JButton halfAndHalfButton;
    private JButton giveMeAClueButton;
    private JPanel StatusPage;
    private JTextField textField5;
    private JButton backToCategoriesButton;
    private JPanel FinishPage;
    private JTextField textField7;
    private JButton finishButton;
    private JButton nextButton;
    private JTextField moneyTF;
    private JTextField playerSetTextField;
    private JButton button18;
    private QuestionsA currentQuest;
    private int currentPlayer;
    private boolean playerOneAlive = true;
    private int scorePlayerOne = 0;
    private int questionCounter = 0;
    private int askThePublicCounter = 0;
    private int giveMeAClueCounter = 0;
    private int halfAndHalfButtonCounter = 0;

    public int getCurrentPlayer() { return currentPlayer; }

    public void setCurrentPlayer(int currentPlayer) { this.currentPlayer = currentPlayer; }

    public boolean isPlayerOneAlive() { return playerOneAlive; }

    public void setPlayerOneAlive(boolean playerOneAlive) { this.playerOneAlive = playerOneAlive; }

    public int getScorePlayerOne() { return scorePlayerOne; }

    public void setScorePlayerOne(int score) { this.scorePlayerOne = scorePlayerOne; }

    public Main() {

        backToCategoriesButton.setEnabled(false);
        finishButton.setEnabled(false);
        this.quest = new QuestionAndPlayerManager();

        Player1JButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page1.setVisible(false);
                Page2.setVisible(true);

                currentPlayer = 1;
                playerOneAlive = true;

                Player1JButton.setEnabled(true);
            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page2.setVisible(false);
                Page3.setVisible(true);
            }
        });
        beginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page3.setVisible(false);
                Categories.setVisible(true);
            }
        });
        generalKnowledge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categories.setVisible(false);
                QuestionPage.setVisible(true);
                generalKnowledge.setEnabled(true);
                option1.setEnabled(true);
                option2.setEnabled(true);
                option3.setEnabled(true);
                option4.setEnabled(true);

                currentQuest = quest.setQnA(option1, option2, option3, option4, question1, "generalKnowledge");
                String name = namePlayer1.getText();
                playerSetTextField.setText(name.trim() + "'s turn");
            }
        });
        geography.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categories.setVisible(false);
                QuestionPage.setVisible(true);
                geography.setEnabled(true);
                option1.setEnabled(true);
                option2.setEnabled(true);
                option3.setEnabled(true);
                option4.setEnabled(true);

                currentQuest = quest.setQnA(option1, option2, option3, option4, question1, "geography");
                String name = namePlayer1.getText();
                playerSetTextField.setText(name.trim() + "'s turn");
            }
        });
        hipHopMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categories.setVisible(false);
                QuestionPage.setVisible(true);
                hipHopMusic.setEnabled(true);
                option1.setEnabled(true);
                option2.setEnabled(true);
                option3.setEnabled(true);
                option4.setEnabled(true);

                currentQuest = quest.setQnA(option1, option2, option3, option4, question1, "hipHopMusic");
                String name = namePlayer1.getText();
                playerSetTextField.setText(name.trim() + "'s turn");
            }
        });
        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuestionPage.setVisible(false);
                StatusPage.setVisible(true);

                String buttonText = option1.getText();
                if (buttonText.equals(currentQuest.getCorrectAnswer())) {
                    textField5.setText("Well done! This answer was correct.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(true);
                        scorePlayerOne += 500;
                        moneyTF.setText("Your score is: " + scorePlayerOne);
                        questionCounter++;
                    }
                } else if (buttonText.equals(currentQuest.getAnswer1())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer2())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer3())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer4())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else {
                    System.out.println("Error getting correct answer.");
                }

                if (Player1JButton.isEnabled()) {
                    nextButton.setEnabled(false);
                }

                updatePlayer();
                helpFacilities();

                if (questionCounter == 3){
                    StatusPage.setVisible(false);
                    FinishPage.setVisible(true);

                    String name = namePlayer1.getName();
                    textField7.setText("Thanks for playing: " + name.trim() + " your final score is: " + scorePlayerOne);
                }
            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuestionPage.setVisible(false);
                StatusPage.setVisible(true);

                String buttonText = option2.getText();
                if (buttonText.equals(currentQuest.getCorrectAnswer())) {
                    textField5.setText("Well done! This answer was correct.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(true);
                        scorePlayerOne += 500;
                        moneyTF.setText("Your score is: " + scorePlayerOne);
                        questionCounter++;
                    }
                } else if (buttonText.equals(currentQuest.getAnswer1())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer2())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer3())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer4())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else {
                    System.out.println("Error getting correct answer.");
                }

                if (Player1JButton.isEnabled()) {
                    nextButton.setEnabled(false);
                }

                updatePlayer();
                helpFacilities();

                if (questionCounter == 3){
                    StatusPage.setVisible(false);
                    FinishPage.setVisible(true);

                    String name = namePlayer1.getName();
                    textField7.setText("Thanks for playing: " + name.trim() + " your final score is: " + scorePlayerOne);
                }
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuestionPage.setVisible(false);
                StatusPage.setVisible(true);

                String buttonText = option3.getText();
                if (buttonText.equals(currentQuest.getCorrectAnswer())) {
                    textField5.setText("Well done! This answer was correct.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(true);
                        scorePlayerOne += 500;
                        moneyTF.setText("Your score is: " + scorePlayerOne);
                        questionCounter++;
                    }
                } else if (buttonText.equals(currentQuest.getAnswer1())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer2())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer3())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer4())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1){
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else {
                    System.out.println("Error getting correct answer.");
                }

                if (Player1JButton.isEnabled()) {
                    nextButton.setEnabled(false);
                }

                updatePlayer();
                helpFacilities();

                if (questionCounter == 3){
                    StatusPage.setVisible(false);
                    FinishPage.setVisible(true);

                    String name = namePlayer1.getName();
                    textField7.setText("Thanks for playing: " + name.trim() + " your final score is: " + scorePlayerOne);
                }
            }
        });
        option4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuestionPage.setVisible(false);
                StatusPage.setVisible(true);

                String buttonText = option4.getText();
                if (buttonText.equals(currentQuest.getCorrectAnswer())) {
                    textField5.setText("Well done! This answer was correct.");
                    if (currentPlayer == 1) {
                        setPlayerOneAlive(true);
                        scorePlayerOne += 500;
                        moneyTF.setText("Your score is: " + scorePlayerOne);
                        questionCounter++;
                    }
                } else if (buttonText.equals(currentQuest.getAnswer1())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1) {
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer2())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1) {
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer3())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1) {
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else if (buttonText.equals(currentQuest.getAnswer4())) {
                    textField5.setText("Oops! This answer was incorrect.");
                    if (currentPlayer == 1) {
                        setPlayerOneAlive(false);
                        moneyTF.setText("Game over, your score is: " + scorePlayerOne);
                    }
                } else {
                    System.out.println("Error getting correct answer.");
                }

                if (Player1JButton.isEnabled()) {
                    nextButton.setEnabled(false);
                }

                updatePlayer();
                helpFacilities();

                if (questionCounter == 3){
                    StatusPage.setVisible(false);
                    FinishPage.setVisible(true);

                    String name = namePlayer1.getName();
                    textField7.setText("Thanks for playing: " + name.trim() + " your final score is: " + scorePlayerOne);
                }
            }
        });
        halfAndHalfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String buttonText = option1.getText();
                String buttonTxt = option2.getText();
                String buttonTt = option3.getText();
                String buttonT = option4.getText();

                if (buttonText.equals(currentQuest.getCorrectAnswer())) {
                    option3.setEnabled(false);
                    option4.setEnabled(false);
                } else if (buttonTxt.equals(currentQuest.getCorrectAnswer())) {
                    option1.setEnabled(false);
                    option4.setEnabled(false);
                } else if (buttonTt.equals(currentQuest.getCorrectAnswer())) {
                    option2.setEnabled(false);
                    option4.setEnabled(false);
                } else if (buttonT.equals(currentQuest.getCorrectAnswer())) {
                    option2.setEnabled(false);
                    option3.setEnabled(false);
                } else {
                    System.out.println("Error with Half and Half.");
                }

                halfAndHalfButtonCounter = 1;
            }
        });
        backToCategoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusPage.setVisible(false);
                Categories.setVisible(true);
            }
        });
        giveMeAClueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane op = new JOptionPane(currentQuest.getClue());
                JDialog dial = op.createDialog("Give Me a Clue");
                dial.setAlwaysOnTop(true);
                dial.setVisible(true);

                giveMeAClueCounter = 1;
            }
        });
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusPage.setVisible(false);
                FinishPage.setVisible(true);

                String name = namePlayer1.getText();
                textField7.setText("Thanks for playing: " + name.trim() + " your final score is: " + scorePlayerOne);
            }
        });
        askThePublicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Random rndm = new Random();
                int optionOne = rndm.nextInt(100) + 1;
                int optionTwo = rndm.nextInt(100 - optionOne) + 1;
                int optionThree = rndm.nextInt(100 - optionOne - optionTwo) + 1;

                while ((optionOne + optionTwo + optionThree > 100)){
                    optionOne = rndm.nextInt(100) + 1;
                    optionTwo = rndm.nextInt(100 - optionOne) + 1;
                    optionThree = rndm.nextInt(100 - optionOne - optionTwo) + 1;
                }

                int optionFour = (100 - optionOne - optionTwo - optionThree);
                System.out.println(optionOne + optionTwo + optionThree + optionFour);

                String askThePublicOptions = (option1.getText() + ": " + optionOne + "%, " + option2.getText() + ": " + optionTwo + "%, " + option3.getText() + ": " + optionThree + "%, " + option4.getText() + ": " + optionFour + "%");

                JOptionPane aTPOptionPane = new JOptionPane(askThePublicOptions);
                JDialog title = aTPOptionPane.createDialog("Ask the Public");
                title.setAlwaysOnTop(true);
                title.setVisible(true);

                askThePublicCounter = 1;
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Who Wants To Be a Zillionaire?");
        frame.setContentPane(new Main().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void updatePlayer (){

        if (playerOneAlive == true){
            backToCategoriesButton.setEnabled(true);
        } else if (playerOneAlive == false){
            backToCategoriesButton.setEnabled(false);
            finishButton.setEnabled(true);
        } else {
            System.out.println("Error.");
        }
    }

    private void helpFacilities (){

        if (halfAndHalfButtonCounter == 1){
            halfAndHalfButton.setEnabled(false);
        }
        if (giveMeAClueCounter == 1){
            giveMeAClueButton.setEnabled(false);
        }
        if (askThePublicCounter == 1){
            askThePublicButton.setEnabled(false);
        }
    }

}