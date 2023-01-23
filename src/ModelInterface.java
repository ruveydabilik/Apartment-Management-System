package src;

import java.sql.*;
import java.util.*;


interface ModelInterface {

	abstract ResultSet select(Map<String, Object> whereParameters , String which_) throws Exception;
	
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
				
				ResultSet resultSet = select(whereParameters, which_);
				
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
