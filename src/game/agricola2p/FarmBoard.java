package game.agricola2p;

import java.util.*;

public class FarmBoard extends Element {
	
	protected List<Resource> resources;

	public FarmBoard(Board board) {
		super(board);
		this.resources = new ArrayList<Resource>();
	}
	
}
