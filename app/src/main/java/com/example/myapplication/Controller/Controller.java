package com.example.myapplication.Controller;

import com.example.myapplication.Model.Patient;

public class Controller {

    private static Patient patient;
    private static Controller instance;

    private Controller(){
        super();
    }

    public void createPatient(int age, float glycemieValue, boolean areYouFast){
        patient = new Patient(age, glycemieValue, areYouFast);
    }

    public static final Controller getInstance(){
        if (instance == null)
            instance = new Controller();

        return instance;
    }



    //notify the controller to get the result
    public String getResult(){
        return patient.getResult();
    }
}
