package game.agricola2p;

import static game.agricola2p.PlayerColor.RED;

import java.util.*;

public class GameBoard extends Element {

	protected Map<String, Action> actions;
	private StartingPlayerToken startingPlayerToken;
	
	private static void addAction(Map<String, Action> map, Action action) {
		map.put(action.id, action);
	}
	

	public GameBoard(Board board) {
		super(board);
		this.actions = new HashMap<String, Action>();
		this.startingPlayerToken = new StartingPlayerToken(board);
		addAction(actions, new ActionStartPlayerAnd1Wood(board, this.startingPlayerToken));
		addAction(actions, new Action3Wood(board));
		addAction(actions, new Action1Stone(board));
		addAction(actions, new Action2Stone(board));
		addAction(actions, new ActionFences(board));
	}

	@Override
	protected void onRoundStart() {
		board.currentPlayer = this.startingPlayerToken.owner;
	}
	
}
