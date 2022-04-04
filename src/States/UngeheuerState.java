package States;

import Player.Player;
import Player.Goods;
import java.util.ArrayList;
import java.util.Random;

import static Player.Goods.SWORDS;


public class UngeheuerState extends State{

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


        if(getStats(p) == Status.SWORDSGIVEN){
            chance = 4;
        }
        int chosenNumber = rand.nextInt(chance);
        System.out.println(chosenNumber);
        if(chosenNumber == 0) {
            System.out.println("rjkelöfdsasaaaaaadjsafhr\n budududum du hast das Ungeheuer besiegt, nimm diesen pendragon");
            p.setPenDragon(1);
            stats[Integer.parseInt(p.name)] = Status.DEFEATED;
        }else {
            System.out.println("aaaarrghhhhhhhhhhhh try again");
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
        p.changeGoods(SWORDS,-2);
        /*
        this.statusList[Integer.parseInt(p.name)]
        */
        p.startAdventure();
    }
}
