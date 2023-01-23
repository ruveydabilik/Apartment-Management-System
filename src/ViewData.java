package src;

import java.util.*;

public class ViewData {
	final String functionName;
	final String operationName;
	final Map<String, Object> viewParameters;
	String which_= "";

	ViewData(String functionName, String operationName) {
		this.functionName = functionName;
		this.operationName = operationName;
		this.viewParameters = null;
	}

	ViewData(String functionName, String operationName, Map<String, Object> viewParameters) {
		this.functionName = functionName;
		this.operationName = operationName;
		this.viewParameters = viewParameters;
	}
	ViewData(String functionName, String operationName, Map<String, Object> viewParameters, String which_) {
		this.functionName = functionName;
		this.operationName = operationName;
		this.viewParameters = viewParameters;
		this.which_ = which_;
	}
	
	@Override
	public String toString() {
		return "Function name = " + functionName + " / " + operationName + " : " + viewParameters.toString();
	}
	
}
