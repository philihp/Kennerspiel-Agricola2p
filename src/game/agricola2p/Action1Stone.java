package game.agricola2p;

import game.GameError;
import java.util.*;

public class Action1Stone extends Action {
	

	public Action1Stone(Board board) {
		super(board);
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		resources.add(new Stone(board));
	}

}
