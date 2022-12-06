package GUI;

import java.util.Scanner;

//This class is supposed to handle input from the user. This will be replaced as the final version of the game
//will be running with a GUI and not text based.
public class InputHandler {
    static Scanner input;
    public InputHandler(){
        this.input = new Scanner(System.in);
    }

    public static Actions getPlayerActionInput(){
        System.out.println("Would you like to explore or do Nothing? Press 0 for explore, 1 for doNothing 2 for Fighting or 3 if you want to giveSwords or 4 if you would like to trade");
        return Actions.values()[Integer.parseInt(input.nextLine())];
    }

    public static Reactions getPlayerReactionInput(){
        System.out.println("Enter your Reaction please. Press 0 for Friendship, 1 for Fight, 2 for Retreat, 3 for ignore and 4 for give");
        return Reactions.values()[Integer.parseInt(input.nextLine())];
    }

    public int getAmountOfPlayers(){
        System.out.println("How many Players will be playing? \n Pleasse enter a number between 1 and 4");
        return Integer.parseInt(input.nextLine());
    }

    public void continuePlaying(){
        System.out.println("Would you like to keep playing? press 0 for exit, or any button to continue");
        String userInput = input.nextLine();
        if(userInput == "0"){
            System.exit(0);
        }
    }
}
