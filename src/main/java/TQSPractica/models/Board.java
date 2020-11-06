package TQSPractica.models;
import java.util.List;

import TQSPractica.Player;

public interface Board {
	
	public List<Piece> getPices(Player player);

	public Piece getPieceOn(int x, int y);

	public Piece getPieceOn(int[] infront);

	void move(Piece p, Position from, Position to);

}
