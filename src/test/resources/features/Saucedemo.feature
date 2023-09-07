Feature: Shopping Process from Saucedemo page

  Background:
    Given  user navigates to https://www.saucedemo.com/
    And user logs with standard user

  Scenario: User Navigation
    Given user navigates to the About tab
    When user returns to the Products page
    Then user should see the product page

  Scenario Outline: Adding Products to Cart
    Given user sorts the products from low to high price
    When user adds the top <prodCount> most expensive products to the shopping cart
    Then user should see the cart icon displaying the number <prodCount> in the top right corner

    Examples:
    | prodCount|
    | 4         |
    | 6         |

  Scenario Outline: Buying the product
    Given user sorts the products from low to high price
    And user adds the top 4 most expensive products to the shopping cart
    And user goes on the shopping cart
    When user proceeds to checkout
    And user enters personal information <firstName>, <lastName>, <postalCode> and continue
    And user verifies the correct total price
    And user completes the purchase
    Then user should see a success message

    Examples:
      |firstName|lastName  |postalCode|
      |Alejandro |Maciel     |00000   |

