package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javax.naming.ldap.Control;

public class Controller {

	@FXML
	private Rectangle topBar;

	@FXML
	private AnchorPane pane;

	@FXML
	private Circle circle;


	public void initialize() {
		pane.widthProperty().addListener((obs, oldValue, newValue) -> topBar.setWidth(newValue.doubleValue() + 10));
	}


	public void testHandler() {
		System.out.println(topBar);
		System.out.println(topBar.getParent().getLayoutBounds().getWidth());
	}

	public void onCircleJoin () {
		circle.setFill(Paint.valueOf("#FF0000"));
	}

	public void onCircleLeave () {
		circle.setFill(Paint.valueOf("#0000FF"));
	}



}
