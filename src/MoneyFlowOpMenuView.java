package src;

import java.util.*;

public class MoneyFlowOpMenuView implements ViewInterface {

    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        System.out.println("MoneyFlow Op Menu icindeyiz");
        String which;

        Integer choice;
        do {
            System.out.println("1. Show all MoneyFlows");
            System.out.println("2. Add an MoneyFlow");
            System.out.println("3. Back");
            System.out.println();

            choice = getInteger("Enter your choice : ", false);
        }
        while (choice == null || choice < 1 || choice > 3);


        Map<String, Object> userInput = new HashMap<>();
        userInput.put("mainMenuChoice", choice);

        switch (choice.intValue()) {
            case 1: {
                which = MoneyFlowQuestioner.whichQuestioner();
                operationName = "select";
                break;
            }
            case 2: {
                which = MoneyFlowQuestioner.whichQuestioner();
                operationName = "insert.gui";
                break;
            }

            case 3: return new ViewData("MainMenu", "");
            default: return new ViewData(null, null);
        }

        return new ViewData("MoneyFlow", operationName, new HashMap<>());
    }

    @Override
    public String toString() {
        return "Main Menu View";
    }
}
