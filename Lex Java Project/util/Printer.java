package util;



import legend.*;


public class Printer 
{
    // BACKGROUND COLORS
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    // TEXT COLORS
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    // HIGH INTESITY BACKGROUND
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";

    
    
    private String[][] menus = {
        { "Loba", "Lifeline", "Octane", "Wraith" },
        { "Rare", "Epic", "Legendary", "Gold" },
        { "Pistol", "Shotgun", "SMG", "LMG" }
    };

    public Printer() {}

    public void WelcomeMessage() 
    {
        System.out.println(RED_BACKGROUND_BRIGHT + ANSI_BLACK +"======================================================================================================================\n----------------------------------------------------------------------------------------------------------------------");
        System.out.println("================================              Welcome to APEX Legends               ==================================\n--------------------------------             the pc version from 1970               ----------------------------------");
        System.out.println("======================================================================================================================\n" + ANSI_RESET);
    }
    public void NameYourLegend()
    {
        System.out.println("What would you like to call your Legend?\nPlease enter a name: ");    
    }

    public void PrintLegendChoices() 
    {
        System.out.println("Pick your legend:");
        int rowToPrint = 0; // warrior row
        for(int col = 0; col < menus[rowToPrint].length; col++)
        {
            System.out.println(col + 1 + ") " + menus[rowToPrint][col]);
        }
    }
    public void PrintArmourChoices() 
    {
        System.out.println("Pick your armour: ");
        int rowToPrint = 1; // armour row
        for(int col = 0; col < menus[rowToPrint].length; col++)
        {
            System.out.println(col + 1 + ") " + menus[rowToPrint][col]);
        }
    }
    public void PrintWeaponChoices() 
    {
        System.out.println("Pick your weapon: ");
        int rowToPrint = 2; // weapon row
        for(int col = 0; col < menus[rowToPrint].length; col++)
        {
            System.out.println(col + 1 + ") " + menus[rowToPrint][col]);
        }
    }

    public void PrintStartingStats(Legend pWarrior, Legend eWarrior, String type)
    {
        
        System.out.println("Your Legend is now " + ANSI_CYAN + "== " + type + " ==" + ANSI_RESET);
        System.out.println("Your Health is: " + pWarrior.GetHealth() + "\n");
        System.out.println("Your enemy's health is: " + eWarrior.GetHealth() + "\n");
    }
    
    public void YourLegend(Legend type)
    {
        System.out.println("Your legend is now : " + type);    
    }
    public void PrintAttackTypes(int pTurn)
    {
        
        if(pTurn == 6)
        {
            System.out.println(ANSI_YELLOW + "You have survived 6 rounds and have earned a super attack" + ANSI_RESET);
            System.out.println("1) for a basic attack \n2) for a heavy attack \n3) Super attack");
        }   
            else if(pTurn == 12)
            {
                System.out.println(ANSI_YELLOW + "You have survived 12 rounds and have earned a super attack" + ANSI_RESET);
                System.out.println("1) for a basic attack \n2) for a heavy attack \n3) Super attack");
            }
                else if(pTurn == 18)
                {
                    System.out.println(ANSI_YELLOW + "You have survived 18 rounds and have earned a super attack" + ANSI_RESET);
                System.out.println("1) for a basic attack \n2) for a heavy attack \n3) Super attack");
                }  
        else
        {
            System.out.println("What type of attack would you like to perform?");
            System.out.println("1) for a basic attack \n2) for a heavy attack");
        }
        
    }
    public void PrintEnemyChoice(int eChoice)
    {
        if(eChoice == 1)
        {
            System.out.println("Enemy selects basic attack");
        }
        else
        {
            System.out.println(ANSI_RED + "Enemy selects heavy attack!" + ANSI_RESET);
        }
    }
    public void PrintPlayerChoice(int pChoice, String type)
    {
        if(pChoice == 1)
        {
            System.out.println(ANSI_CYAN + type + ANSI_RESET+  " selects basic attack\n");
        }
        if(pChoice == 3)
        {
            System.out.println(ANSI_CYAN + type + ANSI_RESET + ANSI_YELLOW + " selects SUPER attack!\n" + ANSI_RESET);
        }
        else
        {
            System.out.println(ANSI_CYAN + type + ANSI_RESET + ANSI_RED + " selects heavy attack!\n" + ANSI_RESET);
        }
    }
    public void PrintMissMessage(boolean isPlayer, String type)
    {
        if(isPlayer)
        {
            System.out.println(ANSI_CYAN + type + ANSI_RESET+" misses!\n");
        }
        else
        {
            System.out.println("Enemy misses!\n");
        }
    }
    public void PrintHitMessage(boolean isPlayer, int damage, String type)
    {
        if(isPlayer)
        {
            System.out.println(ANSI_CYAN + type + ANSI_RESET+" hits for " + damage + " damage!\n");
        }
        else
        {
            System.out.println("Enemy hits for " + damage + " damage!\n");
        }
    }
    public void PrintBigHitMessage(boolean isPlayer, int damage, String type)
    {
        if(isPlayer)
        {
            System.out.println(ANSI_RED_BACKGROUND + "==== Huge Damage!!! ==== " + ANSI_RESET);
        }
        else
        {
            System.out.println(ANSI_RED_BACKGROUND + "==== Huge Damage!!! ====" + ANSI_RESET);
        }
    }
    public void PrintSurrenderMessage(boolean isPlayer, int pChoice, String type)
    {
        System.out.println(ANSI_CYAN + type + ANSI_RESET+", Your health is less than 10, would you like to surrender? \n1)  Yes  \n2)  No");
        
    }

    public void PrintWinMessage(boolean isPlayer, String type, int eTurn, int pTurn, int pTotalDamage, int eTotalDamage)
    {
        if(isPlayer)
        {   
            System.out.println(ANSI_RED_BACKGROUND + "Game Over\n" + ANSI_RESET +  "\n" + ANSI_CYAN + type + ANSI_RESET+ ANSI_YELLOW + ANSI_RESET+ " Wins! in " + pTurn + " turns. Total damage done : " + pTotalDamage + "\n");
        }
        else
        {
            System.out.println(ANSI_RED_BACKGROUND + "Game Over\n" + ANSI_RESET + "\n" + ANSI_BLUE + "Enemy " + ANSI_RESET +" Wins! in " + eTurn + " turns. Total damage done : " + eTotalDamage + "\n");
        }
    }
    public void PrintPlayAgainMessage(boolean isPlayer)
    {
        System.out.println("Would you like to play again ?\n1) Yes \n2) No");
    }
    
}