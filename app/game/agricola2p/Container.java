package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

abstract class Container extends Element {
	
	public List<Element> resources;

	public Container(Board board, int initialSize) {
		super(board);
		resources = new ArrayList<Element>(initialSize);
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T find(final Class<T> clazz) {
		for(Object e : resources) {
			if(clazz.isInstance(e))
				return (T)e;
		}
		return null;
	}
	
}
