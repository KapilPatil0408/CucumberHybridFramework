Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User has navigates to login page
When User has enters valid email address <username> into email field
And User has enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in 
Examples:
|username         |password|
|kapil1@gmail.com | 12345  |
|kapil2@gmail.com | 12345  |
|kapil3@gmail.com | 12345  |

Scenario: Login with invalid credentials
Given User has navigates to login page
When  User has enters invalid email address into email field
And  User has enters invalid password "1234587" into password field
And   User clicks on Login button
Then  USer should get a proper warning message about credentials mismatch


Scenario: Login with valid email and invalid password
Given User has navigates to login page
When User has enters valid email address "kapi09@gmail.com" into email field
And User has enters invalid password "1234567" into password field
And   User clicks on Login button
Then  USer should get a proper warning message about credentials mismatch


Scenario: Login with Invalid email and valid password
Given User has navigates to login page
When User has enters invalid email address into email field
And User has enters valid password "12345" into password field
And   User clicks on Login button
Then  USer should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User has navigates to login page
When User dont entered email address into email field
And User dont entered password into password field
And   User clicks on Login button
Then  USer should get a proper warning message about credentials mismatch