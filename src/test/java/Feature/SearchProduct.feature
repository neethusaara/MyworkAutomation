Feature: Search Products

  @test
  Scenario Outline: Search a product in home page and offers page with short name
    Given user is in green cart home page
    When user search for product with short name<Name>and extracted the actual code
    Then user searches the same shortname<Name>in offers page
    And user validate search results in home page and topDeal matches

    Examples:
      |Name|
      |tom|
      |Beet|

  @testExcel
  Scenario Outline: Search an item in the excel sheet
    Given search and locate value<value>in excel sheet

    Examples:
      |value|
      |logout|