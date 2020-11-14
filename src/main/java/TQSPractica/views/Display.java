package TQSPractica.views;

import TQSPractica.Player;
import TQSPractica.models.Move;

public interface Display {

	enum Menu {
		OK,
		EXIT
	}

	Object showMenu();

	Move getMove(Player white);

}
