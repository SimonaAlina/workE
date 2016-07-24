package visitorDoc;

public class WordCountVisitor implements Visitor {

	@Override
	public int visit(Document doc) {
		int count = 0;
		for (String line : doc.getLines())
			count += line.split(" ").length;
		return count;
	}

}
