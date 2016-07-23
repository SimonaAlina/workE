package observer;

import java.util.Observable;
import java.util.Observer;

public class PublicPage implements Observer {

	public String name;

	public PublicPage(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("Update " + name + "'s stream, someone liked something.");
	}

}
