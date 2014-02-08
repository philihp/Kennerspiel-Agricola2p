package game.agricola2p;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
abstract class Element {
	
	protected int lastTouched;
	
	protected Board board;
	
	public Element(Board board) {
		this.board = board;
		board.allElements.add(this);
		touch();
	}
	
	public void touch() {
		this.lastTouched = board.move;
	}
	
	abstract public String getType();

	protected void onRoundStart() {
	}

	protected void onRoundEnd() {
	}
	
	protected void onGameStart() {
		onRoundStart();
	}
	
	protected void onGameEnd() {
	}
}
