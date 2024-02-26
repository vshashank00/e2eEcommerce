Feature: Check order
  Scenario Outline: In order page section
    Given Go to login page with <email> and <password>
    Then click on my order and check the item is visible are <productone>,<producttwo>
    Examples:
      | email                  | password   | productone    | producttwo  |
      | vshashank1@hotmail.com | Shashank@1 | IPHONE 13 PRO | ZARA COAT 3 |