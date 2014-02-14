package game.agricola2p;

import game.GameError;

public class Shelter extends Building {

	public Shelter(Board board) {
		super(board);
	}

	@Override
	public int getValue() {
		return 0;
	}

	@Override
	public String getType() {
		return "SHELTER";
	}

	@Override
	public boolean canBuild() {
		return canBuildWith(2, 1, 0);
	}

	@Override
	public int contains() {
		return 1;
	}
	
	@Override
	protected void build(FarmBoard owner, String[] params) throws GameError  {
		super.build(owner, params);
		if(params.length != 1) {
			throw new GameError("SHELTER needs to know what animal to give");
		}
		
		switch(params[1]) {
		case "SHEEP" :
			owner.resources.add(new Sheep(board));
			break;
		case "PIG":
			owner.resources.add(new Pig(board));
			break;
		case "HORSE" :
			owner.resources.add(new Horse(board));
			break;
		case "COW":
			owner.resources.add(new Cow(board));
			break;
		default :
			throw new GameError("Second parameter should be HORSE, COW, SHEEP, or PIG");
		}
	}

	@Override
	public boolean canBuildAt(LotPasture pasture) {
		return (pasture.building instanceof Stall);
	}
	
}
