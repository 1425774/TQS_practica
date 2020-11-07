package TQSPractica.models;

import java.util.ArrayList;
import java.util.List;

import TQSPractica.Player;

public class Rook extends Piece {
	
	private static final int VALUE = 5;
	private static final char IDENTIFIER = 'R';
	
	public Rook(Board board,Position initial_position, Player owner) throws Exception {
		super(board, initial_position, owner, VALUE);
	}

	@Override
	protected void generatePossibleMoves() {
		List<Position> possible_moves = new ArrayList<>();
		
		Board b = this.getBoard();
		int[] b_dimensions = b.getDimensions();
		int[] coor = this.getCurrentPosition().getCoorPosition();
		boolean stop = false;
		boolean add_move = false;
		int i;
		
		// Going right
		i = coor[0]+1;
		while (!stop && i < b_dimensions[0]) {
			
			Piece p =  b.getPieceOn(new int[] {i,coor[1]});
			
			if (p == null) {
				add_move = true;
			} else {
				stop = true;
				
				if (p.getOwner() != this.getOwner()) {
					add_move = true;
				}
			}
			
			if (add_move) {
				possible_moves.add(new Position(i,coor[1]));
				add_move = !add_move;
			}
			
			i++;
		}
		// Going left
		stop = false;
		i = coor[0]-1;
		while (!stop && i >= 0) {
			
			Piece p =  b.getPieceOn(new int[] {i,coor[1]});
			
			if (p == null) {
				add_move = true;
			} else {
				stop = true;
				
				if (p.getOwner() != this.getOwner()) {
					add_move = true;
				}
			}
			
			if (add_move) {
				possible_moves.add(new Position(i,coor[1]));
				add_move = !add_move;
			}
			
			i--;
		}
		// Going left
		stop = false;
		i = coor[1]+1;
		while (!stop && i < b_dimensions[1]) {
			
			Piece p =  b.getPieceOn(new int[] {coor[0], i});
			
			if (p == null) {
				add_move = true;
			} else {
				stop = true;
				
				if (p.getOwner() != this.getOwner()) {
					add_move = true;
				}
			}
			
			if (add_move) {
				possible_moves.add(new Position(coor[0], i));
				add_move = !add_move;
			}
			
			i++;
		}
		// Going right
		stop = false;
		i = coor[1]-1;
		while (!stop && i >= 0) {
			
			Piece p =  b.getPieceOn(new int[] {coor[0], i});
			
			if (p == null) {
				add_move = true;
			} else {
				stop = true;
				
				if (p.getOwner() != this.getOwner()) {
					add_move = true;
				}
			}
			
			if (add_move) {
				possible_moves.add(new Position(coor[0], i));
				add_move = !add_move;
			}
			
			i--;
		}
		
		this.setPossibleMoves(possible_moves);
		
	}

	@Override
	public String toString() {
		return Rook.IDENTIFIER + this.getCurrentPosition().getChessPosition();
	}

}
