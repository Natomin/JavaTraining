package java8.ch03.ex05;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Transformer extends Application {

	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}
	
    public void start(Stage stage) {
//        Image image = new Image("file:./src/java8/ch03/ex05/Golden_Gate_Bridge_0002.jpg", 700, 500, false, false);
        Image image = new Image("file:./src/java8/ch03/ex05/cat.jpg", 700, 450, false, false);
        int width  = (int)image.getWidth();
        int height = (int)image.getHeight();
        Image image2 = transform(image,
				(x, y, c) -> x < 10 || y < 10 || x >= width - 10 || y >= height - 10 ? Color.GRAY : c);
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
