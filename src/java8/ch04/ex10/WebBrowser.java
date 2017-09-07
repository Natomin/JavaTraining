package java8.ch04.ex10;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebBrowser extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
	    Button backButton = new Button("⇦︎︎️");
	    WebView webView = new WebView();

	    WebEngine webEngine = webView.getEngine();
	    backButton.setOnAction(                
	        event -> { webEngine.getHistory().go(-1); }
	    );
	    backButton.disableProperty().bind( 
	        Bindings.equal(0, webEngine.getHistory().currentIndexProperty())//履歴エントリ取得。なければボタン押せないようにする。
	    );
	    
	    TextField urlField = new TextField();
	    urlField.setOnAction( 
	        event -> { webEngine.load(urlField.getText()); }
	    );
	    webEngine.locationProperty().addListener( 
	        (location, oldLocation, newLocation) -> { urlField.setText(newLocation); }
	    );
	    webEngine.load("https://www.google.co.jp/");
	    
	    HBox box = new HBox(backButton, urlField);
	    HBox.setHgrow(urlField, Priority.ALWAYS);
	    BorderPane pane = new BorderPane();
	    pane.setTop(box);
	    pane.setCenter(webView);

	    stage.setScene(new Scene(pane, 1000, 700));
	    stage.show();
	}

}
