package game.agricola2p;

public class Expansion extends Element {
	
	public Expansion(Board board) {
		super(board);
	}

	@Override
	public String getType() {
		return "EXPANSION";
	}

}
