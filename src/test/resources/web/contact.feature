@web @contact
Feature: Contact

  @send-message
  Scenario: Send Message
    Given user is on homepage
    And user click login on navigation tab
    And user input username with "user_1_new"
    And user input password with "password1"
    And user click login button
    And user click contact on navigation tab
    When user input all contact info
    And user click send
    Then user successfully send message and popup will appear
    And user click logout button