package com.company.GameManagment;
import com.company.Arena.ArenaManager;
import com.company.Factory.UnitFactory;
import com.company.Interfaces.CallBack;
import com.company.Obstacles.River;
import com.company.Obstacles.Vally;
import com.company.PositionPair;
import com.company.Store;
import com.company.Tactics.Attack.RandomAttackTactic;
import com.company.Tactics.Deffend.InRangeTactic;
import com.company.Units.Unit;
import com.company.Team.Team;



public class DODGameManager extends GameManager implements CallBack{
    public static Unit mainBase;
    public static int remainingAttackUnit=100;
    private static DODGameManager instance= new DODGameManager();
    Team[] teams;
    private static UnitFactory unitFactory = new UnitFactory();
    private int coins;
    private DODGameManager(){}

    public static DODGameManager getInstance(){
        return instance;
    }



//    public void SetGame()
//    {
//        int numAttacker,numDefender;
//        System.out.println("How many players in attack team");
//        numAttacker= Tools.isInteger(1,100);
//
//        System.out.println("How many players in defend team");
//        numDefender=Tools.isInteger(1,100);
//
//        Player[] players=new Player[numAttacker];
//        for (int i=0; i<numAttacker; i++)
//        {
//            Player a=new ConsolePlayer(this.coins , 1);
//        }
//    }

    @Override
    public synchronized void GetResult(Unit diedUnit) {

        try {
            System.out.println("..... Unit "+diedUnit.getId()+" died ......");
            Store.allUnits.remove(diedUnit);
            ArenaManager.deleteUnitFromArenaWithRadios(diedUnit.getMyPosition(), diedUnit);
        }
        catch (Exception e)
        { System.out.println("handled"); }
    }

    public void runUnits()
    {
        for (Unit i: Store.allUnits)
        {
            DODGameManager.MyThread a=new MyThread(this , i);
            new Thread(a).start();
        }
    }

    public void PauseGame()
    {
        for (Unit i: Store.allUnits)
        {
            i.Suspend();
        }
    }

    public void ResumeGame()
    {
        for (Unit i: Store.allUnits)
        {
            i.Resume();
        }
    }




    public void start_StaticGame()
    {
        /** UNIT DEFENDER INITIALIZE *
         *                           *
         *                           *
         ****************************/
        mainBase=unitFactory.callunitstatic("MAINBASE",new PositionPair(5000,5000) , null);
        Store.allUnits.add(mainBase);
        ArenaManager.addUnitWithRadius(mainBase);

        Unit patriotright=unitFactory.callunitstatic("PatriotMissileSystem",new PositionPair(5000,5090), new InRangeTactic());
        Store.allUnits.add(patriotright);
        ArenaManager.addUnitWithRadius(patriotright);

        Unit patriotleft=unitFactory.callunitstatic("PatriotMissileSystem",new PositionPair(5000,4910), new InRangeTactic());
        Store.allUnits.add(patriotleft);
        ArenaManager.addUnitWithRadius(patriotleft);

        Unit patriotup=unitFactory.callunitstatic("PatriotMissileSystem",new PositionPair(4910,5000), new InRangeTactic());
        Store.allUnits.add(patriotup);
        ArenaManager.addUnitWithRadius(patriotup);

        Unit patriotdown=unitFactory.callunitstatic("PatriotMissileSystem",new PositionPair(5150,5000), new InRangeTactic());
        Store.allUnits.add(patriotdown);
        ArenaManager.addUnitWithRadius(patriotdown);

        Unit Pillboxdownleft=unitFactory.callunitstatic("Pillbox",new PositionPair(5500,4500), new InRangeTactic());
        Store.allUnits.add(Pillboxdownleft);
        ArenaManager.addUnitWithRadius(Pillboxdownleft);

        Unit Prismdownright=unitFactory.callunitstatic("PrismTower",new PositionPair(5500,5500), new InRangeTactic());
        Store.allUnits.add(Prismdownright);
        ArenaManager.addUnitWithRadius(Prismdownright);

        Unit Prismupleft=unitFactory.callunitstatic("PrismTower",new PositionPair(4500,4500), new InRangeTactic());
        Store.allUnits.add(Prismupleft);
        ArenaManager.addUnitWithRadius(Prismupleft);

        Unit Pillboxuprigt=unitFactory.callunitstatic("Pillbox",new PositionPair(4500,5500), new InRangeTactic());
        Store.allUnits.add(Pillboxuprigt);
        ArenaManager.addUnitWithRadius(Pillboxuprigt);

        Unit Grandrigt=unitFactory.callunitstatic("GrandCannon",new PositionPair(5000,5500), new InRangeTactic());
        Store.allUnits.add(Grandrigt);
        ArenaManager.addUnitWithRadius(Grandrigt);

        Unit Grandextrarigt=unitFactory.callunitstatic("GrandCannon",new PositionPair(5000,5700), new InRangeTactic());
        Store.allUnits.add(Grandextrarigt);
        ArenaManager.addUnitWithRadius(Grandextrarigt);

        Unit Grandleft=unitFactory.callunitstatic("GrandCannon",new PositionPair(5000,4500), new InRangeTactic());
        Store.allUnits.add(Grandleft);
        ArenaManager.addUnitWithRadius(Grandleft);

        Unit Grandup=unitFactory.callunitstatic("GrandCannon",new PositionPair(4300,5000), new InRangeTactic());
        Store.allUnits.add(Grandup);
        ArenaManager.addUnitWithRadius(Grandup);

        Unit Granddown=unitFactory.callunitstatic("GrandCannon",new PositionPair(5700,5000), new InRangeTactic());
        Store.allUnits.add(Granddown);
        ArenaManager.addUnitWithRadius(Granddown);

        Unit Miragetankdownrigt=unitFactory.callunitstatic("MirageTank Defender",new PositionPair(5250,5500) , new InRangeTactic());
        Store.allUnits.add(Miragetankdownrigt);
        ArenaManager.addUnitWithRadius(Miragetankdownrigt);

        Unit Miragetankdownleft=unitFactory.callunitstatic("MirageTank Defender",new PositionPair(5250,4500) , new InRangeTactic());
        Store.allUnits.add(Miragetankdownleft);
        ArenaManager.addUnitWithRadius(Miragetankdownleft);

        Unit Miragetankupleft=unitFactory.callunitstatic("MirageTank Defender",new PositionPair(4750,4500) , new InRangeTactic());
        Store.allUnits.add(Miragetankupleft);
        ArenaManager.addUnitWithRadius(Miragetankupleft);

        Unit Miragetankupright=unitFactory.callunitstatic("MirageTank Defender",new PositionPair(4750,5500) , new InRangeTactic());
        Store.allUnits.add(Miragetankupright);
        ArenaManager.addUnitWithRadius(Miragetankupright);

        Unit Grizzlytankdown1=unitFactory.callunitstatic("GrizzlyTank Defender",new PositionPair(5500,4900) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankdown1);
        ArenaManager.addUnitWithRadius(Grizzlytankdown1);

        Unit Grizzlytankdown2=unitFactory.callunitstatic("GrizzlyTank Defender",new PositionPair(5500,5000) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankdown2);
        ArenaManager.addUnitWithRadius(Grizzlytankdown2);

        Unit Grizzlytankdown3=unitFactory.callunitstatic("GrizzlyTank Defender",new PositionPair(5500,5100) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankdown3);
        ArenaManager.addUnitWithRadius(Grizzlytankdown3);

        Unit Grizzlytankup1=unitFactory.callunitstatic("GrizzlyTank Defender",new PositionPair(4500,4900)  , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankup1);
        ArenaManager.addUnitWithRadius(Grizzlytankup1);

        Unit Grizzlytankup2=unitFactory.callunitstatic("GrizzlyTank Defender",new PositionPair(4500,5000)  , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankup2);
        ArenaManager.addUnitWithRadius(Grizzlytankup2);

        Unit Grizzlytankup3=unitFactory.callunitstatic("GrizzlyTank Defender",new PositionPair(4500,5100)  , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankup3);
        ArenaManager.addUnitWithRadius(Grizzlytankup3);

        Unit NavySealdown1=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(5800,4900) , new InRangeTactic());
        Store.allUnits.add(NavySealdown1);
        ArenaManager.addUnitWithRadius(NavySealdown1);

        Unit NavySealdown2=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(5800,5000) , new InRangeTactic());
        Store.allUnits.add(NavySealdown2);
        ArenaManager.addUnitWithRadius(NavySealdown2);

        Unit NavySealdown3=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(5800,5100) , new InRangeTactic());
        Store.allUnits.add(NavySealdown3);
        ArenaManager.addUnitWithRadius(NavySealdown3);

        Unit NavySealup1=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(4200,4900) , new InRangeTactic());
        Store.allUnits.add(NavySealup1);
        ArenaManager.addUnitWithRadius(NavySealup1);

        Unit NavySealup2=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(4200,5000) , new InRangeTactic());
        Store.allUnits.add(NavySealup2);
        ArenaManager.addUnitWithRadius(NavySealup2);

        Unit NavySealup3=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(4200,5100) , new InRangeTactic());
        Store.allUnits.add(NavySealup3);
        ArenaManager.addUnitWithRadius(NavySealup3);

        Unit NavySealrigt1=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(4900,5800) , new InRangeTactic());
        Store.allUnits.add(NavySealrigt1);
        ArenaManager.addUnitWithRadius(NavySealrigt1);

        Unit NavySealrigt2=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(5000,5800) , new InRangeTactic());
        Store.allUnits.add(NavySealrigt2);
        ArenaManager.addUnitWithRadius(NavySealrigt2);

        Unit NavySealrigt3=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(5100,5800) , new InRangeTactic());
        Store.allUnits.add(NavySealrigt3);
        ArenaManager.addUnitWithRadius(NavySealrigt3);

        Unit NavySealleft1=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(4900,4200) , new InRangeTactic());
        Store.allUnits.add(NavySealleft1);
        ArenaManager.addUnitWithRadius(NavySealleft1);

        Unit NavySealleft2=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(5000,4200) , new InRangeTactic());
        Store.allUnits.add(NavySealleft2);
        ArenaManager.addUnitWithRadius(NavySealleft2);

        Unit NavySealleft3=unitFactory.callunitstatic("NavySEAL Defender",new PositionPair(5100,4200) , new InRangeTactic());
        Store.allUnits.add(NavySealleft3);
        ArenaManager.addUnitWithRadius(NavySealleft3);


        /** UNIT ATTACKER INITIALIZE *
         *                           *
         *                           *
         ****************************/

        Unit teslatankdown1=unitFactory.callunitstatic("Tesla Attack",new PositionPair(6500,4500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankdown1);
        ArenaManager.addUnitWithRadius(teslatankdown1);

        Unit teslatankdown2=unitFactory.callunitstatic("Tesla Attack",new PositionPair(6500,4750) , new RandomAttackTactic());
        Store.allUnits.add(teslatankdown2);
        ArenaManager.addUnitWithRadius(teslatankdown2);

        Unit teslatankdown3=unitFactory.callunitstatic("Tesla Attack",new PositionPair(6500,5000) , new RandomAttackTactic());
        Store.allUnits.add(teslatankdown3);
        ArenaManager.addUnitWithRadius(teslatankdown3);

        Unit teslatankdown4=unitFactory.callunitstatic("Tesla Attack",new PositionPair(6500,5250) , new RandomAttackTactic());
        Store.allUnits.add(teslatankdown4);
        ArenaManager.addUnitWithRadius(teslatankdown4);

        Unit teslatankdown5=unitFactory.callunitstatic("Tesla Attack",new PositionPair(6500,5500) ,new RandomAttackTactic());
        Store.allUnits.add(teslatankdown5);
        ArenaManager.addUnitWithRadius(teslatankdown5);

        Unit teslatankleft1=unitFactory.callunitstatic("Tesla Attack",new PositionPair(4500,3500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankleft1);
        ArenaManager.addUnitWithRadius(teslatankleft1);

        Unit teslatankleft2=unitFactory.callunitstatic("Tesla Attack",new PositionPair(4750,3500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankleft2);
        ArenaManager.addUnitWithRadius(teslatankleft2);

        Unit teslatankleft3=unitFactory.callunitstatic("Tesla Attack",new PositionPair(5000,3500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankleft3);
        ArenaManager.addUnitWithRadius(teslatankleft3);

        Unit teslatankleft4=unitFactory.callunitstatic("Tesla Attack",new PositionPair(5250,3500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankleft4);
        ArenaManager.addUnitWithRadius(teslatankleft4);

        Unit teslatankleft5=unitFactory.callunitstatic("Tesla Attack",new PositionPair(5500,3500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankleft5);
        ArenaManager.addUnitWithRadius(teslatankleft5);

        Unit teslatankup1=unitFactory.callunitstatic("Tesla Attack",new PositionPair(3500,4500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankup1);
        ArenaManager.addUnitWithRadius(teslatankup1);

        Unit teslatankup2=unitFactory.callunitstatic("Tesla Attack",new PositionPair(3500,4750) , new RandomAttackTactic());
        Store.allUnits.add(teslatankup2);
        ArenaManager.addUnitWithRadius(teslatankup2);

        Unit teslatankup3=unitFactory.callunitstatic("Tesla Attack",new PositionPair(3500,5000) , new RandomAttackTactic());
        Store.allUnits.add(teslatankup3);
        ArenaManager.addUnitWithRadius(teslatankup3);

        Unit teslatankup4=unitFactory.callunitstatic("Tesla Attack",new PositionPair(3500,5250) , new RandomAttackTactic());
        Store.allUnits.add(teslatankup4);
        ArenaManager.addUnitWithRadius(teslatankup4);

        Unit teslatankup5=unitFactory.callunitstatic("Tesla Attack",new PositionPair(3500,5500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankup5);
        ArenaManager.addUnitWithRadius(teslatankup5);

        Unit teslatankright1=unitFactory.callunitstatic("Tesla Attack",new PositionPair(4500,6500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankright1);
        ArenaManager.addUnitWithRadius(teslatankright1);

        Unit teslatankright2=unitFactory.callunitstatic("Tesla Attack",new PositionPair(4750,6500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankright2);
        ArenaManager.addUnitWithRadius(teslatankright2);

        Unit teslatankright3=unitFactory.callunitstatic("Tesla Attack",new PositionPair(5000,6500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankright3);
        ArenaManager.addUnitWithRadius(teslatankright3);

        Unit teslatankright4=unitFactory.callunitstatic("Tesla Attack",new PositionPair(5250,6500) , new RandomAttackTactic());
        Store.allUnits.add(teslatankright4);
        ArenaManager.addUnitWithRadius(teslatankright4);

        Unit teslatankright5=unitFactory.callunitstatic("Tesla Attack",new PositionPair(5500,6500) ,new RandomAttackTactic());
        Store.allUnits.add(teslatankright5);
        ArenaManager.addUnitWithRadius(teslatankright5);

        Unit prismtankdown1=unitFactory.callunitstatic("Prism Tank Attack",new PositionPair(6750,5500) , new RandomAttackTactic());
        Store.allUnits.add(prismtankdown1);
        ArenaManager.addUnitWithRadius(prismtankdown1);

        Unit Grizzlytankdownattack1=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(6750,4750) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankdownattack1);
        ArenaManager.addUnitWithRadius(Grizzlytankdownattack1);

        Unit Grizzlytankdownattack2=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(6750,5000) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankdownattack2);
        ArenaManager.addUnitWithRadius(Grizzlytankdownattack2);

        Unit Grizzlytankdownattack3=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(6750,5250) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankdownattack3);
        ArenaManager.addUnitWithRadius(Grizzlytankdownattack3);

        Unit prismtankdown2=unitFactory.callunitstatic("Prism Tank Attack",new PositionPair(6750,4500) , new RandomAttackTactic());
        Store.allUnits.add(prismtankdown2);
        ArenaManager.addUnitWithRadius(prismtankdown2);

        Unit Grizzlytankleftattack1=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(4750,3250) ,new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankleftattack1);
        ArenaManager.addUnitWithRadius(Grizzlytankleftattack1);

        Unit Grizzlytankleftattack2=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(5000,3250) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankleftattack2);
        ArenaManager.addUnitWithRadius(Grizzlytankleftattack2);

        Unit Grizzlytankleftattack3=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(5250,3250) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankleftattack3);
        ArenaManager.addUnitWithRadius(Grizzlytankleftattack3);

        Unit Grizzlytankupattack1=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(3250,4750) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankupattack1);
        ArenaManager.addUnitWithRadius(Grizzlytankupattack1);

        Unit Grizzlytankupattack2=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(3250,5000) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankupattack2);
        ArenaManager.addUnitWithRadius(Grizzlytankupattack2);

        Unit Grizzlytankupattack3=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(3250,5250) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankupattack3);
        ArenaManager.addUnitWithRadius(Grizzlytankupattack3);

        Unit prismtankright1=unitFactory.callunitstatic("Prism Tank Attack",new PositionPair(4500,6750) , new RandomAttackTactic());
        Store.allUnits.add(prismtankright1);
        ArenaManager.addUnitWithRadius(prismtankright1);

        Unit Grizzlytankrightattack1=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(4750,6750) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankrightattack1);
        ArenaManager.addUnitWithRadius(Grizzlytankrightattack1);

        Unit Grizzlytankrightattack2=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(5000,6750) , new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankrightattack2);
        ArenaManager.addUnitWithRadius(Grizzlytankrightattack2);

        Unit Grizzlytankrightattack3=unitFactory.callunitstatic("GrizzlyTank Attack",new PositionPair(5250,6750) ,new RandomAttackTactic());
        Store.allUnits.add(Grizzlytankrightattack3);
        ArenaManager.addUnitWithRadius(Grizzlytankrightattack3);

        Unit prismtankright2=unitFactory.callunitstatic("Prism Tank Attack",new PositionPair(5500,6750) , new RandomAttackTactic());
        Store.allUnits.add(prismtankright2);
        ArenaManager.addUnitWithRadius(prismtankright2);

        Unit MirageTankdown1=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(7250,4750) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankdown1);
        ArenaManager.addUnitWithRadius(MirageTankdown1);

        Unit MirageTankdown2=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(7250,5000) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankdown2);
        ArenaManager.addUnitWithRadius(MirageTankdown2);

        Unit MirageTankdown3=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(7250,5250) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankdown3);
        ArenaManager.addUnitWithRadius(MirageTankdown3);

        Unit MirageTankright1=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(4750,7250) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankright1);
        ArenaManager.addUnitWithRadius(MirageTankright1);

        Unit MirageTankright2=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(5000,7250) ,new RandomAttackTactic());
        Store.allUnits.add(MirageTankright2);
        ArenaManager.addUnitWithRadius(MirageTankright2);

        Unit MirageTankright3=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(5250,7250) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankright3);
        ArenaManager.addUnitWithRadius(MirageTankright3);

        Unit MirageTankup1=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(2750,4750) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankup1);
        ArenaManager.addUnitWithRadius(MirageTankup1);

        Unit MirageTankup2=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(2750,5000) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankup2);
        ArenaManager.addUnitWithRadius(MirageTankup2);

        Unit MirageTankup3=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(2750,5250) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankup3);
        ArenaManager.addUnitWithRadius(MirageTankup3);

        Unit MirageTankleft1=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(4750,2750) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankleft1);
        ArenaManager.addUnitWithRadius(MirageTankleft1);

        Unit MirageTankleft2=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(5000,2750) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankleft2);
        ArenaManager.addUnitWithRadius(MirageTankleft2);


        Unit MirageTankleft3=unitFactory.callunitstatic("MirageTank Attack",new PositionPair(5250,2750) , new RandomAttackTactic());
        Store.allUnits.add(MirageTankleft3);
        ArenaManager.addUnitWithRadius(MirageTankleft3);

        River river4=new River(new PositionPair(5250,4950),50);
        ArenaManager.addObstacleWithRadius(river4);
        Store.allObstacles.add(river4);

        River river1=new River(new PositionPair(5250,5000),50);
        ArenaManager.addObstacleWithRadius(river1);
        Store.allObstacles.add(river1);


        River river2=new River(new PositionPair(5250,5050),50);
        ArenaManager.addObstacleWithRadius(river2);
        Store.allObstacles.add(river2);

        River river3=new River(new PositionPair(5250,5100),50);
        ArenaManager.addObstacleWithRadius(river3);
        Store.allObstacles.add(river3);


        Vally vally1=new Vally(new PositionPair(5000,4800),40);
        ArenaManager.addObstacleWithRadius(vally1);
        Store.allObstacles.add(vally1);

        Vally vally2=new Vally(new PositionPair(5070,4800),40);
        ArenaManager.addObstacleWithRadius(vally2);
        Store.allObstacles.add(vally2);

        Vally vally3=new Vally(new PositionPair(5140,4800),40);
        ArenaManager.addObstacleWithRadius(vally3);
        Store.allObstacles.add(vally3);



        Unit Blackeagledown1=unitFactory.callunitstatic("BlackEagle",new PositionPair(100,5000) , new RandomAttackTactic());
        Store.allUnits.add(Blackeagledown1);

//        Unit Blackeagledown2=obj.callunitstatic("BlackEagle",new PositionPair(8000,5000) , new RandomAttackTactic());
//        Store.allUnits.add(Blackeagledown2);

//        Unit Blackeagledown3=obj.callunitstatic("BlackEagle",new PositionPair(5000,100 ),new RandomAttackTactic());
//        Store.allUnits.add(Blackeagledown3);

//        Unit Blackeagledown4=obj.callunitstatic("BlackEagle",new PositionPair(5000,8000) , new RandomAttackTactic());
//        Store.allUnits.add(Blackeagledown4);
    }


    private class MyThread implements Runnable {
        CallBack callBack;
        Unit unitToRun;

        private MyThread(CallBack callBack, Unit unitToRun) {
            this.callBack = callBack;
            this.unitToRun = unitToRun;
        }

        @Override
        public void run() {
            this.runUnit();
        }

        private void runUnit() {
            Thread unitThread = new Thread(unitToRun);
            unitThread.start();

            try {
                unitThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.callBack.GetResult(unitToRun);
        }
    }
}
