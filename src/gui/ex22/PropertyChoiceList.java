package gui.ex22;

import java.awt.Choice;

public class PropertyChoiceList{
	Choice fontSize = new Choice();
	Choice font = new Choice();
	Choice textColor = new Choice();
	Choice backGroundColor = new Choice();
	
	
	public PropertyChoiceList(){
		fontSize.add("50");
		fontSize.add("100");
		fontSize.add("150");
		fontSize.add("200");
		
		font.add("serif");
		font.add("dialog");
		
		textColor.add("black");
		textColor.add("cyan");
		textColor.add("magenta");
		textColor.add("yellow");
		
		backGroundColor.add("white");
		backGroundColor.add("cyan");
		backGroundColor.add("magenta");
		backGroundColor.add("yellow");
		backGroundColor.add("pink");
		backGroundColor.add("green");
		
	}
	public Choice getFontSizeChoice(){
		return fontSize;
	}
	
	public Choice getFontChoice(){
		return font;
	}
	public Choice getTextColorChoice(){
		return textColor;
	}
	public Choice getbackGroundColorChoice(){
		return backGroundColor;
	}

}
