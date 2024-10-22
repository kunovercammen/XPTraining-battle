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
        } else if (attacker.getWeapon().getDamage() == defender.getWeapon().getDamage()) {
            winner = attacker;
        } else {
            winner = defender;
        }
    }

    public Soldier getWinner() {
        return winner;
    }

}
