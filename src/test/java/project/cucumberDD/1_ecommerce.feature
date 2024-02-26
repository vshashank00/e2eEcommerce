
Feature: Go to ecommerce website
  @Regression
  Scenario Outline: Add two item to cart
    Given Login in with <email> and <password>
    When I add products <productone> and <producttwo> to cart
    And And product verification done on Checkoutpage
    Then "THANKYOU FOR THE ORDER." message should displayed

    Examples:
      | email                  | password   | productone    | producttwo  |
      | vshashank1@hotmail.com | Shashank@1 | IPHONE 13 PRO | ZARA COAT 3 |

