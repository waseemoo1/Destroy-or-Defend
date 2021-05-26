package com.company.Team;


import com.company.Units.Unit;

public abstract class Player {
    protected int coins;
    protected int teamId;
    protected int color;

    public Player(int coins, int teamId) {
        this.coins = coins;
        this.teamId = teamId;
    }
    public abstract Unit BuyUnit();
}
