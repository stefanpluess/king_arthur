import java.util.ArrayList;

public class Board {
    public ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    public ArrayList<Integer> pointzero = new ArrayList<>();
    public ArrayList<Integer> pointone = new ArrayList<>();
    public ArrayList<Integer> pointtwo = new ArrayList<>();

    public Board(){


        pointzero.add(1);
        pointzero.add(2);
        pointone.add(0);
        pointtwo.add(0);
        map.add(pointzero);
        map.add(pointone);
        map.add(pointtwo);
    }
}
