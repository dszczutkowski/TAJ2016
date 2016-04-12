
Scenario: MyPush should add an element to the collection
Given an element by <x>
When the element is added to the collection
Then the top element should be <x>

Examples:
|x|
|9|
|53|

Scenario: If stack is empty, MyPop should throw an exception
Given an empty stack 
Then MyPop should throw an exception

Scenario: My Pop should delete value on top 
Given the nonEmpty stack by <stack>
When MyPop occurs
Then the top of stack should be <x>

Examples:
|stack|x|
|1,2|1|
|1,3,4|3|
|3,6,7,8,4|8|
|7,5,6,3,2,3|2|
|7,5,6,3,2,123,3|123|

Scenario: If empty, IsEmpty should be true
Given an empty stack
Then IsEmpty should be true

Scenario: If not empty, IsEmpty should be false
Given the stack by <stack>
Then IsEmpty should be false

Examples:
|stack|
|1|
|1,2|
|1,3,4|
|3,6,7,8,4|
|7,5,6,3,2,1,3|

Scenario: If stack is empty, MyTop should throw an exception
When the stack is empty
Then MyTop should throw an exception

Scenario: MyTop should return the top element
When add new element <x>
Then MyTop should be <x>

Examples:
|x|
|1|
|2|
|3|
|45|
|123|
|123456|


