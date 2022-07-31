package legend;

public class Lifeline extends Legend
{
    private int minHealth = 30;
    private int highHealth = 70;
    private int minDexterity = 70;
    private int highDexterity = 130;
    private int minStrength = 50;
    private int highStrength = 100;
    private String type = "Lifeline";

    public Lifeline() 
    {
        super();
        super.SetHealth(randNum.nextInt(highHealth) + minHealth); // 50 - 149
        super.SetDexterity(randNum.nextInt(highDexterity) + minDexterity); // 50 - 149
        super.SetStrength(randNum.nextInt(highStrength) + minStrength); // 50 - 149
    }

    public String GetType()
    {
        return this.type;
    }
}