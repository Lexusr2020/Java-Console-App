package armour;

public class Legendary extends Armour
{
    private int minPoints = 120;
    private int maxPoints = 190;
    private int minDexCost = 12;
    private int maxDexCost = 18;
    private String type = "Legendary";

    public Legendary()
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