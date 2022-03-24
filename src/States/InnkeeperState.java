package States;

import Player.Player;

import java.util.ArrayList;
import java.util.Random;

/*
This State contains the innKeeper, he might gift you some things or trade with you.

NOT IMPLEMENTED YET
-doNothing
-explore
 */


public class InnkeeperState implements State{

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
    public void begin(Player p) {
        Random rand = new Random();
        switch (rand.nextInt(5)) {
            case 0:
                System.out.println("Aaah seid gegrüsst edler Ritter. Hier nehmt 2 Vorräte");
                p.changeSupplies(2);
                statusList.set(Integer.parseInt(p.name), Status.MET);
                break;
            case 1:
                System.out.print("Willkommen im Gasthaus edler Ritter. Ihr könnt mit mir handeln");
                trade(p, rand);
                break;

        }

    }




    public void explore (Player p){
            System.out.println("Ich bin die Herrin vom See, willsch du min fettli ha?");
    }
    public void doNothing (Player p){
        System.out.println("aint doin shit here");
    }
    public void trade(Player p, Random rand) {
        String[] chosen = {"", ""};
        for (int i=0; i<3; i++ ) {
            switch (rand.nextInt(3)) {
                case 0:
                    System.out.println("chose supplies");
                    if(chosen[0].equals("supplies")){
                        chosen[i] = "swords";
                    }else {
                        chosen[i] = "supplies";
                    }
                    break;
                case 1:
                    System.out.println("chose swords");
                    if(chosen[0].equals("swords")){
                        chosen[i] = "shields";
                    }else {
                        chosen[i] = "swords";
                    }
                    break;
                case 2:
                    System.out.println("chose shields");
                    if(chosen[0].equals("shields")){
                        chosen[i] = "supplies";
                    }else {
                        chosen[i] = "shields";
                    }
                    break;
            }
        }

        int amount = rand.nextInt(3);
        if(getStats(p) == Status.DEFEATED){
            amount -= 1;
        }

        System.out.printf("Gebt mir %d %s und ihr erhaltet von mir 3 %s", amount, chosen[0], chosen[1]);
    }
    public Status[] stats = {Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN};
    @Override
    public Status getStats(Player p){
        return stats[Integer.parseInt(p.name)];
    }
    @Override
    public void fight(Player p) {
        Random rand = new Random();
        System.out.println("Waaaaahhh, nehmt was ihr wollt aber lasst mich in Ruhe");
        int amount = rand.nextInt(2) + 1;
        switch(rand.nextInt(3)){
            case 0:
                p.changeSwords(amount);
                System.out.printf("Ihr erhaltet %d Schwerter", amount);
                break;
            case 1:
                p.changeShields(amount);
                System.out.printf("Ihr erhaltet %d Schilder", amount);
                break;
            case 2:
                p.changeSupplies(amount);
                System.out.printf("Ihr erhaltet %d Vorräte", amount);
                break;
        }
        stats[Integer.parseInt(p.name) - 1] = Status.DEFEATED;
        System.out.printf("Ihr verliert Ruhm!");
        p.increaseRuhm(-2);
    }
}

