public class Main {

	private enum BoardState {
		 // complete this enum with all the possible states of a noughts and crosses board (there's more than 3)
		 NOUGHTS_WIN , CROSSES_WIN , DRAW , STILL_PLAYING_CROSSES_PLAY_NEXT , STILL_PLAYING_NOUGHTS_PLAY_NEXT 
		 }
		
		 private static BoardState getStateOfBoard(String board) {
		 // complete this method so that it returns the correct board state
			 Board bd = new Board(board);
			 BoardState StateOfBoard = BoardState.CROSSES_WIN; //default initialization of StateOfBoard
			 switch(bd.getState()) {
			 	case "NoughtsPlayNext":
			 		StateOfBoard=BoardState.STILL_PLAYING_NOUGHTS_PLAY_NEXT;
			 		break;
			 	case "CrossesPlayNext":
			 		StateOfBoard=BoardState.STILL_PLAYING_CROSSES_PLAY_NEXT;
			 		break;
			 	case "NoughtsWin":
			 		StateOfBoard=BoardState.NOUGHTS_WIN;
			 		break;
			 	case "Draw":
			 		StateOfBoard=BoardState.DRAW;
			 		break;
			 	default:
			 		StateOfBoard=BoardState.CROSSES_WIN;
			 }
		 return StateOfBoard;
		 }
		
		 public static void main(String[] args) {
		 // leave this main method unchanged
		 for (int i = 0; i < args.length; i++) {
		 System.out.println(getStateOfBoard(args[i]));
		 }
			
	 }
	
}
