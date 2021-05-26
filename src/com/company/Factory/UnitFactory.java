package com.company.Factory;

import com.company.PositionPair;
import com.company.Tactics.Tactic;
import com.company.Units.*;
import com.company.Units.AirPlanes.BlackEagle;
import com.company.Units.Soldiers.GrizzlyTank;
import com.company.Units.Soldiers.Infantry;
import com.company.Units.Soldiers.NavySeal;
import com.company.Units.Soldiers.Sniper;
import com.company.Units.Structures.*;
import com.company.Units.Tanks.MirageTank;
import com.company.Units.Tanks.PrismTank;
import com.company.Units.Tanks.TankDestroyer;
import com.company.Units.Tanks.Tesla;

public class UnitFactory
{
    private static int id =0;

    public Unit callunitstatic(String str, PositionPair positionPair , Tactic tactic) {
        /** UNIT SOLIDER *
         *               *
         *               *
         ****************/

        /** Sniper INITIALIZE *
         *                    *
         *                    *
         *********************/
        if (str.equals("Sniper Attack")) {
            id++;
           return new Sniper(positionPair, id, true, tactic);
        }
        else if (str.equals("Sniper Defender")) {
            id++;
            return new Sniper( positionPair, id ,false , tactic);
        }
        /** Infantry INITIALIZE *
         *                      *
         *                      *
         ***********************/
        else if (str.equals("Infantry Attack")) {
            id++;
            return new Infantry(positionPair, id, true, tactic);
        }
        else if (str.equals("Infantry Defender")) {
            id++;
            return new Infantry(positionPair, id, false, tactic);
        }
        /** GrizzlyTank INITIALIZE *
         *                         *
         *                         *
         **************************/
        else if (str.equals("GrizzlyTank Attack")) {
            id++;
            return new GrizzlyTank(positionPair, id, true, tactic);
        }
        else if (str.equals("GrizzlyTank Defender")) {
            id++;
            return new GrizzlyTank(positionPair, id, false, tactic);
        }
        /** NavySEAL INITIALIZE *
         *                      *
         *                      *
         ***********************/
        else if (str.equals("NavySEAL Attack")) {
            id++;
            return new NavySeal(positionPair, id, true, tactic);
        }
        else if (str.equals("NavySEAL Defender")) {
            id++;
            return new NavySeal(positionPair, id, false, tactic);
        }
        /**  UNIT TANK   *
         *               *
         *               *
         ****************/

        /** Tesla INITIALIZE *
         *                   *
         *                   *
         ********************/
        else if (str.equals("Tesla Attack")) {
            id++;
            return new Tesla(positionPair, id, true, tactic);
        }
        else if (str.equals("Tesla Defender")) {
            id++;
            return new Tesla(positionPair, id, false, tactic);
        }
        /** MirageTank INITIALIZE *
         *                        *
         *                        *
         *************************/
        else if (str.equals("MirageTank Attack")) {
            id++;
            return new MirageTank(positionPair, id, true, tactic);
        }
        else if (str.equals("MirageTank Defender")) {
            id++;
            return new MirageTank(positionPair, id, false, tactic);
        }
        /** Tank destroyer INITIALIZE *
         *                            *
         *                            *
         *****************************/
        else if (str.equals("Tank destroyer Attack")) {
            id++;
            return new TankDestroyer(positionPair, id, true, tactic);
        }
        else if (str.equals("Tank destroyer Defender")) {
            id++;
            return new TankDestroyer(positionPair, id, false, tactic);
        }
        /** Prism Tank INITIALIZE *
         *                        *
         *                        *
         *************************/
        else if (str.equals("Prism Tank Attack")) {
            id++;
            return new PrismTank(positionPair, id, true, tactic);
        }
        else if (str.equals("Prism Tank Defender")) {
            id++;
            return new PrismTank(positionPair, id, false, tactic);
        }
        /** UNIT STRUCTURE *
         *                 *
         *                 *
         ******************/

        /** MAINBASE INITIALIZE *
         *                      *
         *                      *
         ***********************/
        else if (str.equals("MAINBASE")) {
            return new MainBase(positionPair, 0);
        }
        /** Pillbox INITIALIZE *
         *                     *
         *                     *
         **********************/
        else if (str.equals("Pillbox")) {
            id++;
            return new PillBox(positionPair, id, false);
        }
        /** PrismTower INITIALIZE *
         *                        *
         *                        *
         *************************/
        else if (str.equals("PrismTower")) {
            id++;
            return new PrismTower(positionPair, id, false);
        }
        /** GrandCannon INITIALIZE *
         *                         *
         *                         *
         **************************/
        else if (str.equals("GrandCannon")) {
            id++;
            return new GrandCannon(positionPair, id, false);
        }
        /** PatriotMissileSystem INITIALIZE *
         *                                  *
         *                                  *
         ***********************************/
        else if (str.equals("PatriotMissileSystem")) {
            id++;
            return new PatriotMissileSystem(positionPair, id, false);
        }
        /** UNIT Airplane  *
         *                 *
         *                 *
         ******************/

        /** BlackEagle INITIALIZE *
         *                        *
         *                        *
         *************************/
         else if (str.equals("BlackEagle")){
             id++;
             return new BlackEagle(positionPair , id , true);
        }
        else return null;
    }
}




