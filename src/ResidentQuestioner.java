package src;

import java.util.Scanner;

public class ResidentQuestioner {
    static String which;

    public static void wanterApartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Which apartment?: ");
        which = scanner.nextLine();
    }

    public static String storage(){
        return which;
    }

}
