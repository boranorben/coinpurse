package coinpurse;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 *  
 *  @author Issaree Srisomboon
 */
public class Purse {
	
    /** Collection of objects in the purse. */
    private List<Coin> money;
    
    /** Capacity is maximum number of coins the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	this.money = new ArrayList<Coin>();
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
    public int count() {
    	return this.money.size();
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double balance=0.0;
    	for (int i=0 ; i<money.size() ; i++) {
    		balance += money.get(i).getValue();
    	}
    	return balance;
    }
    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity() {
    	return this.capacity;
    }
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
    	if(this.count() == this.capacity) return true;
        return false;
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
        // if the purse is already full then can't insert anything.
    	if (!isFull() && coin.getValue() > 0) {
    		money.add(coin);
    		Collections.sort(money);
    		Collections.reverse(money);
			return true;
    	}
        return false;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw( double amount ) {
    	List<Coin> templist = new ArrayList<Coin>();
		if (amount > 0) {	
			for (int i=0 ; i<=money.size()-1 ; i++) {
				double coins = money.get(i).getValue();
				if (coins <= amount) {
					amount -= coins;
					templist.add(money.get(i));
					money.remove(money.get(i));
				}
			}
			if (amount!=0) {
				for (Coin withdraw : templist) {
					money.add(withdraw);
					Collections.sort(money);
					Collections.reverse(money);
				}
				return null;
			}
		}
		Coin[] array = new Coin[templist.size()];
		templist.toArray(array);
		return array;
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * @return a string description of the purse contents.
     */
    public String toString() {
    	return String.format("%d coins with value %.1f",this.count(),getBalance());
    }

}