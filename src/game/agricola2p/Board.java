package game.agricola2p;

import game.GameError;
import java.util.*;

public class Board extends game.Board {
	
	public int move;
	public List<Element> elements;
	
	protected GameBoard gameBoard;
	protected EnumMap<PlayerColor, FarmBoard> farmBoard;
	
	protected PlayerColor startingPlayer;
	protected PlayerColor currentPlayer;
	
	public Board() {
		this.move = 0;
		elements = new ArrayList<Element>();
		gameBoard = new GameBoard(this);
		farmBoard = new EnumMap<PlayerColor, FarmBoard>(PlayerColor.class);
		farmBoard.put(PlayerColor.RED, new FarmBoard(this));
		farmBoard.put(PlayerColor.BLUE, new FarmBoard(this));
		startingPlayer = PlayerColor.RED;
	}
	
	protected void onRoundStart() {
		currentPlayer = startingPlayer;
	}
	
	protected FarmBoard activeFarm() {
		return farmBoard.get(currentPlayer);
	}

	@Override
	public void runCommand(String command) throws GameError {
		move++;
	}

}
