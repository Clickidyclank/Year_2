import random


def main():
    reader = open('bank.txt', 'r')
    all_details = reader.read().split()
    reader.close()
    # slicing details list to be sent to the relevant lists
    account_number = all_details[0::4]
    balance = all_details[1::4]
    # For loop used to format balance to the proper currency format of 0.00
    for i in range(len(balance)):
        bal_format = float(balance[i])
        bal_format = format(bal_format, ".2f")
        balance[i] = bal_format
    first_name = all_details[2::4]
    last_name = all_details[3::4]
    # combining first and last name lists to make 1 list for name
    name = []
    for i in range(len(first_name)):
        name.append(str(first_name[i]) + ' ' + str(last_name[i]))

    # Choice initialised before while loop then uses the menu function to be assigned an intended value by the user
    # which is then used in the if statement to determine which function to carry out, this will keep looping until
    # the user enters the value '6' where it will then write everything to file and close the writer, finally the
    # program will use the quit() function to exit
    choice = 0
    while choice != 6:
        choice = menu()

        if choice == 1:
            open_account(account_number, balance, name)
        elif choice == 2:
            close_account(account_number, balance, name)
        elif choice == 3:
            withdraw(balance, account_number)
        elif choice == 4:
            deposit(balance, account_number)
        elif choice == 5:
            generate_report(account_number, balance, name)
        elif choice == 6:
            print('exiting program, saving any changes made.')
    writer = open('bank.txt', 'w')

    for i in range(len(account_number)):
        full_details = account_number[i] + ' ' + balance[i] + ' ' + name[i] + '\n'
        writer.write(full_details)
    writer.close()
    quit()


def menu():
    # Menu function that presents user with 6 choices
    print('\n1. Open an account\t\t\t\t\t\t2. Close an account\n3. Withdraw Money\t\t\t\t\t\t4. Deposit Money\n'
          '5. Generate a report for management\t\t6. Quit')

    while True:
        try:
            choice = int(input('Please select one:\t'))
            break
        except ValueError:
            print("Must be a number.")
    return choice


def open_account(a, b, n):
    # For new accounts a name is the only required input, account numbers are randomly generated and balances are
    # initialised to 0
    checker = True

    while checker:
        account_no = ''
        rng = []
        for i in range(6):
            rng.append(random.randint(0, 9))
        for i in range(6):
            account_no += str(rng[i])
        if not a.count(account_no) > 0:
            checker = False

    a.append(account_no)

    while True:
        name = input('Enter person\'s name:\t')
        if any(str.isdigit(c) for c in name):
            print('Must not contain any numbers')
        else:
            n.append(name)
            break

    while True:
        try:
            bal = float(input("Enter the amount of money to deposit to this account:\t"))
            break
        except ValueError:
            print("must be a number")
    b.append(str(bal))

    return a, b, n


def close_account(a, b, n):
    # Ask user for account no related to account to be removed
    while True:
        remove = input('Enter related Account no for removal:\t')
        if remove.isnumeric() and len(remove) == 6:
            break
        elif remove.isnumeric():
            print("Must be 6 digits")
        else:
            print('Must be 6 digits and entirely numerical')

    # For loop that will scan to see if input matches up with account no on each index, breaks out of loop once an
    # account is deleted to avoid crashes due to loop more times than there are indexes available
    for i in range(len(a)):
        if a[i].count(remove) > 0:
            a.pop(i)
            b.pop(i)
            n.pop(i)
            break
    else:
        print("No account found related to number given")


def deposit(b, a):
    # Ask user for input(Account No and the Amount to be deposited)
    while True:
        choice = input('Enter related account number:\t')
        if choice.isnumeric() and len(choice) == 6:
            break
        elif choice.isnumeric():
            print("Must be 6 digits")
        else:
            print('Must be 6 digits and entirely numerical')

    while True:
        try:
            deposit_amount = float(input('Enter the amount you wish to deposit:\t'))
            break
        except ValueError:
            print("Must only contain numbers")

    # For loop that will scan through all the account numbers and if it finds a match will run the if statement
    for i in range(len(b)):
        current_bal = b[i]
        if a[i].count(choice) > 0:
            # if statement will add the current balance and the amount being deposited together which is
            # then sent back to the same index
            final_bal = float(current_bal) + float(deposit_amount)
            b[i] = str(final_bal)

    return b


def withdraw(b, a):
    # Ask user for input(Account No and the Amount to be withdrawn)
    while True:
        choice = input('Enter related account number:\t')
        if choice.isnumeric() and len(choice) == 6:
            break
        elif choice.isnumeric():
            print("Must be 6 digits")
        else:
            print('Must be 6 digits and entirely numerical')

    while True:
        try:
            withdraw_amount = float(input('Enter the amount you wish to deposit:\t'))
            break
        except ValueError:
            print("Must only contain numbers")

    # For loop that will scan through all the account numbers and if it finds a match will run the if statement
    for i in range(len(b)):
        current_bal = float(b[i])
        if a[i].count(choice) > 0:
            # if statement will take the current balance and subtract the amount being withdrawn together which is
            # then sent back to the same index
            if current_bal - withdraw_amount > 0:
                # If statement checks to ensure there is enough funds in the account for the amount to be withdrawn
                final_bal = float(current_bal) - float(withdraw_amount)
                b[i] = str(final_bal)
            else:
                # Else statement in case there is not enough funds for the amount to be withdrawn
                print("******************************\n Not enough funds in account.\n******************************")
    return b


def generate_report(a, b, n):
    total = 0.0
    highest = 0.0
    # For loop will scan through all the accounts balances and each time a higher balance is found it will be assigned
    # to the highest variable, the total is also found by adding the balance of that account to the total variable
    # each loop, both the total and highest variables are initialised to 0
    for i in range(len(b)):
        if float(b[i]) > float(highest):
            highest = float(b[i])
            highest = str(highest)
        total += float(b[i])
    # output for the report
    print("\nTotal amount of value across all accounts:\t" + str(total))
    print("Highest balance account(s):")
    for i in range(len(b)):
        if b[i].count(highest) > 0:
            print("Name: " + n[i] + " | Balance: " + b[i] + '\n')

    for i in range(len(a)):
        print('\n*********************************')
        print('Account Number:\t' + a[i])
        print('Name: ' + n[i] + ' | Balance: ' + str(b[i]))


main()