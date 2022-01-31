import java.util.*;

class prime_counter
{
    public static void main(String[] args)
    {
                //Prime_Numbers list will contain all future prime numbers
                //NonPrime_Numbers list will contain all future non-prime numbers
                //Skip_Numbers list will contain all future non-prime numbers squared(more on this later).
        List<Long> Prime_Numbers=new ArrayList<Long>();  
        List<Long> Skip_Numbers=new ArrayList<Long>();
        List<Long> NonPrime_Numbers=new ArrayList<Long>(); 

        System.out.println("Enter a number:");

        Scanner userInput = new Scanner(System.in);

                //max_value will determine to what number the software should count to.
                //sqrt_max_val is the square root of max_value(more on this later).
        int max_value = Integer.parseInt(userInput.next());

                //if max_value is negative or zero(0) output an error.
        if(max_value <= 0)
        {
            System.out.println("Please enter a valid number.");
            System.exit(0);
        }
        int sqrt_max_val = (int)Math.sqrt(max_value);

                //this saves the current time(more on that later).
        long startTimer = System.nanoTime();

                //this 'for loop' counts every number from 1 to max_value (i).
                //foreach of those numbers(i) the software counts again from 1 to that number (y).
                //it divides the first number(i) by the second number(y) and checks for a remainder.
                //if the divided number doesn't have a remainder add +1 successNumber.
                //when the software gets to successNumber=2, add first number(i) to Prime list, and
                //start counting the next number(y).
                //if successNumber is lower than 2 add that number(i) to Non-prime list.
                //then square number(i) because: NonPrime * NonPrime = Prime, and add that number,
                //to Skip_Numbers list.
                //Note: a prime number can be added to Prime_Numbers list if that number doesn't exist
                //      in Skip_Numbers.
        for (int i = 1; i <= max_value; i++)
        {
            byte successNumber = 0;
            for (int y = 1; y < i; y++)
            {
                if (i % y == 0)
                {
                    successNumber++;
                }
                if (successNumber >= 2)
                {
                    break;
                }
            }
            if (successNumber >= 2 && !Skip_Numbers.contains(i))
            {
                Prime_Numbers.add((long)i);
            }
            else
            {
                NonPrime_Numbers.add((long)i);
                //sqrt_max_val makes sure that this 'if statement' won't add a number
                //higher than max_value.
                if (i <= sqrt_max_val)
                {
                    Skip_Numbers.add((long)(i * i));
                }
            }
        }

                //this adds the numbers from Skip_Numbers list to the Prime_Numbers list.
                //Note: this list contains: Non-prime * Non-prime = Prime.
        for (long i : Skip_Numbers)
        {
            Prime_Numbers.add(i);
        }

                //this prints all the data.
        System.out.println("\n" + "Prime numbers (till " + max_value + "):");
        for (long i : Prime_Numbers)
        {
            System.out.print(i + ", ");
        }

        System.out.println("\n" + "\n" + "Non-Prime numbers (till " + max_value + "):");
        for (long i : NonPrime_Numbers)
        {
            System.out.print(i + ", ");
        }

        System.out.println("");

                //this saves the current time(after the software has finished).
        long endTimer = System.nanoTime();
                //this prints for how long the software been executed.
        System.out.println("Execution time in seconds:"+ (double)(endTimer - startTimer)/1000000000); 
    }
}