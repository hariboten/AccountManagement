/*package hariboten;

import java.util.HashMap;
import java.util.Map;

class UserRepository {
	private static UserRepository singleton;
	private Map<Id, User> users = new HashMap<Id, User>();
	private UserRepository() {
	}
	public static synchronized UserRepository getUserRepository() {
		if (singleton == null) {
			singleton = new UserRepository();
		}
		return singleton;
	}


	public void addUser(User user) {
		users.put(user.getId(), user);
	}

	public User getUser(Id userId) {
		return users.get(userId);
	}


}
*/
