package Controllers;

import Tabs.Add_tab;
import sample.Car;

public class Add_tab_controller {

    private GeneralController generalController;
    private Add_tab add_tab;

    public Add_tab_controller(GeneralController generalController, Add_tab add_tab) {
        this.generalController = generalController;
        this.add_tab = add_tab;

    }

    /**
     * @param make The make of the Car object
     * @param model The model of the Car object
     * @param millage The millage of the car object
     * @param year The year of the car object
     * @param reg_num The Reg num of the car object
     */

    public void add(String make, String model, String millage, String year,String reg_num) {
        try {

            Car car1 = new Car(make, model,Integer.parseInt(reg_num),Integer.parseInt(millage),Integer.parseInt(year));

            generalController.getCarObList().add(car1);


            System.out.println(generalController.getCarList());

            add_tab.setInfo("");




        } catch (NumberFormatException nfe) {
            add_tab.setInfo("That is not a valid entry. Please check to make sure all your entries are valid");
        }
    }


}
