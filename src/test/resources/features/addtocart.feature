Feature: Add to cart functionality
  Scenario: Add to cart workflow check
    Given User is on Homepage
    And User click on a product
    Then user add to cart that product
    Then User click on the checkout
    And User give details
    Then User redirect to payment page
