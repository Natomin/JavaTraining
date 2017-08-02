package java8.ch03.ex11;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Transformer extends Application {
	@FunctionalInterface
	interface ColorTransformer {
		Color apply(int x, int y, Color colorAtXY, int width, Color flameColor);
	}

	public static ColorTransformer combine(ColorTransformer tr1, ColorTransformer tr2) {
		return (x, y, colorAtXY, width, transformed) -> {
			Color color = tr1.apply(x, y, colorAtXY, width, transformed);
			return tr2.apply(x, y, color, width, transformed);
		};
	}

	public static ColorTransformer changeToColorTransformer(UnaryOperator<Color> op) {
		return (x, y, colorAtXY, width, transformed) -> {
			return op.apply(colorAtXY);
		};

	}

	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y,
						f.apply(x, y, in.getPixelReader().getColor(x, y), 20, Color.BLUEVIOLET));
			}
		}
		return out;
	}

	public void start(Stage stage) {
		Image image = new Image("file:./src/java8/ch03/ex05/cat.jpg", 700, 450, false, false);

		ColorTransformer tr1 = (x, y, c, w,
				t) -> x < w || x > image.getWidth() - w || y < w || y > image.getHeight() - w ? t : c;

		ColorTransformer tr2 = changeToColorTransformer(Color::grayscale);

		Image image2 = transform(image, combine(tr1, tr2));

		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
