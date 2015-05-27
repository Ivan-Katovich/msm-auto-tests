Feature: Flights journey
Description: This feature will check flights full journey

@first
Scenario: Check the ability to find results with Flights search gadget
	Given I am on SuperHomePage
	When I click on the superHomePageElement 'flightsFormButton'
	And I fill superHomePage form by 'minimumFlightsProfile' profile
	And I click on the superHomePageElement 'flyingSearchButton'
	And I wait for page absolutely load
	#And I wait for all providers load
	Then I am taken to the FlightsResults page