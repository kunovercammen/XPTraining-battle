package be.cegeka.battle;


import com.google.common.base.Strings;

public class Soldier {

    private final String name;

    private WeaponType weapon;

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
}