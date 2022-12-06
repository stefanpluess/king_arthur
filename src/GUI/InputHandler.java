package GUI;

import java.util.Scanner;

//This class is supposed to handle input from the user. This will be replaced as the final version of the game
//will be running with a GUI and not text based.
public class InputHandler {
    public Actions getPlayerActionInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to explore or do Nothing? Press 0 for explore, 1 for doNothing 2 for Fighting or 3 if you want to giveSwords or 4 if you would like to trade");
        return Actions.values()[Integer.parseInt(input.nextLine())];
    }
}
