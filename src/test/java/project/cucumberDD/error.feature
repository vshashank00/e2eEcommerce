Feature: Login Action

@Error
  Scenario Outline: UnSuccessful Login
    Given User is on Home Page with InValid <email> and <password> Credentials
    And Checks password is correct or not
    Then Message displayed and close the browser Successfully
  Examples:
    | email                  | password |
    | vshashank1@hotmail.com | Shashank |

