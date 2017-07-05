package gui.ex23;


import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseAdapter extends MouseAdapter {
	DigitalClock flame;
	Point point;
	/* コンストラクタ */
	MyMouseAdapter(DigitalClock flm) {
		flame = flm;
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON3){
			flame.pop.show(flame, e.getX(), e.getY());
		}else if(e.getButton() == MouseEvent.BUTTON1){
			flame.setClickedPointX(e.getXOnScreen());
			flame.setClickedPointY(e.getYOnScreen());
			point = flame.getLocation();
			
		}
	}
}
