package TQSPractica.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import TQSPractica.Player;

@SuppressWarnings("deprecation")
public class MockBoard extends Observable implements Board {
	
	private List<Piece> pieces = new ArrayList<>();

	
	public void setPiece(Piece p) {
		pieces.add(p);
	}
	
	public void clean() {
		pieces.clear();
	}


	@Override
	public List<Piece> getPices(Player player) {
		// TODO Auto-generated method stub
		return pieces;
	}

	@Override
	public Piece getPieceOn(int x, int y) {
		
		Position pos = new Position(x,y);

		for (Piece piece : pieces) {
			if (pos.equals(piece.getCurrentPosition())) {
				return piece;
			}
		}

		return null;
	}

	@Override
	public Piece getPieceOn(int[] coor) {
		return getPieceOn(coor[0], coor[1]);
	}

	@Override
	public void move(Piece p, Position from, Position to) {
		this.setChanged();
		this.notifyObservers(this);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getDimensions() {
		return new int[] {8, 8};
	}


}
