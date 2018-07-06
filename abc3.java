import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.*;
import java.io.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.*;
public class tic_tac_toe extends JFrame implements MouseListener,KeyListener
{
JFrame j=new JFrame("How to Play?");
JFrame playerFrame=new JFrame("Play Tic-Tac-Toe");;
JPanel jp = new JPanel();
JLabel jl = new JLabel();
JTextField player1FName, player2FName;
JButton buttons[]=new JButton[9]; // boxes in the panel which are 9 in total is stored in the form of array. Each box is the object of jbutton class
String names[] = new String[2];
JButton b,q, p;
int alternate=0;
int countA = 0; 
// constructor to set initial values.
tic_tac_toe()
{
j.setSize(400,400); // creates a panel for the tic tac toe game
//j.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
//JPanel textArea = new JPanel();
//textArea.setPreferredSize(new Dimension(200,200));
drawingComponent DC = new drawingComponent(0);
//textArea.add(DC);
//textArea.setVisible(true);
//j.getContentPane().add(DC);
b = new JButton("Start"); // creates "Start Game button"
q = new JButton("Quit"); // creates "Quit" button
b.setBounds(200,320, 80, 20);
q.setBounds(290,320, 80, 20);
//jl.setIcon(new ImageIcon("C:\\Users\\Desktop\\ba.jpg"));
// add start quit and image at the begining of the game.
j.add(b);
j.add(q);
j.add(DC);
//j.add(jl);

b.addMouseListener(this); // to set the action when button pressed.
q.addMouseListener(this); // to set the action when button pressed.
j.setDefaultCloseOperation(1); // exit the game
j.setVisible(true);

}

public void resetButtons()
{
    alternate=0;
	playerSelection();
	for(int i = 0; i <= 8; i++)
	{
		buttons[i].setText("");
	}
}

public void playerSelection(){
	JFrame frame = new JFrame();
	frame.setSize(200,100);
	String[] options = new String[2];
	options[0] = new String("Player 1");
	options[1] = new String("Player 2");
	int opt = JOptionPane.showOptionDialog(frame.getContentPane(),"Which player would like to start?","Player Information", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
	if(opt == 0){
		if(names[0] != "Player 1"){
			String temp = names[0];
			names[0] = names[1];
			names[1] = temp;
		}
	}
	else{
		if(names[0] != "Player 2"){
			String temp = names[0];
			names[0] = names[1];
			names[1] = temp;
		}
	}

}
private class buttonListener implements ActionListener
{
public void actionPerformed(ActionEvent e) 
{
JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
if(alternate%2 == 0)
buttonClicked.setText("X");
else
buttonClicked.setText("O");
if(checkForWin() == true )
{
	if(alternate%2 == 0){
		JFrame frame = new JFrame();
		String[] options = new String[1];
		options[0] = new String("OK");
		JOptionPane.showOptionDialog(frame,
                   names[0] + " Win!","Result",
                   JOptionPane.PLAIN_MESSAGE,
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   options,
                   options[0]);
	}
	else{
		JFrame frame = new JFrame();
		String[] options = new String[1];
		options[0] = new String("OK");
		JOptionPane.showOptionDialog(frame,
                   names[1] + " Win!","Result",
                   JOptionPane.PLAIN_MESSAGE,
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   options,
                   options[0]);
	}

resetButtons();
return;
}
alternate++;
if (alternate==9)
{
	JFrame frame = new JFrame();
		String[] options = new String[1];
		options[0] = new String("OK");
		JOptionPane.showOptionDialog(frame,
                   "Stalemet","Result",
                   JOptionPane.PLAIN_MESSAGE,
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   options,
                   options[0]);
resetButtons(); 
}
}
public boolean checkForWin()
{
if( checkAdjacent(0,1) && checkAdjacent(1,2) ) //no need to put " == true" because the default check is for true
return true;
else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
return true;
else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
return true;

//vertical win check
else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
return true;  
else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
return true;
else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
return true;

//diagonal win check
else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
return true;  
else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
return true;
else 
return false;
}
public boolean checkAdjacent(int a, int b)
{
if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
return true;
else
return false;
}
}
// program starts from here.
public static void main(String[] args) {
	new tic_tac_toe();
}
// after main. this will be called
@Override
public void mouseClicked(MouseEvent e)
{
if(e.getSource() == b){
	j.setVisible(false);
	playerFrame.setSize(400,400);
	p = new JButton("Play Game!");
	JLabel player1LName = new JLabel("Player 1 Name:");
	player1FName = new JTextField(20);
	player1LName.setLabelFor(player1FName);
	JLabel player2LName = new JLabel("Player 2 Name:");
	player2FName = new JTextField(20);
	player2LName.setLabelFor(player2FName);
	playerFrame.setLayout(new FlowLayout(FlowLayout.CENTER,5,50));
	playerFrame.add(player1LName);
	playerFrame.add(player1FName);
	playerFrame.add(player2LName);
	playerFrame.add(player2FName);
	playerFrame.add(p);
	p.addMouseListener(this);
	playerFrame.setDefaultCloseOperation(1);	
	
	playerFrame.setVisible(true);
}
if(e.getSource()==p)
{ 
names[0] = player1FName.getText();
names[1] = player2FName.getText();
playerSelection();
playerFrame.setVisible(false);
JFrame window = new JFrame("Tic-Tac-Toe");
window.setBounds(400,400,400,400);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setLayout(new GridLayout(3,3));
for(int i = 0; i <= 8; i++)
{
buttons[i] = new JButton("");
window.add(buttons[i]);
buttons[i].addActionListener(new buttonListener());
buttons[i].addMouseListener(this);
}
window.setVisible(true);
}
if(e.getSource()==q)
{
j.setVisible(false);
}
}
@Override
public void mousePressed(MouseEvent e) {}
@Override
public void mouseReleased(MouseEvent e) {}
@Override
public void mouseEntered(MouseEvent e) {
	JButton button = (JButton)e.getComponent();
	button.setBackground(Color.GREEN);
}
@Override
public void mouseExited(MouseEvent e) {
	JButton button = (JButton)e.getComponent();
	Color def = new Color(222,239,245);
	button.setBackground(def);
}
@Override
public void keyTyped(KeyEvent e) {}
@Override
public void keyPressed(KeyEvent e) {}
@Override
public void keyReleased(KeyEvent e) {}
}
