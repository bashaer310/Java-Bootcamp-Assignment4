import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> results =new ArrayList<Integer>();
        int optNum = 0;

        try {

            do {
                System.out.println("Please choose one of the options \nEnter 1 to addition the numbers\n" +
                        "Enter 2 to subtraction the numbers\n" +
                        "Enter 3 to multiplication the numbers\n" +
                        "Enter 4 to division the numbers\n" +
                        "Enter 5 to modulus the numbers\n" +
                        "Enter 6 to find minimum number\n" +
                        "Enter 7 to find maximum number\n" +
                        "Enter 8 to find the average of numbers\n" +
                        "Enter 9 to print the last result in calculator\n" +
                        "Enter 10 to print the list of all results in calculato\n");

                //try for input != int
                optNum = input.nextInt();
                input.nextLine();

                //try for num != 1-10
                checkInput(optNum);

                if (optNum >= 1 & optNum <= 8)
                    //try for Arithmetic operator
                    operation(optNum, results);

                else if (optNum == 9) {
                    //try for Arraylist != empty
                    checkSize(results.size());
                    System.out.println(results.get(results.size() - 1));

                }
                else if (optNum == 10) {
                    //try for Arraylist != empty
                    checkSize(results.size());
                    for (int n : results)
                        System.out.println(n);
                }

            } while (optNum != 9 && optNum != 10);

        }catch (InputMismatchException e){
            System.out.println("\nInvalid input");
        }catch (ArithmeticException e1){
            System.out.println("\n"+e1.getMessage());
        }catch (Exception e2){
            System.out.println(e2.getMessage());
        }

    }

    public static void operation(int optNum, ArrayList<Integer> results){
        int result=0;
        System.out.println("Please enter the first number ");
        int num1=input.nextInt();
        input.nextLine();

        System.out.println("Please enter the second number ");
        int num2=input.nextInt();
        input.nextLine();
        switch (optNum){
            case 1:
                result= num1 + num2;
                break;

            case 2:
                result= num1 - num2;
                break;
            case 3:
                result= num1 * num2;
                break;

            case 4:
                result= num1 / num2;
                break;

            case 5:
                result= num1 % num2;
                break;
            case 6:
                result= Math.min(num1,num2);
                break;

            case 7:
                result= Math.max(num1,num2);
                break;
            case 8:
                result= (num1+num2)/2;
                break;

        }
        results.add(result);
        System.out.println("\nThe result of operation "+result);
    }

    public static void checkInput(int num) throws Exception{
        if(num<1 | num >10)
            throw new Exception("\nThe option number should between 1 and 10");

    }
    public static void checkSize(int num) throws Exception{
        if(num<1)
            throw new Exception("\nThe Array list is empty");

    }

}
