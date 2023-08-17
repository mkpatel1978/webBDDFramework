Feature: Login functionality using the demo site for POC

  As a user of the site
  I want to login to the site
  so that i can perform the required actions from my account

  Background:
    Given Go to the webpage for admin

  Scenario: Go to Admin section.
    Given Login to website
    When Click on Admin section
    Then I should able to browse Admin section
    Then I should able to logout successfully from adminpage
    Then Ensure Application is closed Admin
#    Then Ensure Application is closed