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
        return input.nextLine();
    }

    public int getIntInput(){
        return Integer.parseInt(input.nextLine());
    }

    public double getDoubleInput(){
        return Double.parseDouble(input.nextLine());
    }

}
