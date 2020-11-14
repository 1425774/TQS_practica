package TQSPractica;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGame() {
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
	public void testMenuState() {
		System.out.println("[TESTING: menuState() :: Display menu]");
		
		MockDisplay d = new MockDisplay();
		Game g = new Game(d);	
		
		// return false user picked exit return true user picked play
		assertTrue(g.menuState());
		d.pickExit();
		assertFalse(g.menuState());
		
	}

	@Test
	public void testSetupState() {
		System.out.println("[TESTING: setupState() :: Setup the board]");
		
		// only will return true unless something really messy happens
		// as the initialization is done by "hand"
		Game g = new Game(new MockDisplay());
		assertTrue(g.setupState());

	}

	@Test
	public void testWhiteState() {
		System.out.println("[TESTING: whiteState() :: White has to make a play]");
		
		// true made a move -- false surrendered
		MockDisplay d = new MockDisplay();
		Game g = new Game(d);
		
		assertTrue(g.whiteState());
		d.whiteSurrender();
		assertFalse(g.whiteState());
	}

	@Test
	public void testBlackState() {
		System.out.println("[TESTING: balckState() :: Black has to make a play]");
		
		// true made a move -- false surrendered
		MockDisplay d = new MockDisplay();
		Game g = new Game(d);
		
		assertTrue(g.blackState());
		d.blackSurrender();
		assertFalse(g.blackState());
	}
	
	@Test
	public void testResState() {
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
