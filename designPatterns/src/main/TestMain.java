package main;

import letter.Alphabet;

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
		
		//ex 2
		
		//ex 3
	}

}
