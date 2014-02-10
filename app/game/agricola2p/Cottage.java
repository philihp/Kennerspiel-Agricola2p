package game.agricola2p;

public class Cottage extends Building {

	public Cottage(Board board) {
		super(board);
	}

	@Override
	int getValue() {
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

}