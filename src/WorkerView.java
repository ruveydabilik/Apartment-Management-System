package src;

import java.sql.ResultSet;
import java.util.*;


class WorkerView implements ViewInterface {
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
                System.out.print(ResidentID + "\t");
                System.out.print(Name + "\t");
                if (MiddleName == null){
                    System.out.println(" " + "\t");
                }
                else{
                    System.out.print(MiddleName + "\t");
                }
                System.out.println(Surname + "\t");
                System.out.println(EntryDate + "\t");
                if (ExitDate == null ){
                    System.out.println("Current resident " + "\t");
                }
                else{
                    System.out.println(ExitDate + "\t");
                }
                System.out.println(ContactNo + "\t");

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

    Map<String, Object> getWhereParameters() throws Exception {
        System.out.println("Filter conditions:");
        Integer ResidentID = getInteger("ResidentId : ", true);
        String Name = getString("Name: ", true);
        String MiddleName = getString("MiddleName: ", true); //null hatası varsa varsa burdan
        String Surname = getString("Surname: ", true);
        Date EntryDate = getDate("EntryDate: ", true);
        Date ExitDate = getDate("ExitDate: ", true); //null hatası varsa varsa burdan
        String ContactNo = getString("ContactNo: ", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (ResidentID != null) whereParameters.put("EmployeeID", ResidentID);
        if (Name != null) whereParameters.put("Name", Name);
        if (MiddleName != null) whereParameters.put("MiddleName", MiddleName);
        if (Surname != null) whereParameters.put("Surname", Surname);
        if (EntryDate != null) whereParameters.put("EntryDate", EntryDate);
        if (ExitDate != null) whereParameters.put("ExitDate", ExitDate);
        if (ContactNo != null) whereParameters.put("ContactNo", ContactNo);

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Employee", "select", parameters);
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
            ResidentID = getInteger("ResidentID: ", true);
            if(ResidentID == null)
                break;
            Name = getString("Name: ", true);
            MiddleName = getString("MiddleName: ", true);
            Surname = getString("MiddleName: ", true);
            EntryDate = getDate("EntryDate: ", true);
            ExitDate = getDate("ExitDate: ", true);
            ContactNo = getString("ContactNo: ", true);

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
        Integer employeeID = getInteger("EMployee ID: ", true);
        String firstName = getString("First Name : ", true);
        String lastName = getString("Last Name : ", true);
        String eMail = getString("E-mail: ", true);
        String experienceLevel = getString("Experience Level(Junior - Senior): ", true);
        String location = getString("Location: ", true);
        Integer authority = getInteger("Authority(0 - 1): ", true);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (employeeID != null) updateParameters.put("EmployeeID", employeeID);
        if (firstName != null) updateParameters.put("FirstName", firstName);
        if (lastName != null) updateParameters.put("FastName", lastName);
        if (eMail != null) updateParameters.put("Email", eMail);
        if (experienceLevel != null) updateParameters.put("ExperienceLevel", experienceLevel);
        if (location != null) updateParameters.put("Location", location);
        if (authority != null) updateParameters.put("Authority", authority);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Employee", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Resident", "delete", parameters);
    }


    @Override
    public String toString() {
        return "Employee View";
    }
}
