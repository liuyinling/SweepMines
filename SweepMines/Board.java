//class Board

class Board{
	int [][] world;
	Piece [] pList;
	
	public Board(){
		world = new int[10][10];// 0 = empty; 
		pList = new Piece[100];
		initialize();
		
	}
	
	void initialize(){
		int counter=0;
		int random=0;
		//initialize pieces
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++){
				pList[counter++] = new Piece(i,j,0);//public Piece(int l, int c, int type)	
			}
		//randomly generate bomb
		for(int i=0;i<40;i++){
			random = (int)(Math.random()*100);
			pList[random].type = 1;
		}
		//initilize world
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++){
				world[i][j]=0;
			}
		
	}
	void display(){
		showAllBombs();
		System.out.print("/");
		for(int i=0;i<10;i++)
			System.out.print(i);
		System.out.println("");
		for(int i=0;i<10;i++){
			System.out.print(i);
			for(int j=0;j<10;j++){
				System.out.print(world[i][j]);
			}
			System.out.println("");
		}
	}
	
	Piece indexPieces(int l, int c){
		
		for(int i=0;i<100;i++){
			if(pList[i].l==l&&pList[i].c==c){
				return pList[i];
			}
			
		}
		System.out.println("Coordinates are out of bounds!");
		return null;
		
	}
	
	void showAllBombs(){
		
		for(int i=0;i<100;i++){
			if(pList[i].type==1){
				world[i/10][i%10]=9;
			}
			
		}
		System.out.println("Game over!");
		
		
	}
	
	int checkBombs(int l, int c){//check bomb around (l,c)
		int counter=0;
		if(withinBoard(l-1,c-1)){
			if(indexPieces(l-1,c-1).type==1){
				counter++;
			}
		}
		if(withinBoard(l-1,c)){
			if(indexPieces(l-1,c).type==1){
				counter++;
			}
		}
		if(withinBoard(l-1,c+1)){
			if(indexPieces(l-1,c+1).type==1){
				counter++;
			}
		}
		if(withinBoard(l,c-1)){
			if(indexPieces(l,c-1).type==1){
				counter++;
			}
		}
		if(withinBoard(l,c+1)){
			if(indexPieces(l,c+1).type==1){
				counter++;
			}
		}
		if(withinBoard(l+1,c-1)){
			if(indexPieces(l+1,c-1).type==1){
				counter++;
			}
		}
		if(withinBoard(l+1,c)){
			if(indexPieces(l+1,c).type==1){
				counter++;
			}
		}
		if(withinBoard(l+1,c+1)){
			if(indexPieces(l+1,c+1).type==1){
				counter++;
			}
		}
		return counter;
	}
	void play(int l, int c, int flag){
		Piece p = indexPieces(l,c);
		int counter=0;
		if(flag==1){
			p.flag=1;
		}
		else{
			counter=checkNeighbours(l,c);
			
			if(counter==1){
				showAllBombs();
			}
		}
		
		
	}
	
	//check neighbours
	int checkNeighbours(int l, int c){
		int counter=0;
		// the coordinates are out of bounds, exit;
		if(withinBoard(l,c)==false){
			System.out.println("Out of bounds");
			return 0;
		}
		//if it is a bomb, exit;
		Piece p = indexPieces(l,c);
		if(p.type==1){
			return 1;//show all the bomb;
		}
		//check neighbours
		counter = checkBombs(l,c);
		if(counter!=0){
			p.numberOfNeighbours = counter;
			world[l][c]=counter;
			System.out.println("counter = "+counter);
			
		}
		else{
			
			checkNeighbours(l-1,c-1);
			System.out.println("Check 1");
			checkNeighbours(l-1,c);
			System.out.println("Check 2");
			checkNeighbours(l-1,c+1);
			System.out.println("Check 3");
			checkNeighbours(l,c-1);
			System.out.println("Check 4");
			checkNeighbours(l,c+1);
			System.out.println("Check 5");
			checkNeighbours(l+1,c-1);
			System.out.println("Check 6");
			checkNeighbours(l+1,c);
			System.out.println("Check 7");
			checkNeighbours(l+1,c+1);
			System.out.println("Check 8");
			
		}
		return 0;
		
	}
	
	
	boolean withinBoard(int l, int c){
		if(l>=0&&l<world.length&& c>=0 &&c<world[0].length){
			return true;
		}
		else
			return false;
		
	}
	
	
}
