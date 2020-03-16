package fourth.aggregation.third;

/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.ArrayList;

public class Country extends AdministrativeUnit<Region>{
	
	private double square;
	
	public Country(String name) {
		setName(name);
		setList(new ArrayList<Region>());
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}
	
	@Override
	public void setCapital(City city) {
		super.setCapital(city);
		city.setCapital(true);
		for(Region r : getList()) {
			for(District d : r.getList()) {
				for(City c : d.getList()) {
					if(c.isCapital()) {
						c.setCapital(false);
					}
				}
			}
		}
	}

}
