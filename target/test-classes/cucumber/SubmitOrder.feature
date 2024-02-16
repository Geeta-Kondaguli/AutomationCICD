
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  
    
    Background:
    Given I landed on Ecommerce Page

  @RegressionTest
  Scenario Outline: Positive Test for submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed on Confirmation page

    Examples: 
      | name                      | password  | productName|
      | geeta.kondaguli@gmail.com | Geeta8897 | ZARA COAT 3|
     