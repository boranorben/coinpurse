package coinpurse.strategy;

import org.junit.*;

import coinpurse.*;

import static org.junit.Assert.*;

/**
 * Test cases for a greedy withdraw algorithm.
 * @author Issaree Srisomboon
 *
 */
public class GreedyWithdrawTest {
	private Purse purse;
	
	/**
	 * Setup the purse set withdraw strategy as GreedWithdraw 
	 * to use this algorithm and run before each test.
	 */
	@Before
	public void setUp() {
		purse = new Purse(10);
		purse.setWithdrawStrategy( new GreedyWithdraw() );
	}
	
	/** Test if it successes in withdrawing for normal case. */
	@Test
	public void testWithdrawNormal() {
		purse.insert( new Coin(1) );
		purse.insert( new Coin(5) );
		purse.insert( new BankNote(20) );
		Valuable[] val1 = { new Coin(5) , new Coin(1) };
		assertArrayEquals( val1 , purse.withdraw(6) );
		Valuable[] val2 = { new BankNote(20) };
		assertArrayEquals( val2 , purse.withdraw( 20 ) );
	}
	
	/**
	 * Test if it can skip all items with the values that
	 * have more than the amount to withdraw.
	 */
	@Test
	public void testWithdrawNotOrder() {
		purse.insert( new Coin(5) );
		purse.insert( new Coin(2) );
		purse.insert( new Coin(2) );
		purse.insert( new Coin(2) );
		Valuable[] val1 = { new Coin(2) , new Coin(2) , new Coin(2) };
		assertArrayEquals( val1 , purse.withdraw(6) );
	}
	
}
