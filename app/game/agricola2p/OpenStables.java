package game.agricola2p;

import game.GameError;

public class OpenStables extends Building {

	public OpenStables(Board board) {
		super(board);
	}

	@Override
	public int getValue() {
		return 2;
	}

	@Override
	public String getType() {
		return "OPEN_STABLES";
	}

	@Override
	public boolean canBuild() {
		return canBuildWith(3, 0, 0) || canBuildWith(0, 3, 0);
	}

	@Override
	public int contains() {
		return 5;
	}
	
	@Override
	protected void build(FarmBoard owner, String[] params) throws GameError  {
		super.build(owner, params);
		if(params.length != 2) {
			throw new GameError("OPEN_STABLES needs to be built with WOOD/STONE, and if it should give HORSE/COW");
		}
		
		switch(params[0]) {
		case "WOOD":
			eatResources(3, 0, 0);
			break;
		case "STONE":
			eatResources(0, 3, 0);
			break;
		default:
			throw new GameError("First parameter should be WOOD or STONE");
		}
		
		switch(params[1]) {
		case "HORSE" :
			owner.resources.add(new Horse(board));
			break;
		case "COW":
			owner.resources.add(new Cow(board));
			break;
		default :
			throw new GameError("Second parameter should be HORSE or COW");
		}
	}

	@Override
	public boolean canBuildAt(LotPasture pasture) {
		return (pasture.building instanceof Stall);
	}
	
}
