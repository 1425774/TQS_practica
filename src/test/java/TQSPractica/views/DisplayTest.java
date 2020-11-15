package TQSPractica.views;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import TQSPractica.Player;
import TQSPractica.models.MockBoard;
import TQSPractica.models.Move;
import TQSPractica.models.Pawn;
import TQSPractica.models.Piece;
import TQSPractica.models.Position;
import TQSPractica.models.Queen;
import TQSPractica.views.Display.Menu;

public class DisplayTest {

	@Test
	public void testShowMenu() throws FileNotFoundException {
		File f = new File("inputtest/menuok.txt");
		Scanner s = new Scanner(f);
		Display d = new TerminalDisplay(s);
		
		// OK
		assertTrue(Menu.OK == d.showMenu());
		
		// Exit
		f = new File("inputtest/menuexit.txt");
		s = new Scanner(f);
		d = new TerminalDisplay(s);
		assertTrue(Menu.EXIT == d.showMenu());
		
		// Not expected input
		f = new File("inputtest/menubadok.txt");
		s = new Scanner(f);
		d = new TerminalDisplay(s);
		assertTrue(Menu.OK == d.showMenu());
	}

	@Test
	public void testShowWinner() throws FileNotFoundException {
		File f = new File("inputtest/whatever3.txt");
		Scanner s = new Scanner(f);
		Display d = new TerminalDisplay(s);
		
		// Bad one
		try {
			d.showWinner(null);
			fail("Should raise exception");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// Good ones -- Check output
		d.showWinner(Player.BLACK);
		d.showWinner(Player.WHITE);
	}

	@Test
	public void testShowBoard() throws Exception {
		Piece[][] board = {};
		
		// Bad ones -- null
		File f = new File("inputtest/whatever3.txt");
		Scanner s = new Scanner(f);
		Display d = new TerminalDisplay(s);
		try {
			d.showBoard(null);
			fail("Should raise exception");
		} catch (Exception e) {
			// Succes
		}
		
		// Bad ones -- wrong sized
		// 7x7
		board = new Piece[][] {
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
		};
		try {
			d.showBoard(board);
			fail("Should raise exception");
		} catch (Exception e) {
			// Succes
		}
		// 9x9
		board = new Piece[][] {
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null}
		};
		try {
			d.showBoard(board);
			fail("Should raise exception");
		} catch (Exception e) {
			// Succes
		}
		
		// Good ones -- empty
		board = new Piece[][] {
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null}
		};
		d.showBoard(board); // If it not raises exception it is good
		
		// Full
		Piece p = new Pawn(new MockBoard(), new Position("e2"), Player.BLACK);
		Piece q = new Queen(new MockBoard(), new Position("e2"), Player.BLACK);
		board = new Piece[][] {
			{p,p,p,p,p,p,p,p},
			{p,p,p,p,p,p,p,p},
			{p,p,p,p,p,p,p,p},
			{p,p,p,p,p,p,p,p},
			{q,q,q,q,q,q,q,q},
			{q,q,q,q,q,q,q,q},
			{q,q,q,q,q,q,q,q},
			{q,q,q,q,q,q,q,q}
		};
		d.showBoard(board); // If it not raises exception it is good
		
	}

	@Test
	public void testGetMove() throws FileNotFoundException {
		File f = new File("inputtest/movegood.txt");
		Scanner s = new Scanner(f);
		Display d = new TerminalDisplay(s);
		
		// Bad player
		try {
			d.getMove(null);
			fail("Should raise exception");
		} catch (Exception e) {
			// Succes
		}
		
		// Good player -- valid move
		Move m = d.getMove(Player.WHITE);
		assertTrue(m.valid() && m.getDestination().equals(new Position("e2")) && m.getPieceType() == Pawn.class);
		
		// Good player -- non valid move at first // it should loop if it is not good till gets a good one
		f = new File("inputtest/movebadthengood.txt");
		s = new Scanner(f);
		d = new TerminalDisplay(s);
		m = d.getMove(Player.BLACK);
		assertTrue(m.valid() && m.getDestination().equals(new Position("e2")) && m.getPieceType() == Pawn.class);
		
		// Good player -- surrender
		f = new File("inputtest/movesurrender.txt");
		s = new Scanner(f);
		d = new TerminalDisplay(s);
		m = d.getMove(Player.BLACK);
		assertTrue(m == null);
		
	}

}
