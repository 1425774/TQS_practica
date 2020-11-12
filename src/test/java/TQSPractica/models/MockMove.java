package TQSPractica.models;

public class MockMove implements Move {

	private String str;
	
	public MockMove(String string) {
		// TODO Auto-generated constructor stub
		str = string;
	}

	@Override
	public Class<?> getPieceType() {
		if (str.length() == 2) {
			return Pawn.class;
		}
		return Knight.class;
	}

	@Override
	public int getColumn() {
		if (str.length() == 3) {
			return Move.UNSET_COLUMN;
		} 
		return 1;
	}

	@Override
	public Position getDestination() {
		// TODO Auto-generated method stub
		if (str.length() == 2) {
			return new Position(str);
		}
		return new Position(str.substring(str.length()-2));
	}

	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return true;
	}

}
