Feature: Verify Login to PHP travel

Scenario: Login to PHP travel with valid credentials
Given User navigates to PHP travel Login page
When User enter username as "username"
And User enter password as "password"
Then User is able to login to PHP travel successfully.

@Smoke @Reg
Scenario: scenario2
Given given2

@Smoke
Scenario: scenario3
Given given3

@Reg
Scenario: scenario4
Given given4

@Reg
Scenario: scenario5
Given given5


Scenario: scenario6
Given given6

Scenario: scenario7
Given given7

@scenario
Scenario Outline: scenario8
Given character "<char>" Number "<num>"
Examples:
|char|num|
|a|1|
|b|2|