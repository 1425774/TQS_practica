package TQSPractica.models;

import java.util.ArrayList;
import java.util.List;

import TQSPractica.Player;

public class MockBoard implements Board {
	
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

}
