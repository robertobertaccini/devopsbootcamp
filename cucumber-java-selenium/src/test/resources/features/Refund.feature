Feature: Refund

  Scenario Outline: Refund Platium
    Given I login as user
    When I create a new refund request
    And I select PNR "UP4231"
    Then The loyalty is "Platinum"
    When i provide refunder email "tim.straatsma@pega.com"
    Then the case is sent for approval