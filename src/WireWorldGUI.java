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

public class WireWorldGUI 
{
	public JFrame window;
	public JPanel control;
	public JPanel show;
	public JButton[][] board;
	public JRadioButton empty;
	public JRadioButton head;
	public JRadioButton tail;
	public JRadioButton guide;
	public ButtonGroup choice;
	static public int n=10,m=10;
	static WireWorld game; 
	
	ActionListener action = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = ((JButton) e.getSource()).getActionCommand();
			System.out.println(command);
			Integer pom = Integer.parseInt(command);
			int a=pom%m,b=pom/n;
			Object source = e.getSource();
			System.out.println(a+" "+b);
			if(empty.isSelected())
			{
	            ((Component)source).setBackground(Color.WHITE);  
	            game.board[a][b] = 0;
			}
			else if(head.isSelected())
			{
				((Component)source).setBackground(Color.BLUE); 
				game.board[a][b] = 1;
			}
			else if(tail.isSelected())
			{
				((Component)source).setBackground(Color.RED);  
				game.board[a][b] = 2;
			}
			else if(guide.isSelected())
			{
				((Component)source).setBackground(Color.YELLOW);  
				game.board[a][b] = 3;
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
		
	public WireWorldGUI() {
		
		window = new JFrame("Wire World");
		control = new JPanel();
		show = new JPanel();
		empty = new JRadioButton("Empty");
		head  = new JRadioButton("Head");
		tail = new JRadioButton("Tail");
		guide = new JRadioButton("Guide");
		choice = new ButtonGroup();
		n=50;
		m=50;
		game = new WireWorld(n, m);
		board = new JButton[n][m];
		
		empty.setSize(100,20);
		empty.setLocation(20, 40);
		empty.doClick();
		empty.setBackground(Color.GRAY);
		
		head.setSize(100,20);
		head.setLocation(20, 60);
		head.setBackground(Color.GRAY);
		
		tail.setSize(100, 20);
		tail.setLocation(20, 80);
		tail.setBackground(Color.GRAY);
		
		guide.setSize(100,20);
		guide.setLocation(20, 100);
		guide.setBackground(Color.GRAY);
		
		choice.add(empty);
		choice.add(guide);
		choice.add(head);
		choice.add(tail);
		
		control.add(empty);
		control.add(guide);
		control.add(head);
		control.add(tail);
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
		 int[][] apt = new int[n][m];
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 apt[i][j] = game.chceck(i, j);	
			 }
		 }
		 for(int i=0;i<n;i++){
			 for(int j=0;j<m;j++){
				game.board[i][j] = apt[i][j];
				if(game.board[i][j]==0)
				{
					board[i][j].setBackground(Color.WHITE);
				}
				else if(game.board[i][j]==1)
				{
					board[i][j].setBackground(Color.BLUE);
				}	
				else if(game.board[i][j]==2)
				{
					board[i][j].setBackground(Color.RED);
				}
				else if(game.board[i][j]==3)
				{
					board[i][j].setBackground(Color.YELLOW);
				}
			 }
		 }
	}
}
