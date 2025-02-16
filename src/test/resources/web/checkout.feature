@web @checkout
Feature: Checkout

  @checkout-delete
  Scenario: Checkout then Delete Product
    Given user is on homepage
    And user click login on navigation tab
    And user input username with "user_1_new"
    And user input password with "password1"
    And user click login button
    And user click the product
    And verify it's the product
    And click add cart
    And verify popup and confirm
    And user click navbar cart
    And verify product cart is correct
    When user click delete product
    Then verify cart is empty
    And user click logout button

  @checkout-e2e
  Scenario: End to End Checkout
    Given user is on homepage
    And user click login on navigation tab
    And user input username with "user_1_new"
    And user input password with "password1"
    And user click login button
    And user click the product
    And verify it's the product
    And click add cart
    And verify popup and confirm
    And user click navbar cart
    And verify product cart is correct
    When user click place order
    And user input all mandatory payment details
    And user click checkout
    Then user successfully checkout the product
    And click confirm
    And user click logout button
