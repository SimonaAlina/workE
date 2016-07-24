package visitorDoc;

import java.util.List;

public class Document {

	List<String> lines;

	public Document(List<String> lines) {
		super();
		this.lines = lines;
	}

	public Document() {
	}

	public int accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public List<String> getLines() {
		return lines;
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}
}
