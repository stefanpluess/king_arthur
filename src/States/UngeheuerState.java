package States;

import Player.Player;

import java.util.ArrayList;
import java.util.Random;



public class UngeheuerState implements State{

    private int chance = 8;
    public Status[] stats = {Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN};
    public ArrayList<Status> statusList = new ArrayList<>();
    @Override
    public void fillStatusList(ArrayList<Player> playerList){
        for(Player p:playerList){
            statusList.add(Status.UNKNOWN);
        }
    }
    @Override
    public void begin(Player p) {
        System.out.println("rrrrhdkfhdskfjewthagjdsajdqöfsdafhpwqgja");
    }

    @Override
    public Status getStats(Player p) {
        return stats[Integer.parseInt(p.name)-15];
    }

    @Override
    public void fight(Player p) {
        System.out.println("schriiiiiiinggggg fjkdsahgqöjgs");
        Random rand = new Random();

        int chosenNumber = rand.nextInt(chance);
        System.out.println(chosenNumber);
        switch (chosenNumber){
            case 1:
            case 2:
            case 3:
            case 4:
            {
                if(getStats(p) == Status.SWORDSGIVEN) {
                    System.out.println("rjkelöfdsasaaaaaadjsafhr\n budududum du hast das Ungeheuer besiegt, nimm diesen pendragon");
                    p.setPenDragon(1);
                    stats[Integer.parseInt(p.name)] = Status.DEFEATED;
                    return;
                }
            }
            case 0:
            {
                System.out.println("rjkelöfdsasaaaaaadjsafhr\n budududum du hast das Ungeheuer besiegt, nimm diesen pendragon");
                p.setPenDragon(1);
                stats[Integer.parseInt(p.name)] = Status.DEFEATED;
                return;
            }
            default:
            {
                System.out.println("aaaarrghhhhhhhhhhhh try again");
            }
        }
    }

    @Override
    public void doNothing(Player p){
        System.out.println("Doing nothing surely helps, as always");
    }
    @Override
    public void explore(Player p) {
        System.out.println("this might not be the right time to explore, is it?");
    }
    @Override
    public void giveSwords(Player p){
        System.out.println("You gave two swords, your chances to win this fight have increasedd!\n You currently have " + p.getSwords() + " Swords.");
        p.changeSwords(-2);
        /*
        this.statusList[Integer.parseInt(p.name)]
        */
        p.startAdventure();
    }
}
