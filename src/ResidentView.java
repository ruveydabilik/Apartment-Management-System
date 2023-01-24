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
        //System.out.println("Enter the ApartmentID that would you like to update:");
        //Integer ApartmentID = getInteger("ApartmentId : ", false);

        //Integer id = Integer.parseInt(ResidentQuestioner.storage());
        System.out.println("Enter the ResidentID that would you like to update:");
        Integer ResidentID = getInteger("ResidentId : ", false);

        Map<String, Object> whereParameters = new HashMap<>();
        //if (id != null) whereParameters.put("ApartmentID", id);
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
        parameters.put("fieldNames", "Name, MiddleName, Surname, EntryDate, ExitDate, ContactNo");

        List<Object> rows = new ArrayList<>();

        Integer ResidentID;
        String Name, MiddleName, Surname, ContactNo;
        String EntryDate, ExitDate;
        boolean flag = true;

        while(flag) {
            System.out.println("Fields to insert:");
            Name = getString("Name: ", false);
            if(Name == null)
                break;
            MiddleName = getString("MiddleName: ", true);
            Surname = getString("Surname: ", false);
            if(Surname == null)
                break;
            EntryDate = getString("EntryDate: ", false);
            if(EntryDate == null)
                break;
            ExitDate = getString("ExitDate: ", true);
            /*if(ExitDate == null){
                ExitDate = "";
            }*/
            ContactNo = getString("ContactNo: ", true);
            if(ContactNo == null) {
                break;
            }

            System.out.println();
            Date Entry = java.sql.Date.valueOf(EntryDate);
            Date Exit = java.sql.Date.valueOf(ExitDate);
            //Date Exit = null;
            /*if(ExitDate.equals(null)){
                Exit = null;
            }*/

            /*java.sql.Date sqlExitDate =  java.sql.Date.valueOf(EntryDate);*/

            if ( Name != null && Surname != null && Entry != null && ContactNo != null) {
                rows.add(new Resident(Name, MiddleName, Surname, Entry, Exit, ContactNo));
            }
            flag = false;
        }

        parameters.put("rows", rows);

        return new ViewData("Resident", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {

        Map<String, Object> updateParameters = new HashMap<>();
        Map<String, Object> parameters = new HashMap<>();

        String which = ResidentQuestioner.storage();
        String whichApartment = "dbo.Resident" + which.trim();

        parameters.put("whereParameters", getWhereParametersForUpdate());

        System.out.println("Fields to update:");
        //Integer ResidentID = getInteger("ResidentID: ", false);
        String Name = getString("Name : ", false);
        String MiddleName = getString("MiddleName : ", true);
        String Surname = getString("Surname: ", false);
        String EntryDate = getString("EntryDate: ", false);
        String ExitDate = getString("ExitDate: ", true);
        String ContactNo = getString("ContactNo: ", false);
        System.out.println();

        Date Entry = java.sql.Date.valueOf(EntryDate);
        Date Exit = java.sql.Date.valueOf(ExitDate);

        //if (ResidentID != null) updateParameters.put("ResidentID", ResidentID);
        if (Name != null) updateParameters.put("Name", Name);
        if (MiddleName != null) updateParameters.put("MiddleName", MiddleName);
        if (Surname != null) updateParameters.put("Surname", Surname);
        if (Entry != null) updateParameters.put("EntryDate", Entry);
        if (Exit != null) updateParameters.put("ExitDate", Exit);
        if (ContactNo != null) updateParameters.put("ContactNo", ContactNo);



        parameters.put("updateParameters", updateParameters);


        return new ViewData("Resident", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParametersForDelete());

        return new ViewData("Resident", "delete", parameters);
    }


    @Override
    public String toString() {
        return "Resident View";
    }
}
