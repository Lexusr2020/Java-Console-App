package legend;

public class Loba extends Legend
{
    private int minHealth = 50;
    private int highHealth = 100;
    private int minDexterity = 50;
    private int highDexterity = 100;
    private int minStrength = 50;
    private int highStrength = 100;
    private String type = "Loba";
    private String name;

    public Loba() 
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
    public String GetName()
    {
        return this.name;
    }
}