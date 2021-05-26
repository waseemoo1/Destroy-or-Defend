package com.company.Tactics.Attack;
import com.company.Units.Unit;
import com.company.Tools;


public class RandomAttackTactic extends AttackTactic {

    public Unit FindUnitToAttack(Unit fighter)
    {
        return Tools.SearchLeastDistance(fighter);
    }

    public void Facing(Unit unitToAttack ,Unit fighter)
    {
        double distanceBetweenMeAndMyEnemyRadius;
        while (fighter.isAlive() && unitToAttack!=null && unitToAttack.isAlive())
        {
            unitToAttack.CheckSuspending();
            distanceBetweenMeAndMyEnemyRadius=Tools.DistanceBetweenMeAndGoalRadios(fighter.getMyPosition(),unitToAttack);
            while (distanceBetweenMeAndMyEnemyRadius<=fighter.getRange() && unitToAttack.isAlive() && fighter.isAlive())
            {
                unitToAttack.CheckSuspending();
                System.out.println( fighter.getId() + " attack " + unitToAttack.getId());
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
            }
            fighter.move(unitToAttack);
        }

    }
}

