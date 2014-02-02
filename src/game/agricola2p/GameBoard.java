package game.agricola2p;

import static game.agricola2p.PlayerColor.RED;

import java.util.*;

public class GameBoard extends Element {

	protected Map<String, Action> actions;
	private StartingPlayerToken startingPlayerToken;

	public GameBoard(Board board) {
		super(board);
		this.actions = new HashMap<String, Action>();
		this.startingPlayerToken = new StartingPlayerToken(board);
		actions.put("SP1W", new ActionStartPlayerAnd1Wood(board, startingPlayerToken));
		actions.put("3W",new Action3Wood(board));
		actions.put("1S",new Action1Stone(board));
		actions.put("2S",new Action2Stone(board));
		actions.put("FENCES", new ActionFences(board));
	}

	@Override
	protected void onRoundStart() {
		board.currentPlayer = this.startingPlayerToken.owner;
	}
	
}
