package game.agricola2p;

import game.GameError;


import java.util.*;

import com.google.common.collect.*;
import com.google.common.collect.Table.Cell;


public class FarmBoard extends Element {

	protected List<Element> resources;

	protected final PlayerColor color;

	private List<Worker> workers = new ArrayList<Worker>(3);

	protected int rowRangeMin = 0;
	protected int rowRangeMax = 6;

	protected int colRangeMin = 10;
	protected int colRangeMax = 14;

	protected ArrayTable<Integer, Integer, Lot> terrain = createTerrainTable();

	public FarmBoard(Board board, PlayerColor color) {
		super(board);
		this.color = color;
		this.resources = new ArrayList<Element>();
		resources.add(new Fence(board));
		resources.add(new Fence(board));
		resources.add(new Fence(board));
		resources.add(new Fence(board));
		resources.add(new Fence(board));
		resources.add(new Fence(board));
		resources.add(new Fence(board));
		resources.add(new Fence(board));

		workers.add(new Worker(board, color));
		workers.add(new Worker(board, color));
		workers.add(new Worker(board, color));
		resources.addAll(workers);
	}
	
	protected Fence findFence() {
		for(Element e : resources) {
			if(e instanceof Fence) 
				return (Fence)e;
		}
		return null;
	}
	
	protected Wood findWood() {
		for(Element e : resources) {
			if(e instanceof Wood) 
				return (Wood)e;
		}
		return null;
	}
	
	protected Stone findStone() {
		for(Element e : resources) {
			if(e instanceof Stone) 
				return (Stone)e;
		}
		return null;
	}

	protected boolean hasWorker() {
		for (Worker w : workers) {
			if (resources.contains(w)) {
				return true;
			}
		}
		return false;
	}

	protected Worker getFreeWorker() throws GameError {
		for (Worker w : workers) {
			if (resources.contains(w)) {
				return w;
			}
		}
		throw new GameError("No free workers for " + color + " farm");
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		for (Element e : resources) {
			e.onRoundStart();
		}
	}

	@Override
	protected void onRoundEnd() {
		super.onRoundEnd();
		for (Element e : resources) {
			e.onRoundEnd();
		}
	}

	protected Set<Integer> getRowRange() {
		return ContiguousSet.create(Range.closed(rowRangeMin, rowRangeMax), 
				DiscreteDomain.integers());
	}
	protected Set<Integer> getColRange() {
		return ContiguousSet.create(Range.closed(colRangeMin, colRangeMax), 
				DiscreteDomain.integers());
	}

	protected ArrayTable<Integer, Integer, Lot> createTerrainTable() {
		ArrayTable<Integer, Integer, Lot> terrain = ArrayTable.create(getRowRange(),getColRange());
		
		for(Cell<Integer, Integer, Lot> cell : terrain.cellSet()) {
			int row = cell.getRowKey();
			int col = cell.getColumnKey();
			Lot lot = null;
			if(row % 2 == 0) {
				if(col % 2 == 0) {
					lot = new LotIntersection(board);
				}
				else {
					lot = new LotHorizontalFence(board);
				}
			}
			else {
				if(col % 2 == 0) {
					lot = new LotVerticalFence(board);
				}
				else {
					lot = new LotPasture(board);
				}
			}
			terrain.put(cell.getRowKey(), cell.getColumnKey(), lot);
		}
		((LotPasture)terrain.get(5, 11)).building = new Cottage(board); 
		
		return terrain;
	}
	
	public Lot[][] getTerrain() {
		return terrain.toArray(Lot.class);
	}

	public List<Element> getResources() {
		return resources;
	}

	@Override
	public String getType() {
		return "FARM";
	}

}