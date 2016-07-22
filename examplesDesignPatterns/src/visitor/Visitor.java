package visitor;

/**
 * Created by rburlacioiu on 7/22/2016.
 */
public interface Visitor {
    int visit(Book book);
    int visit(Fruit fruit);
}
