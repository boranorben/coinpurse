package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * Changing the withdraw algorithm any time without changing the Purse class.
 * @author Issaree Srisomboon
 *
 */
public interface WithdrawStrategy {
	
	/**
	 * Find and return a collection of money that will enable the purse to withdraw
	 * the requested amount.
	 * @param amount is the amount of money to withdraw
	 * @param money the contents that are available for possible withdraw.
	 * It must not be null, but may be an empty list
	 * @return if a solution is found, return a List containing references from the money
	 * parameter (List) whose sum equals the amount.
	 * If a solution is not found, return null
	 */
	public List<Valuable> withdraw( double amount , List<Valuable> money );
	
}
