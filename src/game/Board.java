package game;

import java.util.*;

abstract public class Board {
	
	private List<Command> history = new ArrayList<Command>();
	
	protected Random rng; 
	
	public void seedRandom(int seed) {
		rng = new Random(seed);
	}
	
	/**
	 * Runs a command on the board to modify it in some way
	 * 
	 * @param command String
	 * @throws GameError
	 */
	public void runCommand(Command command) throws GameError {
		history.add(command);
		command.execute();
	}
	
	/**
	 * Given a command from the user, it finds an actual Command token object
	 * 
	 * @param string Command
	 * @return Command object
	 */
	public abstract Command getCommand(String string);
	
	/**
	 * Do various things before displaying that we normally don't want
	 * to do between every turn.
	 * 
	 * For example, determine which actions are disabled and which are
	 * usable by the player. This could be time-consuming, and we don't
	 * really care to do this when playing back moves already made,
	 * because they've already been made. 
	 */
	public void preDisplay() {
		
	}
	
}
