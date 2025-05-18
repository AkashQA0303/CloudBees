Feature: CloudBees Website Testing
  
  @Webpage
  Scenario: Validate CloudBees Application Flow
    Given user opens the application "https://www.cloudbees.com/"
    When user clicks top menu link "Products"
    And user clicks sub link under top menu "CloudBees CD/RO"
    Then user verifies Cost Savings is "$2m"
    And user scrolls down and clicks link
    Then user verifies text under "Release Governance" section is "Generate single-click audit reports"
    When user clicks top menu link "Resources"
    And user clicks sub link under top menu "Documentation"
    Then user verifies a new tab is opened
    When user clicks in the text field
    Then user verifies a new page is opened in same tab
    When user searches for word "Installation"
    Then user verifies pagination options are visible at the bottom
