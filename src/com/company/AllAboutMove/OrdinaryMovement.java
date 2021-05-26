package com.company.AllAboutMove;

import com.company.Arena.ArenaManager;
import com.company.PositionPair;
import com.company.Tools;
import com.company.Units.Unit;

import java.util.*;

public class OrdinaryMovement extends Movement {


    @Override
    public void move(Unit mover, Unit goal) {

        Stack<PositionPair> pathToGoal;
        double distanceToFight = Tools.DistanceBetweenMeAndGoalRadios( mover.getMyPosition() ,goal);
        while ( distanceToFight>=mover.getRange() && mover.isAlive() && goal.isAlive() )
        {
            mover.CheckSuspending();
            PositionPair oldPosition = new PositionPair(mover.getMyPosition().getX(), mover.getMyPosition().getY());
            PositionPair NewPosition = Tools.NewStep(mover.getMyPosition(), goal.getMyPosition());
            if(ArenaManager.isUnBlockedWithRadius(NewPosition,mover))
            {
                mover.setMyPosition(NewPosition);
                ArenaManager.EditUnitPosition(oldPosition , mover);
                //System.out.println("unit "+mover.getId()+" move to: "+NewPosition);
                int unitSpeed=mover.getSpeed();
                if (ArenaManager.isAnyPointInRiver(mover , NewPosition))
                    unitSpeed=unitSpeed/2;
                try {
                    Thread.sleep(1000/unitSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                distanceToFight =  Tools.DistanceBetweenMeAndGoalRadios ( mover.getMyPosition() , goal);
            }
            else
            {
                pathToGoal=AStareAlgorithm.PathFinding(mover,goal);
                while ( distanceToFight>=mover.getRange() && pathToGoal!=null && !pathToGoal.empty() && mover.isAlive() && goal.isAlive() )
                {
                    mover.CheckSuspending();
                    oldPosition = new PositionPair(mover.getMyPosition().getX(), mover.getMyPosition().getY());
                    NewPosition = pathToGoal.pop();
                    NewPosition = Tools.setAngle(oldPosition , NewPosition);
                    if(!ArenaManager.isUnBlockedWithRadius(NewPosition,mover))
                    {
                        pathToGoal.clear();
                        break;
                    }
                    mover.setMyPosition(NewPosition);
                    ArenaManager.EditUnitPosition(oldPosition, mover);
                    //System.out.println("unit "+mover.getId()+" move to: "+NewPosition);
                    int unitSpeed=mover.getSpeed();
                    if (ArenaManager.isAnyPointInRiver(mover , NewPosition))
                        unitSpeed=unitSpeed/2;
                    try {
                        Thread.sleep(1000/unitSpeed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    distanceToFight =  Tools.DistanceBetweenMeAndGoalRadios ( mover.getMyPosition() , goal);
                }
            }
        }
    }
}
