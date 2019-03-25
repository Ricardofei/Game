import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Board implements ActionListener {
	private static Square[] squArr = new Square[64];
	Square startSqu, endSqu;
	static int s1 = -1;
	static int s2 = -1;
	int step = 1;

	public Board() {

		JFrame frame = new JFrame("Game");

		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		placeComponets(panel);

		frame.setVisible(true);

	}

	void placeComponets(JPanel panel) {
//place the red and white chess
		GridLayout gl = new GridLayout(8, 8);
		panel.setLayout(gl);

		for (int i = 0; i < squArr.length; i++) {
			int row = i / 8;
			int col = i % 8;
			String info = "";
			if (row <= 2) {
				info = Square.RED;
			} else if (row >= 5) {
				info = Square.WHITE;

			} else {
				info = Square.EMPTY;
			}
			if ((row + col) % 2 != 0)
				squArr[i] = new Square(i, info);
			else {
				squArr[i] = new Square(i, Square.EMPTY2);
			}

			squArr[i].getBtn().addActionListener(this);
			squArr[i].getBtn().setActionCommand(i + "");
			panel.add(squArr[i].getBtn());

		}

		startSqu = null;

	}

	private static void refresh() {
//to refresh the panel in order to clean the yellow//
		if (s1 != -1) {
			squArr[s1].setInfo(Square.EMPTY);
			s1 = -1;
		}
		if (s2 != -1) {
			squArr[s2].setInfo(Square.EMPTY);
			s2 = -1;
		}
	}

	
	
	
	// make it move//
	@Override
	public void actionPerformed(ActionEvent e) {

		int num = Integer.parseInt(e.getActionCommand());
		int row = num / 8;
		int col = num % 8;
		// movement of white chess//
		if (squArr[num].getInfo().equals(Square.WHITE)) {
			startSqu = squArr[num];
			refresh();
			if (row > 0) {
				if (col > 0)
					s1 = num - 9;
				if (col < 7)
					s2 = num - 7;
			}
		//use Yellow to show where can go
			if (s1 != -1) {
				if (startSqu.canMoveto(squArr[s1]))
					squArr[s1].setInfo(Square.SELECTED);
				else
					s1 = -1;
			}
			if (s2 != -1) {
				if (startSqu.canMoveto(squArr[s2]))
					squArr[s2].setInfo(Square.SELECTED);
				else
					s2 = -1;

			}
		} else if (squArr[num].getInfo().equals(Square.RED)) {
//movement of RED chess
			startSqu = squArr[num];
			refresh();
			if (row < 7) {
				if (col > 0)
					s1 = num + 7;
				if (col < 7)
					s2 = num + 9;
			}
			if (s1 != -1) {
				if (startSqu.canMoveto(squArr[s1]))
					squArr[s1].setInfo(Square.SELECTED);
				else
					s1 = -1;
			}
			if (s2 != -1) {
				if (startSqu.canMoveto(squArr[s2]))
					squArr[s2].setInfo(Square.SELECTED);
				else
					s2 = -1;

			}

		} else {
			// set move limitation and the rule of white go first red go after//
			if (startSqu != null)
				if (squArr[num].getInfo().equals(Square.SELECTED)) {
					if (step % 2 == 1) {

						if (startSqu.getInfo().equals(Square.WHITE)) {
							refresh();
							startSqu.moveTo(squArr[num]);
							//set the rule of white king and red king
							if (row == 0)
								squArr[num].setInfo(Square.WHITEKING);
							if (row == 7)
								squArr[num].setInfo(Square.REDKING);
							startSqu = null;
							step++;
						} else {
							System.out.println("It's white term now.");
							// remain that white go first
						}
					} else {
						if (startSqu.getInfo().equals(Square.RED)) {
							refresh();
							startSqu.moveTo(squArr[num]);
							if (row == 0)
								squArr[num].setInfo(Square.WHITEKING);
							if (row == 7)
								squArr[num].setInfo(Square.REDKING);
							startSqu = null;
							step++;
						} else {
							System.out.println("It's red term now.");
						}

					}

				}
		}

	}
}



