package game.agricola2p;

import java.util.*;

public class FarmBoard extends Element {
	
	protected List<Element> resources;
	
	protected final PlayerColor color;

	public FarmBoard(Board board, PlayerColor color) {
		super(board);
		this.color = color;
		this.resources = new ArrayList<Element>();
	}
	
}
