import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
public class Subject {
	public static float FirstNumber = 1;
	static Scanner UserInput;
	static String Num;
	public static void main(String[] args) {
		int doChange = 0;
		NumberFormat nf = new DecimalFormat("#.####"); 
		System.out.flush();
		System.out.print("Your current number is: " + nf.format(FirstNumber) + "\n");
		System.out.print("Commands: \n");
		System.out.print("Set [Number] \n");
		System.out.print("Add [Number] \n");
		System.out.print("Remove [Number] \n");
		System.out.print("Multiply [Number] \n");
		System.out.print("Divide [Number] \n\n");
		UserInput = new Scanner(System.in);
		Num = UserInput.nextLine();
		String commandWord[] = Num.split(" ", 3);
		String str1 = commandWord[0].toLowerCase();
		String str2 = commandWord[1];
		int intIndex = str1.indexOf("add");
		doChange = 0;
		if (intIndex == -1) {
			intIndex = str1.indexOf("remove");
			doChange = 1;
		}
		if (intIndex == -1) {
			intIndex = str1.indexOf("multiply");
			doChange = 2;
		}
		if (intIndex == -1) {
			intIndex = str1.indexOf("divide");
			doChange = 3;
		}
		if (intIndex == -1) {
			intIndex = str1.indexOf("set");
			doChange = 4;
		}
		if (intIndex == -1) {
			Error();
		}
		if (intIndex == 0) {
			boolean testNumber = str2.matches(".*\\d.*");
			if (testNumber == true) {
				float InitialNumber = Float.parseFloat(str2);
			if (doChange == 0)
				FirstNumber = FirstNumber + InitialNumber;
			if (doChange == 1)
				FirstNumber = FirstNumber - InitialNumber;
			if (doChange == 2)
				FirstNumber = FirstNumber * InitialNumber;
			if (doChange == 3)
				FirstNumber = FirstNumber / InitialNumber;
			if (doChange == 4)
				FirstNumber = InitialNumber;
			} else
				Error();
		}
		clrscr();
	    }
	public static void clrscr(){
		//Clears Screen in java
		try {
		    if (System.getProperty("os.name").contains("Windows"))
		        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		    else
		        Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {}
		main(null);
		}
	public static void Error() {
		System.out.print("Error! \"" + Num + "\" Wasn't recognized as a valid command. \n");
		System.out.println("Press Enter key to continue... \n");
        UserInput = new Scanner(System.in);
        UserInput.nextLine();
        System.out.println("Loading... \n");
        clrscr();
	}

}