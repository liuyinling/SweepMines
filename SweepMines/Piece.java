class Piece{
	
	int l;
	int c;
	int type; //type = 0 normal piece; type = 1 bomb;
	int flag=0;//flag = 1 this piece may be a bomb;
	int numberOfNeighbours=0;//Neighbours are bomb.
	
	public Piece(int l, int c, int type){
		this.l = l;
		this.c = c;
		this.type = type;
		
	}
	
	
}
