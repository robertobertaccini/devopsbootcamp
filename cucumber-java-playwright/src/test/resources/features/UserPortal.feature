Feature: Login Page feature

  @userportal
  Scenario: Verify User is able to login to User Portal and navigate trough landing pages
    Given I login as user
    When user clicks on "Home" link
    Then verify that "Flight Management Solution Test" landing page appears
    When user clicks on "Dashboard" link
    Then verify that "Dashboard" landing page appears
    When user clicks on "Spaces" link
    Then verify that "Spaces" landing page appears
    When user clicks on "Reports" link
    Then verify that "Reports" landing page appears
    When user clicks on "Explore Data" link
    Then verify that "Explore Data" landing page appears                