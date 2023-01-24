package src;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.sql.ResultSet;
import java.util.*;
import java.text.SimpleDateFormat;


class WorkerView implements ViewInterface {

    String which;
    public static int calculateAge(String birthdate){
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        System.out.println(date);
        LocalDate dob = LocalDate.parse((CharSequence) birthdate);
        return Period.between(dob, LocalDate.parse(date)).getYears();
    }
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
        which = WorkerQuestioner.storage();
        String _whichWorker = "dbo." + which.trim();
        String ID = which.trim() + "Id";
        //Integer intID = Integer.parseInt(ID);

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int WorkerID = resultSet.getInt(ID);
                String Name = resultSet.getString("Name");
                String MiddleName = resultSet.getString("MiddleName");
                String Surname = resultSet.getString("Surname");
                float Salary = resultSet.getFloat("Salary");
                int AptNo = resultSet.getInt("AptNo");
                Date JobTime = resultSet.getDate("JobTime");
                String IbanNo = resultSet.getString("IbanNo");
                Date BirthDate = resultSet.getDate("Birthdate");
                String Gender = resultSet.getString("Gender");
                //Integer Age;
                //String date = BirthDate.toString();
                //Age = calculateAge(date);

                // Display values
                System.out.println(ID+ ": " + WorkerID);
                System.out.print("Name: " + Name);
                if (MiddleName != null){
                    System.out.print(" " + MiddleName);
                }
                System.out.println("\nSurname: " + Surname);
                System.out.println("Salary: " + Salary);
                System.out.println("AptNo: " + AptNo);
                System.out.println("JobTime: " + JobTime);
                System.out.println("IbanNo: " + IbanNo);
                System.out.println("BirthDate: " + BirthDate);
                System.out.println("Gender: " + Gender);

            }
            resultSet.close();
        }

        return new ViewData("WorkerMenu", "");
    }

    ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);

        return new ViewData("WorkerMenu", "");
    }

    ViewData updateOperation(ModelData modelData) throws Exception {
        System.out.println("Number of updated rows is " + modelData.recordCount);

        return new ViewData("WorkerMenu", "");
    }

    ViewData deleteOperation(ModelData modelData) throws Exception {
        System.out.println("Number of deleted rows is " + modelData.recordCount);

        return new ViewData("WorkerMenu", "");
    }

    Map<String, Object> getWhereParameters() throws Exception {
        which = WorkerQuestioner.storage();
        String _whichWorker = "dbo." + which.trim();
        String ID = which.trim() + "Id";
        //Integer intID = Integer.parseInt(ID);

        System.out.println("Filter conditions:");
        Integer WorkerID = getInteger(ID +" : ", false);
        /*String Name = getString("Name: ", false);
        String MiddleName = getString("MiddleName: ", true); //null hatası varsa varsa burdan
        String Surname = getString("Surname: ", false);
        Float Salary = getFloat("Salary: ", false);
        Integer AptNo = getInteger("AptNo", true);
        Date JobTime = getDate("JobTime", false);
        String IbanNo = getString("IbanNo", false);
        Date BirthDate = getDate("Birthdate", false);
        String Gender = getString("Gender", false);
        Integer Age;
        String date = BirthDate.toString();
        Age = calculateAge(date);*/

        Map<String, Object> whereParameters = new HashMap<>();
        if (WorkerID != null) whereParameters.put(ID , WorkerID);
        /*if (Name != null) whereParameters.put("Name", Name);
        if (MiddleName != null) whereParameters.put("MiddleName", MiddleName);
        if (Surname != null) whereParameters.put("Surname", Surname);
        if (Salary != null) whereParameters.put("Salary", Salary);
        if (AptNo != null) whereParameters.put("AptNo", AptNo);
        if (JobTime != null) whereParameters.put("JobTime", JobTime);
        if (IbanNo != null) whereParameters.put("IbanNo", IbanNo);
        if (BirthDate != null) whereParameters.put("BirthDate", BirthDate);
        if (Gender != null) whereParameters.put("Gender", Gender);
        if (Age != null) whereParameters.put("Age", Age);*/

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Worker", "select", parameters);
    }

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        which = WorkerQuestioner.storage();
        String _whichWorker = "dbo." + which.trim();
        String ID = which.trim() + "Id";
        //Integer intID = Integer.parseInt(ID);
        parameters.put("fieldNames","Name, MiddleName, Surname, Salary, AptNo, JobTime, IbanNo, BirthDate, Gender");

        List<Object> rows = new ArrayList<>();

        Integer WorkerID;
        String Name, MiddleName, Surname, IbanNo, Gender;
        String JobTime,BirthDate;
        Float Salary;
        Integer AptNo;
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
            Salary = getFloat("Salary: ", false);
            if(Salary == null)
                break;
            AptNo = getInteger("AptNo: ", true);
            JobTime = getString("JobTime: ", false);
            if(JobTime == null)
                break;
            IbanNo = getString("IbanNo: ", false);
            if(IbanNo== null)
                break;
            BirthDate = getString("BirthDate: ", false);
            if(BirthDate== null)
                break;
            Gender = getString("Gender", false);
            if(Gender == null)
                break;

            Date Jtime = java.sql.Date.valueOf(JobTime);
            Date Birthdate = java.sql.Date.valueOf(BirthDate);

            System.out.println();

            if ( Name != null  && Surname != null && Salary != null && Jtime != null && IbanNo != null && Birthdate != null && Gender != null) {
                rows.add(new Worker(Name, MiddleName, Surname, Salary, AptNo, Jtime,IbanNo,Birthdate,Gender));
            }
            flag = false;
        }

        parameters.put("rows", rows);

        return new ViewData("Worker", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {


        Map<String, Object> updateParameters = new HashMap<>();
        which = WorkerQuestioner.storage();
        String _whichWorker = "dbo." + which.trim();
        String ID = which.trim() + "Id";
        //Integer intID = Integer.parseInt(ID);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        System.out.println("Fields to update:");

       // Integer WorkerID = getInteger(ID +" : ", false);
        String Name = getString("Name: ", false);
        String MiddleName = getString("MiddleName: ", true); //null hatası varsa varsa burdan
        String Surname = getString("Surname: ", false);
        Float Salary = getFloat("Salary: ", false);
        Integer AptNo = getInteger("AptNo: ", true);
        String JobTime = getString("JobTime: ", false);
        String IbanNo = getString("IbanNo: ", false);
        String BirthDate = getString("Birthdate: ", false);
        String Gender = getString("Gender: ", false);
        //Integer Age;
        //String date = BirthDate.toString();
        //Age = calculateAge(date);
        Date Jtime = java.sql.Date.valueOf(JobTime);
        Date Birthdate = java.sql.Date.valueOf(BirthDate);
        //if (WorkerID != null) updateParameters.put(ID , WorkerID);
        if (Name != null) updateParameters.put("Name", Name);
        if (MiddleName != null) updateParameters.put("MiddleName", MiddleName);
        if (Surname != null) updateParameters.put("Surname", Surname);
        if (Salary != null) updateParameters.put("Salary", Salary);
        if (AptNo != null) updateParameters.put("AptNo", AptNo);
        if (Jtime != null) updateParameters.put("JobTime", Jtime);
        if (IbanNo != null) updateParameters.put("IbanNo", IbanNo);
        if (Birthdate != null) updateParameters.put("BirthDate", Birthdate);
        if (Gender != null) updateParameters.put("Gender", Gender);
        //if (Age != null) updateParameters.put("Age", Age);


        parameters.put("updateParameters", updateParameters);

        return new ViewData("Worker", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Worker", "delete", parameters);
    }


    @Override
    public String toString() {
        return "Worker View";
    }
}
