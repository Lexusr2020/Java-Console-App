package armour;

import java.util.Random;

public abstract class Armour 
{
    protected Random randNum = new Random();
    private int armourPoints;
    private int dexCost;

    public Armour() {}

    // getters
    public int GetArmourPoints()
    {
        return this.armourPoints;
    }
    public int GetDexCost()
    {
        return this.dexCost;
    }

    // setters
    public void SetArmourPoints(int points)
    {
        this.armourPoints = points;
    }
    public void SetDexCost(int cost)
    {
        this.dexCost = cost;
    }
}
