# @Shoptest @Chrome @ChromeHeadless

Feature: Testing product search and order

  @Shoptest  @Chrome
  Scenario: 1a.lv order test
    Given client opens https://www.1a.lv website
    When client makes search by text:Putekļu sūcēji
    And sees 'Putekļu sūcēji' searching results
    And sets up new filter
    And adds most stared product in shopping cart
    And goes to delivery page
    Then client enters personal information
    And chooses delivery and payment way
    And checks order summary



