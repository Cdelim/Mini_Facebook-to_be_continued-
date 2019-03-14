
public class VideoPost extends TextPost{
	private String filename;
	private String duration;
	/**To create an object from VideoPost
	 * @param textContent	Variable from Post class.
	 * @param longitude		Variable from Post class.
	 * @param latitude		Variable from Post class.
	 * @param userNames		Variable from TextPost class.
	 * @param filePath		Filename of the VideoPost object to be created
	 * @param videoDuration	Video duration of the VideoPost object to be created
	 */
	public VideoPost(String textContent,String longitude,String latitude,String userNames,String filePath,String videoDuration){
		super(textContent,longitude,latitude,userNames);
		this.filename=filePath;
		this.duration=videoDuration;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
}
