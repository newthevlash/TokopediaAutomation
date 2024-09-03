
@tag
Feature: Feature test tokopedia login
  validate user login tokopedia

  @tag1
  Scenario: Validate login tokopedia successfull
    Given User open the browser
    And User on tokopedia page
    When User click Masuk button
    And User enter valid email or phone number
    And User click Selanjutnya button
    And User enter valid password
    And User click Login button
    Then User navigate to verify with email or phone number
    
    
   @tag1
  Scenario: Validate login tokopedia unsuccessfull with password null
  Given User open the browser
  And User on tokopedia page
  When User click Masuk button
  And User enter valid email or phone number
  And User click Selanjutnya button
  And User set password NULL
  And User click Login button
  Then popup error message under password field
  