import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public abstract class Post implements PostInterface{
	/**Post is a abstract class.It implement PostInterface.
	 * This class abstractly contains two methods that are commonly used in subclasses
	 */
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private Location location2;
	private String date_p;
	private UUID postID;
	private String textContent;
	/**To create an object from the Post class
	 * @param textContent	Text content of the book object to be created
	 * @param longitude		Longitude of the book object to be created
	 * @param latitude		Latitude of the book object to be created
	 */
	public Post(String textContent,String longitude,String latitude){
		this.textContent=textContent;
		setText(textContent);
		Location location=new Location(longitude,latitude);
		this.location2=location;
		Date date=new Date();
		this.date_p=dateFormat.format(date);
		this.postID=UUID.randomUUID();	
	}
	public String getDate_p() {
		return date_p;
	}
	public void setDate_p(String date_p) {
		this.date_p = date_p;
	}
	public void setPostID(UUID postID) {
		this.postID = postID;
	}

	public Location getlocation2() {
		return location2;
	}
	public void setlocation2(Location lc) {
		this.location2 = lc;
	}
	@Override
	public void setText(String text) {
		this.textContent=text;
	}
	@Override
	public String getText() {
		return textContent;
	}
	@Override
	public UUID getID() {
		return postID;
	}
	@Override
	public String getDate() {
		return date_p;
	}
	/**
	 * Abstract two methods
	 */
	public abstract void ShowPostLocation();
	public abstract void ShowTaggedUsers(); 
}
