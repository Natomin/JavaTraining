package java8.ch04.ex09;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlanetAnimation extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//シーングラフ
		Group root = new Group();
		
		//シーングラフに楕円を追加
		Ellipse ellipse = new Ellipse();
		ellipse.setFill(null);
		ellipse.setStroke(Color.PINK);
		ellipse.setCenterX(300.0f);
		ellipse.setCenterY(150.0f);
		ellipse.setRadiusX(200.0f);
		ellipse.setRadiusY(100.0f);
		root.getChildren().add(ellipse);
		
		//シーングラフに円を追加
		Circle planet = new Circle(10);
		planet.setFill(Color.MIDNIGHTBLUE);
		root.getChildren().add(planet);
		
		//円のアニメーション
		PathTransition pathTransition = new PathTransition();
		pathTransition.setNode(planet);
		pathTransition.setDuration(Duration.millis(30000));
		pathTransition.setPath(ellipse);
		pathTransition.setInterpolator(Interpolator.LINEAR);
		pathTransition.setCycleCount(PathTransition.INDEFINITE);//無限

		//シーン作成
		Scene scene = new Scene(root, 600, 300);
		
		//ウインドウ表示
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//アニメーション開始
		pathTransition.play();
		
		
	}

}

