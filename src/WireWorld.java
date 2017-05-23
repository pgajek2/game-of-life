
public class WireWorld {

	private int n, m;
	public int[][] board; 
	
	WireWorld(int x,int y) 
	{
		n=x; m=y;
		board = new int[n][m];
	}
	
	 public void showBoard(){
		 System.out.println("");
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 System.out.print(" "+this.board[i][j]+" ");
			 }
			 System.out.println("");
		 }
	 }
	 
	 public int chceck(int x, int y)
	 {
		 int[] pom = count(x,y);
	//	 System.out.println(x+" "+y+" : "+pom[0]+" "+pom[1]+" "+pom[2]+" "+pom[3]+" ");
		 if(board[x][y]==0)
		 {
			 return 0;
		 }
		 else if(board[x][y]==1)
		 {
			 return 2;
		 }
		 else if(board[x][y]==2)
		 {
			 return 3;
		 }
		 else if(board[x][y]==3 && (pom[1]==1 || pom[1]==2))
		 {
			 return 1;
		 }
		 else if(board[x][y]==3 && (pom[1]!=1 || pom[1]!=2))
		 {
			 return 3;
		 }
		 return -1;
	 }
	 
	 public int[] count(int x,int y)
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

		 int[] pom = new int[4];
		 pom[0]=0;
		 pom[1]=0;
		 pom[2]=0;
		 pom[3]=0;
		 
		 for(int i=0;i<3;i++){
			 for(int j=0;j<3;j++)
			 {
				 if(i==1 && j==1)
				 {
					 
				 }
				 else
				 {
					 if(tab[i][j]==0)
					 {
						 pom[0]++;
					 }
					 else if(tab[i][j]==1)
					 {
						 pom[1]++;
					 }
					 else if(tab[i][j]==2)
					 {
						 pom[2]++;
					 }
					 else if(tab[i][j]==3)
					 {
						 pom[3]++;
					 }
					 else
					 {
						
					 }
				 }
			 }
		 }
		 return pom;
	 }
}
