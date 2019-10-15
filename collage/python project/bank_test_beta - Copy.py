#Author: Antonio Artini
#Name: Bank
#Date: 12/4/2018
global account_number
account_number = []
global balance
balance = []
global balance_2
balance_2 =[]
global name
name = []

import random


#This function is the main function that sets up the user interface for the banking systems
#Any other functions will be called within this one as the options are chosen
def menu():

    #4 lists are made at the start of the function. As the program runs its course, I'm trying to get it to
    #add information to these empty lists from the bank.txt file.






    #str1 = open(file, "r+")
    #str1.write([str1])

    reading()

    print(account_number)
    print(balance_2)
    print(name)



    line = "============================"
    message = "Welcome to A.Artini Banking"
    options = "Please select one of the below options"
    print(line, "\n" + message + "\n" + options)
    print("Options\n\t1. Open Account : \n\t2. Close Account : \n\t3. Withdraw Money : "
          "\n\t4. Deposit Money : \n\t5. Generate Report : \n\t6. Quit")


    while True:
        users_input = read_nonnegative_integer("Option : ")
        if users_input == 6:

            break
        elif users_input == 1:
            open_account()

        elif users_input == 2:
            close_account()

        elif users_input ==3:
            withdraw_money()

        elif users_input == 4:
            deposit_money(accounts, balance)

        elif users_input == 5:
           generate_report(str1, largest_number)
        else:
            users_input = read_nonnegative_integer("Error. Please enter a valid option : ")
    print(account_number)
    print(balance_2)
    print(name)



    close_bank_file()


#takes in the accounts, balance and names list and will write the information
#into the bank.txt file as a list called str1
def close_bank_file():
    f = open("bank.txt", "w")
    length = len(account_number)
    print(length)
    for i in range(len(account_number)):
        full_details = str(account_number[i]) + '\n' + str(balance_2[i]) + '\n' + name[i] + '\n'
        f.write(full_details)
    f.close()
    quit()

#takes in the accounts, balance and names lists ao that we can create one list containing all the
# information in the bank file
def create_list(accounts, balance, names):
    position = 0
    strl = []
    while position < len(accounts):
        account = []
##        print(accounts[position])
##        print(balance[position])
##        print(names[position])
        account += [accounts[position]]
        account += [balance[position]]
        account += [names[position]]
        strl += [account]
        
        position += 1
    return strl

#def load_bank_file(file, accounts, balance, names):

   # f = open(file, "r")

#Opens up the bank.txt file when called and reads the file.
#If the information in the 3 lists (accounts, balance, names) are within the list containig all the bankiing details
# (in the bank.txt) then the 3 empty lists will be appended to for the duration of the program's run time.
def reading():
    fo = open('bank.txt')
    list = []
    for line in fo:
        line = line.strip()
        list.append(line)

    length = len(list)
    print(length)
    i = 0

    while i < length:

        account_number.append((list[i]))
        balance.append(float(list[i+1]))
        balance_2.append((list[i+1]))
        name.append(list[i+2])

        i = i+3



    return list


#When opening an account, a random 6 digit number (which isn't already in the bank.txt file) is generated and
#is appended to the account list.
#The user is asked for their name and their input is appended to the name list.
#The user is asked to make a deposit which is added to the balance list .
def open_account():
    #generate a random 6 digit number
    print("============================")
    print("Opening new account.")
    new_account_number = ""


    for i in range(0,6):
        new_number = random.randint(0,9)
        new_account_number = str(new_number) + str(new_account_number)

    account_number.append(new_account_number)
    print(new_account_number)

    balance_input = read_nonnegative_float("enter balance: ")
    balance_2.append(balance_input)

    valid = True
    name_input= ""
    while valid ==True:
        name_input = read_nonempty_string("Please enter your name: ")
        if name_input is None:
            print("y")
            name_input = read_nonempty_string("Please enter your name: ")
        else:
            print("x")
            valid = False
            name.append(name_input)


##
##    accounts.append(account_number)
##    balance.append(balance_input)
##    name.append(name_input)

    print("Welcome " + str(name_input) + " to your new A.Artini bank account. Account no. "+ str(account_number))


   # str1 = str(account_number) + " "  + str(balance_input) + " " +  str(name_input) + "\n"

  #  edit_file("bank.txt", str1,account_number, balance_input, name_input)

    return account_number, balance, name,


def edit_file(file, str1, account_input, balance_input, name_input):
    f = open(file, "a+")
    if f is None:
        str1 = []
    else:
        str1 = [file.split("\n")]
        str1 = str1.append(account_input)
        str1 = str1.append(balance_input)
        str1 = str1.append(name_input)
    return str1

def input_money(accounts, message_prompt ):
    message_prompt = "PLease enter the amount you wish to lodge: "
    lodgement = read_nonnegative_float(message_prompt)
    return  lodgement

def input_account_number(file):


    valid = True
    while valid == True:
        input_account_number =  read_nonempty_string("Please insert your account number: ")
        if input_account_number in file:
            valid = False
        else:
            input_account_numnber = read_nonempty_string("Invalid number, please try again: ")


def close_account():
    account_number_input = read_nonempty_string("Please insert your account number: ")
    position = int(account_number.index(account_number_input))
    #while True:


    if account_number_input in account_number:


        del account_number[position]
        del balance_2[position]
        del name[position]


   # str1.append(line.split)

    #line_list = line.split()

    #account_number = int(line_list[0])
  #  bal = line_list[1]
    #names = line_list[2] + " " + line_list[3]
    # str1 = str1.split("\n")

  #  accounts.append(account_number)
   # balance.append(bal)
   # name.append(names)

    #account_number, bal, name = create_list(accounts, balance, name)
    #return accounts, balance, name











    #delete_from_file(position)





def withdraw_money(accounts, balance):
    position = 0
    withdraw_input = 0.00
    message = ("Your remaining balance is € " + str(float(balance[position]) - float(withdraw_input)))
    account_numner_input = read_nonempty_string("Please insert your account number: ")

    while valid == True:
        if account_numner_input in accounts:
            position = accounts.index(account_numner_input)
            valid = False
        else:
            account_numner_input = read_nonempty_string("Pleas insert a valid account number: ")
    withdraw_input = read_nonnegative_float("Please insert the amount you would like to withdraw: ")
    if withdraw_input >= float(balance[position]):
        print("You have exceeded the amount in your account. Your remaining balance is € 0.00 ")
        balance[position] = 0
    else:
        balance[position] = balance[position] - withdraw_input
        print(message)
        return balance[position]





def deposit_money(accounts, balance):
    position = 0
    message = "Your total balance is € "


    account_number_input = read_nonempty_string("Please insert your account number: ")
    if account_number_input in accounts:
        position = accounts.index(account_number_input)
    else:
        print("Error, account not on record.")
        #menu()
    input_deposit = read_nonnegative_float("Please enter the amount you would like to deposit: ")
    balance[position] = balance[position] + input_deposit
    print(message + balance[position])
    largest_number(input_deposit)

def largest_number( input_deposit):
    largest = 0.00
    if input_deposit > largest:
        largest = input_deposit
        print("The largest amount withdrawn from an account was € " + str(largest))
    return largest


def generate_report(str1, largest_number):
    print(str1)

    print()





#def save_to_bank(file,balance, position, new_balance):
 #   open(file)
  #  balance[position] = new_balance
#
 #   print()


#functions reads what is passed through as a number and makes sure that the input contains letter and
def read_nonempty_string(prompt):
    something_is_wrong = True
    while something_is_wrong:
        s = input(prompt)
        if len(s) > 0:
            something_is_wrong = False
        else:
            print("Please type something...")
    return s

def read_nonnegative_float(prompt):
    something_is_wrong = True
    while something_is_wrong:
        try:
            number = float(input(prompt))
            if number >= 0:
                something_is_wrong = False
            else:
                print("Non-negative numbers please...")
        except:
            print("Must be numeric...")
    return number

def read_nonnegative_integer(prompt):
    something_is_wrong = True
    while something_is_wrong:
        try:
            number = int(input(prompt))
            if number >= 0:
                something_is_wrong = False
            else:
                print("Non-negative numbers please...")
        except:
            print("Must be numeric...")
    return number

menu()
