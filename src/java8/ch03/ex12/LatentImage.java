package java8.ch03.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@FunctionalInterface
interface ColorTransformer {
		Color apply(int x, int y, Color colorAtXY);
}

public class LatentImage extends Application{
	private Image in;
	private List<ColorTransformer> pendingOperations;

	
	public static LatentImage from(Image in) {
		LatentImage result = new LatentImage();
		result.in = in;
		result.pendingOperations = new ArrayList<>();
		return result;
	}
	
	public static ColorTransformer changeToColorTransformer(UnaryOperator<Color> op) {
		return (x, y, colorAtXY) -> {
			return op.apply(colorAtXY);
		};

	}
	
	public LatentImage transform(ColorTransformer f) {
		pendingOperations.add(f);
		return this;
		
	}
	
	public LatentImage transform(UnaryOperator<Color> f) {
		pendingOperations.add(changeToColorTransformer(f));
		return this;
		
	}
	
	public Image toImage() {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for (ColorTransformer f : pendingOperations)
					c = f.apply(x, y, c);
				out.getPixelWriter().setColor(x, y, c);
			}
		return out;
	}
	
	
	
	
	public void start(Stage stage) {
		Image image = new Image("file:./src/java8/ch03/ex05/cat.jpg", 700, 450, false, false);
		Image finalImage = LatentImage
				.from(image)
				.transform(Color::brighter)
				.transform(Color::grayscale)
				.toImage();
		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(
				finalImage))));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
