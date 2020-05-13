/**
 * @author Emil Elkjær Nielsen (cph-en93@cphbusiness.dk)
 **/
package View;

public interface UIInterface {
    void printMessage(String str);

    void printMenu(String menuStr);

    String getStrInput();

    int getIntInput();

    double getDoubleInput();
}
