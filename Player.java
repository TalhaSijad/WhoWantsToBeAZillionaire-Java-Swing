import javax.swing.*;

public class Player extends Main {

    private String currentPlayer;
    private int maxPlayer;
    private String playerName = "";
    private int playerAmount = 0;
    private boolean used5050 = false;
    private boolean usedGiveMeAClue = false;
    private boolean playerStillInTheGame = true;

    public Player (String playerName, int playerAmount, boolean used5050, boolean usedGiveMeAClue, boolean playerStillInTheGame){
        this.playerName = playerName;
        this.playerAmount = playerAmount;
        this.used5050 = used5050;
        this.usedGiveMeAClue = usedGiveMeAClue;
        this.playerStillInTheGame = playerStillInTheGame;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(int maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAmount() {
        return playerAmount;
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
    }

    public boolean isPlayerStillInTheGame() { return playerStillInTheGame; }

    public boolean isUsed5050() { return used5050; }

    public void setUsed5050(boolean used5050) { this.used5050 = used5050; }

    public boolean isUsedGiveMeAClue() { return usedGiveMeAClue; }

    public void setUsedGiveMeAClue(boolean usedGiveMeAClue) { this.usedGiveMeAClue = usedGiveMeAClue; }

    public void setPlayerStillInTheGame(boolean playerStillInTheGame) { this.playerStillInTheGame = playerStillInTheGame; }


    public void updatePlayerMethod (JButton currentPlayerr, boolean isDead){

    }


}
