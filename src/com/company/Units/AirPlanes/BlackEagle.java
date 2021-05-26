package com.company.Units.AirPlanes;

import com.company.AllAboutMove.AirMovement;
import com.company.AllAboutMove.OrdinaryMovement;
import com.company.PositionPair;
import com.company.Tactics.Attack.AttackBaseDirectlyTactic;
import com.company.Tactics.Tactic;
import com.company.Units.Unit;

public class BlackEagle extends AirPlane {

    public BlackEagle(PositionPair myPosition, int id, boolean state) {
        super(1500, 400, 30, 100, 20, 75, 0.0,0.6, myPosition, id, new AirMovement(), state,  new AttackBaseDirectlyTactic());
    }

    @Override
    public String draw() {

        if(this.isState())
        {
            return "/resorce/Units/Eagle.png";
        }else {
            return "/resorce/Units/Eagle.png";
        }
    }

}
