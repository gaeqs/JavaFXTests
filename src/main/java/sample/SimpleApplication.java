package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(getClass().getResource("/sample.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));

		primaryStage.setTitle("Hello World");

		Scene scene = new Scene(root, 800, 600);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void launch(String[] args) {
		Application.launch(args);
	}
}
