package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sample.filetab.FileTab;
import sample.sidebar.SidebarController;

public class Controller {

	@FXML
	private MenuBar mainMenu;

	@FXML
	private SplitPane mainPane;

	@FXML
	private VBox leftSidebar;

	@FXML
	private TabPane filesTabPane;

	public void initialize() {
		SidebarController controller = new SidebarController(leftSidebar, mainPane, true);
		controller.addPane("Project", new AnchorPane());
		controller.addPane("Structure", new AnchorPane());
		controller.addPane("Favorites", new AnchorPane());

		filesTabPane.getTabs().add(new FileTab("New file"));

		MenuItem item = new MenuItem("Patata");
		item.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/index.png"))));
		item.setAccelerator(KeyCombination.valueOf("Ctrl+C"));

		mainMenu.getMenus().add(new Menu("Test", null, item));
	}


}
