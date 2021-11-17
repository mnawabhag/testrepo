Feature: Orange HRM login page check

 Scenario: Logo presence on orange hrm homepage
  Given I launch chrome browser
  When I open orange hrm homepage
  Then I verify that the logo is present
  And close browser

 Scenario Outline: login with valid credentials
  Given I launch chrome browser
  When I open orange hrm homepage
  Then I enter valid "<username>" and "<password>"
  When I click submit button
  Then I login to the application page and Dashboard is visible
  And close browser
  Examples:
   |username  |password |
   |Admin     |admin123 |
   |lalla     |vslnslnnl |