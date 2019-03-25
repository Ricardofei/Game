import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Board implements ActionListener{
	private Square[] squArr = new Square[64];
	Square startSqu, endSqu;
	public Board() {
		
		JFrame frame = new JFrame("Game");
		
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		placeComponets(panel);
		
		frame.setVisible(true);
		
	}
	void placeComponets(JPanel panel){
		GridLayout gl=new GridLayout(8,8);
		panel.setLayout(gl);
		
		for(int i=0;i<squArr.length;i++) {
			int row=i/8;
			int col=i%8;
			String info="";
			if(row<=2) {
				info=Square.RED;
			}
			else if(row>=5) {
				info=Square.WHITE;
				
				}
			else {
				info=Square.EMPTY;
			}
				if((row+col)%2!=0)
					squArr[i]=new Square(i,info);
				else {
					squArr[i]=new Square(i,Square.EMPTY2);
				}
			
			squArr[i].getBtn().addActionListener(this);
			squArr[i].getBtn().setActionCommand(i+"");
			panel.add(squArr[i].getBtn());
		
		
	}

	
		startSqu=null;
		
		
		
		squArr[40].moveTo(squArr[33]);
	


}

	@Override
	public void actionPerformed(ActionEvent e) {
		int num=Integer.parseInt(e.getActionCommand());
		if(squArr[num].getinfo().equals(Square.WHITE)) {
			startSqu=squArr[num];
		}else {
			if(startSqu!=null&&!squArr[num].getinfo().equals(Square.EMPTY2)) {
			
				startSqu.moveTo(squArr[num]);
				startSqu=null;
				}
			}

		
		}
	}


