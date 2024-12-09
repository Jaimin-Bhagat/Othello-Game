package ca.yorku.eecs3311.othello.viewcontroller;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.PlayerGreedy;
import ca.yorku.eecs3311.othello.model.PlayerRandom;



/**
 * Opponent Strategy Random class
 */

public class OpponentStrategyRandom implements OpponentStrategy {
    @Override
    public void nextCommand(Othello othello) {
        PlayerRandom playerRandom = new PlayerRandom(othello, othello.getWhosTurn());
        Move randomMove = playerRandom.getMove();
        othello.move(randomMove.getRow(), randomMove.getCol());
    }

    @Override
    public Move copiedMove(Othello othello) {
        PlayerRandom playerRandom = new PlayerRandom(othello.copy(), othello.getWhosTurn());
        Move randomMove = playerRandom.getMove();
       return randomMove;
    }

}