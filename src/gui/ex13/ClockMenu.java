package gui.ex13;

import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockMenu {
	private DigitalClock flame;
	private PopupMenu pop = new PopupMenu();
	
	public ClockMenu(DigitalClock flame){
		this.flame = flame;
		//文字サイズ
		Menu sizeMenu = new Menu("文字サイズ");
		MenuItem fsize50 = new MenuItem("50");
		fsize50.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setFontSize(50);
			}
		});
		MenuItem fsize100 = new MenuItem("100");
		fsize100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setFontSize(100);
			}
		});
		MenuItem fsize150 = new MenuItem("150");
		fsize150.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setFontSize(150);
			}
		});
		MenuItem fsize200 = new MenuItem("200");
		fsize200.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setFontSize(200);
			}
		});
		sizeMenu.add(fsize50);
		sizeMenu.add(fsize100);
		sizeMenu.add(fsize150);
		sizeMenu.add(fsize200);
		pop.add(sizeMenu);
		//フォント
		Menu fontMenu = new Menu("フォント");
		MenuItem font_serif = new MenuItem("serif");
		font_serif.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setFontStyle(Font.decode(Font.SERIF));
			}
		});
		MenuItem font_dialog= new MenuItem("dialog");
		font_dialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setFontStyle(Font.decode(Font.DIALOG));
			}
		});
		fontMenu.add(font_serif);
		fontMenu.add(font_dialog);
		pop.add(fontMenu);
		//文字色
		Menu textColor = new Menu("文字色");
		MenuItem text_black = new MenuItem("black");
		text_black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.settextColor("black");
			}
		});
		MenuItem text_cyan = new MenuItem("cyan");
		text_cyan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.settextColor("cyan");
			}
		});
		MenuItem text_magenta = new MenuItem("magenta");
		text_magenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.settextColor("magenta");
			}
		});
		MenuItem text_yellow = new MenuItem("yellow");
		text_yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.settextColor("yellow");
			}
		});
		textColor.add(text_black);
		textColor.add(text_cyan);
		textColor.add(text_magenta);
		textColor.add(text_yellow);
		pop.add(textColor);
		//背景色
		Menu backColor = new Menu("背景色");
		MenuItem back_white = new MenuItem("white");
		back_white.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setBackGroundColor("white");
			}
		});
		MenuItem back_cyan = new MenuItem("cyan");
		back_cyan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setBackGroundColor("cyan");
			}
		});
		MenuItem back_magenta = new MenuItem("magenta");
		back_magenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setBackGroundColor("magenta");
			}
		});
		MenuItem back_yellow = new MenuItem("yellow");
		back_yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setBackGroundColor("yellow");
			}
		});
		MenuItem back_pink = new MenuItem("pink");
		back_pink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setBackGroundColor("pink");
			}
		});
		MenuItem back_green = new MenuItem("green");
		back_green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flame.setBackGroundColor("green");
			}
		});
		backColor.add(back_white);
		backColor.add(back_cyan);
		backColor.add(back_magenta);
		backColor.add(back_yellow);
		backColor.add(back_pink);
		backColor.add(back_green);
		pop.add(backColor);
	}
	
	public PopupMenu getPopupMenu(){
		return pop;
	}
	

}
