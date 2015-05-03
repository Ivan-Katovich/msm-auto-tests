Feature: SuperHomePage elements
Description: This feature will check super home page elements visibility

Scenario: Check logo, main menu, main title and SG buttons
	Given I am on SuperHomePage
	Then I sould see elements: search gadget, main logo
	Then I sould see following text of the SuperHomePage main title: 'Leave Londonn behind Where do you want to go today?'
	Then I sould see following search gadget buttons: 'Holidays', 'Flights', 'Car Hire', 'Hotels', 'Insurance'