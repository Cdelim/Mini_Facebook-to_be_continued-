import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	static ArrayList<String> user = new ArrayList<String>();
	static User online_user;
	/**The first file is read.The data is kept on a list.
	 * @param args	File to read
	 */
	/**The second file is read.It directs to specific methods according to the beginning of the line.
	 * @param args	Second file to read
	 */
	public static void	main(String[] args)  {
		try {
		Scanner scanner =	new	Scanner(new	File(args[0]));
			while	(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] line2 = line.split("	");
				for(String str:line2){
					user.add(str);
				}
				User t_user=new User(line2[0],line2[1],line2[2],line2[3],line2[4],line2[5]);
				UserCollection.users.add(t_user);
			}
			scanner.close();
			Scanner scanner2 =	new	Scanner(new	File(args[1]));
			while	(scanner2.hasNextLine()){
				String line = scanner2.nextLine();
				String[] line2 = line.split("	");	
				for(User user: UserCollection.users){
					if(user.getUserName().equals(line2[1])){
						online_user = user;
					}
				}
				if(line.startsWith("ADDUSER")){
					UserCollection.addUser(line2[1], line2[2], line2[3], line2[4], line2[5],line2[6]);
				}
				if(line.startsWith("REMOVEUSER")){
					UserCollection.removeUser(Integer.parseInt(line2[1]));
				}
				if(line.startsWith("SIGNIN")){
					UserCollection.userSignIn(line2[1], line2[2]);
				}
				if(line.startsWith("LISTUSERS")){
					online_user.LISTUSERS();
				}
				if(line.startsWith("UPDATEPROFILE")){
					online_user.UPDATEPROFILE(line2[1], line2[2], line2[3]);
				}
				if(line.startsWith("CHPASS")){
					online_user.CHPASS(line2[1], line2[2]);
				}
				if(line.startsWith("ADDFRIEND")){
					online_user.ADDFRIEND(line2[1],line2[2]);
				}
				if(line.startsWith("REMOVEFRIEND")){
					online_user.REMOVEFRIEND(line2[1]);
				}
				if(line.startsWith("LISTFRIENDS")){
					online_user.LISTFRIENDS();
				}
				if(line.startsWith("ADDPOST-TEXT")){
					//online_user.ADDPOSTTEXT(line2[1], line2[2], line2[3], line2[4]);
				}
				if(line.startsWith("ADDPOST-IMAGE")){
					//online_user.ADDPOSTIMAGE(line2[1], line2[2], line2[3], line2[4],line2[5],line2[6]);
				}
				if(line.startsWith("ADDPOST-VIDEO")){
					//online_user.ADDPOSTVIDEO(line2[1] , line2[2], line2[3], line2[4],line2[5],line2[6]);
				}
				if(line.startsWith("REMOVELASTPOST")){
					online_user.REMOVELASTPOST();
				}
				if(line.startsWith("SHOWPOSTS")){
					UserCollection.showPosts(line2[1]);
				}
				if(line.startsWith("BLOCKFRIEND")){
					online_user.BLOCK(line2[1],line2[2]);
				}
				if(line.startsWith("UNBLOCK")){
					online_user.UNBLOCK(line2[1]);
				}
				if(line.startsWith("SHOWBLOCKEDFRIENDS")){
					online_user.SHOWBLOCKEDFRIENDS();
				}
				if(line.startsWith("SHOWBLOCKEDUSERS")){
					online_user.SHOWBLOCKEDUSERS();
				}
				if(line.startsWith("SIGNOUT")){
					online_user.SIGNOUT();
				}						
			}
			
			scanner2.close();
		}
		catch(FileNotFoundException ex) {
		System.	out	.println("No File Found!");
			return	;
		}
		
		Login lg = new Login();
		}
	
}
