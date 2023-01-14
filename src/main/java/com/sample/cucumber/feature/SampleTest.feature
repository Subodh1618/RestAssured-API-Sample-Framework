Feature: Sample for demo Tests

  @Sample @Positive
  Scenario Outline: StroryId :: DEMO-Sample StoryId | Name :: TC001_Sapmle test for demo purpose: Verify api successful response| Stream :: Demo | Type :: Positive | Category :: Functional
    Given User forms request using following parameters: "<BaseURL>", "<EndPoint>", "<Headers>", " "<queryParam>"
    When Post request is triggered for the following endpoint: "<EndPoint>"
    Then Status code "<statusCode>" should be verified

    Examples: 
      | BaseURL     | Endpoint | statusCode | queryParam       | Headers |
      |             |          | 200        |                  |         |   //#Enter data to be passed for each parameters
      