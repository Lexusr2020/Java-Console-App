package armour;

public class Gold extends Armour
{
    private int minPoints = 140;
    private int maxPoints = 210;
    private int minDexCost = 14;
    private int maxDexCost = 20;
    private String type = "Gold";

    public Gold()
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
