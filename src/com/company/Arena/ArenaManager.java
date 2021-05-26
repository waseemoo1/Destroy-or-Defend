package com.company.Arena;

import com.company.Obstacles.Obstacle;
import com.company.Units.Unit;
import com.company.PositionPair;
import java.util.Map;


public abstract class ArenaManager {

    //done;
    private static void AddUnitToArena(Unit unitToAdd, PositionPair positionPair) {
        if (Arena.getInstance().map.get(positionPair) == null) {
            Arena.getInstance().map.put(new PositionPair(positionPair.getX(), positionPair.getY()), new Square(unitToAdd));
        } else {
            Arena.getInstance().map.get(positionPair).setUnit(unitToAdd);
        }
    }

    private static void deleteUnitPosition(PositionPair positionPairToDelete) {
        if (Arena.getInstance().map.get(positionPairToDelete) != null) {
            if (Arena.getInstance().map.get(positionPairToDelete).getObstacle() == null)
                Arena.getInstance().map.remove(positionPairToDelete);
            else Arena.getInstance().map.get(positionPairToDelete).setUnit(null);
        }
    }

    //done;
    private synchronized static boolean isUnBlocked(PositionPair positionPairToCheck) {
        return Arena.getInstance().map.get(positionPairToCheck) == null || isRiver(positionPairToCheck);
    }

    private static boolean isRiver(PositionPair positionPairToCheck) {
        return
                Arena.getInstance().map.get(positionPairToCheck) != null
                        && Arena.getInstance().map.get(positionPairToCheck).getObstacle() != null
                        && Arena.getInstance().map.get(positionPairToCheck).getObstacle().getClass().getName().compareToIgnoreCase("com.company.Obstacles.River") == 0;
    }

    //done;
    private static boolean isValid(PositionPair temp) {
        return temp.getX() >= 0 && temp.getX() < Arena.getInstance().getSizeX() && temp.getY() >= 0 && temp.getY() < Arena.getInstance().getSizeY();
    }


    private static void addObstacleToArena(Obstacle obstacleToAdd, PositionPair positionToAdd) {
        if (Arena.getInstance().map.get(positionToAdd) == null) {
            Arena.getInstance().map.put(new PositionPair(positionToAdd.getX(), positionToAdd.getY()), new Square(obstacleToAdd));
        } else {
            Arena.getInstance().map.get(obstacleToAdd.getMyPosition()).setObstacle(obstacleToAdd);
        }
    }


    //done;
    public static void addUnitWithRadius(Unit unitToAdd) {
        AddUnitToArena(unitToAdd, unitToAdd.getMyPosition());
        int unitRadius = unitToAdd.getRadius();
        PositionPair unitMidPoint = new PositionPair(unitToAdd.getMyPosition().getX(), unitToAdd.getMyPosition().getY());
        PositionPair southEast = new PositionPair(unitMidPoint.getX() + unitRadius, unitMidPoint.getY() + unitRadius);
        PositionPair southWest = new PositionPair(unitMidPoint.getX() + unitRadius, unitMidPoint.getY() - unitRadius);
        PositionPair northEast = new PositionPair(unitMidPoint.getX() - unitRadius, unitMidPoint.getY() + unitRadius);
        PositionPair northWest = new PositionPair(unitMidPoint.getX() - unitRadius, unitMidPoint.getY() - unitRadius);
        PositionPair radiusPosition = new PositionPair();

        //add north;
        radiusPosition.setX(northEast.getX());
        for (int j = northWest.getY(); j < northEast.getY(); j++) {
            radiusPosition.setY(j);
            AddUnitToArena(unitToAdd, radiusPosition);
        }

        //add East;
        radiusPosition.setY(northEast.getY());
        for (int i = northEast.getX(); i < southEast.getX(); i++) {
            radiusPosition.setX(i);
            AddUnitToArena(unitToAdd, radiusPosition);
        }

        //add south;
        radiusPosition.setX(southEast.getX());
        for (int j = southEast.getY(); j > southWest.getY(); j--) {
            radiusPosition.setY(j);
            AddUnitToArena(unitToAdd, radiusPosition);
        }


        //add west
        radiusPosition.setY(northWest.getY());
        for (int i = southWest.getX(); i > northWest.getX(); i--) {
            radiusPosition.setX(i);
            AddUnitToArena(unitToAdd, radiusPosition);
        }
    }


    public static void deleteUnitFromArenaWithRadios(PositionPair position, Unit unitToDelete) {
        deleteUnitPosition(position);
        int unitRadius = unitToDelete.getRadius();
        PositionPair southEast = new PositionPair(position.getX() + unitRadius, position.getY() + unitRadius);
        PositionPair southWest = new PositionPair(position.getX() + unitRadius, position.getY() - unitRadius);
        PositionPair northEast = new PositionPair(position.getX() - unitRadius, position.getY() + unitRadius);
        PositionPair northWest = new PositionPair(position.getX() - unitRadius, position.getY() - unitRadius);

        PositionPair radiusPosition = new PositionPair();
        //delete north;
        radiusPosition.setX(northEast.getX());
        for (int j = northWest.getY(); j < northEast.getY(); j++) {
            radiusPosition.setY(j);
            deleteUnitPosition(radiusPosition);
        }

        //delete East;
        radiusPosition.setY(northEast.getY());
        for (int i = northEast.getX(); i < southEast.getX(); i++) {
            radiusPosition.setX(i);
            deleteUnitPosition(radiusPosition);
        }

        //delete south;
        radiusPosition.setX(southEast.getX());
        for (int j = southEast.getY(); j > southWest.getY(); j--) {
            radiusPosition.setY(j);
            deleteUnitPosition(radiusPosition);
        }


        //delete west
        radiusPosition.setY(northWest.getY());
        for (int i = southWest.getX(); i > northWest.getX(); i--) {
            radiusPosition.setX(i);
            deleteUnitPosition(radiusPosition);
        }
    }


    //done;
    public synchronized static void EditUnitPosition(PositionPair oldPosition, Unit unitToSet) {
        ArenaManager.deleteUnitFromArenaWithRadios(oldPosition, unitToSet);
        ArenaManager.addUnitWithRadius(unitToSet);
    }


    //for test;
    public static void print() {
        System.out.println("______________________________________");
        System.out.println();
        Arena obj = Arena.getInstance();
        for (Map.Entry<PositionPair, Square> e : Arena.getInstance().map.entrySet())
            System.out.println("Position " + e.getKey() + " the unit: " + e.getValue());
        System.out.println();
        System.out.println("______________________________________");

    }


    public static boolean isAnyPointInRiver(Unit unitToMove, PositionPair newPosition) {
        int unitRadius = unitToMove.getRadius();
        PositionPair southEast = new PositionPair(newPosition.getX() + unitRadius, newPosition.getY() + unitRadius);
        PositionPair southWest = new PositionPair(newPosition.getX() + unitRadius, newPosition.getY() - unitRadius);
        PositionPair northEast = new PositionPair(newPosition.getX() - unitRadius, newPosition.getY() + unitRadius);
        PositionPair northWest = new PositionPair(newPosition.getX() - unitRadius, newPosition.getY() - unitRadius);

        /*********************************************************
         *                                                       *
         *          1(i-1,j-1) 2(i-1,j) 3(i-1,j+1)               *
         *          4(i,j-1)   U(i,j)   8(i,j+1)                 *
         *          5(i+1,j-1) 6(i+1,j) 7(i+1,j+1)               *
         *                                                       *
         *********************************************************/
        PositionPair pairToCheck = new PositionPair();
        //check north;
        pairToCheck.setX(northEast.getX());
        for (int j = northWest.getY(); j < northEast.getY(); j++) {
            pairToCheck.setY(j);
            if (isRiver(pairToCheck))
                return true;
        }

        //check East;
        pairToCheck.setY(northEast.getY());
        for (int i = northEast.getX(); i < southEast.getX(); i++) {
            pairToCheck.setX(i);
            if (isRiver(pairToCheck))
                return true;
        }


        //check south;
        pairToCheck.setX(southEast.getX());
        for (int j = southEast.getY(); j > southWest.getY(); j--) {
            pairToCheck.setY(j);
            if (isRiver(pairToCheck))
                return false;
        }

        //check west
        pairToCheck.setY(northWest.getY());
        for (int i = southWest.getX(); i > northWest.getX(); i--) {
            pairToCheck.setX(i);
            if (isRiver(pairToCheck))
                return true;
        }
        return false;
    }


    public static boolean isUnBlockedWithRadius(PositionPair newPosition, Unit unitToMove) {
        int unitRadius = unitToMove.getRadius();
        PositionPair southEast = new PositionPair(newPosition.getX() + unitRadius, newPosition.getY() + unitRadius);
        PositionPair southWest = new PositionPair(newPosition.getX() + unitRadius, newPosition.getY() - unitRadius);
        PositionPair northEast = new PositionPair(newPosition.getX() - unitRadius, newPosition.getY() + unitRadius);
        PositionPair northWest = new PositionPair(newPosition.getX() - unitRadius, newPosition.getY() - unitRadius);

        /*********************************************************
         *                                                       *
         *          1(i-1,j-1) 2(i-1,j) 3(i-1,j+1)               *
         *          4(i,j-1)   U(i,j)   8(i,j+1)                 *
         *          5(i+1,j-1) 6(i+1,j) 7(i+1,j+1)               *
         *                                                       *
         *********************************************************/


        PositionPair pairToCheck = new PositionPair();

        //check north;
        if (newPosition.getAngle() == 1 || newPosition.getAngle() == 2 || newPosition.getAngle() == 3) {
            pairToCheck.setX(northEast.getX());
            for (int j = northWest.getY(); j <= northEast.getY(); j++) {
                pairToCheck.setY(j);
                if (!isUnBlocked(pairToCheck))
                    return false;
            }
        }

        //check East;
        if (newPosition.getAngle() == 3 || newPosition.getAngle() == 8 || newPosition.getAngle() == 7) {
            pairToCheck.setY(northEast.getY());
            for (int i = northEast.getX(); i <= southEast.getX(); i++) {
                pairToCheck.setX(i);
                if (!isUnBlocked(pairToCheck))
                    return false;
            }
        }

        //check south;
        if (newPosition.getAngle() == 5 || newPosition.getAngle() == 6 || newPosition.getAngle() == 7) {
            pairToCheck.setX(southEast.getX());
            for (int j = southEast.getY(); j >= southWest.getY(); j--) {
                pairToCheck.setY(j);
                if (!isUnBlocked(pairToCheck))
                    return false;
            }
        }

        //check west
        if (newPosition.getAngle() == 1 || newPosition.getAngle() == 4 || newPosition.getAngle() == 5) {
            pairToCheck.setY(northWest.getY());
            for (int i = southWest.getX(); i >= northWest.getX(); i--) {
                pairToCheck.setX(i);
                if (!isUnBlocked(pairToCheck))
                    return false;
            }
        }

        return true;
    }

    /******************************************************
     *
     *
     *
     *
     *
     * @param newPosition
     * @param unitToMove
     * @return
     */

    public static boolean isValidWithRadius(PositionPair newPosition, Unit unitToMove) {
        int unitRadius = unitToMove.getRadius();
        PositionPair southEast = new PositionPair(newPosition.getX() + unitRadius, newPosition.getY() + unitRadius);
        PositionPair southWest = new PositionPair(newPosition.getX() + unitRadius, newPosition.getY() - unitRadius);
        PositionPair northEast = new PositionPair(newPosition.getX() - unitRadius, newPosition.getY() + unitRadius);
        PositionPair northWest = new PositionPair(newPosition.getX() - unitRadius, newPosition.getY() - unitRadius);

        /*********************************************************
         * 1/12/2020                                             *
         *          1(i-1,j-1) 2(i-1,j) 3(i-1,j+1)               *
         *          4(i,j-1)   U(i,j)   8(i,j+1)                 *
         *          5(i+1,j-1) 6(i+1,j) 7(i+1,j+1)               *
         *********************************************************/
        PositionPair pairToCheck = new PositionPair();
        //check north;
        if (newPosition.getAngle() == 1 || newPosition.getAngle() == 2 || newPosition.getAngle() == 3) {
            pairToCheck.setX(northWest.getX());
            for (int j = northWest.getY(); j <= northEast.getY(); j++) {
                pairToCheck.setY(j);
                if (!isValid(pairToCheck))
                    return false;
            }
        }

        //check East;
        if (newPosition.getAngle() == 3 || newPosition.getAngle() == 8 || newPosition.getAngle() == 7) {
            pairToCheck.setY(northEast.getY());
            for (int i = northEast.getX(); i <= southEast.getX(); i++) {
                pairToCheck.setX(i);
                if (!isValid(pairToCheck))
                    return false;
            }
        }


        //check south;
        if (newPosition.getAngle() == 5 || newPosition.getAngle() == 6 || newPosition.getAngle() == 7) {
            pairToCheck.setX(southEast.getX());
            for (int j = southEast.getY(); j >= southWest.getY(); j--) {
                pairToCheck.setY(j);
                if (!isValid(pairToCheck))
                    return false;
            }
        }


        //check west
        if (newPosition.getAngle() == 1 || newPosition.getAngle() == 4 || newPosition.getAngle() == 5) {
            pairToCheck.setY(northWest.getY());
            for (int i = southWest.getX(); i > northWest.getX(); i--) {
                pairToCheck.setX(i);
                if (!isValid(pairToCheck))
                    return false;
            }
        }
        return true;
    }

    public static boolean isDestination(PositionPair a, Unit des) {
        return des.getMyPosition().equals(a);
    }


    public static void addObstacleWithRadius(Obstacle obstacleToAdd) {
        addObstacleToArena(obstacleToAdd, obstacleToAdd.getMyPosition());
        int unitRadius = obstacleToAdd.getRadius();
        PositionPair obstacleMidPoint = new PositionPair(obstacleToAdd.getMyPosition().getX(), obstacleToAdd.getMyPosition().getY());
        PositionPair southEast = new PositionPair(obstacleMidPoint.getX() + unitRadius, obstacleMidPoint.getY() + unitRadius);
        PositionPair southWest = new PositionPair(obstacleMidPoint.getX() + unitRadius, obstacleMidPoint.getY() - unitRadius);
        PositionPair northEast = new PositionPair(obstacleMidPoint.getX() - unitRadius, obstacleMidPoint.getY() + unitRadius);
        PositionPair northWest = new PositionPair(obstacleMidPoint.getX() - unitRadius, obstacleMidPoint.getY() - unitRadius);
        PositionPair radiusPosition = new PositionPair();

        //add north;
        radiusPosition.setX(northEast.getX());
        for (int j = northWest.getY(); j < northEast.getY(); j++) {
            radiusPosition.setY(j);
            addObstacleToArena(obstacleToAdd, radiusPosition);
        }

        //add East;
        radiusPosition.setY(northEast.getY());
        for (int i = northEast.getX(); i < southEast.getX(); i++) {
            radiusPosition.setX(i);
            addObstacleToArena(obstacleToAdd, radiusPosition);
        }
        //add south;
        radiusPosition.setX(southEast.getX());
        for (int j = southEast.getY(); j > southWest.getY(); j--) {
            radiusPosition.setY(j);
            addObstacleToArena(obstacleToAdd, radiusPosition);
        }
        //add west
        radiusPosition.setY(northWest.getY());
        for (int i = southWest.getX(); i > northWest.getX(); i--) {
            radiusPosition.setX(i);
            addObstacleToArena(obstacleToAdd, radiusPosition);
        }
    }
}
