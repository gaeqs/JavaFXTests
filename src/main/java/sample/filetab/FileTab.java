package sample.filetab;

import javafx.scene.control.Tab;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

public class FileTab extends Tab {

	public FileTab(String name) {
		super(name);
		CodeArea codeArea = new CodeArea();

		//codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));

		StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
		spansBuilder.add(Collections.singleton("normal"), 20);
		spansBuilder.add(Collections.singleton("patata"), 20);

		StyleSpans<Collection<String>> spans = spansBuilder.create();

		codeArea.multiPlainChanges()
				.successionEnds(Duration.ofMillis(5)).subscribe(ignore -> codeArea.setStyleSpans(0, spans));

		codeArea.getStyleClass().add("text-area");
		codeArea.getStylesheets().add(getClass().getResource("/test.css").toString());

		setContent(codeArea);

	}


}
