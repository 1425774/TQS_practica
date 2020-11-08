package TQSPractica.models;

import java.util.List;

import TQSPractica.Player;

public abstract class Piece {
	
	private List<Position> possibleMoves;
	private Board board;
	private Player owner;
	private int pieceValue;
	private Position currentPosition;
	
	public Position[] getPossibleMoves() {
		if (this.possibleMoves == null) {
			this.generatePossibleMoves();
		}
		return possibleMoves.toArray(new Position[possibleMoves.size()]);
	}
	
	protected void setPossibleMoves(List<Position> moves) {
		this.possibleMoves = moves;
	}

	public Player getOwner() {
		return owner;
	}
	
	public Position getCurrentPosition() {
		return currentPosition;
	}
	
	protected void setCurrentPosition(Position pos) {
		this.board.move(this, this.currentPosition, pos);
		this.currentPosition = pos;
	}
	
	protected Board getBoard() {
		return this.board;
	}
	
	protected Piece(Board board,Position initial_position, Player owner, int value) throws Exception {
		if (initial_position == null || initial_position.getChessPosition() == null) {
			throw new Exception("Can not initialize a piece without a valid position");
		}
		if (board == null) {
			throw new Exception("Can not initialize a piece without a board");
		}
		this.pieceValue = value;
		this.currentPosition = initial_position;
		this.board = board;
		this.owner = owner;
	}
	
	public int getPieceValue() {
		return pieceValue;
	}

	@Override
	abstract public String toString();

	protected abstract void generatePossibleMoves();
	
	// Only the Pawn needs to Override it
	public boolean moveTo(Position pos) {
		
		if (pos == null) {
			return false;
		}
		
		Position[] possible_moves = this.getPossibleMoves();
		
		for (int i = 0; i < possible_moves.length; i++) {
			if (pos.equals(possible_moves[i])) {
				this.setCurrentPosition(pos);
				this.setPossibleMoves(null);
				return true;
			}
		}
		
		return false;

	}
}
