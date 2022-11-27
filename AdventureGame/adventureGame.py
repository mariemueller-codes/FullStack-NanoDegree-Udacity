# Simple-version of an old-fashioned text-based adventure game
import time
import random


# create delay between messages
def print_pause(text):
    n = 2
    print(text)
    time.sleep(n)


#  give instructions about the game
def do_intro():
    print("\n---------------------------------------------------------")
    print("\tDefeat your Opponent Game")
    print("------------------------------------------------------------")
    print_pause("\n\tWelcome player to the fight arena.")
    print_pause("You need to defeat an opponent" +
                " before your HP runs out.\n")


# check who is winning
def check_winner(playerHealth, opponentHealth, opponent):
    if (opponentHealth < 1):
        print_pause("\n\n------------------------------------------------")
        print_pause(f"\t{opponent} is defeated!")
        print_pause(f"\tYou won this round!")
        print_pause(f"\tYou have {playerHealth} HP left.")
        print_pause("----------------------------------------------------")


# continue or exit the game
def play_again(continue_game):
    print_pause("\n\tWhat would you like to do now?")
    print_pause("\t1. Continue fighting")
    print_pause("\t2. Exit the arena")

    while continue_game:
        choice = input("\tEnter your choice: ")

        if (choice == "1"):
            print_pause("\n\tYou continue to fight in the arena.")
            break
        elif (choice == "2"):
            print_pause("\n\tYou exit the arena.\n")
            continue_game = False
            break
    return continue_game


# serves as main function of the application
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

    while (continue_game):
        opponentHealth = random.randrange(maxHealthOpponent)
        opponent = random.choice(opponents)
        print_pause("\n------------------------------------------------------")
        print_pause(f"\t##### {opponent} appeared in the arena! #####")
        print_pause("------------------------------------------------------\n")
        while (opponentHealth > 0):
            print_pause(f"\n\tYour HP: {playerHealth}")
            print_pause(f"\t{opponent}'s HP: {opponentHealth}")
            print_pause("\n\t What would you like to do? ")
            print_pause("\t1. Attack")
            print_pause("\t2. Drink health potion")
            print_pause("\t3. Run away!")

            player_choice = input("\n\tEnter your choice: ")

            if (player_choice == "1"):
                damageDealt = random.randrange(attackDamage)
                damageTaken = random.randrange(attackOpponentDamage)

                opponentHealth -= damageDealt
                playerHealth -= damageTaken

                print_pause(f"\n\tYou attacked {opponent}" +
                            f" with {damageDealt} damage.")
                print_pause(f"\tYou received {damageTaken} in return.")

                if (playerHealth < 1):
                    print_pause("\t You are too weak to continue fighting.")
                    break

            elif (player_choice == "2"):
                if (healthPotions > 0):
                    playerHealth += healthPotionHeal
                    healthPotions -= 1
                    print_pause(f"\tYou drink a potion to heal for\
                         {healthPotionHeal}.")
                    print_pause(f"\tYou now have {playerHealth}" +
                                f" and {healthPotions} potions left.")

            elif (player_choice == "3"):
                print_pause(f"\tYou run away from {opponent}!!!")
                print_pause("\tYou lose.")
                continue_game = play_again(continue_game)
                break
            else:
                print("\tInvalid Input")

        if (playerHealth < 1):
            print_pause("\tYou are too weak to continue the fight.")
            break

        check_winner(playerHealth, opponentHealth, opponent)
        continue_game = play_again(continue_game)

    print_pause("\n\n\tThank you for playing the game!")
    print_pause("\tHave a nice day!")


# call function to start the game
play_game()
