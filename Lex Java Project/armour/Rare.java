package armour;

public class Rare extends Armour
{
    private int minPoints = 30;
    private int maxPoints = 60;
    private int minDexCost = 5;
    private int maxDexCost = 7;
    private String type = "Rare";

    public Rare()
    {
        super();
        super.SetArmourPoints(randNum.nextInt(maxPoints) + minPoints);
        super.SetDexCost(randNum.nextInt(maxDexCost) + minDexCost);
    }

    public String GetType()
    {
        return this.type;
    }
}