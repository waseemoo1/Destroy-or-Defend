package com.company.Units.Structures;
import com.company.PositionPair;
import com.company.Tactics.Deffend.InRangeTactic;

import com.company.Units.Unit;

public class GrandCannon extends Structure {

    public GrandCannon(PositionPair myPosition, int id, boolean state) {
        super(6500, 150, 400, 0, 40, 200, 0.3,0.9, myPosition, id, null, state,  new InRangeTactic());
    }

    @Override
    public String draw() {

        if(this.isState())
        {
            return "/resorce/Units/Grand Canon.png";
        }else {
            return "/resorce/Units/Grand Canon.png";
        }
    }
}
