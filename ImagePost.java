/**
 * @author Cem
 *
 */
public class ImagePost extends TextPost{
	/**ImagePost class is a subclass of the TextPost class
	 * 
	 */
	private String filePath;
	private String resolution;
	/**To create an object from ImagePost
	 * @param textContent	Variable from Post class.
	 * @param longitude		Variable from Post class.
	 * @param latitude		Variable from Post class.
	 * @param userNames		Variable from TextPost class.
	 * @param filePath		Filename of the ImagePost object to be created
	 * @param resolution	Resolution of the ImagePost object to be created
	 */
	public ImagePost(String textContent,String longitude,String latitude,String userNames,String filePath,String resolution){
		super(textContent,longitude,latitude,userNames);
		this.filePath=filePath;
		this.resolution=resolution;
	}
	public String getfilePath() {
		return filePath;
	}
	public void setfilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
}
