Feature: Flights journey
Description: This feature will check flights full journey

@run
Scenario: Check the ability to find results with Flights search gadget
	Given I am on SuperHomePage
	When I open Flights search gadget
	And I fill Flights form by minimum profile
	And I submit Flying Search gadget form
	And I wait for page absolutely load
#	And I wait for all providers load
	Then I am taken to the Flights results page