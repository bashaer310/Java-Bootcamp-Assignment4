import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

//Bashaer Alhuthli
//Java Bootcamp

public class Main {
    public static void main(String[] args) {
        //Q7.Write a menu driven Java program with following option:
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the size of the array ");
        int[] numbers=null;
        try {
            //try for input != int
            //try for size < 0
            int size = input.nextInt();
            input.nextLine();
            checkSize(size);
            numbers = new int[size];

            int answer = 0;
            int count = 0;
            do {
                System.out.println("\nPlease choose one of the options \n1.Accept elements of an array \n2.Display elements of an array \n3.Search the element within array \n4.Sort the array\n5.To Stop");
                //try for input != int
                //try for answer < 1 | answer > 5
                answer = input.nextInt();
                input.nextLine();
                checkAnswer(answer);

                switch (answer) {
                    case 1:
                        //try for the array is full
                        isFull(count,numbers);
                        System.out.println("\nPlease enter a number ");
                        numbers[count] = input.nextInt();
                        input.nextLine();
                        count++;
                        break;
                    case 2:
                        //try for array is empty
                        isEmpty(count);
                        System.out.print("\nThe elements of the array are ");
                        for (int i = 0; i < count; i++)
                            System.out.print(numbers[i] + ", ");
                        break;
                    case 3:
                        boolean isFound = false;
                        ArrayList<Integer> indexes = new ArrayList<Integer>();
                        //try for array is empty
                        isEmpty(count);
                        System.out.print("\nPlease enter a number ");
                        int number = input.nextInt();
                        input.nextLine();
                        for (int i = 0; i < count; i++) {
                            if (numbers[i] == number) {
                                 isFound = true;
                                 indexes.add(i);
                            }
                        }
                        if (isFound) {
                            System.out.print(number + " is found at the index ");
                            for (int i : indexes) {
                                System.out.print(i + ", ");
                            }
                        } else{
                            System.out.println(number + " is not found in the array");
                        }
                        break;
                    case 4:
                        //try for array is empty
                        isEmpty(count);
                        int temp = 0;
                        for (int i = 0; i < count; i++) {
                            for (int j = i + 1; j < numbers.length; j++) {
                                if (numbers[i] > numbers[j]) {
                                    temp = numbers[i];
                                    numbers[i] = numbers[j];
                                    numbers[j] = temp;
                                }
                            }
                        }

                        System.out.print("The elements of the array are ");
                        for (int i = 0; i < count; i++)
                            System.out.print(numbers[i] + " ");
                        break;

                    case 5:
                        System.out.println("Good bye!!");
                        break;
                }

            } while (answer != 5);

        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }catch (IndexOutOfBoundsException e1){
            System.out.println(e1.getMessage());
        } catch (Exception e2){
            System.out.println(e2.getMessage());
        }

    }


    public static void checkSize(int num) throws Exception{
        if(num<1)
            throw new Exception("\nThe size of the Array is not valid");
    }
    public static void checkAnswer(int num) throws Exception{
        if(num<1 | num>5)
            throw new Exception("\nThe option number should be between 1 and 5");
    }
    public static void isFull(int count, int[] num) throws Exception{
        if (count == num.length)
            throw new Exception("\nCan't add an element, the array is full ");
    }
    public static void isEmpty(int count) throws Exception{
        if (count == 0)
            throw new Exception("\nThe array is empty ");
    }

}
