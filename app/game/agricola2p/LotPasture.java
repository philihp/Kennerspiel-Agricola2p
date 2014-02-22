package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

public class LotPasture extends Lot {
	
	protected List<Element> resources;

	public LotPasture(Board board) {
		super(board);
		resources = new ArrayList<Element>();
		this.building = null;
	}

	protected Building building;
	
	protected Trough trough;

	@Override
	public String getType() {
		return "LOT_P";
	}
	
	public Trough getTrough() {
		return trough;
	}
	
	public Building getBuilding() {
		return building;
	}

	public List<Element> getResources() {
		return resources;
	}
}
