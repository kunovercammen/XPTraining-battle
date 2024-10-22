package be.cegeka.battle;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SoldierTest {

    @Test
    void construction_aSoldierMustHaveAName() {
        Soldier soldier = new Soldier("name");

        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test
    void construction_aSoldierMustHaveAName_cannotBeNull() {
        assertThatThrownBy(() -> new Soldier(null))
                .hasMessage("A soldier must have a name")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void construction_aSoldierMustHaveAName_cannotBeEmpty() {
        assertThatThrownBy(() -> new Soldier(""))
                .hasMessage("A soldier must have a name")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void construction_aSoldierMustHaveAName_cannotBeBlank() {
        assertThatThrownBy(() -> new Soldier("     "))
                .hasMessage("A soldier must have a name")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void construction_aSoldierHasWeapon_BareFistAsDefault() {
        Soldier soldier = new Soldier("name");
        assertThat(soldier.getWeapon().getClass()).isEqualTo(BareFist.class);
    }

    @Test
    void construction_aSoldierHasWeapon_Sword() {
        Soldier soldier = new Soldier("name");
        soldier.setWeapon(new Sword());
        assertThat(soldier.getWeapon().getClass()).isEqualTo(Sword.class);
    }

    @Test
    void construction_aSoldierHasWeapon_Axe() {
        Soldier soldier = new Soldier("name");
        soldier.setWeapon(new Axe());
        assertThat(soldier.getWeapon().getClass()).isEqualTo(Axe.class);
    }

    @Test
    void construction_aSoldierHasWeapon_Spear() {
        Soldier soldier = new Soldier("name");
        soldier.setWeapon(new Spear());
        assertThat(soldier.getWeapon().getClass()).isEqualTo(Spear.class);
    }

    @Test
    void fighting_aSoldierWithBareFistAgainstAnotherSoldierWithBareFist_attackerWins() {
        Soldier soldier1 = new Soldier("name");
        Soldier soldier2 = new Soldier("name");

        Fight fight = new Fight(soldier1, soldier2);
        fight.fight();

        assertThat(fight.getWinner()).isEqualTo(soldier1);
    }

    @Test
    void fighting_aSoldierWithBareFistAgainstAnotherSoldierWithSword_defenderWins() {
        Soldier soldier1 = new Soldier("name");
        Soldier soldier2 = new Soldier("name");
        soldier2.setWeapon(new Sword());

        Fight fight = new Fight(soldier1, soldier2);
        fight.fight();

        assertThat(fight.getWinner()).isEqualTo(soldier2);
    }

    @Test
    void fighting_aSoldierWithAxeAgainstAnotherSoldierWithSword_attackerWins() {
        Soldier soldier1 = new Soldier("name");
        soldier1.setWeapon(new Axe());
        Soldier soldier2 = new Soldier("name");
        soldier2.setWeapon(new Sword());

        Fight fight = new Fight(soldier1, soldier2);
        fight.fight();

        assertThat(fight.getWinner()).isEqualTo(soldier1);
    }

}