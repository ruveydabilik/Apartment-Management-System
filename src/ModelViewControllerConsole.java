package src;

import src.*;

import java.util.*;


public class ModelViewControllerConsole {

    public static void main(String[] args) throws Exception {
        // Connect to database
        connectToDatabase();


        // Model View Controller (MVC)
        // Router knows all the controllers
        Map<Object, Object> router = new HashMap<>();
        router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));

        router.put("ResidentMenu", new Controller(new ResidentOpMenuView(), new NopModel()));
        router.put("WorkerMenu", new Controller(new WorkerOpMenuView(), new NopModel()));

        router.put("Resident", new Controller(new ResidentView(), new ResidentModel()));
        router.put("Worker", new Controller(new WorkerView(), new WorkerModel()));

        ViewData viewData = new ViewData("MainMenu", "");

        do {
            // Model, View, and Controller
            Controller controller = (Controller) router.get(viewData.functionName);
            ModelData modelData = controller.executeModel(viewData);
            viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);

            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
        }
        while (viewData != null);

        System.out.println();
        System.out.println();
        System.out.println("Program is ended...");


        // Disconnect from database
        disconnectFromDatabase();
    }


    public static void connectToDatabase() {
        //DatabaseUtilities.host = "localhost:1433" ;
        //DatabaseUtilities.databaseName = "AdventureWorks2019";

        try {
            DatabaseUtilities.getConnection();
        } catch (Exception e) {
            System.out.println("Exception occured : " + e);
            return;
        }
    }

    public static void disconnectFromDatabase() {
        try {
            DatabaseUtilities.disconnect();
        } catch (Exception e) {
            System.out.println("Error disconnecting from database : " + e);
            return;
        }
    }

}
