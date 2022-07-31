package weapon;

public class Shotgun extends Weapon
{
    private int damage = 80;
    private int hitChance = 45; // base 45% chance
    private String type= "Shotgun";

    public Shotgun()
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
        if(randNum.nextInt(100) + 1 <= (hitChance + (dex / 11)))
        {
            damageAmount += strength / 11;
        }
        else
        {
            // do nothing
        }
        return damageAmount;
    }

    
   
    
}