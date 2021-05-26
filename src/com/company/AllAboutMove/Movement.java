package com.company.AllAboutMove;
import com.company.Arena.ArenaManager;
import com.company.PositionPair;
import com.company.Tools;
import com.company.Units.Unit;
import java.util.*;

public abstract class Movement {
    public abstract void move(Unit  mover , Unit goal);
}