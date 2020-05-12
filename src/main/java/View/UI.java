package View;
import java.util.Scanner;

public class UI implements UIInterface{
    Scanner input = new Scanner(System.in);

    /**
     * @param str Streng som skal printes i konsol. Laver IKKE selv linebreak (\n)
     */
    public void printMessage(String str){
        System.out.print(str);
    }


    /**
     * @param menuStr Semikolon sepereret liste med menupunkter
     */
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
            printMessage("Dit input er tomt!");
            getStrInput();
        }
        return str;
    }

    public int getIntInput(){
        String str;
        while(!input.hasNextInt()){
            printMessage("Det er ikke et tal!\n");
            input.next();
        }
        str = input.nextLine();
        if(str.isEmpty()){
            printMessage("\nDit input er tomt! Prøv igen: \n");
            str = input.nextLine();
        }

        return Integer.parseInt(str.trim());
    }

    public double getDoubleInput(){
        String str = input.nextLine();
        return Double.parseDouble(str);
    }

}
