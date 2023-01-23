package src;

import java.sql.*;
import java.util.*;
import java.text.ParseException;

import static javax.swing.UIManager.getString;


class ResidentModel implements ModelInterface {

	String which;
	Scanner scanner = new Scanner(System.in);

	public void wanterApartment() {

		System.out.printf("Which apartment?: ");
		which = scanner.nextLine();

	}

	public ResultSet select(Map<String, Object> whereParameters) throws Exception {

		wanterApartment();

		String whichApartment = "dbo.Resident" + which.trim();
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("ResidentID, Name, MiddleName, Surname, EntryDate, ExitDate, ContactNo");
		sql.append(" FROM " + whichApartment);

		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		
		sql.append(" ORDER BY ResidentID");

		// execute constructed SQL statement
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
		ResultSet result = preparedStatement.executeQuery();
		
		return result;
	}

	public int insert(String fieldNames, List<Object> rows) throws Exception
	{

		wanterApartment();

		String whichResident = "dbo.Resident" + which.trim();
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO " + whichResident +" (" + fieldNames + ") " );
		//sql.append("	Name , MiddleName, Surname, EntryDate, ExitDate, ContactNo");
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

	public int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception
	{

		//String whichResident = "dbo.Resident" + which.trim();
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE " + whereParameters.get("ResidentID") + " SET ");
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


	public int delete(Map<String,Object> whereParameters) throws Exception
	{
		String whichResident = "dbo.Resident" + which.trim();
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM " + whichResident);

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

	public ModelData execute(ViewData viewData) throws Exception {
		return ModelInterface.super.execute(viewData);
	}

	@Override
	public String toString() {
		return "Resident Model";
	}		
}
