package be.cegeka.battle;

public class Fight {

    private final Soldier attacker;

    private final Soldier defender;

    private Soldier winner;

    public Fight(Soldier attacker, Soldier defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public void fight() {
        if (attacker.getWeapon().getDamage() > defender.getWeapon().getDamage()) {
            winner = attacker;
            defender.die();
        } else if (attacker.getWeapon().getDamage() == defender.getWeapon().getDamage()) {
            winner = attacker;
            defender.die();
        } else {
            winner = defender;
            attacker.die();
        }
    }

    public Soldier getWinner() {
        return winner;
    }

}
