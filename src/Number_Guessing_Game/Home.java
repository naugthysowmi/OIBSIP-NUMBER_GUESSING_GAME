package Number_Guessing_Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Home {
	
	JFrame home;
	JLabel label,rangelabel,to,Answer,comment,attemptlabel;
	JTextField t1,t2,ans;
	JButton check,reset;
	Boolean state=false;
	int actualans;
	int attempts=0;
	
	public Home(){
		//Creation of the Home page
		
		
		
		home = new JFrame();
		try {
			home.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("S:\\java\\8389461.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		home.pack();
		home.setSize(1650,1080);
		home.setLayout(null);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creation of the title using label in swing
		label = new JLabel("Welcome to the Number Guessing Game");
		label.setBounds(450,20,600,100);
		label.setFont(new Font("TimesNewRoman",Font.BOLD, 30));
		
		rangelabel = new JLabel("Set the Range : ");
		rangelabel.setBounds(520,220,400,50);
		rangelabel.setFont(new Font("TimesNewRoman",Font.BOLD, 20));
		
		to = new JLabel(" To ");
		to.setBounds(760,220,50,50);
		to.setFont(new Font("TimesNewRoman",Font.BOLD, 20));
		
		Answer = new JLabel("Answer : ");
		Answer.setBounds(550,287,100,50);
		Answer.setFont(new Font("TimesNewRoman",Font.BOLD, 20));
		
		attemptlabel = new JLabel();
		attemptlabel.setBounds(550,480,500,50);
		attemptlabel.setFont(new Font("TimesNewRoman",Font.BOLD, 20));
		
		
		comment = new JLabel();
		comment.setBounds(550,530,500,50);
		comment.setFont(new Font("TimesNewRoman",Font.BOLD, 20));
		
		
		
		// Creation of the TextField for getting the number to set the range 
		// by default set to 0 to 100
		
		t1 = new JTextField("0");
		t1.setBounds(680,232,80,30);
		t1.setFont(new Font("TimesNewRoman",Font.BOLD, 15));

		t2 = new JTextField("100");
		t2.setBounds(800,232,80,30);
		t2.setFont(new Font("TimesNewRoman",Font.BOLD, 15));
		
		ans = new JTextField();
		ans.setBounds(710,300,80,30);
		ans.setFont(new Font("TimesNewRoman",Font.BOLD, 15));
		
		
		// Button to add the action
		check = new JButton("Check");
		check.setBounds(630,380,100,40);
		check.setFont(new Font("TimesNewRoman",Font.BOLD, 15));
		check.setBackground(Color.BLUE);
		check.setForeground(Color.WHITE);
		
		reset = new JButton("Reset");
		reset.setBounds(780,380,100,40);
		reset.setFont(new Font("TimesNewRoman",Font.BOLD, 15));
		reset.setBackground(Color.RED);
		reset.setForeground(Color.WHITE);
		
		label.setForeground(Color.white);
		rangelabel.setForeground(Color.white);
		to.setForeground(Color.white);
		Answer.setForeground(Color.white);
		comment.setForeground(Color.white);
		attemptlabel.setForeground(Color.white);
		
		//Creating instance for the random class
		Random rand = new Random();
		
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int start = Integer.parseInt(t1.getText().toString());
					int end = Integer.parseInt(t2.getText().toString());
					int userans = Integer.parseInt(ans.getText().toString());
					
					if(!state) {
						actualans = rand.nextInt(end - start + 1) + start;
					}
				
					attempts+=1;
					attemptlabel.setText("Attempts : "+attempts);
					state=true;
					if(actualans == userans) {
						comment.setText("Wow, you won the Game. Congrats!!!");
					}
					else if(actualans > userans) {
						comment.setText("Your Answer is small, Better try");
					}
					else if(actualans < userans) {
						comment.setText("Your Answer is large, Better try");
					}
					else {
						comment.setText("Invalid Answer");
					}
				}
				catch(Exception e1) {
					comment.setText("Error Occured, Try Again");
				}
				
			}
		});
		
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				t1.setText("0");
				t2.setText("100");
				ans.setText(null);
				comment.setText(null);
				attempts=0;
				attemptlabel.setText("");
				
			}
			
		});

		
		home.add(label);
		home.add(rangelabel);
		home.add(t1);
		home.add(to);
		home.add(t2);
		home.add(Answer);
		home.add(ans);
		home.add(check);
		home.add(reset);
		home.add(comment);
		home.add(attemptlabel);
		home.setVisible(true);
	}
}
