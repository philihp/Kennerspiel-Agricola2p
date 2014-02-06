package game.agricola2p;

public class StartingPlayerToken extends Element {
	
	protected PlayerColor owner;

	public StartingPlayerToken(Board board) {
		super(board);
	}

	@Override
	public String getType() {
		return "STARTING_PLAYER_TOKEN";
	}

}
