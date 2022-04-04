package States;

import Player.Player;

import java.util.ArrayList;

public abstract class State {
    public void begin(Player p){};
    public void explore(Player p){};
    public void doNothing(Player p){};
    public void fight(Player p){};
    public void trade(Player p){};
    public void giveSwords(Player p){};
    public Status[] stats = {Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN, Status.UNKNOWN};
    public Status getStats(Player p){return null;};
    public void fillStatusList(ArrayList<Player> p){};
}

/*notes on game
Wirt: manchmal schenkt er, gib gut x ab, erhalte pro gut x 2 vorräte
Räuber: gib 1 bel. Gut, kann schlägeln und bei niederlage erhöht sich preis, bei sieg ruhm up
Dorfbewohner: schenkt güter
Burgfräulein: zu hilfe, gib mir schild wenn ja, ich danke dir, ruhm up
Riese: komm fight me, wenn abhauen, meist erfolg,
Markt: bettler: gib mir gut
  Wenn fight: aahhh, ruhm down
            Händler: gib mir 3 güter für 2 güter
           Morgan: ich gib später mehr, aber jetz kannst du 2 güter für 1 gut x
Schmied: gib gut x für 2 schilde
Ritter: wott schlegle, gibt dir 2 güter wenn gewonnen : bei niederlage manchmal nix, manchmal zurückfahren
Je nachdem sagt er welcher ritter er ist
Guinevere: gibt pendragon
Steward: kauf ross für 2 güter (schild)
               Fight:verlier tuhm, bekomm ross
Malgrin:
         Beinignorieren, geh feld zurück
*/