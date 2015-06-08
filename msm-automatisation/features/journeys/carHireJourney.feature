Feature: Car hire journey journey
Description: This feature will check Car hire full journey

@second
Scenario: Check the ability to find results with Car hire search gadget
	Given I am on SuperHomePage
	When I click on the superHomePageElement 'carHireFormButton'
	And I fill superHomePage form by 'minimumCarHireProfile' profile
	And I click on the superHomePageElement 'carHireSearchButton'
	And I wait for page absolutely load
	And I wait for all providers load
	Then I am taken to the CarHireResults page
	Then I click on the '1'st element of 'viewDealButtons' group
	When I switch to another handle
#	And I wait for page absolutely load
	Then I am taken to the page contains URL 'http://www.sit1.gb.travelsupermarket.com/beta/en-gb/interstitial'
	When I am automaticaly redirected
#	And I wait for page absolutely load
	Then I am taken to the page contains URL 'www.arguscarhire.com/'