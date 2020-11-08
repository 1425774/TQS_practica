package TQSPractica.models;

import java.util.ArrayList;
import java.util.List;

import TQSPractica.Player;

public class Queen extends Piece {
	
	private static final int VALUE = 9;
	private static final char IDENTIFIER = 'Q';

	public Queen(Board board,Position initial_position, Player owner) throws Exception {
		super(board, initial_position, owner, Queen.VALUE);
	}
	
	private boolean lookOnDir(int deep, int dir, List<Position> acum) {
		
		boolean ret = false;
		boolean add = false;
		int[] coor = this.getCurrentPosition().getCoorPosition();
		
		int x = 0, y = 0;
		
		// Directions
		// 7 0 1
		// 6 Q 2
		// 5 4 3
		switch (dir) {
		case 0:
			x = 0; y = 1;
			break;
		case 1:
			x = 1; y = 1;
			break;
		case 2:
			x = 1; y = 0;
			break;
		case 3:
			x = 1; y = -1;
			break;
		case 4:
			x = 0; y = -1;
			break;
		case 5:
			x = -1; y = -1;
			break;
		case 6:
			x = -1; y = 0;
			break;
		case 7:
			x = -1; y = 1;
			break;
		}
		
		Position aux = new Position(coor[0]+(deep*x), coor[1]+(deep*y));
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
		
		// Directions
		// 7 0 1
		// 6 Q 2
		// 5 4 3
		
		List<Position> possible_moves = new ArrayList<>();
		boolean[] dir_stop_conditions = {
				false, false, false, false, false, false, false, false
		};
		boolean stop = false;
		int i = 1;
		while(!stop) {
			
			// Look all directions
			for (int j = 0; j < 8; j++) {
				if (!dir_stop_conditions[j])
					dir_stop_conditions[j] = !this.lookOnDir(i, j, possible_moves);				
			}
			
			i++;
			// Checking if everything is true
			stop = dir_stop_conditions[0];
			for (int j = 1; j < dir_stop_conditions.length; j++)
				stop = stop && dir_stop_conditions[j];
			
		}
		this.setPossibleMoves(possible_moves);
	}

	@Override
	public String toString() {
		return Queen.IDENTIFIER+this.getCurrentPosition().getChessPosition();
	}
}
