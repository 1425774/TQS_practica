package TQSPractica.views;

import TQSPractica.Player;
import TQSPractica.models.Move;
import TQSPractica.models.Piece;

public interface Display {

	enum Menu {
		OK,
		EXIT
	}

	Menu showMenu();
	
	void showWinner(Player p);
	
	void showBoard(Piece[][] board);

	Move getMove(Player p);

}
