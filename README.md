# IGT
The process to test this application and the requirements are quite simple:
Postman and an IDE to run the app as a Spring boot.

In postman you can access two GET endpoints:
    - /jackpot-draw with one parameter called betAmount, which accepts integer numbers from 1 - 5000.
    - /bets which calls for a getAll() function from the bets repo, showing the values stored in the current session.
