Feature: Login to Free CRM website

Scenario Outline: Verify successful Login in Free CRM website.

Given User is on Free CRM Login Page

When user enter username as "<username>"
And user enter password as "<password>"
And user click on login button

Then User should be able to log into Free CRM website successfully
Then User closes the browser

Examples:
|	username	|	password	|
|	mayurc		|	test@123	|
#|	crmadmin1	|	test@123	|
#|	crmuser1	|	test@123	|




Scenario: Verify user is not able to login with invalid credentials

Given User is on Free CRM Login Page

When user enter username as "mayurc"
And user enter password as "invalidpass"
And user click on login button

Then User should not be able to log into Free CRM website
Then User closes the browser