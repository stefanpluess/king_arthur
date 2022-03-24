package States;

import Player.Player;

import java.util.ArrayList;

public class BeginningState implements State{

    public ArrayList<Status> statusList = new ArrayList<>();

    @Override
    public void fillStatusList(ArrayList<Player> playerList){
        for(Player p:playerList){
            statusList.add(Status.UNKNOWN);
        }
    }
    @Override
    public void giveSwords(Player p){
        System.out.println("this won't help you here");
        p.startAdventure();
    }
    @Override
    public void begin(Player p){
        System.out.println("You have arrived at the stone circle");
    }
    @Override
    public Status getStats(Player p){
        return null;
    }
    @Override
    public void doNothing(Player p) {
        System.out.println("Congratulations, you did nothing");
    }

    @Override
    public void explore(Player p) {
        if(p.checkIfWon()){
            //end game
            System.out.println("Congratulations Player, you have won the game and become king of england");
            System.exit(0);
        }else{
            System.out.println("You haven't met all the requirements yet, go and fight for more glory");
        }
    }
    @Override
    public void fight(Player p){}
}
