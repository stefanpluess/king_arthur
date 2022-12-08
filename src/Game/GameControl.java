package Game;

import GUI.InputHandler;
import Locations.Location;
import Player.Player;
import States.State;
import Setup.Setup;
import java.util.ArrayList;
import Locations.*;
import States.*;

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

    static Setup setup = new Setup(playerList, StartingLocation);

    public static void main(String[] args){
        setup.setupPlayerList(playerList, StartingLocation);
        //main loop of the game
        while(true){
            for(Player currentPlayer:playerList){
                currentPlayer.currentLocation.move(currentPlayer);
            }
            inp.continuePlaying();
        }
    }
}
