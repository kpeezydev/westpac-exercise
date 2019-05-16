Feature: Display Message
Scenario: User should be able to see the help text in the webpage for the age field

 Given user is on calculator page
 When user clicks on help icon for the age field
 Then user should see the help text