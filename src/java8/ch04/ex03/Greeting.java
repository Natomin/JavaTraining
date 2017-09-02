package java8.ch04.ex03;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {
	private StringProperty textProperty = null;
	private String text = "defalt";

	public final StringProperty textProperty() {
		if (textProperty == null) {
			textProperty = new SimpleStringProperty(text);
		}
		return textProperty;
	}

	public final void setText(String newValue) {
		text = newValue;
		if (textProperty == null) {
			textProperty = textProperty();
		}else{
			textProperty.set(text);
		}
	}

	public final String getText() {
		return text;
	}

}
