package TQSPractica.models;

import static org.junit.Assert.*;

import org.junit.Test;

import TQSPractica.Player;

public class PieceTest {

	@Test
	public void testToString() {
		
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

}
