package TQSPractica.models;

import TQSPractica.Player;

public class Bishop extends Piece {
	
	public Bishop(Board board,Position initial_position, Player owner) throws Exception {
		super(board, initial_position, owner, 0);
	}

	@Override
	protected void generatePossibleMoves() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
