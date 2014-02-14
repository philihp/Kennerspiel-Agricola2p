package game.agricola2p;

import game.GameError;

public class StorageBuilding extends Building {

	public StorageBuilding(Board board) {
		super(board);
	}

	@Override
	public int getValue() {
		if(owner == null) return 0;
		
		int resourceCount = 0;
		for (Element e : owner.getResources()) {
			if (e instanceof Wood || e instanceof Reed || e instanceof Wood) {
				resourceCount++;
			}
		}

		return resourceCount / 2;
	}

	@Override
	public String getType() {
		return "STORAGE_BUILDING";
	}

	@Override
	public boolean canBuild() {
		return canBuildWith(2, 0, 1);
	}

	@Override
	public int contains() {
		return 0;
	}

	@Override
	public boolean canBuildAt(LotPasture pasture) {
		return pasture.building == null;
	}

}
