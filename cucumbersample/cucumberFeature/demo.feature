 Feature: This is  test sathyamobile features

Scenario Outline: Mobile features scenario sangeetha
 Given customer login page
 When valid crendials in textbox "<userName>" and "<PassWord>"
 When put the values
 Then Click link
 
 Examples:
 |userName| Password|
 |prakash | pra123|


 