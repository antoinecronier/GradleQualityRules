package utils;

import java.util.List;

import entities.Role;
import entities.User;

public class CodeManager {

	private List<User> users;
	private List<Role> roles;

	public CodeManager(List<User> users, List<Role> roles){
		this.users = users;
		this.roles = roles;
	}

	public void reassign(User u1, User u2, List<Role> roles){
		if (!u1.getIsActive()) {
			u2.setSecurity_code(u1.getSecurity_code());
		}else{
			assign(u2);
		}

		u2.setRoles(roles);

		if (!u1.getIsActive()) {
			u2.setSecurity_code(u1.getSecurity_code());
		}else{
			assign(u2);
		}

		u2.setRoles(roles);
	}

	public void assign(User user){
		user.setSecurity_code(securityCodeSetter());
	}

	private int securityCodeSetter() {
		int c1 = RandomUtil.randomize(0,9);
		int c2 = RandomUtil.randomize(0,9);
		int c3 = RandomUtil.randomize(0,9);
		int c4 = RandomUtil.randomize(0,9);

		String secu_code = ""+c1+""+c2+""+c3+""+c4;

		for (User user : users) {
			if ((user.getSecurity_code() == Integer.parseInt(secu_code)) && user.getIsActive()) {
				secu_code = String.valueOf(securityCodeSetter());
			}
		}

		return Integer.parseInt(secu_code);
	}

	public void doABarrelRoll(){
		Role[] roles = new Role[this.roles.size()];

		int i = 0;
		for (Role role : this.roles) {
			roles[i] = role;
			i++;
		}

		for (User user : this.users) {
			int assignerLoop = RandomUtil.randomize(0,this.roles.size()-1);
			for (int j = 0; j < assignerLoop; j++) {
				Role assignableRole = roles[RandomUtil.randomize(0,this.roles.size()-1)];

				if (!user.getRoles().contains(assignableRole)) {
					user.getRoles().add(assignableRole);
				}
			}
		}
	}
}
