package TQSPractica;

import TQSPractica.views.Display;

public class Game {
	
	public static enum State {
		MENU, SETUP_GAME, WHITE_PLAY, BLACK_PLAY, DISPLAY_RES, EXIT
	}
	
	private Display display;
	
	
	public Game(Display dis) {
		this.display = dis;
	}
	
	public boolean menuState() {
		return false;
		
	}
	
	public boolean setupState() {
		return false;
		
	}
	
	public boolean whiteState() {
		return false;
	}
	
	public boolean blackState() {
		return false;
	}
	
	public Player resState() {
		return null;
	}
	
	public void exitState() {

	}

	public static void main(String[] args) {
	}

	public Object getDisplay() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
