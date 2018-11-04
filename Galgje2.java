package Chapter2;
import java.util.ArrayList;
import java.util.Scanner;
public class Galgje2 
{
	// Check letter function 
	static ArrayList<Integer> indexList = new ArrayList<Integer>();
	public static boolean charChecker (ArrayList<Character> myWord, char answer) 
	{
		if(myWord.contains(answer))
		{
			int currentIndex = myWord.indexOf(answer);
			if (indexList.contains(currentIndex))
			{
				System.out.println("found: your word is now becoming ==>");
				printList(myWord);
				return true;
			}
			else
			{
				indexList.add(currentIndex);
				System.out.println("found: your word is now becoming ==>");
				printList(myWord);
				return true;
			}
		}
		else
		{
			System.out.println("not found: your word is still ==> ");
			printList(myWord);
			return false; 
		}
	}
	
	// print the answers of the user
	public static void printList(ArrayList<Character> myWord)
	{
		System.out.println("You found the following letters: ");
		for(int i=0; i<myWord.size(); i++)
		{
			if(indexList.contains(i))
			{
				System.out.print(myWord.get(i));
			}
			else
			{
				System.out.print('*');
			}
		}
	}
	// Check if the user completed the word! 
	static boolean completeWord(ArrayList<Character> myWord)
	{
		if(myWord.size() == indexList.size())
		{
			return true; 
		}
		else
		{
			return false;
		}
	}
	// Main function
	public static void main(String[] args) {
		System.out.println("Guess the word ");
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('b');
		list.add('l');
		list.add('o');
		list.add('n');
		list.add('d');
		
		int aantalPoogingen = list.size()*2;
		System.out.println("Player2 choos a letter: you have " + aantalPoogingen+" choices " );
		for(int i=0; i<aantalPoogingen; i++)
		{
			Scanner scanner= new Scanner(System.in);
			char answer    = scanner.next() .charAt(0);
			charChecker(list, answer);
			if(completeWord(list))
			{
				System.out.println("\nCongratulations! You won the game!");
				break;
			}
			else if(!completeWord(list) && i== aantalPoogingen-1)
			{
				System.out.println("\nYou Lost! GAME OVER");
				break;
			}
			else
			{
				System.out.println("\nYou still have "+(aantalPoogingen - (i+1))+ " chances to answer!");
			}
			
		}
	}
	
}
