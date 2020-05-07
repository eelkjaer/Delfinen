package Controller;
import Model.*;
import View.UI;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

abstract public class MainController {
    //Abstrakte ting til nedarvning
    /*
     * Viser menuen vha. UI til brugeren
     */
    public abstract void showMenu();

    //Variabler til controlleren
    public ArrayList<Member> members;
    public ArrayList<Result> results;
    public ArrayList<Payment> payments;
    public ArrayList<Competition> competitions;

    UI ui = new UI();

    //Fælles metoder

    /**
     * Viser top 5 svømmere indenfor hver kategori
     */
    public void showTop(){

    }

    public int calculateAge(LocalDate birthDate) {
        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    public void logout(){
        System.out.println("Du er logget ud!");
        System.exit(0);
    }



}
