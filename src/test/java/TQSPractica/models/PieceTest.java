package TQSPractica.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import TQSPractica.Player;

public class PieceTest {

	@Test
	public void testToString() throws Exception {
		
		// This should had been an abstract method for each piece to implement not a public method in piece
		// Should be tested inside each concrete piece test.
		// I leave it here to show my errors :^) Also this should work when all pieces are done
		
		System.out.println("[TESTING: Piece->toString()] : String representation of the piece and it's position");
		
		String[] pos_2_test = {"e4", "h1", "h8", "c3"};
		Board board = new MockBoard();
		Player owner = Player.BLACK;
		for(String pos:pos_2_test) {

			String[] piece_identifiers = {"", "N", "R", "Q", "B", "K"};
			
			Position p = new Position(pos);
			Piece[] pieces = {
					new Pawn(board, p,owner),
					new Knight(board, p, owner),
					new Rook(board, p, owner),
					new Queen(board, p, owner),
					new Bishop(board, p, owner),
					new King(board, p, owner)
			};
			
			for (int i = 0; i < pieces.length; i++) {
				String res = pieces[i].toString();
				//String res = piece_identifiers[i]+pos;
				System.out.printf("\t>IN:%s %s OUT:%s EXPECTED:%s\n", pos, piece_identifiers[i], res, piece_identifiers[i]+pos);
				assertEquals(piece_identifiers[i]+pos, res);
			}
		}

	}
	
	@Test
	public void testgetPieceValue() throws Exception {
		// Same as above but it won't hurt to have an extra test
		System.out.println("[TESTING: Piece->getPieceValue()] : Weight of the piece in the game");

		Board board = new MockBoard();
		Player owner = Player.BLACK;
		Position p = new Position("e4");
		int[] values = {1, 3, 5, 9, 3, Integer.MAX_VALUE};
		Piece[] pieces = {
				new Pawn(board, p,owner),
				new Knight(board, p, owner),
				new Rook(board, p, owner),
				new Queen(board, p, owner),
				new Bishop(board, p, owner),
				new King(board, p, owner)
		};
		
		for (int i = 0; i < pieces.length; i++) {
			System.out.printf("\tIN:%s OUT:%d EXPECTED:%d\n", pieces[i], pieces[i].getPieceValue(), values[i]);
			assertEquals(values[i], pieces[i].getPieceValue());
		}
	}
	
	@Test
	public void testgetOwner() throws Exception {
		System.out.println("[TESTING: Piece->getOwner()] : Who owns the piece");
		Board board = new MockBoard();
		Position pos = new Position("e4");
		
		// Black
		Piece p1 = new Pawn(board, pos, Player.BLACK);
		assertEquals(p1.getOwner(), Player.BLACK);
		
		// White
		Piece p2 = new Pawn(board, pos, Player.WHITE);
		assertEquals(p2.getOwner(), Player.WHITE);
		
		// Null
		try {
			Piece p3 = new Pawn(board, pos, null);
			fail("Should rise exception a wrong owner");
		} catch (Exception e) {
			// Success
		}
		
	}
	
	@Test
	public void testLookOnDirection() throws Exception {
		// This is a protected function added when improving the moves of pieces
		
		MockBoard b = new MockBoard();
		Piece p = new Pawn(b, new Position("e4"), Player.BLACK);
		List<Position> acum = new ArrayList<Position>();
		
		// deep shall not be negative
		// and return false on sizes bigger than the board
		assertFalse(p.toTestLookOnDirection(-1, 1, 1, acum));
		assertFalse(p.toTestLookOnDirection(Integer.MAX_VALUE, 1, 1, acum));
		assertFalse(p.toTestLookOnDirection(9, 1, 1, acum));
		assertFalse(p.toTestLookOnDirection(Integer.MIN_VALUE, 1, 1, acum));
		assertTrue(p.toTestLookOnDirection(3, 1, 1, acum));

		// xmod and ymod (second and third params)
		// shall not be outside the range {-1, 0, 1}
		assertTrue(p.toTestLookOnDirection(3, -1, -1, acum));
		assertTrue(p.toTestLookOnDirection(3, 0, -1, acum));
		assertTrue(p.toTestLookOnDirection(3, -1, 0, acum));
		assertFalse(p.toTestLookOnDirection(3, -2, -1, acum));
		assertFalse(p.toTestLookOnDirection(3, -1, -2, acum));
		
		assertTrue(p.toTestLookOnDirection(3, 1, 1, acum));
		assertTrue(p.toTestLookOnDirection(3, 0, 1, acum));
		assertTrue(p.toTestLookOnDirection(3, 1, 0, acum));
		assertFalse(p.toTestLookOnDirection(3, 2, 1, acum));
		assertFalse(p.toTestLookOnDirection(3, 1, 2, acum));
		
		// acum shall not be null
		assertTrue(p.toTestLookOnDirection(3, 0, -1, acum));
		assertFalse(p.toTestLookOnDirection(3, -2, -1, null));

		
		
	}
	
	@Test
	public void testgetCurrentPosition() throws Exception {
		System.out.println("[TESTING: Piece->getCurrentPosition()] : Where is the piece");
		Board board = new MockBoard();
		Position pos1 = new Position("e4");
		Position pos2 = new Position("a7");
		
		Piece p1 = new Pawn(board, pos1, Player.BLACK);
		assertEquals(pos1, p1.getCurrentPosition());
		
		Piece p2 = new Pawn(board, pos2, Player.BLACK);
		assertEquals(pos2, p2.getCurrentPosition());
		
	}

}
