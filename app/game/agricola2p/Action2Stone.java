package game.agricola2p;

import game.GameError;
import java.util.*;

public class Action2Stone extends Action implements CommittableAfterTaken {
	
	public Action2Stone(Board board) {
		super("2S", board);
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		resources.add(new Stone(board));
		resources.add(new Stone(board));
	}

}
