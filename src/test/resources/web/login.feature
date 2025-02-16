@web @login
Feature: Login

  @valid-login
  Scenario: Login with Valid Username & Password
    Given user is on homepage
    And user click login on navigation tab
    And user input username with "user_1_new"
    And user input password with "password1"
    When user click login button
    Then button logout will appear
    And user click logout button

  @wrong-password
  Scenario: Login with Invalid Password
    Given user is on homepage
    And user click login on navigation tab
    And user input username with "user_1_new"
    And user input password with "wrong_pass"
    When user click login button
    Then popup will appear and show error message