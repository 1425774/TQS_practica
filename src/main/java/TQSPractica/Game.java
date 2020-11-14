package TQSPractica;

import TQSPractica.models.Board;
import TQSPractica.models.BoardImp;
import TQSPractica.models.Move;
import TQSPractica.views.Display;

public class Game {

	public static final int SURRENDER = -1;
	public static final int LEGAL = 0;
	public static final int ILLEGAL = 1;
	
	private Display display;
	private Board board;
	
	private boolean white_surrender = false;
	private boolean black_surrender = false;
	
	
	public Game(Display dis) throws Exception {
		if (dis == null) 
			throw new Exception("No display found");
		
		this.display = dis;
		this.board = new BoardImp();
		this.board.initBoard();
	}
	
	public boolean menuState() {
		return this.display.showMenu() == Display.Menu.OK;		
	}
	
	private int getMoveFromPlayer(Player p) {
		
		// Display assures move is valid or null
		Move m = this.display.getMove(p);
		
		// null surrender
		if (m == null) {
			
			this.white_surrender = (p == Player.WHITE);
			this.black_surrender = (p == Player.BLACK);
			
			return SURRENDER;
		}
			
		
		// make move -- return if it can be made or not
		if (this.board.makeMove(m, p)) {
			return LEGAL;
		}
		return ILLEGAL;
	}
	
	
	public int whiteState() {
		return this.getMoveFromPlayer(Player.WHITE);
	}
	
	public int blackState() {
		return this.getMoveFromPlayer(Player.BLACK);
	}
	
	public Player resState() {
		
		if (black_surrender)
			return Player.WHITE;
		
		if (white_surrender)
			return Player.BLACK;
		
		if (!this.board.isGameOver())
			return null;
		
		return this.board.getPuntuation(Player.WHITE) == Integer.MAX_VALUE ? Player.WHITE : Player.BLACK;
			
	}

	public static void main(String[] args) {
	}

	public Display getDisplay() {
		return this.display;
	}
	
	

}
