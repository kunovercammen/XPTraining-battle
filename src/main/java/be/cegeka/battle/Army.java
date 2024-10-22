package be.cegeka.battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Army {
    private final List<Soldier> soldiers;

    private Soldier frontMan;

    public Army() {
        this.soldiers = new ArrayList<>();
    }

    public void addSoldier(Soldier soldier) {
        if (soldiers.isEmpty()) {
            frontMan = soldier;
        }
        soldiers.add(soldier);
        soldier.setArmy(this);
    }

    public Optional<Soldier> getFrontMan() {
        if (frontMan == null) {
            return Optional.empty();
        }
        return Optional.of(frontMan);
    }

    public void removeFrontMan() {
        soldiers.remove(frontMan);
        if (soldiers.isEmpty()) {
            frontMan = null;
        } else {
            frontMan = soldiers.getFirst();
        }
    }
}
