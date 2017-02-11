# CoinPurse by Issaree Srisomboon
# Description of coinpurse
CoinPurse is an object that users can insert coins in the purse and also withdraw from its conditionally.

In Coin class, it represents coinage (money) with a fixed value and currency.

In Purse class, it is reponsible for insert coins, withdraw money, check the balance and check if the purse is full.

In Main class, it will ask users to deposit, withdraw, inquiry or quit.
## Example methods in Purse class
| Method | Short Description |
| :----------------------: | :-----------------:
| `.getBalance()`            |  Get the total value in Purse.
| `.getCapacity()`           | Return the capacity of the coin purse.
| `.isfull()`                | Test whether the purse is full.
| `.insert(Coin coin)`       |  Insert a coin into the purse.
| `.withdraw(double amount)` | Withdraw the requested amount of money.
# Results in CoinUtil class
There are 3 example methods in this class,

`.filterByCurrency(final List<Coin> coinlist, String currency)`

*Method that examines all the coins in a List and returns only the coins that have a currency that matches the parameter value.*
- **Input**: 0.25-Baht 0.50-Rupee 50.00-Ringgit 5.00-Baht 1.00-Ringgit 1.00-Rupee 1.00-Baht 2.00-Ringgit 10.00-Baht 0.50-Rupee 10.00-Baht 10.00-Rupee 2.00-Baht 5.00-Ringgit
- **Output**: 0.50-Rupee 1.00-Rupee 0.50-Rupee 10.00-Rupee 

`.sortByCurrency(List<Coin> coins)`

*Method to sort a list of coins by currency.*
- **Input**: 10.00-Rupee 5.00-Ringgit 10.00-Baht 0.25-Baht 0.50-Rupee 2.00-Ringgit 1.00-Baht 1.00-Rupee 5.00-Baht 1.00-Ringgit 0.50-Rupee 50.00-Ringgit 2.00-Baht 10.00-Baht
- **Output**: 10.00-Baht 0.25-Baht 1.00-Baht 5.00-Baht 2.00-Baht 10.00-Baht 5.00-Ringgit 2.00-Ringgit 1.00-Ringgit 50.00-Ringgit 10.00-Rupee 0.50-Rupee 1.00-Rupee 0.50-Rupee

`.sumByCurrency(List<Coin> coins)`

*Sum coins by currency and print the sum for each currency.*
- **Input**: 0.25-Baht 2.00-Baht 1.00-Ringgit 0.50-Rupee 0.50-Rupee 5.00-Ringgit 2.00-Ringgit 5.00-Baht 10.00-Baht 10.00-Rupee 50.00-Ringgit 1.00-Rupee 10.00-Baht 1.00-Baht
- **Output**: 28.25 Baht 58.0 Ringgit
