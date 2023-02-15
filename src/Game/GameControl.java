package Game;

import GUI.InputHandler;
import Locations.Location;
import Player.Player;
import States.State;
import Setup.Setup;
import java.util.ArrayList;
import java.util.Scanner;
import Merlin.Merlin;
import Locations.*;
import States.*;

//This class acts as the instance that regulates the game
//the flow of the game and the instances are all stored here and called when necessary
public class GameControl {
    //Variables
    static ArrayList<Player> playerList = new ArrayList<>();
    ArrayList<Location> locationList = new ArrayList<>();
    static InputHandler inp = new InputHandler();

    //States
    State BeginningState = new BeginningState();
    State MalgrinState = new MalgrinState();
    State LadyOfTheSeaState = new LadyOfTheSeaState();
    State UngeheuerState = new UngeheuerState();
    State InnkeeperState = new InnkeeperState();

    //Locations
    static Location StartingLocation = new StartingLocation();
    Location Bridge = new Bridge(BeginningState);
    Location Tournament_Ground = new Tournament_Ground();


    //Merlin TODO Add the locationList and give it to the Merlin class as a parameter.
    Merlin merlin = new Merlin();
    static Setup setup = new Setup(playerList, StartingLocation);

    //This method moves the player.
    //TODO there is no validity check for the input as of now.
    //TODO Check if the .arrive method is still valid and working as intended (maybe a change of structure will be required)
    //TODO implement a merlin check *** does merlin interfere if you walk on a square marked by him but choose to do nothing?
    public static void move(Player p){
        ArrayList<Location> adjacent = p.currentLocation.getAdjacent();
        Location newLocation = inp.getNextLocation(adjacent);

        p.setLastLocation(p.currentLocation);
        p.setCurrentLocation(newLocation);
        newLocation.arrive(p);
    }
    //TODO is the setup class really necessary?
    public static void main(String[] args){
        setup.setupPlayerList(playerList, StartingLocation);
        //main loop of the game
        while(true){
            for(Player currentPlayer:playerList){
                move(currentPlayer);
            }
            inp.continuePlaying();
        }
    }
}
