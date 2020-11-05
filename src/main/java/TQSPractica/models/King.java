package TQSPractica.models;

import TQSPractica.Player;

public class King extends Piece {

	public King(Board board,Position initial_position, Player owner) {
		super(board, initial_position, owner, 0);
	}

	@Override
	protected void generatePossibleMoves() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean moveTo(Position pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
