package game.agricola2p;

public class Element {
	
	protected int lastTouched;
	
	protected Board board;
	
	public Element(Board board) {
		this.board = board;
		board.elements.add(this);
		touch();
	}
	
	public void touch() {
		this.lastTouched = board.move;
	}

	protected void onRoundStart() {
	}

	protected void onRoundEnd() {
	}
	
	protected void onGameStart() {
	}
	
	protected void onGameEnd() {
	}
}
