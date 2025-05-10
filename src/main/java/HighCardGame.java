//High Card Game


import java.util.Scanner;
/**
 * @author: Elliot Chan
 * @version: 1.0.0
 * This is a simple high card game that is very simple in concept. Player 1 and Player 2 battle it out
 * Whoever picks the highest card in their hand wins!
 * Five rounds played.
 */
public class HighCardGame {
    
    public static void main(String args[]) {

        Deck mutualDeck = new Deck();
        mutualDeck.shuffle();

        Scanner s = new Scanner(System.in);
        String name1 = getStringInput(s, "Player 1, what is your name? ");
        int age1 = getIntInput(s, "Player 1, what is your age? ");
        
        System.out.println("Welcome to the card game " + name1 + "!");
        Player p1 = new Player(name1, age1);

        System.out.println();
        String name2 = getStringInput(s, "Player 2, what is your name? ");
        int age2 = getIntInput(s, "Player 2, what is your age? ");
        System.out.println("Welcome to the card game " + name2 + "!");
         Player p2 = new Player(name2, age2);

       
        System.out.println("\nStarting game!");



        int roundNum = 1, p1Points = 0, p2Points = 0;
        

        boolean exitLoop = false;
        while(!exitLoop && roundNum <= 5) {

        for(int i = 0; i < 5; i++) {
            p1.draw(mutualDeck);
            p2.draw(mutualDeck); 
        }


            System.out.println("\nROUND " + roundNum);
            System.out.println("Current points:");
            System.out.println(name1 + ": " + p1Points);
            System.out.println(name2 + ": " + p2Points + "\n");
          
    
                int select1 = -1, value1 = 0;
                do {
                    try {
                System.out.println(name1 + ", these are your five cards: ");
                System.out.println(p1.toString());
                    select1 = getIntInput(s, "Which one do you want to play? (1/2/3/4/5) ") - 1;
                    
                    value1 = p1.getHand()[select1].getValue();
                    }catch(Exception e) {
                        System.out.println("That is not a valid input! Try again!");
                    }
                }while(value1 == 0);
                 

                int select2 = -1, value2 = 0;
              
                   do{
                    try {
                 System.out.println("\n" + name2 + ", these are your five cards: ");
                System.out.println(p2.toString());
                
                    select2 = getIntInput(s, "Which one do you want to play? (1/2/3/4/5) ") - 1;
                    value2 = p2.getHand()[select2].getValue();
                    
                    }catch(Exception e) {
                        System.out.println("That is not a valid input! Try again!");
                    }
                }while(value2 == 0);
            
                if(value1 > value2) {
                    System.out.println("\n" + name1 + " has won this round as " + p1.getHand()[select1].toString() + "["
                    + value1 + "] is worth more than " + name2 + "'s card, " + p2.getHand()[select2].toString() + " [" + value2 + "].");
                    p1Points++; 
                 } else if(value1 < value2) {
                 System.out.println("\n" + name1 + " has lost this round as " + p1.getHand()[select1].toString() + "["
                    + value1 + "] is worth less than " + name2 + "'s card, " + p2.getHand()[select2].toString() + " [" + value2 + "].");
                    p2Points++;
                   }  else {
                    System.out.println("\nNobody wins! Both " + name1 + "'s card, " + p1.getHand()[select1].toString() + "["
                    + value1 + "] and " + name2 + "'s card, " + p2.getHand()[select2].toString() + "[" + value2 + "]." + " are equal!"); 
                   }
                roundNum++;

           while(p1.getHand().length != 0 && p2.getHand().length != 0) {
                  p1.returnCard(p1.getHand()[p1.getHand().length - 1], mutualDeck);
                  p2.returnCard(p2.getHand()[p2.getHand().length - 1], mutualDeck);
           
        }
              
          

           
        }
             System.out.println("\nFINAL SCORE: ");
            System.out.println(name1 + ": " + p1Points);
            System.out.println(name2 + ": " + p2Points);
        s.close();
    }
    private static String getStringInput(Scanner s, String prompt) {
        System.out.print(prompt);
        return s.next();
    }

    private static int getIntInput(Scanner s, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return s.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter an integer.");
                s.nextLine(); 
            }
        }
    }
}
