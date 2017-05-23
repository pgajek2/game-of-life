import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.ObjectInputStream.GetField;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class Main
{
	
	static JFrame frame;
	public static ButtonGroup group;
	public static ButtonGroup otoczenie;
	public static JRadioButton radio1;
	public static JRadioButton radio2;
	public static JRadioButton radio3;
	public static JRadioButton radio4;
	public static JRadioButton moore;
	public static JRadioButton vonneumann;
	public static JRadioButton replicator;
	public static JRadioButton walledcities;
	public static JRadioButton coral;
	public static JRadioButton amazing;
	public static JCheckBox check;
	static JButton[][] p ;
	static JPanel panel;
	static Color color; 
	static Color color2;
	static Board gra;
	static JPanel ster;
	static JButton pokaz;
	static JButton reset;
	static int n=55,m=55;
	static int k1=10,k2=10;

	static MouseWheelListener l = new MouseWheelListener() {
	@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			play();
		}
	};
	
	static MouseListener actionpress = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			 String command = ((JButton) e.getSource()).getActionCommand();
			 Integer pom = Integer.parseInt(command);
			 int a=pom%n,b=pom/m;
			 Object source = e.getSource();
			 if(gra.board[b][a]==1)
			 {
				 source = e.getSource();
	            ((Component)source).setBackground(Color.WHITE);  
	             System.out.println(a+" "+b);
				 gra.board[b][a]=0;
			 }
			 else
			 {
	            ((Component)source).setBackground(Color.BLACK);  
	             System.out.println(a+" "+b);
				 gra.board[b][a]=1;
			 }
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(check.isSelected())
			{
				 String command = ((JButton) e.getSource()).getActionCommand();
				 System.out.println(command);
				 Integer pom = Integer.parseInt(command);
				 int a=pom%n,b=pom/m;
				 Object source = e.getSource();
	            ((Component)source).setBackground(Color.BLACK);  
	            System.out.println(a+" "+b);
				 gra.board[b][a]=1;
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	};
		
	static ActionListener actionreset = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					gra.board[i][j]=0;
					color = color.WHITE;
					p[i][j].setBackground(color);
				}
			}
		}
	};
	
	static ActionListener actioncreate = new ActionListener() {
		@Override
	public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(radio1.isSelected())
			{
				n=25;
				m=25;
				k1=24;
				k2=24;
				uruchom();
			}
			else if(radio2.isSelected())
			{
				n=50;
				m=50;
				k1=12;
				k2=12;
				uruchom();
			}
			else if(radio3.isSelected())
			{
				n=100;
				m=100;
				k1=6;
				k2=6;
				uruchom();
			}
			else if(radio4.isSelected())
			{
				n=150;
				m=150;
				k1=4;
				k2=4;
				uruchom();
			}
			pokaz.setEnabled(false);
			panel.setVisible(true);
			radio1.setEnabled(false);
			radio2.setEnabled(false);
			radio3.setEnabled(false);
			radio4.setEnabled(false);
			reset.setEnabled(true);
		}
	};
	
	 static void Create()
	{
		int i=0;
		int j=0;
		frame = new JFrame();
		panel = new JPanel();	
		ster = new JPanel();
		radio1 = new JRadioButton("25 x 25");
		radio2 = new JRadioButton("50 x 50");
		radio3 = new JRadioButton("100 x 100");
		radio4 = new JRadioButton("150 x 150");
		group = new ButtonGroup();
		otoczenie = new ButtonGroup();
		pokaz = new JButton("Start");
		reset = new JButton("Resetuj");
		check = new JCheckBox("Ci¹g³e zaznaczanie");
		moore = new JRadioButton("Moore");
		vonneumann = new JRadioButton("Von Neumann");
		replicator = new JRadioButton("Replicator");
		walledcities  = new JRadioButton("Walled Cities");
		coral = new JRadioButton("Coral");
		amazing = new JRadioButton("Amazing");
		color2 = color.GRAY;
		
		frame.setTitle("The Game of life");
		frame.setLocation(200, 200);
		frame.setSize(800, 800);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		radio1.setSize(100, 20);
		radio1.setLocation(150, 20);
		radio1.setBackground(color);
		radio1.doClick();
		
		radio2.setSize(100, 20);
		radio2.setLocation(150, 40);
		radio2.setBackground(color);
		
		radio3.setSize(100, 20);
		radio3.setLocation(150, 60);
		radio3.setBackground(color);
		
		radio4.setSize(100, 20);
		radio4.setLocation(150, 80);
		radio4.setBackground(color);
		
		moore.setSize(120, 20);
		moore.setLocation(420, 20);
		moore.setBackground(color);
		moore.doClick();
		
		vonneumann.setSize(120, 20);
		vonneumann.setLocation(420, 40);
		vonneumann.setBackground(color);
		
		replicator.setSize(120, 20);
		replicator.setLocation(420, 60);
		replicator.setBackground(color);

		walledcities.setSize(120, 20);
		walledcities.setLocation(420, 80);
		walledcities.setBackground(color);
		
		coral.setSize(120, 20);
		coral.setLocation(420, 100);
		coral.setBackground(color);
		
		amazing.setSize(120, 20);
		amazing.setLocation(420, 120);
		amazing.setBackground(color);
		
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		group.add(radio4);
		
		otoczenie.add(moore);
		otoczenie.add(vonneumann);
		otoczenie.add(replicator);
		otoczenie.add(walledcities);
		otoczenie.add(coral);
		otoczenie.add(amazing);
		
		check.setSize(150,30);
		check.setLocation(260, 15);
		check.setBackground(color.GRAY);
		
		pokaz.setSize(100, 50);
		pokaz.setLocation(30, 20);
		pokaz.addActionListener(actioncreate);
		
		reset.setSize(100, 50);
		reset.setLocation(30, 70);
		reset.addActionListener(actionreset);
		reset.setEnabled(false);
		
		ster.setLayout(null);
		ster.add(pokaz);
		ster.add(reset);
		ster.setBackground(color2);
		ster.setSize(800, 150);
		ster.setLocation(0, 0);
		ster.add(radio1);
		ster.add(radio2);
		ster.add(radio3);
		ster.add(radio4);
		ster.add(check);
		ster.add(moore);
		ster.add(vonneumann);
		ster.add(replicator);
		ster.add(walledcities);
		ster.add(coral);
		ster.add(amazing);
		
		panel.setLayout(null);
		panel.setLocation(100,160);
		panel.setSize(800,600);
		panel.addMouseWheelListener(l);
		
		color = color.WHITE;
		
		frame.add(ster);
		frame.setVisible(true);
		System.out.println("Poszlo!");	
	}
	 
	static void uruchom()
	{
		p = new JButton[n][m];
		gra = new Board(n,m);
		int pom = 0;
		for( int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{			
				p[i][j] = new JButton();
				p[i][j].setSize(k1, k2);
				p[i][j].setBackground(color);
				if(i==n/2 && j==m/2)
				{
					p[i][j].setBackground(color.RED);
				}
				p[i][j].setLocation(k1*i, k2*j);
				p[i][j].addMouseListener(actionpress);
				String StringCommand = Integer.toString(pom);
				p[i][j].setActionCommand(StringCommand);
				panel.add(p[i][j]);		
				pom++;
			}
		}
		panel.setVisible(false);
		frame.add(panel);
	}
	
	static void play()
	{			
		int[][] apt = new int[n][m];
		 for(int i=0;i<n;i++){
			 for(int j=0;j<m;j++){
				 if(moore.isSelected())
				 {
					 apt[i][j] =gra.checkmoore(i,j);
				 }
				 else if(vonneumann.isSelected())
				 {
					 apt[i][j] =gra.checkneumann(i,j);
				 }
				 else if(replicator.isSelected())
				 {
					 apt[i][j] =gra.replicator(i,j);
				 }
				 else if(walledcities.isSelected())
				 {
					 apt[i][j] =gra.walledcities(i,j);
				 }
				 else if(coral.isSelected())
				 {
					 apt[i][j] =gra.coral(i,j);
				 }
				 else if(amazing.isSelected())
				 {
					 apt[i][j] =gra.amazing(i,j);
				 }
			 }
		 }
		 for(int i=0;i<n;i++){
			 for(int j=0;j<m;j++){
				gra.board[i][j] = apt[i][j];
				if(gra.board[i][j]==1)
				{
					color = color.BLACK;
					p[i][j].setBackground(color);
				}
				else
				{
					color = color.WHITE;
					p[i][j].setBackground(color);
				}	
			 }
		 }
	}
	
	public static void main(String[] args) 
	{
		Create();
		//WireWorldGUI GUI = new WireWorldGUI();
		//BriansBrainGUI las = new BriansBrainGUI();
		//LangtonGUI ant = new LangtonGUI();
	}

}
