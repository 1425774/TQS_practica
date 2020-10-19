package TQSPractica.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void testGetChessPosition() {
		
		System.out.println("[TESTING: Position->getChessPosition()] : Chess notation to chess notation");
		String[][] payload = new String[][] {
			// Tests
			{
				"", "1a","11","aa", "asjq83",	// Rubbish
				"a1","h1","a8","h8",			// Limits
				"a0","h0","a7","h7",
				"a2","h2","a9","h9",
				"z1","g1","z8","g8",
				"b1","i1","b8","i8",
				"d4","f6"						// Some in the center
				
			},
			// Solutions
			{
				null, null, null, null, null,
				"a1","h1","a8","h8",
				null, null,"a7","h7",
				"a2","h2",null,null,
				null,"g1",null,"g8",
				"b1",null,"b8",null,
				"d4","f6"
			}
		};
		
		for (int i = 0; i < payload[0].length; i++) {
			Position test = new Position(payload[0][i]);
			String aux = test.getChessPosition();
			System.out.printf("\t>IN:%s OUT:%s EXPECTED:%s\n",payload[0][i], aux, payload[1][i]);
			assertEquals(payload[1][i], aux);
		}
		
		System.out.println("[TESTING: Position->getChessPosition()] : Coordinates to chess notation");
		int[][] payload2 = new int[][] {
			{}, {1,1,1},{-1,12},{2,-1}, {2},	// Rubbish
			{0, 7},{7,7},{0,0},{7,0},			// Limits
			{0, 8},{7,8},{0,1},{7,1},
			{0, 6},{7,6},{0,-1},{7,-1},
			{-1, 7},{6,7},{-1,0},{6,0},
			{1, 7},{8,7},{1,0},{8,0},
			{3,4},{5,2}							// Some in the center
				
			};
			// Solutions
		String[] solutions = new String[] {
			null, null, null, null, null,
			"a1","h1","a8","h8",
			null, null,"a7","h7",
			"a2","h2",null,null,
			null,"g1",null,"g8",
			"b1",null,"b8",null,
			"d4","f6"
		};
		
		for (int i = 0; i < payload.length; i++) {
			Position test = new Position(payload2[i][0],payload2[i][1]);
			String aux = test.getChessPosition();
			System.out.printf("\t>IN:%s OUT:%s EXPECTED:%s\n",payload2[i], aux, solutions[i]);
			assertEquals(solutions[i], aux);
		}
	}

	@Test
	public void testGetCoorPosition() {
		System.out.println("[TESTING: Position->getCoorPosition()] : Chess notation to coordinates");
		String[] payload = new String[] {
			"", "1a","11","aa", "asjq83",	// Rubbish
			"a1","h1","a8","h8",			// Limits
			"a0","h0","a7","h7",
			"a2","h2","a9","h9",
			"z1","g1","z8","g8",
			"b1","i1","b8","i8",
			"d4","f6"						// Some in the center
		};
		int[][] solutions = new int[][] {
			null, null, null, null, null,	// Rubbish
			{0, 7},{7,7},{0,0},{7,0},		// Limits
			null, null,{0,1},{7,1},
			{0, 6},{7,6}, null, null,
			null,{6,7}, null,{6,0},
			{1, 7}, null,{1,0}, null,
			{3,4},{5,2}	
		};
		
		for (int i = 0; i < payload.length; i++) {
			Position test = new Position(payload[i]);
			int[] aux = test.getCoorPosition();
			System.out.printf("\t>IN:%s OUT:%s EXPECTED:%s\n",payload[i], aux, solutions[i]);
			assertEquals(solutions[i], aux);
		}
		
		System.out.println("[TESTING: Position->getCoorPosition()] : Coordiantes to coordinates");
		
		int[][][] payload2 = new int[][][] {
			// Test
			{
				{}, {1,1,1},{-1,12},{2,-1}, {2},	// Rubbish
				{0, 7},{7,7},{0,0},{7,0},			// Limits
				{0, 8},{7,8},{0,1},{7,1},
				{0, 6},{7,6},{0,-1},{7,-1},
				{-1, 7},{6,7},{-1,0},{6,0},
				{1, 7},{8,7},{1,0},{8,0},
				{3,4},{5,2}
			},
			// Solutions
			{
				null, null, null, null, null,	// Rubbish
				{0, 7},{7,7},{0,0},{7,0},		// Limits
				null, null,{0,1},{7,1},
				{0, 6},{7,6}, null, null,
				null,{6,7}, null,{6,0},
				{1, 7}, null,{1,0}, null,
				{3,4},{5,2}	
			}
		};
		
		for (int i = 0; i < payload2[0].length; i++) {
			Position test = new Position(payload2[0][i][0], payload2[0][i][1]);
			int[] aux = test.getCoorPosition();
			System.out.printf("\t>IN:%s OUT:%s EXPECTED:%s\n",payload2[0][i], aux, payload2[1][i]);
			assertEquals(payload2[1][i], aux);
		}
		
	}

	@Test
	public void testGetTileId() {
		
		System.out.println("[TESTING: Position->getTileId()] : Coordiantes to coordinates");
		String[] payload = new String[] {
				"", "1a","11","aa", "asjq83",	// Rubbish
				"a1","h1","a8","h8",			// Limits
				"a0","h0","a7","h7",
				"a2","h2","a9","h9",
				"z1","g1","z8","g8",
				"b1","i1","b8","i8",
				"d4","f6"						// Some in the center
			};
		int[] solutions = new int[] {
				Position.ERR_NON_EXISTENT_TILE,
				Position.ERR_NON_EXISTENT_TILE,
				Position.ERR_NON_EXISTENT_TILE,
				Position.ERR_NON_EXISTENT_TILE,
				56, 63, 0, 7,
				Position.ERR_NON_EXISTENT_TILE, Position.ERR_NON_EXISTENT_TILE, 8, 15,
				48, 55, Position.ERR_NON_EXISTENT_TILE, Position.ERR_NON_EXISTENT_TILE,
				Position.ERR_NON_EXISTENT_TILE, 62, Position.ERR_NON_EXISTENT_TILE, 6,
				57, Position.ERR_NON_EXISTENT_TILE, 1, Position.ERR_NON_EXISTENT_TILE,
				35, 21
		};
		
		for (int i = 0; i < solutions.length; i++) {
			Position test = new Position(payload[i]);
			int aux = test.getTileId();
			System.out.printf("\t>IN:%s OUT:%s EXPECTED:%s\n",payload[i], aux, solutions[i]);
			assertEquals(payload[i], aux);
		}
	}

	@Test
	public void testSetPositionString() {
		
		System.out.println("[TESTING: Position->setPosition(Strnig)]");
		
		String[] payload = new String[] {
				"", "1a","11","aa", "asjq83",	// Rubbish
				"a1","h1","a8","h8",			// Limits
				"a0","h0","a7","h7",
				"a2","h2","a9","h9",
				"z1","g1","z8","g8",
				"b1","i1","b8","i8",
				"d4","f6"						// Some in the center
			};
		int[] solutions = new int[] {
				Position.ERR_NON_EXISTENT_TILE,
				Position.ERR_NON_EXISTENT_TILE,
				Position.ERR_NON_EXISTENT_TILE,
				Position.ERR_NON_EXISTENT_TILE,
				56, 63, 0, 7,
				Position.ERR_NON_EXISTENT_TILE, Position.ERR_NON_EXISTENT_TILE, 8, 15,
				48, 55, Position.ERR_NON_EXISTENT_TILE, Position.ERR_NON_EXISTENT_TILE,
				Position.ERR_NON_EXISTENT_TILE, 62, Position.ERR_NON_EXISTENT_TILE, 6,
				57, Position.ERR_NON_EXISTENT_TILE, 1, Position.ERR_NON_EXISTENT_TILE,
				35, 21
		};
		
		for (int i = 0; i < solutions.length; i++) {
			Position test = new Position("b5");
			test.setPosition(payload[i]);
			int aux = test.getTileId();
			System.out.printf("\t>IN:%s OUT:%s EXPECTED:%s\n",payload[i], aux, solutions[i]);
			assertEquals(payload[i], aux);
		}
		
	}

	@Test
	public void testSetPositionIntInt() {
		System.out.println("[TESTING: Position->setPosition(int, int)]");
		int[][] payload = new int[][] {
			{}, {1,1,1},{-1,12},{2,-1}, {2},	// Rubbish
			{0, 7},{7,7},{0,0},{7,0},			// Limits
			{0, 8},{7,8},{0,1},{7,1},
			{0, 6},{7,6},{0,-1},{7,-1},
			{-1, 7},{6,7},{-1,0},{6,0},
			{1, 7},{8,7},{1,0},{8,0},
			{3,4},{5,2}							// Some in the center
		};
		
		int[] solutions = new int[] {
			Position.ERR_NON_EXISTENT_TILE,
			Position.ERR_NON_EXISTENT_TILE,
			Position.ERR_NON_EXISTENT_TILE,
			Position.ERR_NON_EXISTENT_TILE,
			56, 63, 0, 7,
			Position.ERR_NON_EXISTENT_TILE, Position.ERR_NON_EXISTENT_TILE, 8, 15,
			48, 55, Position.ERR_NON_EXISTENT_TILE, Position.ERR_NON_EXISTENT_TILE,
			Position.ERR_NON_EXISTENT_TILE, 62, Position.ERR_NON_EXISTENT_TILE, 6,
			57, Position.ERR_NON_EXISTENT_TILE, 1, Position.ERR_NON_EXISTENT_TILE,
			35, 21
		};
		
		for (int i = 0; i < solutions.length; i++) {
			Position test = new Position("b5");
			test.setPosition(payload[i][0],payload[i][1]);
			int aux = test.getTileId();
			System.out.printf("\t>IN:%s OUT:%s EXPECTED:%s\n",payload[i], aux, solutions[i]);
			assertEquals(payload[i], aux);
		}
		
	}
	
	@Test
	public void testCoord2Chess() {
		
		System.out.println("[TESTING: Position->coord2Chess(int, int)]");
		
		int[][] payload = new int[][] {
			{}, {1,1,1},{-1,12},{2,-1}, {2},	// Rubbish
			{0, 7},{7,7},{0,0},{7,0},			// Limits
			{0, 8},{7,8},{0,1},{7,1},
			{0, 6},{7,6},{0,-1},{7,-1},
			{-1, 7},{6,7},{-1,0},{6,0},
			{1, 7},{8,7},{1,0},{8,0},
			{3,4},{5,2}							// Some in the center
		};
		String[] solutions = new String[] {
			null, null, null, null, null,
			"a1","h1","a8","h8",
			null, null,"a7","h7",
			"a2","h2",null,null,
			null,"g1",null,"g8",
			"b1",null,"b8",null,
			"d4","f6"
		};
		
		for (int i = 0; i < solutions.length; i++) {
			String aux = Position.coord2Chess(payload[i][0], payload[i][0]);
			System.out.printf("\t>IN:%s OUT:%s EXPECTED:%s\n",payload[i], aux, solutions[i]);
			assertEquals(solutions[i], aux);
		}
	}
	
	@Test
	public void testChess2Coord() {
		
		System.out.println("[TESTING: Position->coord2Chess(int, int)]");
		
		int[][] solutions = new int[][] {
			null, null, null, null, null,	// Rubbish
			{0, 7},{7,7},{0,0},{7,0},		// Limits
			null, null,{0,1},{7,1},
			{0, 6},{7,6}, null, null,
			null,{6,7}, null,{6,0},
			{1, 7}, null,{1,0}, null,
			{3,4},{5,2}						// Some in the center
		};
		String[] payload = new String[] {
				"", "1a","11","aa", "asjq83",	// Rubbish
				"a1","h1","a8","h8",			// Limits
				"a0","h0","a7","h7",
				"a2","h2","a9","h9",
				"z1","g1","z8","g8",
				"b1","i1","b8","i8",
				"d4","f6"						// Some in the center
			};
		
		for (int i = 0; i < solutions.length; i++) {
			int[] aux = Position.chessd2Coord(payload[i]);
			System.out.printf("\t>IN:%s OUT:%s EXPECTED:%s\n",payload[i], aux, solutions[i]);
			assertEquals(solutions[i], aux);
		}
	}

}
