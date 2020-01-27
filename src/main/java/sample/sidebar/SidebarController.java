package sample.sidebar;

import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class SidebarController {

	private VBox controlled;
	private SplitPane mainPane;

	private boolean leftPane;

	private List<ToggleButton> buttons;
	private List<Double> currentPaneWidths;
	private int selected;

	public SidebarController(VBox controlled, SplitPane mainPane, boolean leftPane) {
		this.controlled = controlled;
		this.mainPane = mainPane;

		this.leftPane = leftPane;

		this.buttons = new ArrayList<>();
		this.currentPaneWidths = new ArrayList<>();
		this.selected = -1;
	}

	public VBox getControlled() {
		return controlled;
	}

	public SplitPane getMainPane() {
		return mainPane;
	}

	public boolean isLeftPane() {
		return leftPane;
	}

	public void addPane(String name, Pane pane) {
		ToggleButton button = new ToggleButton(name);
		button.getStyleClass().add("pane-menu-button");
		button.setPrefWidth(controlled.getPrefWidth() - 1);
		button.setPrefHeight(100);
		controlled.getChildren().add(button);

		buttons.add(button);
		currentPaneWidths.add(0.3);

		button.selectedProperty().addListener((obs, oldValue, newValue) -> {
			if (oldValue == newValue) return;
			if (newValue) {
				if (selected != -1) {
					buttons.get(selected).setSelected(false);
				}
				selected = buttons.indexOf(button);
				int index = leftPane ? 0 : mainPane.getItems().size() - 1;
				mainPane.getItems().add(index, pane);
				mainPane.setDividerPosition(index, currentPaneWidths.get(selected));
			} else {
				selected = -1;

				int index = leftPane ? 0 : mainPane.getItems().size() - 1;
				currentPaneWidths.set(buttons.indexOf(button), mainPane.getDividerPositions()[index]);

				mainPane.getItems().remove(pane);
			}
		});
	}
}
