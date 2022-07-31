package legend;

public class Wraith extends Legend
{
    private int minHealth = 70;
    private int highHealth = 170;
    private int minDexterity = 30;
    private int highDexterity = 50;
    private int minStrength = 120;
    private int highStrength = 180;
    private String type = "Wraith";

    public Wraith() 
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