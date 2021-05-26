package com.company.AllAboutMove;
import com.company.PositionPair;
import com.company.Tools;
import com.company.Units.Unit;




public class AirMovement extends Movement {
    @Override
    public void move(Unit mover, Unit goal)
    {
        mover.CheckSuspending();
        double distanceToFight = Tools.DistanceBetweenMeAndGoalRadios(mover.getMyPosition(), goal);
        while (distanceToFight >= mover.getRange() && mover.isAlive() && goal.isAlive()) {
            mover.CheckSuspending();
            PositionPair NewPosition = Tools.NewStep(mover.getMyPosition(), goal.getMyPosition());
            mover.setMyPosition(NewPosition);

            try {
                Thread.sleep(1000 / mover.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            distanceToFight = Tools.DistanceBetweenMeAndGoalRadios(mover.getMyPosition(), goal);

        }
    }
}
