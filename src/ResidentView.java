package src;

import java.sql.ResultSet;
import java.util.*;


class ResidentView implements ViewInterface {
        //String whichResident_ = whichResident;
    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        switch(operationName) {
            case "select": return selectOperation(modelData);
            case "insert": return insertOperation(modelData);
            case "update": return updateOperation(modelData);
            case "delete": return deleteOperation(modelData);
            case "select.gui": return selectGUI(modelData);
            case "insert.gui": return insertGUI(modelData);
            case "update.gui": return updateGUI(modelData);
            case "delete.gui": return deleteGUI(modelData);
        }

        return new ViewData("MainMenu", "");
    }

    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int ResidentID = resultSet.getInt("ResidentId");
                String Name = resultSet.getString("Name");
                String MiddleName = resultSet.getString("MiddleName");
                String Surname = resultSet.getString("Surname");
                Date EntryDate = resultSet.getDate("EntryDate");
                Date ExitDate = resultSet.getDate("ExitDate");
                String ContactNo = resultSet.getString("ContactNo");

                // Display values
                System.out.println("ResidentID: " + ResidentID);
                System.out.print("Name: " + Name);
                if (MiddleName != null){
                    System.out.print(" " + MiddleName);
                }
                System.out.println("\nSurname: " + Surname);
                System.out.println("ContactNo: " + ContactNo);
                System.out.println("EntryDate: " + EntryDate);
                if (ExitDate == null ){
                    System.out.println("Current resident ");
                }
                else{
                    System.out.println("ExitDate: " + ExitDate + "\t");
                }

                System.out.println("");

            }
            resultSet.close();
        }

        return new ViewData("ResidentMenu", "");
    }

    ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);

        return new ViewData("ResidentMenu", "");
    }

    ViewData updateOperation(ModelData modelData) throws Exception {
        System.out.println("Number of updated rows is " + modelData.recordCount);

        return new ViewData("ResidentMenu", "");
    }

    ViewData deleteOperation(ModelData modelData) throws Exception {
        System.out.println("Number of deleted rows is " + modelData.recordCount);

        return new ViewData("ResidentMenu", "");
    }

    Map<String, Object> getWhereParametersForSelect() throws Exception {
        System.out.println("Enter the ID that would you like to select: ");
        Integer ResidentID = getInteger("ResidentId : ", false);

        Map<String, Object> whereParameters = new HashMap<>();
        if (ResidentID != null) whereParameters.put("ResidentID", ResidentID);

        return whereParameters;
    }

    Map<String, Object> getWhereParametersForUpdate() throws Exception {
        System.out.println("Enter the ID that would you like to update:");
        Integer ResidentID = getInteger("ResidentId : ", false);

        Map<String, Object> whereParameters = new HashMap<>();
        if (ResidentID != null) whereParameters.put("ResidentID", ResidentID);

        return whereParameters;
    }

    Map<String, Object> getWhereParametersForDelete() throws Exception {
        System.out.println("Enter the ID that would you like to delete: ");
        Integer ResidentID = getInteger("ResidentId : ", false);

        Map<String, Object> whereParameters = new HashMap<>();
        if (ResidentID != null) whereParameters.put("ResidentID", ResidentID);

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParametersForSelect());

        return new ViewData("Resident", "select", parameters);
    }

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "ResidentID, Name, MiddleName, Surname, EntryDate, ExitDate, ContactNo");

        List<Object> rows = new ArrayList<>();

        Integer ResidentID;
        String Name, MiddleName, Surname, ContactNo;
        Date EntryDate, ExitDate;
        while(true) {
            System.out.println("Fields to insert:");
            ResidentID = getInteger("ResidentID: ", false);
            if(ResidentID == null)
                break;
            Name = getString("Name: ", false);
            if(Name == null)
                break;
            MiddleName = getString("MiddleName: ", true);
            Surname = getString("Surname: ", false);
            if(Surname == null)
                break;
            EntryDate = getDate("EntryDate: ", false);
            if(EntryDate == null)
                break;
            ExitDate = getDate("ExitDate: ", true);
            ContactNo = getString("ContactNo: ", true);
            if(ContactNo == null)
                break;

            /*while(!(authority >= 0) || !(authority <= 1)){
                System.out.println("Authority must be either 0 or 1!!!");
                authority = getInteger("Authority(0 - 1): ", true);
            }*/
            System.out.println();

            if (ResidentID != null && Name != null && MiddleName != null && Surname != null && EntryDate != null && ExitDate != null && ContactNo != null) {
                rows.add(new Resident(ResidentID, Name, MiddleName, Surname, EntryDate, ExitDate, ContactNo));
            }
        }

        parameters.put("rows", rows);

        return new ViewData("Resident", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Integer ResidentID = getInteger("ResidentID: ", false);
        String Name = getString("Name : ", false);
        String MiddleName = getString("MiddleName : ", true);
        String Surname = getString("Surname: ", false);
        Date EntryDate = getDate("EntryDate: ", false);
        Date ExitDate = getDate("ExitDate: ", true);
        String ContactNo = getString("ContactNo: ", false);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (ResidentID != null) updateParameters.put("ResidentID", ResidentID);
        if (Name != null) updateParameters.put("Name", Name);
        if (MiddleName != null) updateParameters.put("MiddleName", MiddleName);
        if (Surname != null) updateParameters.put("Surname", Surname);
        if (EntryDate != null) updateParameters.put("EntryDate", EntryDate);
        if (ExitDate != null) updateParameters.put("ExitDate", ExitDate);
        if (ContactNo != null) updateParameters.put("ContactNo", ContactNo);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParametersForUpdate());

        return new ViewData("Resident", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParametersForDelete());

        return new ViewData("Resident", "delete", parameters);
    }


    @Override
    public String toString() {
        return "Employee View";
    }
}
