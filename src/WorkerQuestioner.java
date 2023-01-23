package src;

import java.util.Scanner;

public class WorkerQuestioner {

    static String which;
    public static String whichWorker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which worker ?:");
        which = scanner.nextLine();
        return which;
    }

    public static String storage(){
        return which;
    }
}
