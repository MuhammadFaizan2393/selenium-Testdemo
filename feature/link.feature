Feature: Broken link validation
  @TC_LINK_01
  Scenario Outline: Verify broken links on a web page
    Given I launch the application in "<browser>" browser
    When I navigate to "https://saucelabs.com/"
    Then I should find all brokenlink on this webpage
    Then I verify the brokenlinks
    And I closed the browser.
    Examples:
      | browser  |
      | chrome   |
      | firefox  |