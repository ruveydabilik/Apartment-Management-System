package src;

import src.*;

import java.util.*;


public class ModelViewControllerConsole {

    public static void main(String[] args) throws Exception {
        // Connect to database
        connectToDatabase();

        // Model View Controller (MVC)
        // Router knows all the controllers
        Map<String, Controller> router = new HashMap<>();

        // ilk parametreler functionNameler, tek tek Mapin içine atıyoruz. İkinci parametre de controller,
        // her functionName için eşleşen bir controller var
        router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));
        router.put("ResidentMenu", new Controller(new ResidentOpMenuView(), new NopModel()));
        router.put("WorkerMenu", new Controller(new WorkerOpMenuView(), new NopModel()));
        router.put("MoneyFlowMenu", new Controller(new MoneyFlowOpMenuView(), new NopModel()));

        router.put("Resident", new Controller(new ResidentView(), new ResidentModel()));
        router.put("Worker", new Controller(new WorkerView(), new WorkerModel()));
        router.put("MoneyFlow", new Controller(new MoneyFlowView(), new MoneyFlowModel()));

        ViewData viewData = new ViewData("MainMenu", "");

        do {

            // Model, View, and Controller
            Controller controller = router.get(viewData.functionName); // controllerı null alıyor
            if (controller == null) {
                System.out.println("controller is null");
            }

            ModelData modelData = controller.executeModel(viewData);
            if (modelData == null) {
                System.out.println("Modeldata is null");
            }
            // aşşada getView konsola MainMenuViewi getirdi.
            viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);
            // ama sonradan seçime göre Resident ya da Workerı da gertiriyo

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
