package com.company.Units.Tanks;

import com.company.AllAboutMove.Movement;
import com.company.PositionPair;
import com.company.Tactics.Tactic;
import com.company.Units.Unit;

public abstract class Tanks extends Unit {

    public Tanks(int health, int damage, int range, int speed, int radius, int price, double shield, double attackSpeed, PositionPair myPosition, int id, Movement movement, boolean state, Tactic myTactic) {
        super(health, damage, range, speed, radius, price, shield, attackSpeed, myPosition, id, movement, state, myTactic);
    }
}
