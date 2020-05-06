package Controller;
import Model.*;

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

    //Fælles metoder

    /**
     * Viser top 5 svømmere indenfor hver kategori
     */
    public void showTop(){

    }


    public void logout(){
        System.out.println("Du er logget ud!");
        System.exit(0);
    }



}
