package com.company.Units.Soldiers;

import com.company.AllAboutMove.OrdinaryMovement;
import com.company.PositionPair;
import com.company.Tactics.Tactic;
import com.company.Units.AirPlanes.BlackEagle;
import com.company.Units.Unit;

public class GrizzlyTank extends Soldiers{

    public GrizzlyTank(PositionPair myPosition, int id, boolean state, Tactic myTactic) {
        super(1000, 250, 250, 30, 20, 50, 0.4,0.6, myPosition, id, new OrdinaryMovement(), state,  myTactic);
    }

    @Override
    public String draw()
    {
        if(this.isState())
        {
            if (this.getMyPosition().getAngle() == 1)
            {
                return "/resorce/Units/GrizzlyTankAttack 1.png";
            }
            else if( this.getMyPosition().getAngle() == 4 )
            {
                return "/resorce/Units/GrizzlyTankAttack 2.png";
            }
            else if ( this.getMyPosition().getAngle() == 5 )
            {
                return "/resorce/Units/GrizzlyTankAttack 3.png";
            }else if (this.getMyPosition().getAngle() == 2)
            {
                return "/resorce/Units/GrizzlyTankAttack 4.png";
            }
            else if(this.getMyPosition().getAngle() == 3)
            {
                return "/resorce/Units/GrizzlyTankAttack 5.png";
            }else if (this.getMyPosition().getAngle() == 8)
            {
                return "/resorce/Units/GrizzlyTankAttack 6.png";
            }else if (this.getMyPosition().getAngle() == 7)
            {
                return "/resorce/Units/GrizzlyTankAttack 7.png";
            }
            else if (this.getMyPosition().getAngle() == 6)
            {
                return "/resorce/Units/GrizzlyTankAttack 8.png";
            }
            return "/resorce/Units/GrizzlyTankAttack 8.png";
        }

        else {
            if (this.getMyPosition().getAngle() == 1)
            {
                return "/resorce/Units/GrizzlyTankDef 1.png";
            }
            else if( this.getMyPosition().getAngle() == 4 )
            {
                return "/resorce/Units/GrizzlyTankDef 2.png";
            }
            else if ( this.getMyPosition().getAngle() == 5 )
            {
                return "/resorce/Units/GrizzlyTankDef 3.png";
            }else if (this.getMyPosition().getAngle() == 2)
            {
                return "/resorce/Units/GrizzlyTankDef 4.png";
            }
            else if(this.getMyPosition().getAngle() == 3)
            {
                return "/resorce/Units/GrizzlyTankDef 5.png";
            }else if (this.getMyPosition().getAngle() == 8)
            {
                return "/resorce/Units/GrizzlyTankDef 6.png";
            }else if (this.getMyPosition().getAngle() == 7)
            {
                return "/resorce/Units/GrizzlyTankDef 7.png";
            }
            else if (this.getMyPosition().getAngle() == 6)
            {
                return "/resorce/Units/GrizzlyTankDef 8.png";
            }
            return "/resorce/Units/GrizzlyTankDef 8.png";
        }
    }


}
