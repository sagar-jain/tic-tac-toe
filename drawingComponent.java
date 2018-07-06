import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
public class drawingComponent extends JComponent{
	public int flag;
	drawingComponent(int f){
		this.flag = f;
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		if(flag == 0){
			g2.drawString("HOW TO PLAY", 20, 20);
			g2.drawString("2.	Keep doing alternating moves until all blocks are not filled.", 20, 85);
			g2.drawString("1.	Have the first player go first.Fill the block.", 20, 45);
			g2.drawString(" Have the second player go next. Fill in similar manner.", 20, 60);
		}
	}
}