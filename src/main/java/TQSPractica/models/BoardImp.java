package TQSPractica.models;

import java.util.List;

import TQSPractica.Player;

public class BoardImp implements Board{

	@Override
	public List<Piece> getPices(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piece getPieceOn(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piece getPieceOn(int[] infront) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean move(Piece p, Position from, Position to) {
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public int[] getDimensions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piece getPieceOn(Position pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean makeMove(Move m, Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPuntuation(Player p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getPuntuation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Piece[][] getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

}
