import java.util.*;

public class TextPost extends Post {
	/**TextPost class is subclass of the Post class. 
	 * 
	 */
	private String userNames;
	private Location location=getlocation2();
	ArrayList<String> taggedusers=new ArrayList<String>();
	/**
	 * @param textContent	Variable from Post class.
	 * @param longitude		Variable from Post class.
	 * @param latitude		Variable from Post class.
	 * @param userNames		It contains the persons to be labeled.
	 */
	public TextPost(String textContent,String longitude,String latitude,String userNames){
		super(textContent,longitude,latitude);
		this.userNames=userNames;
	}
	public String getUserNames() {
		return userNames;
	}
	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}
	@Override
	public void ShowTaggedUsers() {
		String[] t_user;
		t_user=userNames.split(":");
		for(int q=0;q<t_user.length;q++){
			//int a=1;
			for(int i=0;i<Main.online_user.friends.size();i++){
				if(Main.online_user.friends.get(i).getUserName().equals(t_user[q])){
					//taggedusers.add(Main.online_user.friends.get(i).getName());
					System.out.print(Main.online_user.friends.get(i).getName()+" ");	
				}
			}
		}
	}
	@Override
	public void ShowPostLocation() {
		System.out.println("Location: "+location.getLongitude()+", "+location.getLatitude());
		
	}
}
