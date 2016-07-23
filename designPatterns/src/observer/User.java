package observer;

import java.util.Observable;
import java.util.Observer;

//concrete observer
public class User implements Observer {

  public String name;

  public User(String name) {
      this.name = name;
  }

  @Override
  public void update(Observable o, Object arg) {
      System.out.println("Update " + name + "'s stream, someone tweeted something.");
  }
}