Narrative:
Correct error messages requered field in JKU moscov payments
As a user
I want to see error messages when make mistake fill in inputs data


Scenario: User should have possibility see correct errror messages

Given user has opened 'tinkoff.ru' site

When user click on SecondMenu 'Платежи' button
And user check 'city' if not Moscow choosen '<city>'
And user choose 'Коммунальные платежи'
And user check that first list element 'ЖКУ-Москва' and save as 'искомый'

Then cause all errors requred fields and check error messages

Examples:
|city|
|Москве|




