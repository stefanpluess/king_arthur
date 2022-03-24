package States;

import Player.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
This state contains Malgrin the knight, you can fight him, give swords to increase the chances of winning

NOT IMPLEMENTED YET
-explore
-doNothing
 */

public class MalgrinState implements State{

    public Status[] stats = {Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN};
    public ArrayList<Status> statusList = new ArrayList<>();

    /*@Override
    public void trade(Player p, Player p2){
        System.out.println("How many of each good would you like to trade?");
        System.out.println("You currently have " + p.getShield + "Shields, " + p.getSwords() + "Swords and " + p.getSupplies());
        Scanner inp = new Scanner(System.in);

    }


     */

    public void giveSwords(Player p){
        if(p.getSwords() >= 2) {
            stats[Integer.parseInt(p.name) - 1] = Status.SWORDSGIVEN;
            p.changeSwords(-2);
            System.out.println("You gave two Swords, your chances to win have increased now!\n You currently have " + p.getSwords() + " Swords.");
        } else{
            System.out.println("You do not have enough Swords to perform this action!");
        }
        p.startAdventure();
    }

    @Override
    public void fillStatusList(ArrayList<Player> playerList){
        for(Player p:playerList){
            statusList.add(Status.UNKNOWN);
        }
    }
    @Override
    public void begin(Player p){
        System.out.println("Ich bin Malgrin der Ritter, Wächter der Brücke. Ihr könnt hier nicht passieren");
    }
    @Override
    public void explore(Player p){
        System.out.println("What are you trying to explore?");
    }

    @Override
    public void doNothing(Player p){
        System.out.println("I have arrived but I won't do shit");
    }

    @Override
    public Status getStats(Player p){
        return this.stats[Integer.parseInt(p.name)];
    }
    public void fight(Player p){
        switch(getStats(p)){
            case DEFEATED -> {
                System.out.println("Ihr scheint ein nobler Ritter zu sein, ihr könnt passieren.");
                return;
            }
            case SWORDSGIVEN -> {System.out.println("Schriiinnggg schrinnnngg");}
            case UNKNOWN -> {
                System.out.println("Schriiiingggg Schriiinnggg");
            }
            case UNDEFEATED -> {
                System.out.println("Ihr wollt wirklich noch einmal? nun gut");
            }

        }
        Random rand = new Random();
        if(rand.nextInt(4) == 0){
            System.out.println("AAAARRGHHH du hast mich besiegt. Du kannst passieren");
            stats[Integer.parseInt(p.name) - 1] = Status.DEFEATED;
            p.increaseRuhm(3);
        }else{
            System.out.println("Hahaha das soll dir eine Lehre sein");
            p.goback();
            stats[Integer.parseInt(p.name)] = Status.UNDEFEATED;
        }
    }

}
