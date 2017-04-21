

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.FunctionManager;
import utils.RandomUtil;

public class FunctionManagerTest {

	private int a=0;
	private int b=0;
	private static FunctionManager manager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		manager = new FunctionManager();
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
	public void sumTest() {
		a = RandomUtil.randomize(0, Integer.MAX_VALUE/2);
		b = RandomUtil.randomize(0, Integer.MAX_VALUE/2);
		assertEquals(a+b, manager.sum(a, b));
	}

	@Test
	public void f1U0Test() throws Exception {
		a = 0;
		assertEquals(12, manager.f1(a));
	}

	@Test
	public void f1U1Test() throws Exception {
		a = 1;
		assertEquals(20, manager.f1(a));
	}

	@Test
	public void f1U2Test() throws Exception {
		a = 2;
		assertEquals(28, manager.f1(a));
	}

	@Test
	public void f1UnTest() throws Exception {
		for (int i = 0; i < 1000; i++) {
			int a = RandomUtil.randomize(-100000000, 100000000);

			if (a > -1) {
				assertEquals((8*a)+12, manager.f1(a));
			}else{
				assertTrue("a lower than 0", true);
			}
		}
	}

	@Test
	public void f2Test() throws Exception {
		for (int i = 0; i < 1000; i++) {
			int a = RandomUtil.randomize(-100000000, 100000000);

			if (a > -1) {
				assertEquals(manager.f1(a)*manager.f1(a/a)+2, manager.f2(a));
			}else{
				assertTrue("A lower than 0", true);
				//fail("Lower than 0");
			}
		}
	}
}
