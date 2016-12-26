package gui.ex12;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent e){//×押すとウインドウ閉じる処理
		System.exit(0);
	}

}
