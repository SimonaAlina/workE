package observer;

import java.util.Observable;

public class FacebookStream extends Observable {

	public void someoneLiked() {
	      setChanged();
	      notifyObservers();
	  }
}
