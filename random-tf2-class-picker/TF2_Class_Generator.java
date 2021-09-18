package generator.tf2classes;
import java.util.Scanner;

public class TF2_Class_Generator {
	
	static String[] classes = { "Scout", "Soldier", "Pyro", "Demoman", "Heavy", "Engineer", "Medic", "Sniper", "Spy"};
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		func();
	}
	
	private static void func() {
		var class_tf2 = classes[(int) (Math.random() * classes.length)];
		
		int slot = 1;
		if (((int) (Math.random() * 2) + 1) <= 1) //50/50 chance that the slow would be 1-2 or 1-4.
		{
			slot = (int) (Math.random() * 4);
		}
		else
		{
			slot = (int) (Math.random() * 2);
		}
		
		System.out.println("\nYour class is: " + class_tf2);
		System.out.println("Slot: " + (slot + 1));
		
		System.out.print("\nPress enter to continue...");
		userInput.nextLine();
		func();
	}
}
