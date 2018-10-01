package xiaoxiaole;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Xiaoxiaole {
      static Scanner sc1 = new Scanner(System.in);
      static int bestScore = 0;
      public static void main(String[] args) {
            // TODO Auto-generated method stub
            System.out.println("Swap two symbols to connect three symbols of the same kind in the same row or column.");
           System.out.println("You can only swap two symbols next to each other.");
            System.out.println("Game ends when your move does not connect three symbols of the same kind.");         
            System.out.println("This game is case insensitive.\n"); 
            do {
            Board currentBoard = new Board();
            int countWrong = 0;
            output(currentBoard);
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            while (countWrong < 1) {
                 System.out.println("Please enter letter coordinate of the first point: ");
                 String tempj1 = sc.next().toUpperCase();
                 char tempJJ1 = tempj1.charAt(0);
                 int tempJ1 = tempJJ1 - 'A';
                 System.out.println("Please enter number coordinate of the first point: ");
                 int tempI1 = sc.nextInt();
                 System.out.println("Please enter letter coordinate of the second point: ");
                 String tempj2 = sc.next().toUpperCase();
                 char tempJJ2 = tempj2.charAt(0);
                 int tempJ2 = tempJJ2 - 'A';
                 System.out.println("Please enter number coordinate of the second point: ");
                 int tempI2 = sc.nextInt();
                 currentBoard.swap1(tempI1, tempJ1, tempI2, tempJ2);
                 output(currentBoard);
                 if (!currentBoard.screenIsClearable()) {
                       System.out.println("Unsuccessful Move");
                       countWrong++;
                       output(currentBoard);
                 } else {
                       currentBoard.screenClear();
                       output(currentBoard);
                       currentBoard.fall();
                       output(currentBoard);
                       while (currentBoard.screenIsClearable()) {
                             currentBoard.screenClear();
                             output(currentBoard);
                             currentBoard.fall();
                             output(currentBoard);
                       }
                 } 
            }
            System.out.println("\nGame ends!\nYour total score is: " + currentBoard.score);
            if (currentBoard.score > bestScore) {
                 bestScore = currentBoard.score;
                 System.out.println("You just made a new personal best!\nYour best score is: " + bestScore + "\nEnter 1 to play again.");
            }
            } while (sc1.nextInt() == 1);
      }
      public static void output(Board currentBoard) {
            System.out.println("  A B C D E F G H");
            for (int i = 0; i < 8; i++) {
                 System.out.print((i) + " ");
                 for (int j = 0; j < 8; j++) {
                       System.out.print(currentBoard.currentBoard[i][j].element + " ");
                 }
                 System.out.println();
                 
            }
            
            System.out.println("Current Score is: " + currentBoard.score + "\n");
            try {
                 TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
            }
      }
}
