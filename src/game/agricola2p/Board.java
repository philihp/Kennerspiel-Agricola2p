package game.agricola2p;

import game.Command;
import game.GameError;
import static game.agricola2p.PlayerColor.*;
import java.util.*;

public class Board extends game.Board {
	
	public int move;
	public List<Element> allElements;
	
	protected GameBoard gameBoard;
	protected EnumMap<PlayerColor, FarmBoard> farmBoards;
	
	protected PlayerColor currentPlayer;
	
	public Board() {
		this.move = 0;
		allElements = new ArrayList<Element>();
		
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

	public Command getCommand(String string) {
		return null;
	}

}
