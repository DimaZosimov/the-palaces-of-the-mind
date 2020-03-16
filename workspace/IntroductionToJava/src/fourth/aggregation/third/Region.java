package fourth.aggregation.third;

/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Region extends AdministrativeUnit<District>{
	
	public Region(String name) {
		setName(name);
		setList(new ArrayList<District>());
	}
	
	@Override
	public boolean add(District district) {
		for(City c : district.getList()) {
			c.setRegion(this);
		}
		return getList().add(district);
	}
	
	@Override
	public void setCapital(City city) {
		City cityCap = getCapital();
		if(cityCap != null) {
			cityCap.setCapRegion(false);
		}
		for(District dis : getList()) {
			List<City> cities = dis.getList();
				if(!cities.contains(city)) {
					continue;
				} else {
					for(City c : cities) {
						if(c.equals(city)) {
							super.setCapital(c);
							c.setCapRegion(true);
						}
					}
				}
		}
		
	}	

}
