package armour;

public class Epic extends Armour
{
    private int minPoints = 70;
    private int maxPoints = 100;
    private int minDexCost = 8;
    private int maxDexCost = 10;
    private String type = "Epic";

    public Epic()
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