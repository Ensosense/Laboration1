package uppgifter;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Uppgift_Meny {

    static int[] arr = new int[5];
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        startMenu();

    }

    public static void startMenu() {

        System.out.println("""
                     1. Upp och Ner
                     2. Min Max
                     3. Sten Sax Påse
                     4. Ordning och reda
                     e. Avsluta
                """);

        System.out.println("Gör ditt val");
        String choice = sc.nextLine();
        startMenuSelection(choice);
    }

    private static void startMenuSelection(String choice) {
        switch (choice) {
            case "1" -> uppOchNer();
            case "2" -> minMax();
            case "3" -> stenSaxPåse();
            case "4" -> ordningOchReda();
            case "e" -> System.out.println("Spelet avslutas");
            default -> {
                System.out.println("Felaktigt val, försök igen!");
                startMenu();
            }
        }
    }

    public static void uppOchNer() {

        String [] stringInput = new String[4];
        System.out.println("Ange tre strängar och END");
        for (int i = 0; i < stringInput.length; i++) {
            stringInput[i] = sc.nextLine();
        }


        if (stringInput[3].equalsIgnoreCase("END")) {
            System.out.println(stringInput[2]);
            System.out.println(stringInput[1]);
            System.out.println(stringInput[0]);

        }
    }

    public static void minMax() {

        int[] array = new int[5];

        System.out.println("Ange 5 tal");

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }


        int max = array[0]; //index
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Det största talet är: " + max);
        System.out.println("Det minsta talet är: " + min);
    }


    public static void stenSaxPåse() {

        String[] randomChoice = {"rock", "scissors", "paper"};


        Random random = new Random();
        String playersMove;

        int playerCount = 0;
        int computerCount = 0;

        Scanner sc = new Scanner(System.in);

        while (true) {
            String computersMove = randomChoice[random.nextInt(randomChoice.length)]; //kör random val för datorn
            System.out.println("Enter: rock, scissors or paper");
            playersMove = sc.nextLine();

            System.out.println("Computers move is: " + computersMove);

            if (!playersMove.equals("rock") && !playersMove.equals("scissors") && !playersMove.equals("paper")) {
                System.out.println("Not valid input, try again.");
            } else {

                if (playersMove.equals(computersMove)) {
                    System.out.println("Tie game, try again.");

                } else if (playersMove.equals("rock") && computersMove.equals("scissors")) {
                    playerCount++;
                    System.out.println("You won! The current standings are: " + playerCount + "-" + computerCount);

                } else if (playersMove.equals("rock") && computersMove.equals("paper")) {
                    computerCount++;
                    System.out.println("You loose! The current standings are: " + playerCount + "-" + computerCount);

                } else if (playersMove.equals("scissors") && computersMove.equals("paper")) {
                    playerCount++;
                    System.out.println("You won! The current standings are: " + playerCount + "-" + computerCount);

                } else if (playersMove.equals("scissors") && computersMove.equals("rock")) {
                    computerCount++;
                    System.out.println("You loose! The current standings are: " + playerCount + "-" + computerCount);


                } else if (playersMove.equals("paper") && computersMove.equals("scissors")) {
                    computerCount++;
                    System.out.println("You loose! The current standings are: " + playerCount + "-" + computerCount);


                } else if (playersMove.equals("paper") && computersMove.equals("rock")) {
                    playerCount++; //räknar vinster
                    System.out.println("You won! The current standings are: " + playerCount + "-" + computerCount);

                }
            }

            if (playerCount == 3) {
                System.out.println("You won the game, congratulations!");
                break;
            } else if (computerCount == 3) {
                System.out.println("The computer won!");
                break;
            }
        }
    }


    public static void ordningOchReda() {

        System.out.println();
        System.out.println("Ange 5 tal ");

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        String joinedNumbers = String.join(" ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(n -> new String[n]));
        System.out.println(joinedNumbers); // skriver ut en array med mellanrum utan kommatecken

        int max = 0;
        int secondMax = 0;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];

            }
            if (arr[i] < max && arr[i] > secondMax) {
                secondMax = arr[i];

            }

            if (arr[i] < min) {
                secondMin = min;
                min = arr[i];

            }

            if (arr[i] > min && arr[i] < secondMin) {
                secondMin = arr[i];
            }
        }

        System.out.println("Min value: " + min + "\n2Min value: " + secondMin);
        System.out.println("Max value: " + max + "\n2Max value: " + secondMax);

        isSortedArray(arr, 5); // n: 5 är storleken på arrayen
        System.out.println("I ordning: " + (isSortedArray(arr, arr.length) ? "true" : "false"));

        int sum = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
        System.out.println("Summa: " + sum);

    }

    private static boolean isSortedArray(int[] array, int n) { // denna metod används i OrdningOchReda
        if (n == 1 || n == 0) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}


