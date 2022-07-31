package weapon;

public class LMG extends Weapon
{
    private int damage = 65;
    private int hitChance = 50; // base 60% chance
    private String type= "LGM";

    public LMG()
    {
        super();
        super.SetWeaponDamage(damage);
    }

    public String GetType()
    {
        return this.type;
    }

    @Override 
    public int Strike(int dex, int strength) // 50
    {
        int damageAmount = 0;
        if(randNum.nextInt(100) + 1 <= (hitChance + (dex / 11)))
        {
            damageAmount += strength / 11; // 150 = 15
        }
        else
        {
            // do nothing
        }
        return damageAmount;
    }
}
