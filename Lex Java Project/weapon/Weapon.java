

package weapon;

import java.util.Random;

public abstract class Weapon 
{
    protected Random randNum = new Random();
    private int weaponDamage;

    public Weapon() {}

    public int GetWeaponDamage()
    {
        return this.weaponDamage;
    }
   
    public void SetWeaponDamage(int damage)
    {
        this.weaponDamage = damage;
    }
    

    // poloymorphic method
    public abstract int Strike(int dex, int strength);
}