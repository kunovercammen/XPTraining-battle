package be.cegeka.battle;

public abstract class WeaponType {
    private final String name;
    private final int damage;

    protected WeaponType(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
