package game.agricola2p;

import game.Command;
import game.GameError;
import static game.agricola2p.PlayerColor.*;
import java.util.*;

public class Board extends game.Board {

	protected int move;
	protected List<Element> allElements;

	protected GameBoard gameBoard;
	protected EnumMap<PlayerColor, FarmBoard> farmBoards;

	protected PlayerColor currentPlayer;

	public Board() {
		this.move = 0;
		allElements = new ArrayList<Element>();

		currentPlayer = RED;
		farmBoards = new EnumMap<PlayerColor, FarmBoard>(PlayerColor.class);
		farmBoards.put(RED, new FarmBoard(this, RED));
		farmBoards.put(BLUE, new FarmBoard(this, BLUE));

		// FarmBoards must be done first, because GameBoard creates
		// the Actions, and ActionStartingPlayer1Wood tries to give
		// the StartingPlayerToken to one of the FarmBoards.
		gameBoard = new GameBoard(this);
	}

	protected FarmBoard activeFarm() {
		return farmBoards.get(currentPlayer);
	}

	public void runCommand(Command command) throws GameError {
		super.runCommand(command);
		move++;
	}

	public Command getCommand(String string) throws GameError {
		if(string.charAt(0) == '#') {
			return new CommandComment(string);
		}
		
		String[] tokens = string.split("\\s+");
		if(tokens.length == 0) {
			throw new GameError("No command submitted");
		}
		else {
			String command = tokens[0];
			String[] params = Arrays.copyOfRange(tokens, 1, tokens.length);
			switch(command) {
			case "ACTION":
				return new CommandAction(this, params); 
			default:
				return null;
			}
		}
	}
	
	public int getMove() {
		return move;
	}
	public EnumMap<PlayerColor, FarmBoard> getFarmBoards() {
		return farmBoards;
	}
}
