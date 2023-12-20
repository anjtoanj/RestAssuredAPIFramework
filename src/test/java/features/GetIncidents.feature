Feature: Get all Incidents

@GetIncident
Scenario: Get all incidents 
	Given enable logs
	And add the query parameters
	|sysparm_fields|sys_id, sys_created_by,sys_class_name,number, category, short_description, description|
	|short_description      |Unable to connect to email|
		
	When get all incident request
	Then verify the status code is 200
	And validate the response
	|result.sys_created_by|employee|
