package visitorDoc;

public class CharacterCountVisitor implements Visitor {

	@Override
	public int visit(Document doc) {
		int count = 0;
		for (String line : doc.getLines())
			count += line.length();
		return count;
	}

}
