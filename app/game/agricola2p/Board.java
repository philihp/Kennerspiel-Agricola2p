package game.agricola2p;

import game.Command;
import game.GameError;
import static game.agricola2p.PlayerColor.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Board extends game.Board {

	protected int move;
	protected int round;
	protected List<Element> allElements;

	protected GameBoard gameBoard;
	protected EnumMap<PlayerColor, FarmBoard> farmBoards;

	protected PlayerColor currentPlayer;
	
	protected Map<String, Task> tasks = new TreeMap<String,Task>();

	public Board() {
		this.move = 1;
		this.round = 1;
		allElements = new ArrayList<Element>();

		currentPlayer = RED;
		farmBoards = new EnumMap<PlayerColor, FarmBoard>(PlayerColor.class);
		farmBoards.put(RED, new FarmBoard(this, RED));
		farmBoards.put(BLUE, new FarmBoard(this, BLUE));

		// FarmBoards must be done first, because GameBoard creates
		// the Actions, and ActionStartingPlayer1Wood tries to give
		// the StartingPlayerToken to one of the FarmBoards.
		gameBoard = new GameBoard(this);

		gameBoard.onGameStart();
		for (FarmBoard farmBoard : farmBoards.values()) {
			farmBoard.onGameStart();
		}

	}

	protected FarmBoard activeFarm() {
		return farmBoards.get(currentPlayer);
	}

	public Command getCommand(String string) throws GameError {
		if (string.charAt(0) == '#') {
			return new CommandComment(string);
		}

		String[] tokens = string.split("\\s+");
		if (tokens.length == 0) {
			throw new GameError("No command submitted");
		} else {
			String command = tokens[0];
			String[] params = Arrays.copyOfRange(tokens, 1, tokens.length);
			switch (command) {
			case "ACTION":
				return new CommandAction(this, params);
			case "COMMIT":
				return new CommandCommit(this);
			case "FENCE":
				return new CommandFence(this, params);
			case "WALL":
				return new CommandWall(this, params);
			case "EXPAND":
				return new CommandExpand(this, params);
			default:
				throw new RuntimeException("Unknown Command \"" + command
						+ "\"");
			}
		}
	}

	public int getRound() {
		return round;
	}

	public int getMove() {
		return move;
	}
	
	public PlayerColor getCurrentPlayer() {
		return currentPlayer;
	}

	public EnumMap<PlayerColor, FarmBoard> getFarmBoards() {
		return farmBoards;
	}
	
	public Map<String, Task> getTasks() {
		return tasks;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}
}
