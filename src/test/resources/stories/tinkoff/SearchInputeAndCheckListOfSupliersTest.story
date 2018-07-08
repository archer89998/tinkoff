Narrative:
Search working correct and all pages after serching show coorrect info
As a user
I want to see perfect searching and that list of suplier is correct


Scenario: User should have possibility searching and receive correct result

Given user has opened 'tinkoff.ru' site

When user click on SecondMenu 'Платежи' button
And user enter saved finding data and check that first list element 'ЖКУ-Москва' is 'искомый'
And user choose 'Коммунальные платежи' from list

Then user check that page is same when he click by icon





