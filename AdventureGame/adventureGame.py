# Simple-version of an old-fashioned text-based adventure game
# The game will present some scenarios and ask the user to make one of 2 choices, by entering 1 or 2
import time
import random

# TODO: Add functions and refactor your code
# TODO: Create win and lose conditions
# TODO: Check if the player wants to play again
# TODO: Check your style with pycodestyle
# TODO: Test Your Code
# TODO: Run away option -> you lose

"""
Standout Suggestions
Tips to personalize your project submissions and make them stand out:

Identify the repetitive parts and refactor them into functions.
Reduce redundancy by applying the DRY principle.
Use intuitive function names and avoid generic names to provide clear context.
Avoid using global variables in the functions.
"""
# Method to create delay between messages
def print_pause(text):
    n = 1
    print(text)
    time.sleep(n)

def do_intro():
    print("\n---------------------------------------------------------")
    print("\tDefeat your Opponent Game")
    print("------------------------------------------------------------")
    print_pause("\nYou need to defeat an opponent \
before your health point (HP) runs out.\n")

def play_game():
    # Variables for Opponent Stats (this can be change)
    opponents = ["Voldemort", "Dementor", "Bellatrix", "Nagini", "Malfoy"]
    maxHealthOpponent = 100
    attackOpponentDamage = 10

    # Variables for Players Stats (this can be change)
    playerHealth = 100
    attackDamage = 25
    healthPotions = 3
    healthPotionHeal = 30
    
    do_intro()

    continue_game = True

    while(continue_game):
        opponentHealth = random.randrange(maxHealthOpponent)
        opponent = random.choice(opponents)
        print_pause("\n-----------------------------------------------------------")
        print_pause(f"\t##### {opponent} appeared in the arena! #####")
        print_pause("-------------------------------------------------------------\n")
        while(opponentHealth > 0):
            print_pause(f"\n\tYour HP: {playerHealth}")
            print_pause(f"\t{opponent}'s HP: {opponentHealth}")
            print_pause("\n\t What would you like to do? ")
            print_pause("\t1. Attack")
            print_pause("\t2. Drink health potion")
            print_pause("\t3. Run away!")

            player_choice = input("\n\tEnter your choice: ")

            if(player_choice=="1"):
                damageDealt = random.randrange(attackDamage)
                damageTaken = random.randrange(attackOpponentDamage)

                opponentHealth -= damageDealt
                playerHealth -= damageTaken

                print_pause(f"\n\tYou attacked {opponent} with {damageDealt} damage.")
                print_pause(f"\tYou received {damageTaken} in return.")

                if(playerHealth < 1):
                    print_pause("\t You are too weak to continue fighting.")
                    break

            elif(player_choice=="2"):
                if(healthPotions > 0):
                    playerHealth += healthPotionHeal
                    healthPotions -= 1
                    print_pause(f"\tYou drinka potion to heal for {healthPotionHeal}.")
                    print_pause(f"\tYou now have {playerHealth} and {healthPotions} potions left.")

            elif(player_choice=="3"):
                print_pause(f"\tYou run away from {opponent}.")
                continue
            else:
                print("\tInvalid Input")

        if(playerHealth < 1):
            print_pause("\tYou are too weak to continue the fight.")
            break

        print_pause("\n\n----------------------------------------------------------")
        print_pause(f"\t{opponent} is defeated!")
        print_pause(f"\tYou won this round!")
        print_pause(f"\tYou have {playerHealth} HP left.")

        print_pause("--------------------------------------------------------------")
        print_pause("\nWhat would you like to do now?")
        print_pause("1. Continue fighting")
        print_pause("2. Exit the arena")

        choice = input("Enter your choice: ")

        if(choice == "1"):
            print_pause("You continue to fight in the arena.")
        elif(choice == "2"):
            print_pause("You exit the areana.\n")
            break
        else:
            print_pause("Invalid choice")
    
    print_pause("Thank you for playing the game!")
    print_pause("Have a nice day!")

play_game()