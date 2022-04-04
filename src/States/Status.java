package States;
import Player.Player;

public enum Status {
    DEFEATED{
        @Override
        public String toString(){return "defeated";}
    },
    UNDEFEATED,
    UNKNOWN,
    SWORDSGIVEN,
    MET
}
