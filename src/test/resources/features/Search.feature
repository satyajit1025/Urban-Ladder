Feature: Search functionality
  Scenario: Search workflow check
    Given user on the homepage
    And user click on search box and search a product
    And user get data as per search
    Then user filter data as per choice
    Then user successfully search the product