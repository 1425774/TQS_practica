package TQSPractica;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGame() throws Exception {
		System.out.println("[TESTING: Game() :: Constructor]");
		
		MockDisplay d = new MockDisplay();
		Game g;
		
		// Good stuff
		g = new Game(d);
		assertTrue(d.equals(g.getDisplay()));
		
		// Bad stuff
		try {
			g = new Game(null);
			fail("Game can't start without a display");
		} catch (Exception e) {
			// Success
		}		
	}

	@Test
	public void testMenuState() throws Exception {
		System.out.println("[TESTING: menuState() :: Display menu]");
		
		MockDisplay d = new MockDisplay();
		Game g = new Game(d);	
		
		// return false user picked exit return true user picked play
		assertTrue(g.menuState());
		d.pickExit();
		assertFalse(g.menuState());
		
	}

	@Test
	public void testWhiteState() throws Exception {
		System.out.println("[TESTING: whiteState() :: White has to make a play]");
		
		MockDisplay d = new MockDisplay();
		Game g = new Game(d);
		
		
		// good move
		assertTrue(g.whiteState() == Game.LEGAL);
		// bad move
		d.badMove();
		assertTrue(g.whiteState() == Game.ILLEGAL);
		// surrender
		d.whiteSurrender();
		assertTrue(g.whiteState() == Game.SURRENDER);
		
	}

	@Test
	public void testBlackState() throws Exception {
		System.out.println("[TESTING: balckState() :: Black has to make a play]");
		

		MockDisplay d = new MockDisplay();
		Game g = new Game(d);
		
		
		// good move
		assertTrue(g.blackState() == Game.LEGAL);
		// bad move
		d.badMove();
		assertTrue(g.blackState() == Game.ILLEGAL);
		// surrender
		d.blackSurrender();
		assertTrue(g.blackState() == Game.SURRENDER);
	}
	
	@Test
	public void testResState() throws Exception {
		System.out.println("[TESTING: resState() :: Shows result]");
		
		// returns the player that won, if either won return null
		MockDisplay d = new MockDisplay();
		Game g = new Game(d);
		
		// no one winning
		assertTrue(g.resState() == null);
		
		// Black surrenders
		d.blackSurrender();
		g.blackState();
		assertTrue(g.resState() == Player.WHITE);
		
		// White surrenders
		d.whiteSurrender();
		g.whiteState();
		assertTrue(g.resState() == Player.BLACK);
		
		// White wins
		d = new MockDisplay();
		g = new Game(d);
		d.whitewins(g);
		assertTrue(g.resState() == Player.WHITE);
		
		// Black wins
		d = new MockDisplay();
		g = new Game(d);
		d.blackwins(g);
		assertTrue(g.resState() == Player.BLACK);
		
	}

}