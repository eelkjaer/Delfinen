package View;
import java.util.Scanner;

public class UI {
    Scanner input = new Scanner(System.in);

    public void printToConsole(String str){
        System.out.print(str);
    }

    public void printMenu(String menuStr){
        String[] menu = menuStr.split(";");
        System.out.println("#####################");
        for(int i=0; menu.length > i; i++){
            System.out.println(i+1 + ")\t"+menu[i]);
        }
        System.out.println("#####################");
        System.out.print("Vælg menu: ");
    }

    public String getStrInput(){
        String str = input.nextLine();
        if(str.isEmpty()){
            printToConsole("Dit input er tomt!");
            getStrInput();
        }
        return str;
    }

    public int getIntInput(){
        String str = input.nextLine();

        if(str.isEmpty()){
            printToConsole("Dit input er tomt! Prøv igen: ");
            str = input.nextLine();
        }
        int select = Integer.parseInt(str.trim());
        return select;
    }

    public double getDoubleInput(){
        String str = input.nextLine();
        if(str.isEmpty()){
            printToConsole("Dit input er tomt!");
            getDoubleInput();
        }
        return Double.parseDouble(str);
    }

}
