
package src;

import java.sql.*;
import java.util.*;


class MoneyFlowModel implements ModelInterface {
    String which;

    public ResultSet select(Map<String, Object> whereParameters) throws Exception {

        which = MoneyFlowQuestioner.storage();
        String _whichFlow = "dbo." + which.trim();
        String ID = which.trim() + "Id";


        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append(ID +" , ApartmentId, ResidentId, Amount, Description, Date, ParentId");
        sql.append(" FROM " + _whichFlow);

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));

        sql.append(" ORDER BY " + ID);
        //System.out.println(sql.toString() + "\n");

        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();

        return result;
    }


    public int insert(String fieldNames, List<Object> rows) throws Exception {

        which = MoneyFlowQuestioner.storage();
        String _whichFlow = "dbo." + which.trim();
        String ID = which.trim() + "Id";

        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO " + _whichFlow + " (" + fieldNames + ") ");
        //  sql.append("	ResidentId, Name , MiddleName, Surname, EntryDate, ExitDate, ContactNo");
        sql.append(" VALUES ");

        String[] fieldList = fieldNames.split(",");

        int rowCount = 0;
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i) instanceof MoneyFlow) {
                rowCount++;

                MoneyFlow moneyFlow = (MoneyFlow) rows.get(i);

                sql.append("(");
                for (int j = 0; j < fieldList.length; j++) {
                    String fieldName = fieldList[j].trim();
                    sql.append(DatabaseUtilities.formatField(moneyFlow.getByName(fieldName)));
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

    @Override
    public int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
        return 0;
    }

    @Override
    public int delete(Map<String, Object> whereParameters) throws Exception {
        return 0;
    }

    public ModelData execute(ViewData viewData) throws Exception {
        return ModelInterface.super.execute(viewData);
    }

    @Override
    public String toString() {
        return "MoneyFlow Model";
    }
}

