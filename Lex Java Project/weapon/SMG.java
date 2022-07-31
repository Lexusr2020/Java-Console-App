package weapon;

public class SMG extends Weapon
{
    private int damage = 80;
    private int hitChance = 30; // base 30% chance
    private String type= "SMG";

    public SMG()
    {
        super();
        super.SetWeaponDamage(damage);
    }

    public String GetType()
    {
        return this.type;
    }

    @Override 
    public int Strike(int dex, int strength)
    {
        int damageAmount = 0;
        if(randNum.nextInt(100) + 1 <= (hitChance + (dex / 14)))
        {
            damageAmount += strength / 14;
        }
        else
        {
            // do nothing
        }
        return damageAmount;
    }
    
}