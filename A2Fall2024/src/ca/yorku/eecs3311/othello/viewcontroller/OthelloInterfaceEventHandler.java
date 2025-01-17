package ca.yorku.eecs3311.othello.viewcontroller;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.util.ArrayList;

/**
 * Common interface for all event handler
 */
public class OthelloInterfaceEventHandler implements EventHandler<ActionEvent> {
    private Opponent gameOpponent;
    private int row;
    private int col;
    private Alert winnerAlert;
    private Othello othelloGame;
    private GameTimer gameTimer;
    private String actionType;
    private OthelloOperator gameOperator;
    private OthelloApplication oApplication;
    private ArrayList<Button> buttons;

    /**
     * Constructor
     * @param opponent
     * @param buttons
     * @param winner
     * @param othello
     * @param gameTimer
     * @param buttonText
     * @param operator
     * @param oApplication
     */
    public OthelloInterfaceEventHandler(Opponent opponent, ArrayList<Button> buttons, Alert winner, Othello othello, GameTimer gameTimer,
                                        String buttonText, OthelloOperator operator, OthelloApplication oApplication) {
        this.gameOpponent = opponent;

        this.winnerAlert = winner;
        this.othelloGame = othello;
        this.gameTimer = gameTimer;
        this.actionType = buttonText;
        this.gameOperator = operator;
        this.oApplication = oApplication;
        this.buttons = buttons;

    }

    @Override
    public void handle(ActionEvent event) {

        try {
            this.gameOperator.operateAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (this.actionType.equals("Human")) {
            this.gameOpponent.setStrategy(new OpponentStrategyHuman());
            OthelloApplication.player2 = "Human";
            OthelloApplication.player1 = "Human";
            OthelloApplication.whosPlayer2.setText("Human");
            OthelloApplication.whosPlayer1.setText("Human");
        }

        if (this.actionType.equals("Greedy")) {
            if (this.othelloGame.getWhosTurn() == OthelloBoard.P1) {
                this.gameOpponent.setStrategy(new OpponentStrategyGreedy());
                OthelloApplication.whosPlayer2.setText("Greedy");
                OthelloApplication.whosPlayer1.setText("Human");
                OthelloApplication.player1 = "Human";
                OthelloApplication.player2 = "Greedy";
            } else {
                this.gameOpponent.setStrategy(new OpponentStrategyGreedy());
                OthelloApplication.whosPlayer1.setText("Greedy");
                OthelloApplication.whosPlayer2.setText("Human");
                OthelloApplication.player1 = "Greedy";
                OthelloApplication.player2 = "Human";

            }

        }
        if (this.actionType.equals("Random")) {
            if (this.othelloGame.getWhosTurn() == OthelloBoard.P1) {
                this.gameOpponent.setStrategy(new OpponentStrategyRandom());
                OthelloApplication.whosPlayer2.setText("Random");
                OthelloApplication.whosPlayer1.setText("Human");
                OthelloApplication.player1 = "Human";
                OthelloApplication.player2 = "Random";
            } else {
                this.gameOpponent.setStrategy(new OpponentStrategyRandom());
                OthelloApplication.whosPlayer1.setText("Random");
                OthelloApplication.whosPlayer2.setText("Human");
                OthelloApplication.player1 = "Random";
                OthelloApplication.player2 = "Human";

            }

        }
        
    }
}