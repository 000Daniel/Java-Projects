package tf2_class_generator;
import java.util.Scanner;

public class TF2_Class_Generator {
			//picks one of the 9 classes
	static String[] classes = {"Scout", "Soldier", "Pyro", "Demoman", "Heavy", "Engineer", "Medic", "Sniper", "Spy"};
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		func();
	}
	
	private static void func() {
		int temp_Index = (int) (Math.random() * classes.length);
		
		int slot = 1;
		if (((int) (Math.random() * 2) + 1) <= 1) //50/50 chance that the slot would be 1-2 or 1-4.
		{
			slot = (int) (Math.random() * 4);
		}
		else
		{
			slot = (int) (Math.random() * 2);
		}
		
		System.out.println("\nYour class is: " + classes[temp_Index]);
		System.out.println("Slot: " + (slot + 1));
		
		System.out.print("\nPress enter to continue...");
		userInput.nextLine();		//pauses before generating a new class
		func();
	}
}
