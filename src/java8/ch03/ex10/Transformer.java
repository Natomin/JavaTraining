package java8.ch03.ex10;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Transformer extends Application{
	public static Image transform(Image in, UnaryOperator<Color> f) {
        int width  = (int)in.getWidth();
        int height = (int)in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(
                    x, y,
                    f.apply(in.getPixelReader().getColor(x, y))
                );
            }
        }
        return out;
    }
	
    public void start(Stage stage) {
        Image image = new Image("file:./src/java8/ch03/ex05/cat.jpg", 700, 450, false, false);
        UnaryOperator<Color> op = Color::brighter;
        Image brightenedImage = transform(image, (UnaryOperator<Color>) op.compose(Color::grayscale));
        //UnaryOperator<T>のcomposeの戻り値型はFunction<Color,Color>だから適切ではない
        
        stage.setScene(new Scene(new HBox(
            new ImageView(image),
            new ImageView(brightenedImage)
        )));
        stage.show();
    }
    
    public static void main(String[] args) {
    	launch(args);
	}

}
