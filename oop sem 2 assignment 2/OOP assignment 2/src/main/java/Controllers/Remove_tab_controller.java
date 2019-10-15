package Controllers;

import Tabs.Remove_tab;

public class Remove_tab_controller {

    private GeneralController generalController;
    private Remove_tab remove_tab;

    public Remove_tab_controller(GeneralController generalController,Remove_tab remove_tab) {
        this.generalController = generalController;
        this.remove_tab = remove_tab;
    }



    public void remove(int reg_num){




        for (int i= 0; i<generalController.getCarObList().size();i++){

            int index = generalController.getCarObList().get(i).getReg_num();
            if (index == reg_num){

                generalController.getCarObList().remove(i);

            }
        }



    }


}

