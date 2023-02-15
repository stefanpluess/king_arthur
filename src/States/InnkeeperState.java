package States;

import Player.Player;
import Player.Goods;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
This State contains the innKeeper, he might gift you some things or trade with you.

NOT IMPLEMENTED YET
-doNothing
-explore
NOT WORKING PROPERLY

 */


public class InnkeeperState extends State{
    //Variables
    private final Goods[] GoodList = {Goods.SWORDS, Goods.SHIELDS, Goods.SUPPLIES};
    public Status[] stats = {Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN};
    public ArrayList<Status> statusList = new ArrayList<>();


    //Methods
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
        switch (rand.nextInt(2)) {
            case 0:
                System.out.println("Aaah seid gegrüsst edler Ritter. Hier nehmt 2 Vorräte");
                p.changeGoods(Goods.SUPPLIES, 2);
                statusList.set(Integer.parseInt(p.name)-1, Status.MET);
                break;
            case 1:
                System.out.print("Willkommen im Gasthaus edler Ritter. Ihr könnt mit mir handeln");
                trade(p, rand);
                break;
        }
    }

    public void explore (Player p){
            System.out.println("Ich bin die Herrin vom See");
    }
    public void doNothing (Player p){
        System.out.println("nothing");
    }
    public void trade(Player p, Random rand) {
        Goods[] chosen = {GoodList[rand.nextInt(2)], Goods.NONE};
        do{
            chosen[1] = GoodList[rand.nextInt(2)];
        }while(chosen[0] == chosen[1]);
        System.out.println(chosen[0]);
        System.out.println(chosen[1]);
        int amount = rand.nextInt(3);
        if(getStats(p) == Status.DEFEATED){
            amount -= 1;
        }
        System.out.printf("Gebt mir 1 %s und ihr erhaltet von mir %d %s",  chosen[0], amount , chosen[1]);
        Scanner in = new Scanner(System.in);
        System.out.println("Nimmst du mein Angebot an? gib y für ja oder n für nein ein");
        String s = in.nextLine();
        while(!s.equals("y") && !s.equals("n")){
            System.out.println("Fehlerhafte eingabe, gib y für ja oder n für nein ein.");
            s = in.nextLine();
        }
        switch(s){
            case "y":
                System.out.printf("Toll! wie viele %s möchtest du mir geben?", chosen[0]);
                System.out.printf("Du hast aktuell %d %s", p.getGoods(chosen[0]), chosen[0].toString());
                int tradedGoods = Integer.parseInt(in.nextLine());
                while (tradedGoods > p.getGoods(chosen[0])){
                    System.out.printf("Hört auf zu scherzen Ritter, ihr habt doch selbst nicht so viele %s. Nun sagt, wie viele möchtet ihr mir geben?", chosen[0].toString());
                    tradedGoods = Integer.parseInt(in.nextLine());
                }
                p.changeGoods(chosen[0], -tradedGoods);
                p.changeGoods(chosen[1], amount*tradedGoods);
                System.out.println("Es war mir ein Vergnügen mit dir Geschäfte zu machen!");
                System.out.printf("Du hast nun %d %s und %d %s", p.getGoods(chosen[0]), chosen[0].toString(), p.getGoods(chosen[1]), chosen[1].toString());
                break;
            case "n":
                System.out.println("Schade! komm wieder vorbei falls du doch noch handeln möchtest.");
        }
    }

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
                p.changeGoods(Goods.SWORDS, amount);
                System.out.printf("Ihr erhaltet %d Schwerter", amount);
                break;
            case 1:
                p.changeGoods(Goods.SHIELDS, amount);
                System.out.printf("Ihr erhaltet %d Schilder", amount);
                break;
            case 2:
                p.changeGoods(Goods.SUPPLIES, amount);
                System.out.printf("Ihr erhaltet %d Vorräte", amount);
                break;
        }
        stats[Integer.parseInt(p.name) - 1] = Status.DEFEATED;
        System.out.printf("Ihr verliert Ruhm!");
        p.changeRuhm(-2);
    }
}

