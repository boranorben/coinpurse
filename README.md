# CoinPurse by Issaree Srisomboon
# Description of coinpurse
CoinPurse is an object that users can insert coins and bank notes in the purse and also withdraw from its conditionally.
Now it offers you to use Coin Purse in two country are Thailand and Malaysia.
# Short description 
- **AbstarctValuable** The parent class for Coin and Banknote.
- **Banknote** Bank note with a fixed value and currency.
- **Coin** Coin represents coinage (money) with a fixed value and currency.
- **CoinUtil** Some Coin utility methods for practice using Lists and Comparator.
- **ConsoleDialog** User Interface for the Coin Purse. 
- **Main**  A main class to create objects and connect objects together.
- **MalayMoneyFactory** Class for creating Malaysia's currency (Sen and Riggit).
- **MoneyFactory** An abstract class for defining the method used to create coins and bank notes.
- **Purse**  A purse contains coins and bank notes.
- **ThaiMoneyFactory** Class for creating Thailand's currency (Baht).
- **Valuable** An interface for objects having a monetary value and currency.

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
- **Output**: 28.25-Baht 12.0-Rupee 58.0-Ringgit

