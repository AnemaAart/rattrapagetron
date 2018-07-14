package model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testAccelerate() {
		final int expected = 0;
		final PlayerPh player = new PlayerPh(-1, -1, 0, 0, null);
		assertEquals(expected, player.getVelocityX());
	}

	@Test
	public void testCrash() {
		final int expected = 0;
		final PlayerPh player = new PlayerPh(-1, -1, 0, 0, null);
		assertEquals(expected, player.getVelocityX());
	}

}
