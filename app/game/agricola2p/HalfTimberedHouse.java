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
		return "HOUSE";
	}
	
	@Override
	public boolean canBuild() {
		return false;
	}
	
	@Override
	public int contains() {
		return 2;
	}

	@Override
	public boolean canBuild(LotPasture pasture) {
		return pasture.building != null && pasture.building instanceof Cottage;
	}

}
