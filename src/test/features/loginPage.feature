Feature: Login functionality using the demo site for POC

  As a user of the site
  I want to login to the site
  so that i can perform the required actions from my account

  Background:
    Given Go to the webpage

  Scenario: Login with successful credential
    Given Enter the correct credential
    When Click on login button
    Then I should able to login successfully

  Scenario: Login with successful credential
    Given Enter the correct credential
    When Click on login button
    Then I should able to login successfully
    Then I should able to logout successfully