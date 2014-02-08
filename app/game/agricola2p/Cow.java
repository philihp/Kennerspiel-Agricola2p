package game.agricola2p;

public class Cow extends Element {

	public Cow(Board board) {
		super(board);
	}
	
	@Override
	public String getType() {
		return "COW";
	}

}
