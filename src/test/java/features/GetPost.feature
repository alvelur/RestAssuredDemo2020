Feature:
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given I perfom GET operation for "/posts/1"
    Then I should see the author name as "Alejandro Velasquez"

   Scenario: Verify Post operation for Profile
     Given I perfom POST  operation for "/posts/{profileNo}/profile" with body
     | name  |profile |
     | sam   |2       |
     Then I should see the body has name as "sam"

