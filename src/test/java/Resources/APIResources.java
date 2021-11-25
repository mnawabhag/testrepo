package Resources;

public enum APIResources {
	//collection of constants or methods
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String string;

	APIResources(String string) {

		this.string=string;
		
	}
	
	public String getResource() {
		return string;
	}
	
	
}
