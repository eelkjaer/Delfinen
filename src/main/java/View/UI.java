package View;
import java.util.Scanner;

public class UI {
    Scanner input = new Scanner(System.in);

    public void printToConsole(String str){
        System.out.print(str);
    }

    public void printMenu(String menuStr){
        System.out.print(menuStr);
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
