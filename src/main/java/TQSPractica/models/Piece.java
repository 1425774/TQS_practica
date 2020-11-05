package TQSPractica.models;

import java.util.Arrays;

import TQSPractica.Player;

public abstract class Piece {
	
	private Position[] possibleMoves;
	private Board board;
	private Player owner;
	private int pieceValue;
	private Position currentPosition;
	
	public Position[] getPossibleMoves() {
		return possibleMoves;
	}

	public Player getOwner() {
		return owner;
	}
	
	public Position getCurrentPosition() {
		return currentPosition;
	}
	
	protected void setCurrentPosition(Position pos) {
		
	}
	
	protected Piece(Board board,Position initial_position, Player owner, int value) {
		
	}
	
	public int getPieceValue() {
		return pieceValue;
	}

	@Override
	public String toString() {
		return null;
	}

	protected abstract void generatePossibleMoves();	
	public abstract boolean moveTo(Position pos);
}
