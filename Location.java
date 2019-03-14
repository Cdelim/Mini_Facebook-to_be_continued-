
public class Location {
	private String latitude;
	private String longitude;
	/**Creates an object from the Location class according to the given values. 
	 * The object is used to indicate the location of the posts	
	 * @param longitude First coordinate value
	 * @param latitude	Second coordinate value
	 */
	public Location(String longitude,String latitude){
		this.longitude=longitude;
		this.latitude=latitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
