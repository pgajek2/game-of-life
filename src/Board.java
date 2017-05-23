
public class Board {
	
	private int n, m;
	public int[][] board; 
	 
	Board(int n, int m){
		 this.n = n;
		 this.m = m;
		 this.board = new int[this.n][this.m];
		 for(int i=0;i<n;i++){
			 for(int j=0;j<m;j++) {
				 this.board[i][j]=0;
			 }
		 }
	 }

    public void showBoard(){
		 System.out.println("");
		 for(int i=0;i<n;i++){
			 for(int j=0;j<m;j++){
				 System.out.print(" "+this.board[i][j]+" ");
			 }
			 System.out.println("");
		 }
	 }
	 
	public int checkmoore(int x, int y){
		 int count = count(x,y);
		 if(count==3 && this.board[x][y]==0)
		 {
			 return 1;
		 }
		 else if((count==2 || count==3) && this.board[x][y]==1)
		 {
			 return 1;
		 }
		 else
		 {
			 return 0;
		 }
	 }
	 
	public int checkneumann(int x, int y){
		 int count = count(x,y);
		 if(count==3 && this.board[x][y]==0)
		 {
			 return 1;
		 }
		 else if((count==2 || count==3) && this.board[x][y]==1)
		 {
			 return 1;
		 }
		 else
		 {
			 return 0;
		 }
	 }
	 
	public int replicator(int x, int y){
		 int count = count(x,y);
		 if((count==1 || count==3 || count==5 || count==7) && this.board[x][y]==0)
		 {
			 return 1;
		 }
		 else if((count==1 || count==3 || count==5 || count==7)  && this.board[x][y]==1)
		 {
			 return 1;
		 }
		 else
		 {
			 return 0;
		 }
	 }

	public int walledcities(int x, int y){
		 int count = count(x,y);
		 
		 if((count==4 || count==5 || count==6 || count==7 || count==8) && this.board[x][y]==0)
		 {
			 return 1;
		 }
		 else if((count==2 || count==3 || count==4 || count==5)  && this.board[x][y]==1)
		 {
			 return 1;
		 }
		 else
		 {
			 return 0;
		 }
	 }
	
	public int coral(int x, int y){
		 int count = count(x,y);
		 
		 if((count==3) && this.board[x][y]==0)
		 {
			 return 1;
		 }
		 else if((count==4 || count==5 || count==6 || count==7 || count==8)  && this.board[x][y]==1)
		 {
			 return 1;
		 }
		 else
		 {
			 return 0;
		 }
	 }
	
	public int amazing(int x, int y)
	{
		 int count = count(x,y);

		 if((count==3) && this.board[x][y]==0)
		 {
			 return 1;
		 }
		 else if((count==1 || count==2 || count==3 || count==4 || count==5)  && this.board[x][y]==1)
		 {
			 return 1;
		 }
		 else
		 {
			 return 0;
		 }
	 }
	 
	public int count(int x,int y)
	 {
		 int[][] tab = new int[3][3];
		 int count = 0; 
		 if(x==0 && y==0){
			 tab[0][0] = this.board[n-1][m-1];  tab[0][1] = this.board[n-1][y];  tab[0][2] = this.board[n-1][y+1];
			 tab[1][0] = this.board[x][m-1];      tab[1][1] = this.board[x][y];    tab[1][2] = this.board[x][y+1];
			 tab[2][0] = this.board[x+1][m-1];      tab[2][1] = this.board[x+1][y];  tab[2][2] = this.board[x+1][y+1];
			 //tab[0][0] = tab[0][1] = tab[0][2] = 0;
			 //tab[0][0] =  tab[1][0] = tab[2][0] = 0;
		 }
		 else if(x==0 && y==this.m-1){
			 tab[0][0] = this.board[n-1][y-1];    tab[0][1] = this.board[n-1][y];  tab[0][2] = this.board[n-1][0];
			 tab[1][0] = this.board[x][y-1];    tab[1][1] = this.board[x][y];    tab[1][2] = this.board[x][0];
			 tab[2][0] = this.board[x+1][y-1];  tab[2][1] = this.board[x+1][y];  tab[2][2] = this.board[x+1][0];
			 //tab[0][0] = tab[0][1] = tab[0][2] = 0;
			 //tab[0][2] = tab[1][2] = tab[2][2] = 0;
		 }
		 else if(x==this.n-1 && y==0){
			 tab[0][0] = this.board[x-1][m-1];  tab[0][1] = this.board[x-1][y];  tab[0][2] = this.board[x-1][y+1];
			 tab[1][0] = this.board[x][m-1];    tab[1][1] = this.board[x][y];    tab[1][2] = this.board[x][y+1];
			 tab[2][0] = this.board[0][m-1];    tab[2][1] = this.board[0][y];	 tab[2][2] = this.board[0][y+1];
			 // tab[0][0] = tab[1][0] =1 tab[2][0] = 0;
			 // tab[2][0] = tab[2][1] = tab[2][2] = 0;
		 }
		 else if(x==this.n-1 && y==this.m-1){
			 tab[0][0] = this.board[x-1][y-1];  tab[0][1] = this.board[x-1][y];  tab[0][2] = this.board[x-1][0];
			 tab[1][0] = this.board[x][y-1];  	tab[1][1] = this.board[x][y];    tab[1][2] = this.board[x][0];
			 tab[2][0] = this.board[0][y-1];  	tab[2][1] = this.board[0][y];	 tab[2][2] = this.board[0][0];
			 //tab[2][0] = tab[2][1] = tab[2][2] = 0;
			 //tab[0][2] = tab[1][2] =  tab[2][2] = 0;
		 }	
		 else if(x==0 && y>0 && y<this.m-1){
			 tab[0][0] = this.board[n-1][y-1]; tab[0][1] = this.board[n-1][y];  tab[0][2] = this.board[n-1][y+1];;
			 tab[1][0] = this.board[x][y-1];    tab[1][1] = this.board[x][y];    tab[1][2] = this.board[x][y+1];
			 tab[2][0] = this.board[x+1][y-1];  tab[2][1] = this.board[x+1][y];  tab[2][2] = this.board[x+1][y+1];
			 //tab[0][0] = tab[0][1] = tab[0][2] = 0;
		 }
		 else if(x>0 && x<this.n-1 && y==0){
			 tab[0][0] = this.board[x-1][m-1]; 	tab[0][1] = this.board[x-1][y];  tab[0][2] = this.board[x-1][y+1];
			 tab[1][0] = this.board[x][m-1];    tab[1][1] = this.board[x][y];    tab[1][2] = this.board[x][y+1];
			 tab[2][0] = this.board[x+1][m-1];  tab[2][1] = this.board[x+1][y];  tab[2][2] = this.board[x+1][y+1];	
			 //tab[0][0]= tab[1][0]= tab[2][0]=0;
		 }
		 else if(x==this.n-1 && y>0 && y<this.m-1){
			 tab[0][0] = this.board[x-1][y-1];  tab[0][1] = this.board[x-1][y];  tab[0][2] = this.board[x-1][y+1];
			 tab[1][0] = this.board[x][y-1];    tab[1][1] = this.board[x][y];    tab[1][2] = this.board[x][y+1];
			 tab[2][0] = this.board[0][y-1];  	tab[2][1] = this.board[0][y];  	 tab[2][2] = this.board[0][y+1];		
			 //tab[2][0] = tab[2][1] = tab[2][2] = 0;	
		 }
		 else if(y==this.m-1 && x>0 && x<this.n-1){
			 tab[0][0] = this.board[x-1][y-1];  tab[0][1] = this.board[x-1][y];  tab[0][2] = this.board[x-1][0];
			 tab[1][0] = this.board[x][y-1];    tab[1][1] = this.board[x][y];    tab[1][2] = this.board[x][0];
			 tab[2][0] = this.board[x+1][y-1];  tab[2][1] = this.board[x+1][y];  tab[2][2] = this.board[x+1][0];
			 //tab[0][2] = tab[1][2] = tab[2][2] = 0
		 }
		 else{
			 tab[0][0] = this.board[x-1][y-1];  tab[0][1] = this.board[x-1][y];  tab[0][2] = this.board[x-1][y+1];
			 tab[1][0] = this.board[x][y-1];    tab[1][1] = this.board[x][y];    tab[1][2] = this.board[x][y+1];
			 tab[2][0] = this.board[x+1][y-1];  tab[2][1] = this.board[x+1][y];  tab[2][2] = this.board[x+1][y+1];
		 }

		 for(int i=0;i<3;i++){
			 for(int j=0;j<3;j++)
			 {
				 if(i==1 && j==1)
				 {
					 count = count;		 
				 }
				 else
				 {
					 count += tab[i][j];
				 }
			 }
		 }
		 return count;
	 }
	 
	public void game(){
		 int[][] apt = new int[this.n][this.m];
		 for(int i=0;i<n;i++){
			 for(int j=0;j<m;j++){
				apt[i][j] = checkmoore(i,j);
			 }
		 }
		 for(int i=0;i<n;i++){
			 for(int j=0;j<m;j++){
				this.board[i][j] = apt[i][j];
			 }
		 }
	 }
	 
	
}
