

import util.*;
import armour.*;
import legend.*;
import weapon.*;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class ApexLegendsMain 
{
    private static Scanner input = new Scanner(System.in);
    private static Random randNum = new Random();
    public static int min = 0;
    public static int max = 2;
    

    private static Printer printer = new Printer();
    private static boolean gameOver = false;
    private static boolean playerTurn = true;
    private static boolean enemyTurn = false;
    private static int heavyAttackMod = 10;
    private static int superAttackMod = 20;
    public static boolean valueBad = true;

    // player
    public static boolean playAgain=false;
    public static int pTurn = 1;
    private static int pChoice;
    private static int pDamage;
    private static int pTotalDamage = 0;
    private static Legend pLegend;
    private static Armour pArmour;
    private static Weapon pWeapon;

    // computer
    public static int eTurn = 1;
    private static int eChoice;
    private static int eDamage;
    private static int eTotalDamage = 0;
    private static Legend eLegend;
    private static Armour eArmour;
    private static Weapon eWeapon;
     

    public static void main(String[] agrs)
    {
        
        playAgain = true;

        printer.WelcomeMessage();
        printer.NameYourLegend();
        String type = input.nextLine();
        

        
        ///////////////////////////////////////
        // Player Setup Section
        // warrior selectionboolean valueBad = true; 
        //input validation. checking for false inputs like a letter instead of a integer
        do {        //try catch start
            try{
                    printer.PrintLegendChoices();
                    pChoice = input.nextInt();
                    if(pChoice >=1 && pChoice <=4)
                    {
                        valueBad = false; // allows us to exit the do..while loop
                    }
            }
            catch(InputMismatchException e) {
                input.nextLine();
                valueBad = true;
            }
        } while(valueBad == true);
        CreateLegend(pChoice, playerTurn); //try catch ends here 
    
        ///////////////////////////////////////
        // Armour selection
        do {        //try catch start
            try{
                    printer.PrintArmourChoices();
                    pChoice = input.nextInt();    
                    if(pChoice >=1 && pChoice <=4)
                    {
                        valueBad = false; 
                    }
            }
            catch(InputMismatchException e) {
                input.nextLine();
                valueBad = true;
            }
        } while(valueBad == true);
        CreateArmour(pChoice, playerTurn);  //try catch ends here 
             
        ///////////////////////////////////////
        // Weapon selection
        do {        //try catch start
            try{
                    printer.PrintWeaponChoices();
                    pChoice = input.nextInt();    
                    if(pChoice >=1 && pChoice <=4)
                    {
                        valueBad = false; 
                    }
            }
            catch(InputMismatchException e) {
                input.nextLine();
                valueBad = true;
            }
        } while(valueBad == true);
        CreateWeapon(pChoice, playerTurn);  //try catch ends here   
        
        playerTurn = false;
        //////////////////////////////////////
        // Enemy Setup Section
        CreateLegend(randNum.nextInt(4) + 1, playerTurn); // warrior
        CreateArmour(randNum.nextInt(4) + 1, playerTurn); // armour
        CreateWeapon(randNum.nextInt(4) + 1, playerTurn); // weapon
        
        playerTurn = true;

        //////////////////////////////////////
        // Print initial warrior stats
        
        printer.PrintStartingStats(pLegend, eLegend, type);
        

        ////////////////////////
        // Main Game Loop!
        while(!gameOver)
        {
            
            // print stats for each turn
            if(playerTurn) // players turn
            {
                
                pTurn++;
                printer.PrintAttackTypes(pTurn);
                pChoice = input.nextInt();
                printer.PrintPlayerChoice(pChoice, type);

                if(pChoice == 1) // basic attack
                {
                    pDamage = pWeapon.Strike(pLegend.GetDexterity(), pLegend.GetStrength());
                }
                if(pChoice == 3)
                {
                    pDamage = pWeapon.Strike(pLegend.GetDexterity() - heavyAttackMod, 
                        pLegend.GetStrength() + superAttackMod); 
                }
                else // heavy attack
                {
                    pDamage = pWeapon.Strike(pLegend.GetDexterity() - heavyAttackMod, 
                        pLegend.GetStrength() + heavyAttackMod);
                }
                if(pDamage >= 0)
                {
                    pTotalDamage = (pDamage + pTotalDamage);     
                }
                
                    if(pDamage >= 15)
                    {
                        printer.PrintBigHitMessage(playerTurn, pDamage, type);
                    }

                    if(pDamage <= 0) // missed
                    {
                        printer.PrintMissMessage(playerTurn, type);
                        
                    }
                    else // hit!
                    {
                        printer.PrintHitMessage(playerTurn, pDamage, type);
                        eLegend.TakeDamage(pDamage);
                        
                        if(pLegend.GetHealth() <=20)
                        {
                            printer.PrintSurrenderMessage(playerTurn, pChoice, type);
                            pChoice = input.nextInt();
                            if(pChoice == 1)
                            {
                                enemyTurn = true;
                                
                                printer.PrintWinMessage(!playerTurn, type, pTurn, eTurn, pTotalDamage, eTotalDamage);
                                
                                gameOver = true;   
                            }
                            else
                            {//do nothing
                                
                            }
                        }
                        if(eLegend.GetHealth() <= 0)
                        {
                            printer.PrintWinMessage(playerTurn, type, pTurn, eTurn, pTotalDamage, eTotalDamage);
                            
                            gameOver = true;
                        }
                        else
                        {// do nothing enemy is still kickin.
                        
                        }
                    }
            } // players turn ends here

            else // enemys turn
            {
                // enemy randomly chooses and attack type
                // 1) basic 2) heavy
                
                eTurn++;
                eChoice = randNum.nextInt(max + min) + 1;
                printer.PrintEnemyChoice(eChoice);
                
                // if basic attack, call strike with no mods
                if(eChoice == min) // basic attack
                {
                    eDamage = eWeapon.Strike(eLegend.GetDexterity(), eLegend.GetStrength());
                }
                else // heavy attack
                {
                    eDamage = eWeapon.Strike(eLegend.GetDexterity() - heavyAttackMod, 
                    eLegend.GetStrength() + heavyAttackMod);
                }
                if(eDamage >= 0)
                {
                    eTotalDamage = (eDamage + eTotalDamage);       
                }
                if(eDamage >= 15)
                    {
                        printer.PrintBigHitMessage(enemyTurn, eDamage, type);
                    }

                if(eDamage <= 0) // missed
                {
                    // player misses!
                    printer.PrintMissMessage(enemyTurn, type);
                    
                }
                else // hit!
                {   
                    // get the damage amount back from strike
                    printer.PrintHitMessage(enemyTurn, eDamage, type);
                    // take the damage amount from the enemies health
                    pLegend.TakeDamage(eDamage); 
                    // if damage == 0 // miss
                    
                    // no change
                    // end true
                    if(pLegend.GetHealth() <= 0)
                    {
                        //print game over
                        gameOver = true;
                        printer.PrintWinMessage(enemyTurn, type, pTurn, eTurn, pTotalDamage, eTotalDamage);
                        
                        playerTurn = false;   
                    }
                    else
                    {// do nothing player is still kickin.
                        
                    }
                }// hit
            
            }// enemy turn
            if(gameOver == true)
            {// PLAY AGAIN
                
                printer.PrintPlayAgainMessage(playerTurn);
                pChoice = input.nextInt();
                if(pChoice == 1)
                {
                    
                    playAgain = true;
                    enemyTurn = false;
                    playerTurn = true;
                    gameOver = false;

                    do {        //try catch start
                        try{
                                printer.PrintLegendChoices();
                                pChoice = input.nextInt();
                                if(pChoice >=1 && pChoice <=4)
                                {
                                    valueBad = false; // allows us to exit the do..while loop
                                }
                        }
                        catch(InputMismatchException e) {
                            input.nextLine();
                            valueBad = true;
                        }
                    } while(valueBad == true);
                    CreateLegend(pChoice, playerTurn); //try catch ends here 
                
                    ///////////////////////////////////////
                    // Armour selection
                    do {        //try catch start
                        try{
                                printer.PrintArmourChoices();
                                pChoice = input.nextInt();    
                                if(pChoice >=1 && pChoice <=4)
                                {
                                    valueBad = false; 
                                }
                        }
                        catch(InputMismatchException e) {
                            input.nextLine();
                            valueBad = true;
                        }
                    } while(valueBad == true);
                    CreateArmour(pChoice, playerTurn);  //try catch ends here 
                         
                    ///////////////////////////////////////
                    // Weapon selection
                    do {        //try catch start
                        try{
                                printer.PrintWeaponChoices();
                                pChoice = input.nextInt();    
                                if(pChoice >=1 && pChoice <=4)
                                {
                                    valueBad = false; 
                                }
                        }
                        catch(InputMismatchException e) {
                            input.nextLine();
                            valueBad = true;
                        }
                    } while(valueBad == true);
                    CreateWeapon(pChoice, playerTurn);  //try catch ends here   
                    
                    playerTurn = false;
                    //////////////////////////////////////
                    // Enemy Setup Section
                    CreateLegend(randNum.nextInt(4) + 1, playerTurn); // warrior
                    CreateArmour(randNum.nextInt(4) + 1, playerTurn); // armour
                    CreateWeapon(randNum.nextInt(4) + 1, playerTurn); // weapon
                    
                    playerTurn = true;
            
                    //////////////////////////////////////
                    // Print initial warrior stats
                    
                    printer.PrintStartingStats(pLegend, eLegend, type);
                    pTurn = 0;
                    pTurn++;
                    eTurn = 0;
                    eTurn++;
                    pTotalDamage = 0;
                }
                else
                {
                    printer.PrintWinMessage(playerTurn, type, eTurn, pTurn, pTotalDamage, eTotalDamage);
                    
                    gameOver = true;
                }

            }
            playerTurn = !playerTurn; // flips the boolean  
        } // while
        
    } // main

    public static void CreateLegend(int choice, boolean player)
    {
        switch(choice)
        {
            case 1: // Loba
            {
                if(player) {
                    pLegend = new Loba();
                }
                else {
                    eLegend = new Loba();
                }
                break;
            }
            case 2: // Lifeline
            {
                if(player) {
                    pLegend = new Lifeline();
                }
                else {
                    eLegend = new Lifeline();
                }
                break;
            }
            case 3: // Octane
            {
                if(player) {
                    pLegend = new Octane();
                }
                else {
                    eLegend = new Octane();
                }
                break;
            }
            case 4: // Wraith 
            {
                if(player) {
                    pLegend = new Wraith();
                }
                else {
                    eLegend = new Wraith();
                }
                break;
            }// cases
        } // switch
    } // CreateLegend

    public static void CreateArmour(int choice, boolean player)
    {
        switch(choice)
        {
            case 1: // Rare
            {
                if(player) {
                    pArmour = new Rare();
                }
                else {
                    eArmour = new Rare();
                }
                break;
            }
            case 2: // Epic
            {
                if(player) {
                    pArmour = new Epic();
                }
                else {
                    eArmour = new Epic();
                }
                break;
            }
            case 3: // Legendary
            {
                if(player) {
                    pArmour = new Legendary();
                }
                else {
                    eArmour = new Legendary();
                }
                break;
            }
            case 4: // Gold Armour
            {
                if(player) {
                    pArmour = new Gold();
                }
                else {
                    eArmour = new Gold();
                }
                break;
            }
        } // switch
    } // CreateArmour

    public static void CreateWeapon(int choice, boolean player)
    {
        switch(choice)
        {
            case 1: // dagger
            {
                if(player) {
                    pWeapon = new Pistol();
                }
                else {
                    eWeapon = new Pistol();
                }
                break;
            }
            case 2: // sword
            {
                if(player) {
                    pWeapon = new Shotgun();
                }
                else {
                    eWeapon = new Shotgun();
                }
                break;
            }
            case 3: // axe
            {
                if(player) {
                    pWeapon = new SMG();
                }
                else {
                    eWeapon = new SMG();
                }
                break;
            }
                case 4: // bow
            
            {
                if(player) {
                    pWeapon = new LMG();
                }
                else {
                    eWeapon = new LMG();
                }
                break;
            }
            
        } // switch
    } // CreateWeapon
} // class