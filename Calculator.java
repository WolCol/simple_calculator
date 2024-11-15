import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public Scanner scanner;

    public Calculator(){
        scanner = new Scanner(System.in);
    }

    public void closeScanner(){
        scanner.close();
    }

    public void calc(){
        System.out.println("Do you want to add, subtract, multiply or divide? Note that this calculator can only use integers as input. ");
        try {
            String calcType = scanner.nextLine();
            if (calcType.equalsIgnoreCase("add")) {
                add();
            } else if (calcType.equalsIgnoreCase("subtract")) {
                subtract();
            } else if (calcType.equalsIgnoreCase("multiply")) {
                multiply();
            } else if (calcType.equalsIgnoreCase("divide")) {
                divide();
            } else {
                System.out.println("That's not a valid input! Enter add, subtract, multiply or divide.");
            }

            askForAnotherCalculation();
        }

        catch (InputMismatchException e){
            System.out.println("Enter a valid input!");
            scanner.nextLine();
            askForAnotherCalculation();
        }
    }

    public void askForAnotherCalculation(){
        System.out.println("Do you want to do another calculation? ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")||answer.equalsIgnoreCase("yeah")) {
            calc();
        }
        else{
            System.out.println("Goodbye!");
        }
    }

    public void add() {
        // Findet heraus, wie viele Zahlen der Nutzer addieren möchte.
        System.out.println("How many items do you want to add? ");
        int numOfItems = scanner.nextInt();
        scanner.nextLine(); // konsumiert Zeilenumbruch

        if (numOfItems > 1) {
            // Erstellt ein Array mit der Länge der Zahlen, die gewünscht waren und weist dann jeder Position eine Zahl nacheinander zu.
            int i = 0;
            int nums[] = new int[numOfItems];
            while (i < numOfItems) {
                System.out.println("Enter number " + (i + 1) + ": ");
                nums[i] = scanner.nextInt();
                scanner.nextLine(); // konsumiert Zeilenumbruch
                i++;
            }

            // Zählt alle Zahlen im Array zusammen.
            int sum = 0;
            for (int j : nums) {
                sum += j;
            }

            //Zeigt dem Nutzer die Gesamtsumme an.
            System.out.println("The solution is: " + sum);
        } else {
            System.out.println("You need to have at least two items to add them together!");
        }

    }

    public void subtract(){
        // Findet heraus, wie viele Zahlen der Nutzer subtrahieren möchte.
        System.out.println("How many items do you want to subtract? ");
        int numOfItems = scanner.nextInt();
        scanner.nextLine(); // konsumiert Zeilenumbruch

        if (numOfItems > 1) {
            // Erstellt ein Array mit der Länge der Zahlen, die gewünscht waren und weist dann jeder Position eine Zahl nacheinander zu.
            int i = 0;
            int nums[] = new int[numOfItems];
            while (i < numOfItems) {
                System.out.println("Enter number " + (i + 1) + ": ");
                nums[i] = scanner.nextInt();
                scanner.nextLine(); // konsumiert Zeilenumbruch
                i++;
            }

            // Zieht alle Zahlen von der ersten ab.
            int firstNum = nums[0];
            int sumOtherNums = 0;
            int index = 0;
            for (int j : nums) {
                if (index++ == 0) {       //im ersten Durchlauf ist index == 0 true und die Summe wird durch continue nicht erhöht → erste Zahl wird übersprungen
                    continue;
                }
                    sumOtherNums += j;
            }
            int solution = firstNum - sumOtherNums;

            //Zeigt dem Nutzer die Differenz an.
            System.out.println("The solution is: " + solution);
        } else {
            System.out.println("You need at least two items to subtract them!");
        }
    }

    public void multiply() {
        // Findet heraus, wie viele Zahlen der Nutzer multiplizieren möchte.
        System.out.println("How many items do you want to multiply? ");
        int numOfItems = scanner.nextInt();
        scanner.nextLine();
        if (numOfItems > 1) {
            // Erstellt ein Array mit der Länge der Zahlen, die gewünscht waren und weist dann jeder Position eine Zahl nacheinander zu.
            int i = 0;
            int nums[] = new int[numOfItems];
            while (i < numOfItems) {
                System.out.println("Enter number " + (i + 1) + ": ");
                nums[i] = scanner.nextInt();
                scanner.nextLine(); // konsumiert Zeilenumbruch
                i++;
            }

            // Multipliziert alle Zahlen miteinander
            int product = 1;
            for (int j : nums) {
                product *= j;
            }

            // Zeigt dem Nutzer das Produkt an.
            System.out.println("The solution is: " + product);
        } else {
            System.out.println("You need at least two items to multiply them!");
        }
    }

    public void divide(){
        // Findet heraus, wie viele Zahlen der Nutzer dividieren möchte.
        System.out.println("How many items do you want to divide? ");
        int numOfItems = scanner.nextInt();
        scanner.nextLine(); // konsumiert Zeilenumbruch

        if (numOfItems > 1) {
            // Erstellt ein Array mit der Länge der Zahlen, die gewünscht waren und weist dann jeder Position eine Zahl nacheinander zu.
            int i = 0;
            int nums[] = new int[numOfItems];
            while (i < numOfItems) {
                System.out.println("Enter number " + (i + 1) + ": ");
                nums[i] = scanner.nextInt();
                scanner.nextLine(); // konsumiert Zeilenumbruch
                if (nums[i] == 0 && i != 0) {
                    System.out.println("You cannot divide by zero! Try again.");
                } else {
                    i++;
                }
            }

            // Dividiert alle Zahlen miteinander
            double quotient = nums[0];
            int index = 0;
            for (int j : nums) {
                if (index++ == 0) {       //im ersten Durchlauf ist index == 0 true und die Summe wird durch continue nicht erhöht → erste Zahl wird übersprungen
                    continue;
                }
                quotient /= j;
            }

            // Zeigt dem Nutzer den Quotienten an.
            System.out.println("The solution is: " + quotient);
        } else {
            System.out.println("You need at least two items to divide them!");
        }
    }
}
