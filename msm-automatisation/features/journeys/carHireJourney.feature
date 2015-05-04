Feature: Car hire journey journey
Description: This feature will check Car hire full journey

Scenario: Check the ability to find results with Car hire search gadget
	Given I am on SuperHomePage
	When I open Car hire search gadget
	And I fill Car hire form by minimum profile
	And I submit Car hire Search gadget form
	And I wait for page absolutely load
	And I wait for all providers load
	Then I am taken to the Car hire results page