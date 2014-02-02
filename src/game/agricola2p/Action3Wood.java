package game.agricola2p;

import game.GameError;
import java.util.*;

public class Action3Wood extends Action {
	

	public Action3Wood(Board board) {
		super(board);
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		resources.add(new Wood(board));
		resources.add(new Wood(board));
		resources.add(new Wood(board));
	}

}
