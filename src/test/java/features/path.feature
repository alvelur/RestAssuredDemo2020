Feature: Verify HTTP rest operations in the WECRUITIO project

  Scenario: Verify that PUT campaign is working correctly
    Given I perfom POST operations for "posts/"
    When I perform a GET operation for "posts/"
    And I perform a PUT operation for "posts/"
    Then I perform a DELETE operation for "posts/"

  Scenario: Verify the collections of authors in the post
    Given I perfom Post operation
    When I perform Get operation
    And I should see authors name looking for the "8" id
    Then I perform Delete operation