import javax.swing.*;
import java.awt.event.*;

public class Square {

	public static String EMPTY = "pieces/empty.png";
	public static String EMPTY2 = "pieces/empty2.png";
	public static String WHITE = "pieces/white.png";
	public static String RED = "pieces/red.png";
	// yellow//
	public static String SELECTED = "pieces/selected.png";
	// white king red king//
	public static String WHITEKING = "pieces/white-king.png";
	public static String REDKING = "pieces/red-king.png";

	private JButton btn;
	private int location;
	private String info;

	public Square(int location, String info) {
		this.location = location;
		btn = new JButton();
		this.info = info;
		ImageIcon icon = new ImageIcon(this.info);
		btn.setIcon(icon);

	}

	public JButton getBtn() {
		return btn;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
		ImageIcon icon = new ImageIcon(this.info);
		btn.setIcon(icon);
	}

	public void moveTo(Square squ) {
		squ.setInfo(this.info);
		this.setInfo(EMPTY);

	}

	public boolean canMoveto(Square squ) {
		if (squ.getInfo().equals(EMPTY)) {
			return true;
		} else
			return false;
	}

}
