Feature: Check SuperHomePage elements
Description: This feature will check super home page elements visibility

@first
Scenario: Check logo, main menu, main title and SG buttons
	Given I am on SuperHomePage
	Then the superHomePage element 'mainLogo' is visible
	And the superHomePage element 'mainMenu' is visible
	And the superHomePage element 'mainTitle' has the text 'Leave London behind Where do you want to go today?'
	And the superHomePage element 'holidaysFormButton' has the text 'Holidays'
	And the superHomePage element 'flightsFormButton' has the text 'Flights'
	And the superHomePage element 'carHireFormButton' has the text 'Car Hire'
	And the superHomePage element 'hotelsFormButton' has the text 'Hotels'
	And the superHomePage element 'insuranceFormButton' has the text 'Insurance'