package Controller;

public class UserController extends MainController {
    BaseController base;
    public UserController(BaseController base){
        this.base = base;
    }
    @Override
    public void showMenu() {
        refreshData();
        ui.printMenu("Se Top 5 - Junior;Se Top 5 - Senior;Log ud");
        int select = ui.getIntInput();
        switch (select){
            case 1:
                // Se top 5 junior
                showTop("junior");
            case 2:
                // Se top 5 senior
                showTop("senior");
            case 3:
                base.logout();
                break;
            default:
                ui.printMessage(select + " findes ikke!\n");
                showMenu();
        }
    }
}
