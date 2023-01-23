package src;

class Controller {
	private ViewInterface view;
	private ModelInterface model;
	
	Controller(ViewInterface view, ModelInterface model) {
		this.view = view;
		this.model = model;
	}
	
	ModelData executeModel(ViewData viewData, String which_) throws Exception {
		return model.execute(viewData, which_);
	}

	ViewData getView(ModelData modelData, String functionName, String operationName) throws Exception {
		return view.create(modelData, functionName, operationName);
	}
	
	@Override
	public String toString() {
		return "Controller with " + model + " and " + view;
	}	
	
}
