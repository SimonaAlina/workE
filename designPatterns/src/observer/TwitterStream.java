package observer;

import java.util.Observable;

//concrete subject
public class TwitterStream extends Observable {

  public void someoneTweeted() {
      setChanged();
      notifyObservers();
  }
}
