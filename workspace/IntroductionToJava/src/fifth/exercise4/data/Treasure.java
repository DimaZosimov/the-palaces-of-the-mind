package fifth.exercise4.data;

/**
 * @author Dima Zosimov
 * @version 1.0 26.01.2020
 */

public class Treasure {
	
	private String name;
	private int cost;
	
	public Treasure(String name, int cost) {
		if(cost < 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return String.format("%-40s%d", name, cost);
	}
	
}
