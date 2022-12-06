package GUI;

public enum Actions {
    EXPLORE(0), DONOTHING(1), FIGHT(2), GIVESWORDS(3), TRADE(4);

    public final int id;
    Actions(int id) {
        this.id = id;
    }

}
