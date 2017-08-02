package java8.ch03.ex06;


import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Transformer extends Application{
	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg){
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}
		return out;
	}
	
	public void start(Stage stage) throws Exception {
	    Image image = new Image("file:./src/java8/ch03/ex05/cat.jpg", 700, 450, false, false);
        Image image2 = transform(image,(c, factor) -> c.deriveColor(0, 1, factor, 1),
        		//factor分だけcを明るくする
                1.2);//ファクター1.2を使用する
        stage.setScene(new Scene(new HBox(
            new ImageView(image),
            new ImageView(image2)
        )));
        stage.show();
	}
	
	public static void main(String[] args) {
    	launch(args);
	}

}
