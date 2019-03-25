import javax.swing.*;

public class Square {
	private JButton btn;
	private int location;
	private String info;
	public Square(int location,String info) {
		this.location=location;
		btn=new JButton();
		if (info.equals("EMPTY")) {
			this.info="pieces/empty.png";
		}
		else if(info.equals("EMPTY2")) {
			this.info="pieces/empty2.png";
		}
		else if(info.equals("WHITE")) {
			this.info="pieces/white.png";
		}
		else if(info.equals("RED")) {
			this.info="pieces/red.png";
		}
		/*int row=location/8;
		int col=location%8;
		this.info="piece/empty2.png";
		
		if((row+col)%2==0){
			
			this.info="pieces/empty2.png";
		}
		if(info.equals("WHITE")) {
			this.info="pieces/white.png";
		}else if(info.equals("RED")){
			this.info="pieces/red.png";
		}*/
		
		
		ImageIcon icon = new ImageIcon(this.info);
		btn.setIcon(icon);
		
	}
	public JButton getBtn() {
		return btn;
	}
	
}
