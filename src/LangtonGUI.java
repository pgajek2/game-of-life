import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LangtonGUI {
	public JFrame window;
	public JPanel control;
	public JPanel show;
	public JButton[][] board;
	public JRadioButton black;
	public JRadioButton white;
	public JRadioButton Ant;
	public JRadioButton guide;
	public ButtonGroup choice;
	static public int n=10,m=10;
	static int x,y;
	static int N=0;
	static int W=0;
	static int E=0;
	static int S=0;
	static Langton game; 
	
	ActionListener action = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = ((JButton) e.getSource()).getActionCommand();
			System.out.println(command);
			Integer pom = Integer.parseInt(command);
			int a=pom%m,b=pom/n;
			Object source = e.getSource();
			System.out.println(a+" "+b);
			if(black.isSelected())
			{
	            ((Component)source).setBackground(Color.BLACK);  
	            game.board[a][b] = 1;
			}
			else if(white.isSelected())
			{
				((Component)source).setBackground(Color.WHITE); 
				game.board[a][b] = 0;
			}
			else if(Ant.isSelected())
			{
				((Component)source).setBackground(Color.RED);
				N=1;
				x=a;
				y=b;
			}
		}
	};
	
	MouseWheelListener l = new MouseWheelListener() {
		@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				play();
			}
		};
		
	public LangtonGUI() {
		
		window = new JFrame("Wire World");
		control = new JPanel();
		show = new JPanel();
		black = new JRadioButton("Black");
		white  = new JRadioButton("White");
		Ant = new JRadioButton("Ant");
		choice = new ButtonGroup();
		n=50;
		m=50;
		game = new Langton(n, m);
		board = new JButton[n][m];
		
		black.setSize(100,20);
		black.setLocation(20, 40);
		black.doClick();
		black.setBackground(Color.GRAY);
		
		white.setSize(100,20);
		white.setLocation(20, 60);
		white.setBackground(Color.GRAY);
		
		Ant.setSize(100, 20);
		Ant.setLocation(20, 80);
		Ant.setBackground(Color.GRAY);
		
		choice.add(black);
		choice.add(white);
		choice.add(Ant);
		
		control.add(black);
		control.add(white);
		control.add(Ant);
		control.setLayout(null);
		control.setSize(800,200);
		control.setBackground(Color.GRAY);
		
		show.setLayout(null);
		show.setLocation(130, 220);
		show.setSize(800,600);
		show.addMouseWheelListener(l);
		
		int pom = 0;
		for(int j=0;j<n;j++)
		{
			for(int i=0;i<m;i++)
			{
				board[i][j] = new JButton();
				board[i][j].setSize(10, 10);
				board[i][j].setLocation(10*i, 10*j);
				String send = Integer.toString(pom);
				board[i][j].setActionCommand(send);
				board[i][j].addActionListener(action);
				board[i][j].setBackground(Color.WHITE);
				show.add(board[i][j]);
				pom++;
			}
		}
		
		window.setLayout(null);
		window.add(control);
		window.add(show);
		window.setSize(800, 800);
		window.setVisible(true);
	}
	
	 void play()
	{			
		// int[][] apt = new int[n][m];
		 /*for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 apt[i][j] = game.chceck(i, j);	
			 }
		 }*/
		 //apt[x][y] = game.chceck(x, y);
		// game.board[x][y] = apt[x][y];
		 	if(N==1 && game.board[x][y]==0)
		 	{
				board[x][y].setBackground(Color.BLACK);
				game.board[x][y]=1;
				x=x-1; y=y;
				N=0;
				W=1;
		 	}
		 	else if(W==1 && game.board[x][y]==0)
		 	{
				board[x][y].setBackground(Color.BLACK);
				game.board[x][y]=1;
				x=x; y=y+1;
				W=0;
				S=1;
		 	}
		 	else if(E==1 && game.board[x][y]==0)
		 	{
				board[x][y].setBackground(Color.BLACK);
				game.board[x][y]=1;
				x=x; y=y-1;
				E=0;
				N=1;
		 	}
		 	else if(S==1 && game.board[x][y]==0)
		 	{
				board[x][y].setBackground(Color.BLACK);
				game.board[x][y]=1;
				x=x+1; y=y;
				S=0;
				E=1;
		 	}
		 	if(N==1 && game.board[x][y]==1)
		 	{
		 		board[x][y].setBackground(Color.WHITE);
				game.board[x][y]=0;
				x=x+1; y=y;
				N=0;
				E=1;
		 	}
		 	else if(W==1 && game.board[x][y]==1)
		 	{
		 		board[x][y].setBackground(Color.WHITE);
				game.board[x][y]=0;
				x=x; y=y-1;
				W=0;
				N=1;
		 	}
		 	else if(E==1 && game.board[x][y]==1)
		 	{
		 		board[x][y].setBackground(Color.WHITE);
				game.board[x][y]=0;
				x=x; y=y+1;
				E=0;
				S=1;
		 	}
		 	else if(S==1 && game.board[x][y]==1)
		 	{
		 		board[x][y].setBackground(Color.WHITE);
				game.board[x][y]=0;
				x=x-1; y=y;
				S=0;
				W=1;
		 	}
		 	board[x][y].setBackground(Color.RED);
		 /*for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				game.board[i][j] = apt[i][j];
				if(game.board[i][j]==0)
				{
					board[i][j].setBackground(Color.WHITE);
					
				}
				else if(game.board[i][j]==1)
				{
					board[i][j].setBackground(Color.BLACK);
				}	
				else if(game.board[i][j]==2)
				{
					board[i][j].setBackground(Color.RED);
				}
			 }
		 }*/
		 
	}
}
