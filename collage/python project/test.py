global account_number
account_number =[]
global balance
balance = []
global balance_2
balance_2 =[]
global name
name = []


def reading():
    fo = open('bank.txt')
    list = []
    for line in fo:
        line = line.strip()
        list.append(line)

    length = len(list)

    i = 0

    while i < length:

        account_number.append((list[i]))
        balance.append(float(list[i+1]))
        balance_2.append((list[i+1]))
        name.append(list[i+2])

        i = i+3



    return list

def opening_account():
    import random
    import math
    fname = input("Please enter your name")
    start_balance = int(input("Please enter your starting balance"))

    digit_1 = random.randint(0, 9)
    digit_2 = random.randint(0, 9)
    digit_3 = random.randint(0, 9)
    digit_4 = random.randint(0, 9)
    digit_5 = random.randint(0, 9)
    digit_6 = random.randint(0, 9)
    total_digit_for_check = str(digit_1) + str(digit_2) + str(digit_3) + str(digit_4) + str(digit_5) + str(digit_6)

    new_account_number = (total_digit_for_check)

    account_number.append(new_account_number)
    name.append(fname)
    balance.append(start_balance)
    balance_2.append(start_balance)

    print("Thank your for opening an account with us. your details are below")
    print("Account number ", new_account_number)
    print ("Balance " ,start_balance )
    print("Name ", fname )

def main_menu():

    choice = 0
    while choice !=6:
        print("please choose one of the following options")
        print("1. Open an account")
        print("2. Close an account")
        print("3. Withdraw money")
        print("4. Deposit money")
        print("5. Generate a report for management")
        print("6. Quit")
        choice = int(input())
        if choice == 1:
            opening_account()

        elif choice == 2:
            closeing_account()
        elif choice == 3:
            withdraw_money()
        elif choice == 4:
            deposit_money()
        elif choice == 5:
            report()
        elif choice == 6:
            writer = open('bank.txt', 'w')

            for i in range(len(account_number)):
                full_details = str(account_number[i]) + '\n' + str(balance_2[i]) + '\n' + name[i] + '\n'
                writer.write(full_details)
            writer.close()
            quit()


def closeing_account():
    account_search = input("what is the account number you wish to close")
    account_find = int(account_number.index(account_search))
    balance_find = balance[account_find]
    name_find = name[account_find]

    if account_search in account_number:
        del account_number[account_find]
        del balance_2[account_find]
        del name[account_find]

    else:
        print("That account number is not in our system. please try again")


def withdraw_money():
    account_search = input("please enter your account number")
    if account_search in account_number:
        amount_withdraw = int(input("please enter the amount you wish to withdraw"))
        account_find = int(account_number.index(account_search))
        balance_find = balance[account_find]
        print("amount in account =", balance_find)
        print("how much do you wish to withdraw")
        if amount_withdraw < balance_find:
            balance_2[account_find] = (float(balance_2[account_find]) - float(amount_withdraw))
            print("you have withdraw",amount_withdraw," from your account. There is " , balance_2[account_find], "left")
        else:
            print("you do not have available funds to do that.")
    else:
        print("sorry we do not have that account number on file. please try again")

def deposit_money():
    account_search = input("please enter your account number")
    if account_search in account_number:
        amount_deposit = int(input("please enter the amount you wish to deposit"))
        account_find = int(account_number.index(account_search))
        balance_find = balance[account_find]

        balance_2[account_find] = (float(balance_2[account_find]) + float(amount_deposit))
        print("amount in account =", balance_2[account_find])

def report():
    lenght = len(account_number)
    i=0
    total=0

    print("Account number = ",account_number)
    print("Balance =    " ,balance_2)
    print("Name =    " ,name)


    for i in range (0,lenght):
        total = balance[i]+total
    print("The total ammount in the bank currently is ",total)

    person_max = max(balance)
    account_find = (balance.index(person_max))
    print("The highest amount that one person has in the bank is ",person_max)
    print("With account number = ",(account_number[account_find]))
    print("And name ",name[account_find])



reading()
main_menu()