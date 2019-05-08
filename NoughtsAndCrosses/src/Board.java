public class Board {

	private String content;
	private int TurnsPlayed;
	private Boolean isFull;
	private char NextTurn;
	private String State;
	
	public Board() {
		this.content="_________";
		this.TurnsPlayed=0;
		this.isFull=false;
		this.NextTurn='X';
		this.State="CrossesPlayNext";
	}
	
	public Board(String bd) {
		this.content=bd;
		this.TurnsPlayed=HowManyTurns(bd);
		this.isFull=isBoardFull(bd);
		this.NextTurn=WhoseTurnIsIt(bd);
		this.State=this.WhichState();
	}
	
	// auto-generated setters & getters
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTurnsPlayed() {
		return TurnsPlayed;
	}

	public void setTurnsPlayed(int turnsPlayed) {
		TurnsPlayed = turnsPlayed;
	}

	public Boolean getIsFull() {
		return isFull;
	}

	public void setIsFull(Boolean isFull) {
		this.isFull = isFull;
	}

	public char getNextTurn() {
		return NextTurn;
	}

	public void setNextTurn(char nextTurn) {
		NextTurn = nextTurn;
	}
	
	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}
	//end of auto-generated setters & getters
	
	public int HowManyTurns(String bd) {
		int count=0;
		int i=0;
		for(i=0;i<9;i++) {
			if (bd.charAt(i)=='X' || bd.charAt(i)=='O')
				count+=1;
		}
		return count;
	}
	
	public Boolean isBoardFull(String bd) {
		return (this.TurnsPlayed==9);
	}
	
	public char WhoseTurnIsIt(String bd) {
		int TurnsPlayedByCrosses=0;
		int TurnsPlayedByNoughts=0;
		char ans='X';
		int i=0;
		for(i=0;i<9;i++) {
			if (bd.charAt(i)=='X')
				TurnsPlayedByCrosses+=1;
		}
		for(i=0;i<9;i++) {
			if (bd.charAt(i)=='O')
				TurnsPlayedByNoughts+=1;
		}
		if(TurnsPlayedByCrosses>TurnsPlayedByNoughts)
			ans='O';
		return ans;
	}
	
	public String WhichState() {
		String ans="NoughtsPlayNext";
		if(this.NextTurn=='O') { // the case in which Crosses just played
			if(this.CrossesWin()) //check whether Crosses win or not
				ans="CrossesWin";
			else {
				if(this.isFull) //Crosses didn't win, so check now whether the board is full or not
				ans="Draw"; //in that case this is a Draw since no one can play
				} //if the board is not full, Noughts play next but no need to write it here because I initialized the answer with "NoughtsPlayNext"
			}
		else { // the case in which Noughts just played
			if(this.NoughtsWin()) { //check whether Noughts win or not
				ans="NoughtsWin";
				}
			else {ans="CrossesPlayNext";} //There can't be a draw if Noughts has just played
		}
		return ans;
	}
	
	public Boolean CrossesWin() {
		Boolean ans=false;
		if (this.TurnsPlayed > 4) { //at least 5 turns played otherwise it is impossible that anyone has won
			if((this.getContent().charAt(0)=='X' && this.getContent().charAt(3)=='X' && this.getContent().charAt(6)=='X')
				|| (this.getContent().charAt(0)=='X' && this.getContent().charAt(1)=='X' && this.getContent().charAt(2)=='X')
				|| (this.getContent().charAt(0)=='X' && this.getContent().charAt(4)=='X' && this.getContent().charAt(8)=='X')
				|| (this.getContent().charAt(1)=='X' && this.getContent().charAt(4)=='X' && this.getContent().charAt(7)=='X')
				|| (this.getContent().charAt(2)=='X' && this.getContent().charAt(5)=='X' && this.getContent().charAt(8)=='X')
				|| (this.getContent().charAt(2)=='X' && this.getContent().charAt(4)=='X' && this.getContent().charAt(6)=='X')
				|| (this.getContent().charAt(3)=='X' && this.getContent().charAt(4)=='X' && this.getContent().charAt(5)=='X')
				|| (this.getContent().charAt(6)=='X' && this.getContent().charAt(7)=='X' && this.getContent().charAt(8)=='X'))
					ans=true; //there are 8 different ways to win
		}
		return ans;
	}
	
	public Boolean NoughtsWin() {
		Boolean ans=false;
		if (this.TurnsPlayed > 5) { //at least 6 turns played otherwise it is impossible that Noughts have won (because Crosses played first)
			if((this.getContent().charAt(0)=='O' && this.getContent().charAt(3)=='O' && this.getContent().charAt(6)=='O')
				|| (this.getContent().charAt(0)=='O' && this.getContent().charAt(1)=='O' && this.getContent().charAt(2)=='O')
				|| (this.getContent().charAt(0)=='O' && this.getContent().charAt(4)=='O' && this.getContent().charAt(8)=='O')
				|| (this.getContent().charAt(1)=='O' && this.getContent().charAt(4)=='O' && this.getContent().charAt(7)=='O')
				|| (this.getContent().charAt(2)=='O' && this.getContent().charAt(5)=='O' && this.getContent().charAt(8)=='O')
				|| (this.getContent().charAt(2)=='O' && this.getContent().charAt(4)=='O' && this.getContent().charAt(6)=='O')
				|| (this.getContent().charAt(3)=='O' && this.getContent().charAt(4)=='O' && this.getContent().charAt(5)=='O')
				|| (this.getContent().charAt(6)=='O' && this.getContent().charAt(7)=='O' && this.getContent().charAt(8)=='O'))
					ans=true; //there are 8 different ways to win
		}
		return ans;
	}
	
}
