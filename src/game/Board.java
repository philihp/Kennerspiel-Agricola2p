package game;

import java.util.Random;

abstract public class Board {
	
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
		throw new UnsupportedOperationException();
	}
	
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
