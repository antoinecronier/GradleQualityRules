

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entities.Role;
import entities.User;
import utils.CodeManager;
import utils.RandomUtil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.javafaker.Faker;

public class CodeManagerTest {

	private final static int USER_MIN_NUMBER = 0;
	private final static int ROLE_MIN_NUMBER = 0;
	private final static int USER_MAX_NUMBER = 10000;
	private final static int ROLE_MAX_NUMBER = 10;
	private final static int TEST_LOOPER = 10000;

	private static CodeManager manager;
	private static List<User> users;
	private static List<Role> roles;
	private static Faker faker;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		faker = new Faker();
		users = new ArrayList<User>();
		roles = new ArrayList<Role>();

		int i = RandomUtil.randomize(USER_MIN_NUMBER, USER_MAX_NUMBER);
		while (i > 0) {
			users.add(new User(faker.firstName(), faker.lastName(),
					(RandomUtil.randomize(0, 1) == 0) ? true : false,
					RandomUtil.randomize(1111, 9999), new ArrayList<Role>()));
			i--;
		}

		int j = RandomUtil.randomize(ROLE_MIN_NUMBER, ROLE_MAX_NUMBER);
		while (j > 0) {
			roles.add(new Role(faker.words(1).get(0), j, new ArrayList<User>()));
			j--;
		}

		for (User user : users) {
			int loop = RandomUtil.randomize(0, roles.size() - 1);

			for (int k = 0; k < loop; k++) {
				Role roleTmp = roles.get(RandomUtil.randomize(0,
						roles.size() - 1));
				if (!user.getRoles().contains(roleTmp)) {
					user.getRoles().add(roleTmp);
					roleTmp.getUsers().add(user);
				}
			}
		}

		manager = new CodeManager(users, roles);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void reassignTest() {
		Boolean failure = false;
		User uTest = new User();
		uTest.setIsActive(true);
		manager.assign(uTest);

		for (int i = 0; i < TEST_LOOPER; i++) {
			manager.reassign(
					users.get(RandomUtil.randomize(0, users.size() - 1)),
					uTest, roles);
			for (User user : users) {
				if (user.getSecurity_code() == uTest.getSecurity_code()
						&& user.getIsActive()) {
					System.out.println("check");
					failure = true;
					fail("Security code already assign");
				}
			}
		}

		if (!failure) {
			assertTrue(true);
		}
	}

	@Test
	public void assignTest() {
		Boolean failure = false;
		User uTest = new User();
		uTest.setIsActive(true);

		for (int i = 0; i < TEST_LOOPER; i++) {
			manager.assign(uTest);
			for (User user : users) {
				if (user.getSecurity_code() == uTest.getSecurity_code()
						&& user.getIsActive()) {
					failure = true;
					fail("Security code already assign");
				}
			}
		}

		if (!failure) {
			assertTrue(true);
		}
	}

	@Test
	public void doABarrelRollTest() {
		manager.doABarrelRoll();
		for (User user : users) {
			Set<Role> set = new HashSet<Role>(user.getRoles());

			if (set.size() < user.getRoles().size()) {
				fail("Duplicate role assign");
			}
		}
	}
}
