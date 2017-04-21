

import java.util.ArrayList;

import entities.Role;
import entities.User;
import utils.CodeManager;

public class Application {

	public static void main(String[] args) {
		User user = new User();
		user.setFirstname("fn");
		user.setLastname("ln");

		CodeManager manager = new CodeManager(new ArrayList<User>(), new ArrayList<Role>());
		manager.assign(user);

		System.out.println(user.getSecurity_code());
	}

}
