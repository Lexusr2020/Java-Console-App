package legend;

import java.util.Random;

public abstract class Legend 
{
    protected Random randNum = new Random();
    private int health;
    private int dexterity;
    private int strength;


    public Legend() {}

    // getters
    public int GetHealth() 
    {
        return this.health;
    }
    public int GetDexterity() 
    {
        return this.dexterity;
    }
    public int GetStrength() 
    {
        return this.strength;
    }
    

    // setters
    public void SetHealth(int health) 
    {
        this.health = health;
    }
    public void SetDexterity(int dexterity) 
    {
        this.dexterity = dexterity;
    }
    public void SetStrength(int strength) 
    {
        this.strength = strength;
    }
    public void TakeDamage(int damage)
    {
        if(damage > 0)
            this.health -= damage;
            
    }
    
}