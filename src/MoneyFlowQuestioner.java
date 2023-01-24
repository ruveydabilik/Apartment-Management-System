package src;

import java.util.Scanner;

public class MoneyFlowQuestioner {

    static String which;
    public static String whichQuestioner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Income or Outcome?:");
        which = scanner.nextLine();
        return which;
    }

    public static String storage(){
        return which;
    }
}