package game.agricola2p;

public class Cottage extends Building {

	public Cottage(Board board) {
		super(board);
	}

	@Override
	public int getValue() {
		return 0;
	}

	@Override
	public String getType() {
		return "COTTAGE";
	}
	
	@Override
	public boolean canBuild() {
		return false;
	}

	@Override
	public int contains() {
		return 1;
	}

	@Override
	public boolean canBuildAt(LotPasture pasture) {
		return false;
	}

}
