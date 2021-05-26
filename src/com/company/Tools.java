package com.company;

import com.company.AllAboutMove.RadiusPositionPair;
import com.company.Units.Soldiers.GrizzlyTank;
import com.company.Units.Unit;

import java.util.Scanner;

public class Tools {
public static PositionPair setAngle(PositionPair oldPosition , PositionPair newPosition) {
    PositionPair temp = newPosition;
    /*********************************************************
     * 1/12/2020                                             *
     *          1(i-1,j-1) 2(i-1,j) 3(i-1,j+1)               *
     *          4(i,j-1)   U(i,j)   8(i,j+1)                 *
     *          5(i+1,j-1) 6(i+1,j) 7(i+1,j+1)               *
     *********************************************************/
    if (newPosition.getX() > oldPosition.getX()) {
        if (newPosition.getY() > oldPosition.getY()) {
            temp.setAngle(7);
        } else if (newPosition.getY() < oldPosition.getY()) {
            temp.setAngle(5);
        } else {
            temp.setAngle(6);
        }
    } else if (newPosition.getX() < oldPosition.getX()) {
        if (newPosition.getY() > oldPosition.getY()) {
            temp.setAngle(3);
        } else if (newPosition.getY() < oldPosition.getY()) {
            temp.setAngle(1);
        } else {
            temp.setAngle(2);
        }
    } else {
        if (newPosition.getY() > oldPosition.getY()) {
            temp.setAngle(8);
        } else if (newPosition.getY() < oldPosition.getY()) {
            temp.setAngle(4);
        }
    }
    return temp;
}

    public static PositionPair NewStep(PositionPair a, PositionPair b) {
        /*********************************************************
         * 1/12/2020                                             *
         *          1(i-1,j-1) 2(i-1,j) 3(i-1,j+1)               *
         *          4(i,j-1)   U(i,j)   8(i,j+1)                 *
         *          5(i+1,j-1) 6(i+1,j) 7(i+1,j+1)               *
         *********************************************************/
        PositionPair temp = new PositionPair();
        if (a.getX() > b.getX()) {
            temp.setX(a.getX() - 1);
            if (a.getY() > b.getY()) {
                temp.setY(a.getY() - 1);
                temp.setAngle(1);
            } else if (a.getY() < b.getY()) {
                temp.setY(a.getY() + 1);
                temp.setAngle(3);
            } else {
                temp.setY(a.getY());
                temp.setAngle(2);
            }
        } else if (a.getX() < b.getX()) {
            temp.setX(a.getX() + 1);
            if (a.getY() > b.getY()) {
                temp.setY(a.getY() - 1);
                temp.setAngle(5);
            } else if (a.getY() < b.getY()) {
                temp.setY(a.getY() + 1);
                temp.setAngle(7);
            } else {
                temp.setY(a.getY());
                temp.setAngle(6);
            }
        } else {
            temp.setX(a.getX());
            if (a.getY() > b.getY()) {
                temp.setY(a.getY() - 1);
                temp.setAngle(4);
            } else if (a.getY() < b.getY()) {
                temp.setY(a.getY() + 1);
                temp.setAngle(8);
            } else {
                temp.setY(a.getY());
            }
        }
        return temp;
        /*********************************************************
         * 1/12/2020                                             *
         *          1(i-1,j-1) 2(i-1,j) 3(i-1,j+1)               *
         *          4(i,j-1)   U(i,j)   8(i,j+1)                 *
         *          5(i+1,j-1) 6(i+1,j) 7(i+1,j+1)               *
         *********************************************************/
    }

    public static double Distance(PositionPair a, PositionPair b) {
        return (Math.sqrt(Square(a.getY() - b.getY()) + Square(a.getX() - b.getX())));
    }

    public static double DistanceBetweenMeAndGoalRadios(PositionPair myPosition, Unit myGoal)
    {
        int unitRadius= myGoal.getRadius();
        PositionPair southEast=new PositionPair(myGoal.getMyPosition().getX()+unitRadius,myGoal.getMyPosition().getY()+unitRadius);
        PositionPair southWest=new PositionPair(myGoal.getMyPosition().getX()+unitRadius,myGoal.getMyPosition().getY()-unitRadius);
        PositionPair northEast=new PositionPair(myGoal.getMyPosition().getX()-unitRadius,myGoal.getMyPosition().getY()+unitRadius);
        PositionPair northWest=new PositionPair(myGoal.getMyPosition().getX()-unitRadius,myGoal.getMyPosition().getY()-unitRadius);
        double minDistance = Double.MAX_VALUE;

        PositionPair pair=new PositionPair();

        //distance from North
            pair.setX(northWest.getX());
            for (int j=northWest.getY(); j<northEast.getY();j++)
            {
                pair.setY(j);
                minDistance = Math.min(minDistance , Distance(myPosition , pair));
            }

        //distance from East;
            pair.setY(northEast.getY());
            for ( int i=northEast.getX(); i<southEast.getX(); i++ )
            {
                pair.setX(i);
                minDistance = Math.min(minDistance , Distance(myPosition , pair));
            }

        //distance from south;
            pair.setX(southEast.getX());
            for (int j=southEast.getY(); j>southWest.getY();j--)
            {
                pair.setY(j);
                minDistance = Math.min(minDistance , Distance(myPosition , pair));
            }

        //distance from west
            pair.setY(northWest.getY());
            for ( int i=southWest.getX(); i>northWest.getX(); i-- )
            {
                pair.setX(i);
                minDistance = Math.min(minDistance , Distance(myPosition , pair));

            }
            return minDistance;
    }



    private static double Square(int a) {
        return a * a;
    }



    public static Scanner scanner=new Scanner(System.in);
    public static int isInteger(int a , int b)
    {
        int c=a-1;
        do {
            try{
                c=Integer.parseInt(scanner.nextLine());
                if(c<a || c>b)
                {
                    System.out.println("please insert a number between "+a+" and "+b);
                }
            }catch (NumberFormatException ex){
                System.out.println("please insert an integer");
            }
        }while (c<a || c>b);
        return c;
    }


    public static boolean InMyRange(Unit attacker,Unit goal , PositionPair newPosition)
    {
        return Tools.Distance(newPosition, goal.getMyPosition())<=attacker.getRange();
    }


    public static boolean InMyRangeWithRadius(Unit attacker,Unit goal , PositionPair newPosition)
    {
        return Tools.DistanceBetweenMeAndGoalRadios(newPosition, goal)<=attacker.getRange();
    }

    public static boolean GoalInMyRangeWithRadius(Unit attacker, RadiusPositionPair myGoal , PositionPair myPosition)
    {
        int unitRadius= myGoal.getRadius();
        PositionPair southEast=new PositionPair(myGoal.getMyPosition().getX()+unitRadius,myGoal.getMyPosition().getY()+unitRadius);
        PositionPair southWest=new PositionPair(myGoal.getMyPosition().getX()+unitRadius,myGoal.getMyPosition().getY()-unitRadius);
        PositionPair northEast=new PositionPair(myGoal.getMyPosition().getX()-unitRadius,myGoal.getMyPosition().getY()+unitRadius);
        PositionPair northWest=new PositionPair(myGoal.getMyPosition().getX()-unitRadius,myGoal.getMyPosition().getY()-unitRadius);
        double minDistance = Double.MAX_VALUE;

        PositionPair pair=new PositionPair();

        //distance from North
        pair.setX(northWest.getX());
        for (int j=northWest.getY(); j<northEast.getY();j++)
        {
            pair.setY(j);
            minDistance = Math.min(minDistance , Distance(myPosition , pair));
        }

        //distance from East;
        pair.setY(northEast.getY());
        for ( int i=northEast.getX(); i<southEast.getX(); i++ )
        {
            pair.setX(i);
            minDistance = Math.min(minDistance , Distance(myPosition , pair));
        }

        //distance from south;
        pair.setX(southEast.getX());
        for (int j=southEast.getY(); j>southWest.getY();j--)
        {
            pair.setY(j);
            minDistance = Math.min(minDistance , Distance(myPosition , pair));
        }

        //distance from west
        pair.setY(northWest.getY());
        for ( int i=southWest.getX(); i>northWest.getX(); i-- )
        {
            pair.setX(i);
            minDistance = Math.min(minDistance , Distance(myPosition , pair));
        }
        return minDistance <= attacker.getRange();
    }

    public static Unit SearchLeastDistance(Unit fighter) {
        double distance;
        double minDistance = Double.MAX_VALUE;
        Unit goal = null;
        try{
            for (Unit i : Store.allUnits) {
                if (Causal(fighter , i))
                {
                    if (IsMyEnemy(fighter , i))
                    {
                        distance = Distance(i.getMyPosition(), fighter.getMyPosition());
                        if (distance < minDistance) {
                            minDistance = distance;
                            goal = i;
                        }
                    }
                }
            }
        }catch (Exception e)
        {
            return null;
        }
        return goal;
    }


    public  static Unit SearchMinHealth(Unit fighter) {
        int Health;
        int minHealth = Integer.MAX_VALUE;
        Unit goal = null;
        try {
            for (Unit i : Store.allUnits) {
                if ( fighter!=null && fighter.isAlive() && i!=null && i.isAlive() && fighter.isState() == !i.isState()) {
                    Health = i.getHealth();
                    if (Health < minHealth) {
                        minHealth = Health;
                        goal = i;
                    }
                }
            }
        }catch (Exception E){
            return null;
        }

        return goal;
    }

    public  static Unit SearchMaxDamage(Unit fighter) {
        int Damage;
        int MaxDamage = 0;
        Unit goal = null;
        try {
            for (Unit i : Store.allUnits) {
                if (fighter!=null && fighter.isAlive() && i!=null && i.isAlive() && fighter.isState() == !i.isState()) {
                    Damage = i.getDamage();
                    if (Damage > MaxDamage) {
                        MaxDamage = Damage;
                        goal = i;
                    }
                }
            }
        }catch (Exception e)
        {
            return null;
        }
        return goal;
    }

    public static Unit FindUnitToKill(Unit fighter)
    {
        Unit a=SearchLeastDistance(fighter);
        if(a!=null && Tools.Distance(a.getMyPosition(),fighter.getMyPosition())<=fighter.getRange()){
            return a;
        }
        return null;
    }

    public static boolean IsMyEnemy(Unit fighter,Unit goal){
        String FighterName=fighter.getClass().getSimpleName();
        String GoalName=goal.getClass().getSimpleName();
        if( FighterName.equals("Sniper") && (GoalName.equals("Sniper") || GoalName.equals("GrizzlyTank") || GoalName.equals("NavySeal") || GoalName.equals("Infantry"))){
            return true;
        }
        else if(FighterName.equals("Tesla") &&  (GoalName.equals("NavySeal") || GoalName.equals("GrizzlyTank") || GoalName.equals("Infantry") || GoalName.equals("Sniper") || GoalName.equals("Tesla") || GoalName.equals("MirageTank") || GoalName.equals("TankDestroyer") || GoalName.equals("PrismTank"))){
            return true;
        }
        else if(FighterName.equals("PillBox") && (GoalName.equals("Sniper") || GoalName.equals("GrizzlyTank") || GoalName.equals("NavySeal") || GoalName.equals("Infantry")))
            return true;
        else if(FighterName.equals("Infantry") && (GoalName.equals("Sniper") || GoalName.equals("GrizzlyTank") || GoalName.equals("NavySeal") || GoalName.equals("Infantry")))
            return true;
        else if(FighterName.equals("NavySeal") &&  (GoalName.equals("NavySeal") || GoalName.equals("GrizzlyTank") || GoalName.equals("Infantry") || GoalName.equals("Sniper") || GoalName.equals("Tesla") || GoalName.equals("MirageTank") || GoalName.equals("TankDestroyer") || GoalName.equals("PrismTank")))
            return true;
        else if(FighterName.equals("TankDestroyer") && (GoalName.equals("Tesla") || GoalName.equals("MirageTank") || GoalName.equals("TankDestroyer") || GoalName.equals("PrismTank")))
            return true;
        else if (FighterName.equals("PrismTower") && (GoalName.equals("NavySeal") || GoalName.equals("GrizzlyTank") || GoalName.equals("Infantry") || GoalName.equals("Sniper") || GoalName.equals("Tesla") || GoalName.equals("MirageTank") || GoalName.equals("TankDestroyer") || GoalName.equals("PrismTank")))
            return true;
        else if (FighterName.equals("GrandCannon") && (GoalName.equals("NavySeal") || GoalName.equals("GrizzlyTank") || GoalName.equals("Infantry") || GoalName.equals("Sniper") || GoalName.equals("Tesla") || GoalName.equals("MirageTank") || GoalName.equals("TankDestroyer") || GoalName.equals("PrismTank")))
            return true;
        else if (FighterName.equals("MirageTank") && (GoalName.equals("MainBase") || GoalName.equals("NavySeal") || GoalName.equals("GrizzlyTank") || GoalName.equals("Infantry") || GoalName.equals("Sniper") || GoalName.equals("Tesla") || GoalName.equals("MirageTank") || GoalName.equals("TankDestroyer") || GoalName.equals("PrismTank")  || GoalName.equals("PillBox")   || GoalName.equals("PrismTower")   || GoalName.equals("GrandCannon") || GoalName.equals("PatriotMissileSystem")))
            return true;
        else if (FighterName.equals("GrizzlyTank") && (GoalName.equals("MainBase") || GoalName.equals("NavySeal") || GoalName.equals("GrizzlyTank") || GoalName.equals("Infantry") || GoalName.equals("Sniper") || GoalName.equals("Tesla") || GoalName.equals("MirageTank") || GoalName.equals("TankDestroyer") || GoalName.equals("PrismTank")  || GoalName.equals("PillBox")   || GoalName.equals("PrismTower")   || GoalName.equals("GrandCannon") || GoalName.equals("PatriotMissileSystem")))
            return true;
        else if (FighterName.equals("PrismTank") && (GoalName.equals("MainBase") || GoalName.equals("NavySeal") || GoalName.equals("GrizzlyTank") || GoalName.equals("Infantry") || GoalName.equals("Sniper") || GoalName.equals("Tesla") || GoalName.equals("MirageTank") || GoalName.equals("TankDestroyer") || GoalName.equals("PrismTank") || GoalName.equals("PrismTower")   || GoalName.equals("GrandCannon")   || GoalName.equals("PillBox") || GoalName.equals("PatriotMissileSystem")))
            return true;
        else if (FighterName.equals("BlackEagle") && GoalName.equals("MainBase") )
            return true;
        else if (FighterName.equals("PatriotMissileSystem") && GoalName.equals("BlackEagle") )
            return true;
        else
            return false;
    }

    public static boolean Causal(Unit fighter, Unit i){
        return fighter != null && fighter.isAlive() && i != null && i.isAlive() && fighter.isState() == !i.isState();
    }
}
