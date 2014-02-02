package game.agricola2p;

public class Worker extends Element {
	
	public final PlayerColor color; 
	
	public Worker(Board board, PlayerColor color) {
		super(board);
		this.color = color;
	}

}
