package game.agricola2p;

public class HalfTimberedHouse extends Building {

	public HalfTimberedHouse(Board board) {
		super(board);
	}

	@Override
	public int getValue() {
		return 5;
	}

	@Override
	public String getType() {
		return "HALF_TIMBERED_HOUSE";
	}
	
	
	@Override
	public int contains() {
		return 2;
	}

	@Override
	public boolean canBuildAt(LotPasture pasture) {
		return pasture.building != null && pasture.building instanceof Cottage;
	}

	@Override
	public boolean canBuild() {
		return canBuildWith(3, 2, 1);
	}

}
