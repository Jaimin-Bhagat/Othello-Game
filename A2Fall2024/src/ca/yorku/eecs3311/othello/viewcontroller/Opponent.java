package ca.yorku.eecs3311.othello.viewcontroller;
import ca.yorku.eecs3311.othello.model.Othello;
/**
 * Opponent is an interface that creates different strategies
 *
 */
public class Opponent {
    private OpponentStrategy strategy;
    public Opponent() {
        this.strategy = new OpponentStrategyHuman();
    }

    public void setStrategy(OpponentStrategy strategy) {
        this.strategy = strategy;
    }

    public void move(Othello othello) {
        this.strategy.nextCommand(othello);
    }
}