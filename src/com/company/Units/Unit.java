package com.company.Units;
import com.company.AllAboutMove.Movement;
import com.company.PositionPair;
import com.company.Tactics.Tactic;

public abstract class Unit implements Runnable {
    private int color = 0;
    private int health, damage, range, speed , radius , price;
    private double shield, attackSpeed;
    private PositionPair myPosition;
    private int id;
    private Movement movement;
    private boolean suspendFlag=false;
    //true attacker , false defender;
    private boolean state;
    private Tactic myTactic;

    public Unit(int health, int damage, int range, int speed, int radius, int price, double shield, double attackSpeed, PositionPair myPosition, int id, Movement movement, boolean state, Tactic myTactic) {
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.radius = radius;
        this.price = price;
        this.shield = shield;
        this.attackSpeed = attackSpeed;
        this.myPosition = myPosition;
        this.id = id;
        this.movement = movement;
        this.state = state;
        this.myTactic = myTactic;
    }


    public Tactic getMyTactic() {
        return myTactic;
    }

    public Unit() {
    }

    public Unit(int radius, PositionPair myPosition) {
        this.radius = radius;
        this.myPosition = myPosition;
    }


    public abstract String draw();

    public int getRadius() {
        return radius;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public PositionPair getMyPosition() {
        return myPosition;
    }

    public boolean isState() {
        return state;
    }

    public void setMyPosition(PositionPair myPosition) {
        this.myPosition = myPosition;
    }

    @Override
    public void run()
    {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("unit "+this.id +" start: ");
        while (this.isAlive()) {

            this.CheckSuspending();

            Unit unitToAttack=null;
            if (myTactic!=null)
                unitToAttack=myTactic.FindUnitToAttack(this);

            if (unitToAttack!=null && unitToAttack.isAlive())
            {
                System.out.println("unit "+this.id +" want to attack: "+unitToAttack.id);
                myTactic.Facing(unitToAttack, this);
            }
            try { Thread.sleep(50); }catch (Exception e) {
                System.out.println("here");
                e.printStackTrace();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void move(Unit goal)
    {
        movement.move(this,goal);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                '}';
    }
    public double getAttackSpeed() {
        return attackSpeed;
    }

    public synchronized void AcceptAttack(int hit) {
        double damage = (hit - hit * this.shield);
        this.health -= damage;
        System.out.println("unit "+this.getId()+" get a total damage: "+damage+" health now is "+ this.getHealth());
    }


    public void Suspend()
    {
        suspendFlag = true;
    }

    public void Resume()
    {
        synchronized (this)
        {
            suspendFlag = false;
            this.notifyAll();
        }
    }

    public void CheckSuspending()
    {
        synchronized (this) {
            while (this.isSuspendFlag()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Exception in CheckSuspending");
                }
            }
        }
    }

    private boolean isSuspendFlag() {
        return suspendFlag;
    }


}