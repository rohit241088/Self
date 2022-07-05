Feature: Google Home page search feature with random values
  @Multithreaded
  Scenario Outline: Following is a test on google home page search feature
    Given User is on home page
    When Searches for "<string>"
    Then each search results should contain "<string>"
    Examples:
      |string|
      |Vivek Sharma|
      |Sachin Singh|
