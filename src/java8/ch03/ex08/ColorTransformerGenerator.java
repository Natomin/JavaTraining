package java8.ch03.ex08;


import java8.ch03.ex05.ColorTransformer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorTransformerGenerator extends Application{
	public static ColorTransformer generateColorTransformer(
			Image image, int frameWidth, Color frameColor)
		{
		    return (x, y, c) ->{
		    	int width  = (int)image.getWidth();
		        int height = (int)image.getHeight();
		        return x < frameWidth || y < frameWidth || x >= width - frameWidth || y >= height - frameWidth
				        ? frameColor : c;
		    };
		        
		}
	
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

	public void start(Stage stage) throws Exception {
	    Image image = new Image("file:./src/java8/ch03/ex05/cat.jpg", 700, 450, false, false);
	    Image image2 = transform(image, generateColorTransformer(image, 20, Color.BLUEVIOLET));
	    stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
	    stage.show();
	}
	
	public static void main(String[] args) {
    	launch(args);
	}
}
