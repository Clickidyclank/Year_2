
//--------------------------------------------------
// INCLUDE LIBRARIES
//--------------------------------------------------
#include "word_game.h"

//--------------------------------------------------
// my_getchar
//--------------------------------------------------
char my_get_char() {
    //1. We create the output variable with the value the user has input by keyboard
    char res = getchar();

    //2. We discard any extra character the user has input by keyboard
    boolean finish = False;
    char dummy_char = ' ';

    while (finish == False) {
        dummy_char = getchar();
        if (dummy_char == '\n')
            finish = True;
    }

    //3. We return the output variable
    return res;
}

//--------------------------------------------------
// ask_for_new_command
//--------------------------------------------------
char ask_for_new_command() {
    //1. We create the output variable with an initial value
    char res = ' ';

    //2. While we have not received a valid command

        //2.1 We ask the user for a new command

        //2.2. We read the command entered by the user


        //2.3. We check if the command is correct


    //3. We return the output variable
    return res;
}

//--------------------------------------------------
// process_movement
//--------------------------------------------------
void process_movement(char current_word[NUM_LETTERS], char** letter_ptr_ptr, int* num_movs_ptr, char command){
    //1. We process the different commands

        //1.1. If it is a '<'

            //1.1.1. If we are not in the left border

                //I. We move the pointer to the left

                //II. We update the number of movements


        //1.2. If it is a '>'

            //1.2.1. If we are not in the right border

                //I. We move the pointer to the right

                //II. We update the number of movements


        //1.3. If it is a letter

            //1.3.1. If the letter is different from the current one

                //I. We modify the letter

                //II. We update the number of movements

}

//--------------------------------------------------
// print_status
//--------------------------------------------------
void print_status(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], char* letter_ptr, int num_movs) {
    //1. We clean the screen

    //2. We print the status

    //3. We print the target word

    //4. We print the current word

    //5. We print the underscore associated to the pointer

    //6. We print the number_of_movements

    //7. We print a last line

}

//--------------------------------------------------
// is_game_over
//--------------------------------------------------
int is_game_over(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], int num_movs, int max_movs) {
    //1. We create the output variable with an initial value.
    int res = 0;

    //2. Game is over if current_word matches target_word

    	//2.1. By default we assume current_word and target_word are equal

    	// 2.2. We traverse them to check if they are actually equal

    	//2.3. In case they are equal we set the end of the game

    // 3. Game is over as we have done the max number of movements being allowed

    //4. We return the output variable
    return res;
}


//--------------------------------------------------
// user_game_word
//--------------------------------------------------
void user_game_word(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS]) {
    //1. We initialise the pointer to the first position of the array

    //2. We initialise the num_mov and max_movs


    //3. We initialise the game to not to be over


    //4. We print the initial status of the game

    //5. We perform the main loop

        //5.1. We ask for a new command

        //5.2. We process the command

        //5.3. We print the current status

        //5.4. We determine if the game is over


    //6. Once the game is finished, we display the outcome of it

}
