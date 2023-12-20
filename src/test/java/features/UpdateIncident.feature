Feature:  Update Incident

@UpdateIncident
Scenario: Update incident with short description 
	Given enable logs
	And add the query parameters
	|short_description |Updated From Cucumber|
	And send the get request
#	When update the incident with "short_description" as "Using put method for hamcrest"
#	Then verify the status code is 201
