package src;

import java.sql.*;
import java.util.*;


interface ModelInterface {

<<<<<<< HEAD
	abstract ResultSet select(Map<String, Object> whereParameters , String which_) throws Exception;
=======
	abstract ResultSet select(Map<String, Object> whereParameters) throws Exception;
>>>>>>> d0bb06dfe6279e6ba2a068225d2044deac0e336a
	
	abstract int insert(String fieldNames, List<Object> rows, String which_) throws Exception;
		
	abstract int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters, String which_) throws Exception;

	abstract int delete(Map<String,Object> whereParameters, String which_) throws Exception;
	
	default ModelData execute(ViewData viewData, String which_) throws Exception {
		if (viewData.viewParameters == null) {
			return new ModelData();
		}
	
		switch(viewData.operationName) {
			case "select":
			{
				//String which
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
<<<<<<< HEAD
				ResultSet resultSet = select(whereParameters, which_);
=======
				ResultSet resultSet = select(whereParameters);
>>>>>>> d0bb06dfe6279e6ba2a068225d2044deac0e336a
				
				return new ModelData(viewData.functionName, resultSet);
			}
			case "insert":
			{
				String fieldNames = (String)(viewData.viewParameters.get("fieldNames"));
				List<Object> rows = (List<Object>)(viewData.viewParameters.get("rows"));
				
				int recordCount = insert(fieldNames, rows, which_);
				
				return new ModelData(viewData.functionName, recordCount);
			}
			case "update":
			{
				Map<String, Object> updateParameters = (Map<String, Object>)(viewData.viewParameters.get("updateParameters"));
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
				int recordCount = update(updateParameters, whereParameters, which_);
				
				return new ModelData(viewData.functionName, recordCount);
			}
			case "delete":
			{
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
				int recordCount = delete(whereParameters,which_);
				
				return new ModelData(viewData.functionName, recordCount);
			}
		}
		
		return new ModelData();
	}
	
}
