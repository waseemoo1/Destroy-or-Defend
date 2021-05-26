package com.company.Tactics;

import com.company.Units.Unit;

public abstract class Tactic {

    public abstract Unit FindUnitToAttack(Unit fighter);
    public abstract void Facing(Unit unitToAttack , Unit fighter);


}
