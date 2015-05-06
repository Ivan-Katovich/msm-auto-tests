Feature: Check SuperHomePage elements
Description: This feature will check super home page elements visibility

@first
Scenario: Check logo, main menu, main title and SG buttons
	Given I am on SuperHomePage
	Then I sould see elements: search gadget, main logo
	And I sould see following text of the SuperHomePage main title: 'Leave London behind Where do you want to go today?'
	And I sould see following search gadget buttons: 'Holidays', 'Flights', 'Car Hire', 'Hotels', 'Insurance'