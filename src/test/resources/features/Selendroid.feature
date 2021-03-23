Feature: Test Selendroid Test App

	@Scenario1
  Scenario: Verify title and elements on screen
    Given user launches application
    Then user verifies title
    And user verifies elements on application

	@Scenario2
  Scenario: Check if homepage is displayed
  	Given user is on homepage
  	When user clicks on EN button
  	And selects [No, no]
    Then user should be on homepage

  @Scenario3
  Scenario: Check Chrome Logo
  	Given user is on homepage
  	When user verifies the title
  	And verify text header
  	Then enters name as "Akash"
 
 	@Scenario5
  Scenario: Check Progress Bar
  	Given user is on homepage
  	When clicks on progress bar
  	And waits for loader to disappear
  	Then verifies the registration page
  	
  	@Scenario6
  Scenario: Check Display Toast
  	Given user is on homepage
  	And clicks on display toast button
  	Then verifies toast text
  	
  	@Scenario7
  Scenario: Check Display Popup
  	Given user is on homepage
  	And clicks on display popup button
  	Then clicks on dismiss button
  	
  	@Scenario8
  Scenario: Check unhandles exception
  	Given user is on homepage
  	And clicks on exception button
  	Then verifies homescreen title
  	
  	@Scenario9
  Scenario: Check exception field
  	Given user is on homepage
  	And type "test" in the field
  	Then verifies homescreen title 
  	