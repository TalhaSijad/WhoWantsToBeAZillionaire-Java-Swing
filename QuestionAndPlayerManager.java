import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class QuestionAndPlayerManager {

    public ArrayList<QuestionsA> questionsGk;
    public ArrayList<QuestionsA> questionsGeo;
    public ArrayList<QuestionsA> questionsHh;

    public QuestionAndPlayerManager() {

        questionsGk = new ArrayList<QuestionsA>();
        questionsGeo = new ArrayList<QuestionsA>();
        questionsHh = new ArrayList<QuestionsA>();

        // General Knowledge questions and answers:

        QuestionsA questionsGK1 = new QuestionsA("Who is Winnie the Pooh's gloomy donkey friend?", "Piglet", "Tigger", "Eeyore", "Rabbit", "Eeyore", "His skin colour is grey.");
        questionsGk.add(questionsGK1);

        QuestionsA questionsGK2 = new QuestionsA("What is the standard unit of distance in the metric system?", "Miles", "Metre", "Kilometre", "Centimetre", "Metre", "It's the length of an average step.");
        questionsGk.add(questionsGK2);

        QuestionsA questionsGK3 = new QuestionsA("Which month is Black History Month in USA?", "October", "April", "January", "February", "February", "It's one of the earliest months in the year.");
        questionsGk.add(questionsGK3);

        QuestionsA questionsGK4 = new QuestionsA("What is longest running race in the Olympic Games called?", "Medathlon", "Triathlon", "Marathon", "Longathon", "Marathon", "These are held often.");
        questionsGk.add(questionsGK4);

        // Geography questions and answers:

        QuestionsA questionsGeo1 = new QuestionsA("Hanoi is the capital of which country?", "Malaysia", "Vietnam", "Indonesia", "Chile", "Vietnam", "Begins with V.");
        questionsGeo.add(questionsGeo1);

        QuestionsA questionsGeo2 = new QuestionsA("What is the capital of Pakistan?", "Lahore", "Karachi", "Peshawar", "Islamabad", "Islamabad", "It's one of the biggest cities in Pakistan.");
        questionsGeo.add(questionsGeo2);

        QuestionsA questionsGeo3 = new QuestionsA("Which American city was once called New Amsterdam?", "Minnesota", "Minnesota", "Boston", "New York", "New York", "It's the 'city that never sleeps'.");
        questionsGeo.add(questionsGeo3);

        QuestionsA questionsGeo4 = new QuestionsA("Which of the following is not a part of London?", "Enfield", "Stratford", "Norfolk", "Barking", "Norfolk", "The name of the city contains a dining utesil.");
        questionsGeo.add(questionsGeo4);

        // Hip-Hop questions and answers:

        QuestionsA questionsHh1 = new QuestionsA("Which Hip-Hop artist went double platinum on an album with no features?", "Jay-Z", "Nelly", "J. Cole", "Kanye West", "J. Cole", "He's the youngest artist out of these options.");
        questionsHh.add(questionsHh1);

        QuestionsA questionsHh2 = new QuestionsA("Who is the current president of the label G.O.O.D Music?", "Mos Def", "Pusha T", "John Legend", "Kanye West", "Pusha T", "He only became president recently.");
        questionsHh.add(questionsHh2);

        QuestionsA questionsHh3 = new QuestionsA("How many Grammy awards has artist Kanye West received?", "26", "19", "16", "21", "21", "It's a fairly high number.");
        questionsHh.add(questionsHh3);

        QuestionsA questionsHh4 = new QuestionsA("On which album did R&B artist Frank Ocean first appear on?", "Wolf by Tyler, the Creator", "4 by Beyonce", "MBDTF by Kanye West", "The Blueprint by JAY-Z", "4 by Beyonce", "The only female in these options.");
        questionsHh.add(questionsHh4);
    }

    // Random method to randomly get a question:

    Random rnd = new Random();

    public Random getRnd() {
        return rnd;
    }

    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }

    public int nextInt() {
        return questionsGk.size();
    }

    public QuestionsA setQnA (JButton aBut, JButton bBut, JButton cBut, JButton dBut, JTextField quest, String category){

        QuestionsA random1 = null;

        if (category.equals("generalKnowledge")){
            int randomInt = rnd.nextInt(questionsGk.size());
            random1 = questionsGk.get(randomInt);
            questionsGk.remove(random1);
        }
        else if (category.equals("geography")){
            int randomInt = rnd.nextInt(questionsGeo.size());
            random1 = questionsGeo.get(randomInt);
            questionsGeo.remove(random1);
        }
        else if (category.equals("hipHopMusic")){
            int randomInt = rnd.nextInt(questionsHh.size());
            random1 = questionsHh.get(randomInt);
            questionsHh.remove(random1);
        }
        else {
            System.out.println("Error no category selected.");
        }

        quest.setText(random1.getQuestion());
        aBut.setText(random1.getAnswer1());
        bBut.setText(random1.getAnswer2());
        cBut.setText(random1.getAnswer3());
        dBut.setText(random1.getAnswer4());
        return random1;
    }

    // Player manager:

    public static void main(String[] args) {

        Player playerOne = new Player("player name", 0, false, false, true){


        };

        Player playerTwo = new Player("player name", 0, false, false, true){

        };

        Player playerThree = new Player("player name", 0, false, false, true){

        };

        Player playerFour = new Player("player name", 0, false, false, true){

        };
    }
}