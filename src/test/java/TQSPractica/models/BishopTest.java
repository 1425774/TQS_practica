package TQSPractica.models;

import static org.junit.Assert.*;

import org.junit.Test;

import TQSPractica.Player;

public class BishopTest {
	

	Position e1 = new Position("e1");
	Position e2 = new Position("e2");
	Position e3 = new Position("e3");
	Position e4 = new Position("e4");
	Position e5 = new Position("e5");
	Position e6 = new Position("e6");
	Position e7 = new Position("e7");
	Position e8 = new Position("e8");
	Position f3 = new Position("f3");
	Position f5 = new Position("f5");
	Position f4 = new Position("f4");
	Position d3 = new Position("d3");
	Position d5 = new Position("d5");
	Position d4 = new Position("d4");
	
	Position c6 = new Position("c6");
	Position g6 = new Position("g6");
	Position c2 = new Position("c2");
	Position f6 = new Position("f6");
	Position c3 = new Position("c3");
	
	Position a1 = new Position("a1");
	Position a2 = new Position("a2");
	Position b2 = new Position("b2");
	Position b1 = new Position("b1");
	
	Position a8 = new Position("a8");
	Position a7 = new Position("a7");
	Position b7 = new Position("b7");
	Position b8 = new Position("b8");
	
	Position h1 = new Position("h1");
	Position h2 = new Position("h2");
	Position g2 = new Position("g2");
	Position g1 = new Position("g1");
	
	Position h8 = new Position("h8");
	Position h7 = new Position("h7");
	Position g7 = new Position("g7");
	Position g8 = new Position("g8");

	@Test
	public void testToString() throws Exception {
		System.out.println("[TESTING: Bishop->toString()] : String representation of the piece and it's position");
		MockBoard b = new MockBoard();
		
		Bishop n = new Bishop(b, new Position("e4"), Player.BLACK);
		assertEquals("Be4", n.toString());
	}

	@Test
	public void testBishop() {
		System.out.println("[TESTING: Bishop->Bishop()] : Testing bad parameters in constructor");
		// Bad one -- position
		MockBoard b = new MockBoard();
		Position bad = new Position("lskdjlsk");
		try {
			Bishop n2 = new Bishop(b, bad, Player.BLACK);
			fail("Should throw exception a bad position.");
		} catch (Exception e) {
			// It worked
		}
		
		bad = null;
		try {
			Bishop n3 = new Bishop(b, bad, Player.BLACK);
			fail("Should throw exception a bad position.");
		} catch (Exception e) {
			// It worked
		}
		
		// A bad one (board)
		b = null;
		try {
			Bishop n4 = new Bishop(b, e4, Player.BLACK);
			fail("Should throw exception a bad board.");
		} catch (Exception e) {
			// It worked
		}
	}

	@Test
	public void testGetPossibleMoves() throws Exception {
		System.out.println("[TESTING: Bishop->GetPossibleMoves()] : Where can the piece can move");
		Bishop bi;
		MockBoard b = new MockBoard();
		Position[] exp;
		Position[] res;
		
		// Empty board
		bi = new Bishop(b, e4, Player.BLACK);   // Center
		exp = new Position[] {
				d5, c6, b7, a8,
				f5, g6, h7,
				d3, c2, b1,
				f3, g2, h1
		};
		res = bi.getPossibleMoves();
		assertTrue(PawnTest.comaprePositionsArray(exp, res));
		bi = new Bishop(b, a8, Player.BLACK);   // Corner -top left
		exp = new Position[] {
				d5, c6, b7, e4,
				f3, g2, h1
		};
		res = bi.getPossibleMoves();
		assertTrue(PawnTest.comaprePositionsArray(exp, res));
		bi = new Bishop(b, h1, Player.BLACK);   // Corner -bottom right
		exp = new Position[] {
				d5, c6, b7, a8,
				f3, g2, e4
		};
		res = bi.getPossibleMoves();
		assertTrue(PawnTest.comaprePositionsArray(exp, res));
		bi = new Bishop(b, h8, Player.BLACK);   // Corner -top left
		exp = new Position[] {
				g7, f6, e5, d4,
				c3, b2, a1
		};
		res = bi.getPossibleMoves();
		assertTrue(PawnTest.comaprePositionsArray(exp, res));
		bi = new Bishop(b, a1, Player.BLACK);   // Corner -bottom left
		exp = new Position[] {
				g7, f6, e5, d4,
				c3, b2, h8
		};
		res = bi.getPossibleMoves();
		assertTrue(PawnTest.comaprePositionsArray(exp, res));
		
		// Filled board -- same team
		bi = new Bishop(b, e4, Player.BLACK);
		exp = new Position[] {
				f5, g6, h7,
				d3, c2,
				f3
		};
		b.setPiece(new Queen(b, d5, Player.BLACK));
		b.setPiece(new Queen(b, g2, Player.BLACK));
		b.setPiece(new Queen(b, b1, Player.BLACK));
		res = bi.getPossibleMoves();
		assertTrue(PawnTest.comaprePositionsArray(exp, res));
		// Filled board -- Opposite team
		bi = new Bishop(b, e4, Player.WHITE);
		exp = new Position[] {
				f5, g6, h7, d5,
				d3, c2, b1,
				f3, g2
		};
		b.setPiece(new Queen(b, d5, Player.BLACK));
		b.setPiece(new Queen(b, g2, Player.BLACK));
		b.setPiece(new Queen(b, b1, Player.BLACK));
		res = bi.getPossibleMoves();
		assertTrue(PawnTest.comaprePositionsArray(exp, res));
		
		// Filled board -- Mixed
		bi = new Bishop(b, e4, Player.WHITE);
		exp = new Position[] {
				f5, g6, d5,
				d3, c2, b1,
				f3
		};
		b.setPiece(new Queen(b, d5, Player.BLACK));
		b.setPiece(new Queen(b, g2, Player.WHITE));
		b.setPiece(new Queen(b, b1, Player.BLACK));
		b.setPiece(new Queen(b, h7, Player.WHITE));
		res = bi.getPossibleMoves();
		assertTrue(PawnTest.comaprePositionsArray(exp, res));
		
	}

	@Test
	public void testGetPieceValue() throws Exception {
		System.out.println("[TESTING: King->GetPieceValue()] : Value of the piece");
		Bishop n = new Bishop(new MockBoard(), e4, Player.BLACK);
		assertEquals(3, n.getPieceValue());
	}

}
