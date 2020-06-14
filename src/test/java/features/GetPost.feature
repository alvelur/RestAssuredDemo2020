Feature:
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given I perfom GET operation for "/posts"
    Then I should see the author name as "Karthik KK"

  Scenario: Verify the collections of authors in the post
    Given I perfom GET operation for "/post"
    Then I should see authors name

  Scenario: Verify paramether
    Given I perfom GET operation for "/post"
    Then I should see verifY GET parameter

  Scenario: Verify POST operation
    Given I perfom POST operation for "/posts"

   Scenario: Verify Post operation for Profile
     Given I perfom POST  operation for "/posts/{profileNo}/profile" with body
     | name  |profile |
     | sam   |2       |
     Then I should see the body has name as "sam"

