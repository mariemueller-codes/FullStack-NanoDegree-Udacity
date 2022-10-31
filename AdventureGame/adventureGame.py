# Simple-version of an old-fashioned text-based adventure game
# The game will present some scenarios and ask the user to make one of 2 choices, by entering 1 or 2
import time
choices = ['1', '2']

# Step 1: Print descriptions of what's happening for the player
# Step 2:Pausing between printing descriptions

# print("You find yourself standing in an open field, filled with grass and yellow wildflowers.")
# time.sleep(1)
# print("Rumor has it that a pirate is somewhere around here, and has been terrifying the nearby village.")
# time.sleep(1)
# print("In front of you is a house.")
# time.sleep(1)
# print("To your right is a dark cave.")
# time.sleep(1)
# print("In your hand you hold your trusty (but not very effective) dagger.")
# time.sleep(1)

# Step 3: Give the player some choices
def give_choice():
    print("Enter 1 to knock on the door of the house.")
    print("Enter 2 to peer into the cave.")
    response = input("What would you like to do?\n(Please enter 1 or 2) \n")
    if response in choices:
        print("Player made a choice")
    else:
        give_choice()

# Step 4: Make sure the player gives a valid input
give_choice()

# Step 5: Add functions and refactor your code
def fight():
    return ""

def cave():
    return ""

def field():
    return ""

def house():
    return ""

# Step 6: Use randomness in your game

# Step 7: Create win and lose conditions

# Step 8: Check if the player wants to play again

# Step 9: Check your style with pycodestyle

# Step 10: Test Your Code

"""
Standout Suggestions
Tips to personalize your project submissions and make them stand out:

Identify the repetitive parts and refactor them into functions.
Reduce redundancy by applying the DRY principle.
Use intuitive function names and avoid generic names to provide clear context.
Avoid using global variables in the functions.
"""