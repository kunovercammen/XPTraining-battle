package be.cegeka.battle;


import com.google.common.base.Strings;
import org.checkerframework.checker.units.qual.A;

public class Soldier {

    private final String name;

    private WeaponType weapon;

    private boolean isAlive = true;

    private Army army;

    public Soldier(String name) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("A soldier must have a name");
        }
        if (Strings.isNullOrEmpty(name.trim())) {
            throw new IllegalArgumentException("A soldier must have a name");
        }

        this.name = name;
        setWeapon(new BareFist());
    }

    String getName() {
        return this.name;
    }

    WeaponType getWeapon() {
        return this.weapon;
    }

    void setWeapon(WeaponType weapon) {
        this.weapon = weapon;
    }

    void die() {
        isAlive = false;
        if (army != null) {
            army.removeFrontMan();
        }
    }

    boolean isAlive() {
        return isAlive;
    }

    void setArmy(Army army) {
        this.army = army;
    }

}