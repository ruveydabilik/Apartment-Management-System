package src;

import java.sql.*;
import java.util.*;


class WorkerModel implements ModelInterface {

<<<<<<< HEAD
    public ResultSet select(Map<String, Object> whereParameters, String whichWorker_) throws Exception {

        String whichWorker = "dbo." + whichWorker_.trim();
=======
    public ResultSet select(Map<String, Object> whereParameters, String whichResident_) throws Exception {

        String whichResident = "Resident" + whichResident_.trim();
>>>>>>> d0bb06dfe6279e6ba2a068225d2044deac0e336a
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("	ResidentID, Name, MiddleName, Surname, EntryDate, ExitDate, ContactNo");
<<<<<<< HEAD
        sql.append(" FROM " + whichWorker);
=======
        sql.append(" FROM " + whichResident);
>>>>>>> d0bb06dfe6279e6ba2a068225d2044deac0e336a

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));

        sql.append("ORDER BY ResidentID");
        //System.out.println(sql.toString() + "\n");

        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();

        return result;
    }


<<<<<<< HEAD
    public int insert(String fieldNames, List<Object> rows, String whichWorker_) throws Exception
    {
        String whichWorker = "dbo." + whichWorker_.trim();
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO "+ whichWorker +" (" + fieldNames + ") " );
      //  sql.append("	ResidentId, Name , MiddleName, Surname, EntryDate, ExitDate, ContactNo");
=======
    public int insert(String fieldNames, List<Object> rows, String whichResident_) throws Exception
    {
        String whichResident = "dbo.Resident" + whichResident_.trim();
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO "+ whichResident +" (" + fieldNames + ") " );
        sql.append("	ResidentId, Name , MiddleName, Surname, EntryDate, ExitDate, ContactNo");
>>>>>>> d0bb06dfe6279e6ba2a068225d2044deac0e336a
        sql.append(" VALUES ");

        String[] fieldList = fieldNames.split(",");

        int rowCount = 0;
        for (int i=0; i<rows.size(); i++) {
            if (rows.get(i) instanceof Resident) {
                rowCount++;

                Resident Resident = (Resident)rows.get(i);

                sql.append("(");
                for (int j=0; j<fieldList.length; j++) {
                    String fieldName = fieldList[j].trim();
                    sql.append(DatabaseUtilities.formatField(Resident.getByName(fieldName)));
                    if (j < fieldList.length - 1) {
                        sql.append(", ");
                    }
                }
                sql.append(")");

                if (i < rows.size() - 1) {
                    sql.append(", ");
                }
            }
        }
        //System.out.println(sql.toString());


        // execute constructed SQL statement
        if (rowCount > 0) {
            Connection connection = DatabaseUtilities.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            rowCount = preparedStatement.executeUpdate();
            preparedStatement.close();
        }

        return rowCount;
    }

<<<<<<< HEAD

    public int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters, String whichWorker_) throws Exception
    {
        String whichWorker = "dbo." + whichWorker_.trim();

        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE "+ whichWorker + " SET ");
=======
    @Override
    public ResultSet select(Map<String, Object> whereParameters) throws Exception {
        return null;
    }

    @Override
    public int insert(String fieldNames, List<Object> rows) throws Exception {
        return 0;
    }

    @Override
    public int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception
    {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE HumanResources.Resident SET ");
>>>>>>> d0bb06dfe6279e6ba2a068225d2044deac0e336a
        int appendCount = 0;
        for (Map.Entry<String, Object> entry : updateParameters.entrySet()) {
            sql.append(entry.getKey() + " = " + DatabaseUtilities.formatField(entry.getValue()));
            if (++appendCount < updateParameters.size()) {
                sql.append(", ");
            }
        }
        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
        //System.out.println(sql.toString());


        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        int rowCount = preparedStatement.executeUpdate();
        preparedStatement.close();

        return rowCount;
    }

<<<<<<< HEAD

    public int delete(Map<String,Object> whereParameters, String whichWorker_) throws Exception
    {
        String whichWorker = "dbo." + whichWorker_.trim();
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM " + whichWorker);
=======
    @Override
    public int delete(Map<String,Object> whereParameters) throws Exception
    {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM HumanResources.Resident ");
>>>>>>> d0bb06dfe6279e6ba2a068225d2044deac0e336a

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
        //System.out.println(sql.toString());


        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        int rowCount = preparedStatement.executeUpdate();
        preparedStatement.close();

        return rowCount;
    }

<<<<<<< HEAD

    public ModelData execute(ViewData viewData, String whichWorker_) throws Exception {
        return ModelInterface.super.execute(viewData, whichWorker_);
=======
    @Override
    public ModelData execute(ViewData viewData) throws Exception {
        return ModelInterface.super.execute(viewData);
>>>>>>> d0bb06dfe6279e6ba2a068225d2044deac0e336a
    }

    @Override
    public String toString() {
        return "Resident Model";
    }
}

