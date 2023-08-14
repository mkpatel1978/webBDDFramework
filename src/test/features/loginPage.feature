Feature: Login functionality using the demo site for POC

  As a user of the site
  I want to login to the site
  so that i can perform the required actions from my account

  Background:
    Given Go to the webpage

  Scenario: Login following Logout successful.
    Given Enter the correct credential
    When Click on login button
    Then I should able to login successfully
    Then I should able to logout successfully

  Scenario: Verify incorrect Login.
    Given Enter the incorrect credential
    When Click on login button
    Then I should able to see failure login