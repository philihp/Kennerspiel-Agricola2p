package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

abstract class Building extends Element {
	
	public Building(Board board) {
		super(board);
	}
	
	abstract int getValue();

	abstract boolean canBuild();

}