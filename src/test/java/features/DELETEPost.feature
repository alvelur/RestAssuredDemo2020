Feature: DeletePost
  Test the delete operation


  Scenario: Verify DELETE operation after POST
    Given I ensure to perform POST operation for "/posts" with body as
      | id  |title      |author|
      | 6   |LMAO       |LMAOXD|
    And  I perform DELETE operation for "/posts/{postid}/"
      | postid |
      | 6      |
    And  I perform GET operation for "/posts/{postid}/"
      | postid |
      | 6      |
    Then I should not see the body with title as "LMAO"