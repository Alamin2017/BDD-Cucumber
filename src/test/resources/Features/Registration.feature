@registration
Feature: Nopcommerce registration feature Test

  @test-1
  Scenario Outline: User should be able to registration new account successfully
    Given User go to the NopCommerce Home page
    And User navigate to the Registration page
    When User select the <type> as gender
    And User set first name and last name
    And User set <dob> as date of birth
    And User set <dynamicEmail> as email
    And User set <companyName> as company details
    And User set Newsletter option as <status>
    And User set <password> as password and confirm password again
    And User click on the Register button
    Then Verify that the new account registration message <msg> is displayed
    Examples:
      | type       |  dob         | companyName           | status        | password      | msg                         |
      | Male       | 20/5/1995    | Brainstation-23       | checked       | pass@1234     | Your registration completed |
      | Female     | 9/5/1999     | TigerITBangladesh     | unchecked     | pass@1234     | Your registration completed |
      | Female     | 3/5/2000     | TigerITBangladesh     | checked       | pass@1234     | Your registration completed |
      | Male       | 2/5/1999     | Brainstation-23       | unchecked     | pass@1234     | Your registration completed |
      | Female     | 10/5/1999    | TigerITBangladesh     | checked       | pass@1234     | Your registration completed |



