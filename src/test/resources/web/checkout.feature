@web @checkout
Feature: Checkout

  Background:
    Given user is on homepage
    And user click login on navigation tab
    And user input username with "user_1_new" and password with "password1"
    And user click login button

  @checkout-delete
  Scenario: Checkout then Delete Product
    Given user click the product and click add cart
    And verify popup confirm and verify product cart is correct
    When user click delete product
    Then verify cart is empty
    And user click logout button

  @checkout-e2e
  Scenario: End to End Checkout
    Given user click the product and click add cart
    And verify popup confirm and verify product cart is correct
    When user click place order
    And user input all mandatory payment details and checkout
    Then user successfully checkout the product
    And user click logout button
