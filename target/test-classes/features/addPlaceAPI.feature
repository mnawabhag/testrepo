Feature: Validating Places API

Scenario Outline: Verify if place is being successfully added
	Given Add place payload with "<name>" "<language>" "<address>"
	When user call "AddPlaceAPI" api with "POST" request 
	Then the api call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And  verify place_Id created maps to "<name>" using "getPlaceAPI"
	
Examples:
	|name   |language |address |
	|chinnya|English  |vidyagiri|
#	|Shivaraj|Kannada|kudrikannur|