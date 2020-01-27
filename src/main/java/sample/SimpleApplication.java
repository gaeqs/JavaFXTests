package sample;

import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleApplication extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
			root.getStylesheets().add("/style/style.css");
			primaryStage.setTitle("JAME (Just Another MIPS Emulator)");

			Scene scene = new Scene(root, 800, 600);



			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void launch(String[] args) {
		Application.launch(args);
	}

	private void applyStyle(Node node, String style) {
		System.out.println(node);
		node.setStyle(style);
		if (node instanceof Parent) {
			((Parent) node).getChildrenUnmodifiable().forEach(target -> applyStyle(target, style));
		}
	}
}
