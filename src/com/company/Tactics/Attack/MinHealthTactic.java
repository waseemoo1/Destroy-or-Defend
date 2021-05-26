package com.company.Tactics.Attack;

import com.company.Tools;
import com.company.Units.Unit;

public class MinHealthTactic extends AttackTactic{
    @Override
    public Unit FindUnitToAttack(Unit fighter) {
        return Tools.SearchMinHealth(fighter);
    }

    @Override
    public void Facing(Unit unitToAttack, Unit fighter) {
        double distanceBetweenMeAndMyEnemy;
        while (fighter.isAlive() && unitToAttack!=null && unitToAttack.isAlive())
        {
            fighter.CheckSuspending();
            distanceBetweenMeAndMyEnemy=Tools.DistanceBetweenMeAndGoalRadios(fighter.getMyPosition(),unitToAttack);
            while (distanceBetweenMeAndMyEnemy<=fighter.getRange() && unitToAttack.isAlive() && fighter.isAlive())
            {
                fighter.CheckSuspending();
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
                distanceBetweenMeAndMyEnemy=Tools.DistanceBetweenMeAndGoalRadios(fighter.getMyPosition(),unitToAttack);
            }
            fighter.move(unitToAttack);
        }
    }
}
