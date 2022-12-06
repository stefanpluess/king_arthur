package GUI;

public enum Reactions {
    FRIENDSHIP(0), FIGHT(1), RETREAT(2), IGNORE(3), GIVE(4);
    public final int id;
    Reactions(int id){
        this.id = id;
    }
}
