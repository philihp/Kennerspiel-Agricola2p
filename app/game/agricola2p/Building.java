package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

abstract class Building extends Element {
	
	public Building(Board board) {
		super(board);
	}
	
	public abstract int getValue();

	public abstract boolean canBuild();
	
	public abstract int contains();
	
	public boolean canBuild(LotPasture pasture) {
		return (pasture.building == null);
	}

}
