import Locations.Bridge;
import Locations.*;
import Merlin.Merlin;
import Player.Player;
import States.*;
import GUI.*;

import java.util.ArrayList;

public class Main {
    //TODO introduce a class that handles the game instead of the main method and introduce a class to setup the game
    public static void main(String[] args){

        //main loop of the game
        while(true){
            for(Player currentPlayer:playerList){
                currentPlayer.currentLocation.move(currentPlayer);
            }
            inp.continuePlaying();
        }
    }
}
