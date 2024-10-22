package be.cegeka.battle;

public class War {
    private final Army attackingArmy;

    private final Army defendingArmy;

    private Army winner;

    public War(Army attackingArmy, Army defendingArmy) {
        this.attackingArmy = attackingArmy;
        this.defendingArmy = defendingArmy;
    }

    public void fight() {
        while (attackingArmy.getFrontMan().isPresent() && defendingArmy.getFrontMan().isPresent()) {
            Fight fight = new Fight(attackingArmy.getFrontMan().get(), defendingArmy.getFrontMan().get());
            fight.fight();
        }
        if (attackingArmy.getFrontMan().isPresent()) {
            winner = attackingArmy;
        } else {
            winner = defendingArmy;
        }
    }

    public Army getWinner() {
        return winner;
    }
}
