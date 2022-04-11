import Locations.Bridge;
import Locations.*;
import Merlin.Merlin;
import Player.Player;
import States.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public void checkIfWon(){}
    public static void main(String[] args){
        //Create Class Instances
        ArrayList<Player> playerList = new ArrayList<>();

        //initialize State pattern

        State BeginningState = new BeginningState();
        State MalgrinState = new MalgrinState();
        State LadyOfTheSeaState = new LadyOfTheSeaState();
        State UngeheuerState = new UngeheuerState();
        State InnkeeperState = new InnkeeperState();

        //Create Location instances

        Bridge bridge = new Bridge(MalgrinState);
        StartingLocation startingLocation = new StartingLocation();
        Tournament_Ground tournament_ground = new Tournament_Ground();

        //Create and fill playerList

        System.out.println("How many Players will play?");
        Scanner in = new Scanner(System.in);
        int playerAmount = Integer.parseInt(in.nextLine());
        for(int i = 0; i < playerAmount; i++){
            String s = Integer.toString(i+1);
            playerList.add(new Player(s));
            playerList.get(i).setCurrentPosition(startingLocation);
        }

        //fill status List of States
        UngeheuerState.fillStatusList(playerList);
        InnkeeperState.fillStatusList(playerList);

        //Create and fill locationList

        ArrayList<Location> locationList = new ArrayList<>();
        locationList.add(bridge);
        locationList.add(startingLocation);
        locationList.add(tournament_ground);

        //create Merlin.Merlin instance

        Merlin merlin = new Merlin(locationList);

        //give merlin instance to the locations

        for (Location loc:locationList){
            loc.setMerlinInstance(merlin);
        }

        //fill adjacency list

        bridge.addadjacents(startingLocation);
        bridge.addadjacents(tournament_ground);

        startingLocation.addadjacents(bridge);
        startingLocation.addadjacents(tournament_ground);

        tournament_ground.addadjacents(bridge);
        tournament_ground.addadjacents(startingLocation);

        //Assign new Locations to Players

        //p.setCurrentPosition(startingLocation);

        //fill possibleAdventures variable of instances

        bridge.possibleAdventures.add(MalgrinState);
        startingLocation.possibleAdventures.add(BeginningState);
        //commented for testing purposes
        //tournament_ground.possibleAdventures.add(LadyOfTheSeaState);
        //tournament_ground.possibleAdventures.add(UngeheuerState);
        tournament_ground.possibleAdventures.add(InnkeeperState);

        //main loop of the game
        while(true){
            for(Player currentPlayer:playerList){
                currentPlayer.currentPosition.move(currentPlayer);
            }
            System.out.println("continue?");
            Scanner inp = new Scanner(System.in);
            if(inp.nextLine().equals("exit")){
                System.exit(0);
            }
        }
    }
}
