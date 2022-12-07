package Setup;

import GUI.InputHandler;
import Locations.Bridge;
import Locations.Location;
import Locations.StartingLocation;
import Locations.Tournament_Ground;
import Merlin.Merlin;
import Player.Player;
import States.*;

import java.util.ArrayList;

public class Setup {

    //Variables
    ArrayList<Player> playerList;
    ArrayList<Location> locationList;
    InputHandler inp;

    //States
    State BeginningState;
    State MalgrinState;
    State LadyOfTheSeaState;
    State UngeheuerState;
    State InnkeeperState;

    //Locations
    Location StartingLocation;
    Location Bridge;
    Location Tournament_Ground;



    public void setupInputHandler(){
        inp = new InputHandler();
    }

    public void setupStates(){
        State BeginningState = new BeginningState();
        State MalgrinState = new MalgrinState();
        State LadyOfTheSeaState = new LadyOfTheSeaState();
        State UngeheuerState = new UngeheuerState();
        State InnkeeperState = new InnkeeperState();
    }

    public void setupLocations(){
        Bridge bridge = new Bridge(this.MalgrinState);
        StartingLocation startingLocation = new StartingLocation();
        Tournament_Ground tournament_ground = new Tournament_Ground();
    }

    public void setupPlayerList(ArrayList<Player> playerList){
        int playerAmount = inp.getAmountOfPlayers();
        for(int i = 0; i < playerAmount; i++){
            String s = Integer.toString(i+1);
            playerList.add(new Player(s));
            playerList.get(i).setCurrentLocation(StartingLocation);
        }
    }

    public void fillStatusList(){
        UngeheuerState.fillStatusList(playerList);
        InnkeeperState.fillStatusList(playerList);
    }

    public void setupLocationList(){
        ArrayList<Location> locationList = new ArrayList<>();
        locationList.add(Bridge);
        locationList.add(StartingLocation);
        locationList.add(Tournament_Ground);
    }
    public void setupMerlin(){
        Merlin merlin = new Merlin(locationList);
        for (Location loc:locationList){
            loc.setMerlinInstance(merlin);
        }
    }

    public void fillAdjacencies(){
        Bridge.addadjacents(StartingLocation);
        Bridge.addadjacents(Tournament_Ground);

        StartingLocation.addadjacents(Bridge);
        StartingLocation.addadjacents(Tournament_Ground);

        Tournament_Ground.addadjacents(Bridge);
        Tournament_Ground.addadjacents(StartingLocation);
    }

    public void addAdventures(){
        Bridge.possibleAdventures.add(MalgrinState);
        StartingLocation.possibleAdventures.add(BeginningState);
        Tournament_Ground.possibleAdventures.add(InnkeeperState);
    }
}
