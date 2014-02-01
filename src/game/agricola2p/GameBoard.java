package game.agricola2p;

import java.util.*;

public class GameBoard extends Element {

	protected List<Action> actions;

	public GameBoard(Board board) {
		super(board);
		this.actions = Arrays.asList(
				new ActionA1(board),
				new ActionA2(board));
	}
	
}
