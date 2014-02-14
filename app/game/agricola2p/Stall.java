package game.agricola2p;

public class Stall extends Building {
	
	protected boolean isStable;

	public Stall(Board board) {
		super(board);
		isStable = false;
	}

	@Override
	public int getValue() {
		return isStable?4:1;
	}

	@Override
	public String getType() {
		return isStable?"STABLE":"STALL";
	}
	
	/**
	 * This is false so the BUILD action doesn't think it can build
	 * it. It's only buildable by the STALL action, which doesn't
	 * give a shit.
	 */
	@Override
	public boolean canBuild() {
		return false;
	}

	@Override
	public int contains() {
		return isStable?5:3;
	}

	@Override
	public boolean canBuildAt(LotPasture pasture) {
		return pasture.building == null;
	}

}
