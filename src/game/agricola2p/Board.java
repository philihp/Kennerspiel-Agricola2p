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
			System.out.println("COMMAND: "+command);
			for(int i=0; i < params.length; i++) {
				System.out.println("PARAMS["+i+"]: "+params[i]);
			}
			return null;
		}
	}

}
