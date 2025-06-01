import app.Database;
import controller.GeralController;
import examples.Example;

public class Main {
    public static void main(String[] args) {
        Database.getInstance();
        new Example();
        GeralController geralController = new GeralController();
        geralController.homeScreen();
    }
}
