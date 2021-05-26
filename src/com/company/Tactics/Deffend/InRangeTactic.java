package com.company.Tactics.Deffend;

import com.company.Tools;
import com.company.Units.Unit;

public class InRangeTactic extends DefendTactic{
    @Override
    public Unit FindUnitToAttack(Unit fighter) {
        return Tools.FindUnitToKill(fighter);
    }

    @Override
    public void Facing(Unit unitToAttack, Unit fighter) {
        double distanceBetweenMeAndMyEnemy;
        while (fighter.isAlive() && unitToAttack!=null && unitToAttack.isAlive())
        {
            unitToAttack.CheckSuspending();
            distanceBetweenMeAndMyEnemy=Tools.Distance(unitToAttack.getMyPosition(),fighter.getMyPosition());
            while (distanceBetweenMeAndMyEnemy<=fighter.getRange() && unitToAttack.isAlive() && fighter.isAlive())
            {
                unitToAttack.CheckSuspending();
                System.out.println(fighter.getId()+" attack "+ unitToAttack.getId());
                unitToAttack.AcceptAttack(fighter.getDamage());
                try {
                    double attackSpeedFrequency;
                    if (fighter.getAttackSpeed() > 1)
                    {
                        attackSpeedFrequency = 1000 / fighter.getAttackSpeed();
                    }
                    else
                    {
                        attackSpeedFrequency = 1000 * fighter.getAttackSpeed();
                    }
                    Thread.sleep((int)attackSpeedFrequency);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                distanceBetweenMeAndMyEnemy=Tools.Distance(unitToAttack.getMyPosition(),fighter.getMyPosition());
            }
        }
    }
}
