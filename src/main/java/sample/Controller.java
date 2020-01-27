package sample;

import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sample.filetab.FileTab;
import sample.sidebar.SidebarController;

public class Controller {

	@FXML
	private AnchorPane basePane;

	@FXML
	private SplitPane mainPane;

	@FXML
	private VBox leftPaneMenu;

	@FXML
	private TabPane filesTabPane;

	public void initialize() {
		SidebarController controller = new SidebarController(leftPaneMenu, mainPane, true);
		controller.addPane("Project", new AnchorPane());
		controller.addPane("Structure", new AnchorPane());
		controller.addPane("Favorites", new AnchorPane());

		filesTabPane.getTabs().add(new FileTab("New file"));
	}


}
