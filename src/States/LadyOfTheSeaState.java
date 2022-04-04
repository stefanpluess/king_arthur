package States;

import Player.Player;

import java.util.ArrayList;

public class LadyOfTheSeaState extends State{

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
    public void begin(Player p){
        System.out.println("Ich bin die Herrin vom see, gib mir 3 Güter");
    }
    public void explore(Player p){
        System.out.println("Ich bin die Herrin vom See, willsch du min fettli ha?");
    }
    public void doNothing(Player p){
        System.out.println("aint doin shit here");
    };
    public Status[] stats = {Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN};
    @Override
    public Status getStats(Player p){
        return stats[Integer.parseInt(p.name)];
    }
    @Override
    public void fight(Player p) {}
}
