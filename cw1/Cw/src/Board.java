import java.awt.GridLayout;
import javax.swing.*;
public class Board {
	private Square[] squArr = new Square[64];
	
	public Board() {
		
		JFrame frame = new JFrame("Game");
		
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		placeComponets(panel);
		
		frame.setVisible(true);
		
	}
	public void placeComponets(JPanel panel){
		GridLayout gl=new GridLayout(8,8);
		panel.setLayout(gl);
		
		for(int i=0;i<squArr.length;i++) {
			int row=i/8;
			int col=i%8;
			if(row>5) {
				if((row+col)%2!=0)
					squArr[i]=new Square(i,"WHITE");
				else {
					squArr[i]=new Square(i,"NONE");
				}
				
			}
			else {
				squArr[i]=new Square(i,"NONE");
			}
			panel.add(squArr[i].getBtn());
		}
		
	}

}
