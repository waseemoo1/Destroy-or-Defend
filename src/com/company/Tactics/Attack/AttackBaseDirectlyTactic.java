package com.company.Tactics.Attack;

import com.company.GameManagment.DODGameManager;
import com.company.Tools;
import com.company.Units.Unit;

public class AttackBaseDirectlyTactic extends AttackTactic {

    @Override
    public Unit FindUnitToAttack(Unit fighter) {
        return DODGameManager.mainBase;
    }

    @Override
    public void Facing(Unit unitToAttack, Unit fighter)
    {

        double distanceBetweenMeAndMyEnemyRadius;
        while (fighter.isAlive() && unitToAttack!=null && unitToAttack.isAlive())
        {
            fighter.CheckSuspending();
            distanceBetweenMeAndMyEnemyRadius=Tools.DistanceBetweenMeAndGoalRadios(fighter.getMyPosition(),unitToAttack);
            while (distanceBetweenMeAndMyEnemyRadius<=fighter.getRange() & unitToAttack.isAlive() & fighter.isAlive())
            {
                System.out.println(fighter.getId()+" attack "+ unitToAttack.getId());
                unitToAttack.AcceptAttack(fighter.getDamage());
                fighter.CheckSuspending();
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
                distanceBetweenMeAndMyEnemyRadius=Tools.DistanceBetweenMeAndGoalRadios(fighter.getMyPosition(),unitToAttack);
            }
            fighter.move(unitToAttack);
        }
    }
}
