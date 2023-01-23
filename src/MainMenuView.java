package src;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class MainMenuView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

		Integer choice;
		do {
			System.out.println("1. Resident Operations");
			System.out.println("2. Worker Operations");
			System.out.println("3. Quit");
			System.out.println();

			choice = getInteger("Enter your choice : ", false);
		}
		while (choice == null || choice < 1 || choice > 3);


		Map<String, Object> userInput = new HashMap<>();
		userInput.put("mainMenuChoice", choice);

		switch (choice.intValue()) {
			case 1:{
				System.out.println("Resident Menu icindeyiz");
				return new ViewData("ResidentMenu", "");
			}
			case 2:{
				System.out.println("Worker Menu icindeyiz");
				return new ViewData("WorkerMenu", "");
			}
			default:
			{
				System.out.println("Default içindeyiz");
				return new ViewData(null, null);
			}
		}
	}
	@Override
	public String toString() {
		return "Main Menu View";
	}
}