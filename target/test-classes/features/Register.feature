Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters details into below fields
|firstName|Kapil|
|lastName|Patil|
|telephone|1234567890|
|password|12345|
And User selects privacy policy
And User Clicks on continue button
Then User account should get created successfully


Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters details into below fields
|firstName|Kapil|
|lastName|Patil|
|telephone|1234567890|
|password|12345|
And User selects Yes for Newsletter
And User selects privacy policy
And User Clicks on continue button
Then User account should get created successfully


Scenario: User creates an duplicate account
Given User navigates to Register Account page
When User enters details into below fields with duplicate email
|firstName|Kapil|
|lastName|Patil|
|email|Kapil09@gmail.com|
|telephone|1234567890|
|password|12345|
And User selects privacy policy
And User Clicks on continue button
Then User account should get proper warning about duplicate email

Scenario: User creates account without filling any details
Given User navigates to Register Account page
When User dont enter any details into fields
And User Clicks on continue button
Then User account should get proper warning message for every manadatory field
