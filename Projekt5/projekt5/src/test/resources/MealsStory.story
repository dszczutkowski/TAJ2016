Scenario: Login
Given user is on home page
When user get login page and enter login and password
Then user is logged in

Scenario: Add meal
Given user is on home page
When user get on meals page and add new meal
Then meal is added