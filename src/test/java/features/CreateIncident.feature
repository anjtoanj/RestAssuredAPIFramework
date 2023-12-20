Feature:  Create a New Incident

@CreateIncident
Scenario: Create a new incident with short description 
	Given enable logs
	And short description is "Added From Cucumber"
	When new incident is created
	Then verify the status code is 201
	And response includes the following
	|result.sys_created_by|admin|
	|result.sys_class_name|incident|