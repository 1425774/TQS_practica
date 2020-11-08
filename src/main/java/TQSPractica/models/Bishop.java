package TQSPractica.models;

import java.util.ArrayList;
import java.util.List;

import TQSPractica.Player;

public class Bishop extends Piece {
	
	private static final int VALUE = 3;
	private static final char IDENTIFIER = 'B';
	
	public Bishop(Board board,Position initial_position, Player owner) throws Exception {
		super(board, initial_position, owner, Bishop.VALUE);
	}
	
	private boolean lookOnDirection(int deep, int xmod, int ymod, List<Position> acum) {
		int[] coor = this.getCurrentPosition().getCoorPosition();
		Boolean ret = false;
		Boolean add = false;
		
		Position aux = new Position(coor[0]+(deep*xmod), coor[1]+(deep*ymod));
		if (aux.getTileId() != Position.ERR_NON_EXISTENT_TILE) {
			
			Piece p = this.getBoard().getPieceOn(aux);
			
			add = (p == null || p.getOwner() != this.getOwner());
			ret = (p == null);		
		}
		
		if (add) acum.add(aux);		
		return ret;
	}

	@Override
	protected void generatePossibleMoves() {
		List<Position> possible_moves = new ArrayList<>();
		
		boolean stop = false;		// Stop condition for main loop
		boolean topl = true;		// Stop conditions for directions
		boolean topr = true;
		boolean botl = true;
		boolean botr = true;
		
		int i = 1;
		while (!stop) {
			
			if (botr)
				botr = this.lookOnDirection(i, -1, -1, possible_moves);			
			if (botl)
				botl = this.lookOnDirection(i, +1, -1, possible_moves);
			if (topr)
				topr = this.lookOnDirection(i, -1, +1, possible_moves);
			if (topl)
				topl = this.lookOnDirection(i, +1, +1, possible_moves);
			
			stop = !(topl || topr || botr || botl);
			i++;
		}
		
		this.setPossibleMoves(possible_moves);
	}


	@Override
	public String toString() {
		return Bishop.IDENTIFIER+this.getCurrentPosition().getChessPosition();
	}

}
