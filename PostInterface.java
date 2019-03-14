import java.util.UUID;

public interface PostInterface {
	/**Interface class. It is implemented in the post class.
	 * @param text Text content
	 */
	public void setText(String text);
	public String getText();
	public UUID getID();
	public String getDate();
}
