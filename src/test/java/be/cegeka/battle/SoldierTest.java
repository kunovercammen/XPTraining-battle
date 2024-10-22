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

    @Test
    void army_addSoldier() {
        Army army = new Army();
        Soldier soldier = new Soldier("name");
        army.addSoldier(soldier);
        assertThat(army.getFrontMan()).isEqualTo(soldier);
    }

    @Test
    void army_addSoldier_multipleSoldiers() {
        Army army = new Army();
        Soldier soldier1 = new Soldier("name1");
        Soldier soldier2 = new Soldier("name2");
        army.addSoldier(soldier1);
        army.addSoldier(soldier2);
        assertThat(army.getFrontMan()).isEqualTo(soldier1);
    }

    @Test
    void army_addSoldier_emptyArmy() {
        Army army = new Army();
        assertThatThrownBy(army::getFrontMan)
                .hasMessage("Army is empty")
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void soldier_die() {
        Soldier soldier = new Soldier("name");
        soldier.die();
        assertThat(soldier.isAlive()).isFalse();
    }

    @Test
    void soldier_isAlive() {
        Soldier soldier = new Soldier("name");
        assertThat(soldier.isAlive()).isTrue();
    }

    @Test
    void army_removeFrontMan() {
        Army army = new Army();
        Soldier soldier1 = new Soldier("name1");
        Soldier soldier2 = new Soldier("name2");
        army.addSoldier(soldier1);
        army.addSoldier(soldier2);
        army.removeFrontMan();
        assertThat(army.getFrontMan()).isEqualTo(soldier2);
    }

    @Test
    void war_fight() {
        Army attackingArmy = new Army();
        Soldier soldier1 = new Soldier("name1");
        Soldier soldier2 = new Soldier("name2");
        attackingArmy.addSoldier(soldier1);
        attackingArmy.addSoldier(soldier2);
        Army defendingArmy = new Army();
        Soldier soldier3 = new Soldier("name3");
        Soldier soldier4 = new Soldier("name4");
        defendingArmy.addSoldier(soldier3);
        defendingArmy.addSoldier(soldier4);
        War war = new War(attackingArmy, defendingArmy);
        war.fight();
        assertThat(war.getWinner()).isEqualTo(attackingArmy);
    }

    @Test
    void war_fightWithDifferentWeapons() {
        Army attackingArmy = new Army();
        Soldier soldier1 = new Soldier("name1");
        Soldier soldier2 = new Soldier("name2");
        attackingArmy.addSoldier(soldier1);
        attackingArmy.addSoldier(soldier2);
        Army defendingArmy = new Army();
        Soldier soldier3 = new Soldier("name3");
        Soldier soldier4 = new Soldier("name4");
        soldier4.setWeapon(new Axe());
        defendingArmy.addSoldier(soldier3);
        defendingArmy.addSoldier(soldier4);
        War war = new War(attackingArmy, defendingArmy);
        war.fight();
        assertThat(war.getWinner()).isEqualTo(defendingArmy);
    }

}