package ca.yorku.eecs3311.othello.viewcontroller;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.Move;
/**
 * Opponent Strategy main class
 *
 */
public interface OpponentStrategy {

        public void nextCommand(Othello othello);

        public Move copiedMove(Othello othello);


    }