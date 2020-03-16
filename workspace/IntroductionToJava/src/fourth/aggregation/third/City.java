package fourth.aggregation.third;

/**
 * 
 * @author Dima Zosimov
 *
 */

public class City {
	
	private String name;
	private boolean isCapital = false;
	private boolean isCapDistrict = false;
	private boolean isCapRegion = false;
	private Region region;
	private District district;
	
	public City(String name, Region region, District district) {
		this.name = name;
		this.region = region;
		this.region.add(district);
		this.district = district;
		this.district.add(this);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isCapital() {
		return isCapital;
	}
	
	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
	}
	
	public boolean isCapDistrict() {
		return isCapDistrict;
	}
	
	public void setCapDistrict(boolean isCapDistrict) {
		this.isCapDistrict = isCapDistrict;
	}
	
	public boolean isCapRegion() {
		return isCapRegion;
	}
	
	public void setCapRegion(boolean isCapRegion) {
		this.isCapRegion = isCapRegion;
	}
	
	public Region getRegion() {
		return region;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
	
	public District getDistrict() {
		return district;
	}
	
	public void setDistrict(District district) {
		this.district = district;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s", name, district.toString(), region.toString());
	}
	

}
