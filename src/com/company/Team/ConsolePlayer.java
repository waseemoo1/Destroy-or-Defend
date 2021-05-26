package com.company.Team;

import com.company.Tools;
import com.company.Units.Unit;

public class ConsolePlayer extends Player{

    public ConsolePlayer(int coins, int teamId) {
        super(coins, teamId);
        System.out.println("Choose your color: ");
        this.color= Tools.isInteger(1,10);
    }

    public Unit BuyUnit()
    {
        return null;
    }
}
