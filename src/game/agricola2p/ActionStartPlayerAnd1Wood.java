package game.agricola2p;

import static game.agricola2p.PlayerColor.RED;
import game.GameError;
import java.util.*;

public class ActionStartPlayerAnd1Wood extends Action {
	
	private StartingPlayerToken startingPlayerToken; 

	public ActionStartPlayerAnd1Wood(Board board, StartingPlayerToken startingPlayerToken) {
		super("SP1W", board);
		this.startingPlayerToken = startingPlayerToken;
		board.farmBoards.get(RED).resources.add(startingPlayerToken);
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		resources.add(new Wood(board));
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		
		// take it away from the current owner
		board.farmBoards.get(startingPlayerToken.owner).resources.remove(startingPlayerToken);
		
		// give it to the current player
		board.farmBoards.get(board.currentPlayer).resources.add(startingPlayerToken);
		
		// tell the token who its new owner is
		startingPlayerToken.owner = board.currentPlayer;
		startingPlayerToken.touch();

	}
	
}
