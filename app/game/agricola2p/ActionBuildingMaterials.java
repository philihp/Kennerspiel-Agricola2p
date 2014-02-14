package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionBuildingMaterials extends Action implements CommittableAfterTaken {

	public ActionBuildingMaterials(Board board) {
		super("RSW", board);
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		List<Element> resources = board.activeFarm().resources;
		resources.add(new Reed(board));
		resources.add(new Stone(board));
		resources.add(new Wood(board));
	}


}
