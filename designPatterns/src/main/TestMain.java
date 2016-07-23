package main;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import letter.Alphabet;
import observer.User;
import observer.FacebookStream;
import observer.PublicPage;
import observer.TwitterStream;
import pizza.Pizza;
import pizza.PizzaFactory;
import pizza.PizzaType;

/*
 * Homework 

•	Create a new class LetterMapping that stores the mapping between a letter and it’s number
•	Create a method that generates an ArrayList of LetterMapping objects for the whole alphabet
•	Create an abstract class “Pizza”, and three classes: “DeluxePizza”, “HamAnMushroomPizza” and “ProsciutoPizza”. Starting from those, create a PizzaFactory that returns a Deluxe, HamAndMushroom or a Prosciuto pizza (Factory Pattern)
•	Starting from the Observer Pattern code presented at the course (check code archive),  try to enrich the example: create more streams (subjects/observables), attach/register/subscribe more observers to them. Let your imagination burst!
•	Pick a text of your choice, read it line by line using java IO and store it in a “Document” object type. Using the Visitor Pattern, create 2 algorithms/visitors: WordCountVisitor, CharacterCountVisitor. Apply those algorithms to the documents’ content.
 *
 */
public class TestMain {

	public static void main(String[] args) {
		//ex 1
		new Alphabet().generateAlphabetMapping();
		for(int i = 0 ; i < Alphabet.mapping.size(); ++i)
			System.out.println(Alphabet.mapping.get(i).getLetter() + " - " + Alphabet.mapping.get(i).getNumber());
		System.out.println();
		
		//ex 2
		Pizza p1 = PizzaFactory.getPizza(PizzaType.PROSCIUTO);
		System.out.println("Pizza type: " + p1.getType());
		Pizza p2 = PizzaFactory.getPizza(PizzaType.DELUXE);
		System.out.println("Pizza type: " + p2.getType());
		System.out.println();
		
		//ex 3
        User client1 = new User("Andra P");
        User client2 = new User("Razvan B");
        PublicPage pb1 = new PublicPage("Voltaj");
        PublicPage pb2 = new PublicPage("Vunk");
        
        TwitterStream messageStream = new TwitterStream();	
        messageStream.addObserver(client1);
        messageStream.addObserver(client2);
        messageStream.addObserver(pb1);
        messageStream.addObserver(pb2);

        messageStream.someoneTweeted();
        System.out.println();
        
        FacebookStream fbStream = new FacebookStream();
        fbStream.addObserver(client1);
        fbStream.addObserver(client2);
        fbStream.addObserver(pb1);
        fbStream.addObserver(pb2);
        
        fbStream.someoneLiked();
        
        //ex 4
        
	}

}
