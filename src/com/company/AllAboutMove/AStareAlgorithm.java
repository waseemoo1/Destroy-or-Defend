package com.company.AllAboutMove;
import com.company.Arena.ArenaManager;
import com.company.PositionPair;
import com.company.Tools;
import com.company.Units.Unit;
import java.util.*;

public abstract class AStareAlgorithm {

    public static Stack<PositionPair> tracePath(Map<PositionPair, Cell> cellDetails, PositionPair dest)
    {
        PositionPair pair = new PositionPair(dest.getX(), dest.getY());
        Stack<PositionPair> Path = new Stack<>();

        while (!cellDetails.get(pair).getParent().equals(pair)) {
            Path.push(new PositionPair(pair.getX(), pair.getY()));
            pair=cellDetails.get(pair).getParent();
        }
        return Path;
    }

    public static Stack<PositionPair> PathFinding(Unit unitMover, Unit goal)
    {
        RadiusPositionPair temp=null;

//        if (Tools.Distance(unitMover.getMyPosition() , goal.getMyPosition()) >500 )
//        {
//            temp=new RadiusPositionPair();
//            temp.setMyPosition(new PositionPair(goal.getMyPosition().getX(),goal.getMyPosition().getY()));
//            temp.setRadius(goal.getRadius());
//            /*********************************************************
//             * 1/12/2020                                             *
//             *          1(i-1,j-1) 2(i-1,j) 3(i-1,j+1)               *
//             *          4(i,j-1)   U(i,j)   8(i,j+1)                 *
//             *          5(i+1,j-1) 6(i+1,j) 7(i+1,j+1)               *
//             *********************************************************/
//            PositionPair pair = Tools.setAngle(unitMover.getMyPosition() , goal.getMyPosition());
//            if (pair.getAngle() == 1)
//            {
//                temp.getMyPosition().setX(unitMover.getMyPosition().getX()-500);
//                temp.getMyPosition().setY(unitMover.getMyPosition().getY()-500);
//            }
//            else if( pair.getAngle() == 2 )
//            {
//                temp.getMyPosition().setX(unitMover.getMyPosition().getX()-500);
//                temp.getMyPosition().setY(unitMover.getMyPosition().getY());
//            }
//            else if ( pair.getAngle() == 3 )
//            {
//                temp.getMyPosition().setX(unitMover.getMyPosition().getX()-500);
//                temp.getMyPosition().setY(unitMover.getMyPosition().getY()+500);
//            }else if (pair.getAngle() == 4)
//            {
//                temp.getMyPosition().setX(unitMover.getMyPosition().getX());
//                temp.getMyPosition().setY(unitMover.getMyPosition().getY()-500);
//            }
//            else if(pair.getAngle() == 5)
//            {
//                temp.getMyPosition().setX(unitMover.getMyPosition().getX()+500);
//                temp.getMyPosition().setY(unitMover.getMyPosition().getY()-500);
//            }else if (pair.getAngle() == 6)
//            {
//                temp.getMyPosition().setX(unitMover.getMyPosition().getX()+500);
//                temp.getMyPosition().setY(unitMover.getMyPosition().getY());
//            }else if (pair.getAngle() == 7)
//            {
//                temp.getMyPosition().setX(unitMover.getMyPosition().getX()+500);
//                temp.getMyPosition().setY(unitMover.getMyPosition().getY()+500);
//            }
//            else if (pair.getAngle() == 8)
//            {
//                temp.getMyPosition().setX(unitMover.getMyPosition().getX());
//                temp.getMyPosition().setY(unitMover.getMyPosition().getY()+500);
//            }
//        }

        Map<PositionPair, Boolean> closedList = new HashMap<>();
        Map<PositionPair, Cell> cellDetails = new HashMap<>();
        cellDetails.put(unitMover.getMyPosition(), new Cell(0, 0, 0, unitMover.getMyPosition()));
        PriorityQueue<pPair> openList = new PriorityQueue(new Comparator<pPair>() {
            @Override
            public int compare(pPair node0, pPair node1)
            {
                return Double.compare(node0.getF(), node1.getF());
            }
        });
        openList.add(new pPair(0.0, unitMover.getMyPosition()));

        while (!openList.isEmpty() && unitMover.isAlive() && goal.isAlive())
        {
            pPair firstElement = openList.poll();
            int i = firstElement.getPosition().getX();
            int j = firstElement.getPosition().getY();
            closedList.put(new PositionPair(i, j), true);
            double gNew, hNew, fNew;

            for (int row=i-1; row<=i+1; row++)
            {
                for (int col=j-1; col<=j+1; col++)
                {
                    if (row==i && col==j)
                        continue;

                    PositionPair new1 = new PositionPair(row, col);
                    /*********************************************************
                     * 1/12/2020                                             *
                     *          1(i-1,j-1) 2(i-1,j) 3(i-1,j+1)               *
                     *          4(i,j-1)   U(i,j)   8(i,j+1)                 *
                     *          5(i+1,j-1) 6(i+1,j) 7(i+1,j+1)               *
                     *********************************************************/
                    if(row == i-1 && col ==j-1)
                        new1.setAngle(1);
                    else if(row == i-1 && col ==j)
                        new1.setAngle(2);
                    else if(row == i-1 && col ==j+1)
                        new1.setAngle(3);
                    else if(row == i && col ==j-1)
                        new1.setAngle(4);
                    else if(row == i+1 && col ==j-1)
                        new1.setAngle(5);
                    else if(row == i+1 && col ==j)
                        new1.setAngle(6);
                    else if(row == i+1 && col ==j+1)
                        new1.setAngle(7);
                    else if(row == i && col ==j+1)
                        new1.setAngle(8);
                    if ( ArenaManager.isValidWithRadius(new1,unitMover))
                    {
                        if (temp!=null) {
                            if (Tools.GoalInMyRangeWithRadius(unitMover, temp, new1)) {
                                cellDetails.put(new PositionPair(new1.getX(), new1.getY()), new Cell(0, 0, 0, new PositionPair(i, j)));
                                return tracePath(cellDetails, new1);
                            }
                        }
                        else if ( Tools.InMyRangeWithRadius( unitMover , goal , new1 ))
                                {
                                    cellDetails.put(new PositionPair(new1.getX(), new1.getY()), new Cell(0, 0, 0, new PositionPair(i, j)));
                                    return tracePath(cellDetails, new1);
                                }
                        else if ( closedList.get(new1) == null && ArenaManager.isUnBlockedWithRadius(new1,unitMover))
                        {
                            double cost=1.0;
                            if (ArenaManager.isAnyPointInRiver(unitMover,new1))
                            {
                                cost=2.0;
                            }
                            gNew = cellDetails.get(firstElement.getPosition()).getG() + cost;
                            hNew = Tools.Distance(new1, goal.getMyPosition());
                            fNew = gNew + hNew;

                            if (cellDetails.get(new1) == null || cellDetails.get(new1).getF() > fNew)
                            {
                                openList.add(new pPair(fNew, new PositionPair(row, col)));
                                cellDetails.put(new PositionPair(row, col), new Cell(gNew, hNew, fNew, new PositionPair(i, j)));
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
