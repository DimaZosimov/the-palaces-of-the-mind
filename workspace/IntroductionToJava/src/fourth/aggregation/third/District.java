package fourth.aggregation.third;

/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.ArrayList;

public class District extends AdministrativeUnit<City>{
	
	public District(String name) {
		setName(name);
		setList(new ArrayList<City>());
	}
	
	@Override
	public boolean add(City city) {
		city.setDistrict(this);
		return getList().add(city);
	}
	
	public void setCapital(City city) {
		City cityCap = getCapital();
		if(cityCap != null) {
			cityCap.setCapDistrict(false);
		}
		if(!getList().contains(city)) {
			add(city);
		} else {
			for(City c : getList()) {
				if(c.equals(city)) {
					super.setCapital(c);;
					c.setCapDistrict(true);
				}
			}
		}
	}
	
}
