user1=input("Enter Player1 name ")
user2=input("Enter Player2 name ")

user1_answer=input(user1+" Do you want to choose paper,scissors,rock? ").lower()
user2_answer=input(user2+" Do you want to choose paper,scissors,rock? ").lower()

if user1_answer==user2_answer:
    print("it's tie")
elif user1_answer=='rock':
    if user2_answer=='scissors':
        print("rock wins")
    else:
        print("paper wins")
elif user1_answer=='scissors':
    if user2_answer=='paper':
        print("scissors wins")
    else:
        print('rock wins')
elif user1_answer == 'paper':

    if user2_answer == 'rock':

        print("Paper wins!")

    else:

        print("Scissors win!")

else:

    print("Invalid input! You have not entered rock, paper or scissors, try again.")