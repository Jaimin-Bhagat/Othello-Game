package ca.yorku.eecs3311.othello.viewcontroller;


/**
 * Interface  for implementation of Command design pattern
 */
public interface OthelloCommand {

    public abstract void execute() throws Exception;

}