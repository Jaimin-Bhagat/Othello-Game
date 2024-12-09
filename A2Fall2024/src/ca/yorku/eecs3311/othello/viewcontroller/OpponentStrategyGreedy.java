package ca.yorku.eecs3311.othello.viewcontroller;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.PlayerGreedy;

/**
 * Opponent Strategy Greedy main class
 *
 */
public class OpponentStrategyGreedy implements OpponentStrategy{

    @Override
    public void nextCommand(Othello othello) {
        PlayerGreedy playerGreedy = new PlayerGreedy(othello, othello.getWhosTurn());
        Move greedyMove = playerGreedy.getMove();
        othello.move(greedyMove.getRow(), greedyMove.getCol());
    }

    @Override
    public Move copiedMove(Othello othello) {
        PlayerGreedy playerGreedy = new PlayerGreedy(othello.copy(), othello.getWhosTurn());
        Move greedyMove = playerGreedy.getMove();
        return greedyMove;
    }
}