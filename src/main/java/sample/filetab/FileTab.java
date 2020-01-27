package sample.filetab;

import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

public class FileTab extends Tab {

	public FileTab(String name) {
		super(name, new TextArea());
	}

}
