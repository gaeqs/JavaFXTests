package sample.filetab;

import javafx.scene.control.Tab;
import org.fxmisc.richtext.CodeArea;

public class FileTab extends Tab {

	public FileTab(String name) {
		super(name);
		CodeArea codeArea = new CodeArea();

		setContent(codeArea);

	}


}
