package coinpurse;

import java.util.List;
import java.util.Observable;

import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *  A purse contains coins and bank notes.
 *  You can insert coins and bank notes, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  bank notes or coins to remove.
 *  
 *  @author Issaree Srisomboon
 */
public class Purse extends Observable {
	
    /** Collection of objects in the purse. */
    private List<Valuable> money;
    
    /** Capacity is maximum number of coins the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    private WithdrawStrategy strategy;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of money you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	this.money = new ArrayList<Valuable>();
    }

    /**
     * Count and return the number of money in the purse.
     * This is the number of money, not their value.
     * @return the number of money in the purse
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
    	if( this.count() == this.capacity ) return true;
        return false;
    }

    /** 
     * Insert money into the purse.
     * The coin and bank note is only inserted if the purse has space for it
     * and the coin and bank note have positive value.  No worthless values!
     * @param value is a Coin object to insert into purse
     * @return true if coin or bank note inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
        // if the purse is already full then can't insert anything.
    	if ( !isFull() && value.getValue() > 0 ) {
    		money.add(value);
    		Collections.sort( money );
    		Collections.reverse( money );
    		setChanged();
    		notifyObservers( "Insert " + value.getValue() + " " + value.getCurrency() );
			return true;
    	}
        return false;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of value withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
    	double realAmount = amount;
       	List<Valuable> templist = new ArrayList<>();
       	templist = strategy.withdraw( amount, this.money );
       	if ( templist != null ) {
        	Valuable[] array = new Valuable[ templist.size() ];
        	for ( Valuable tempc : templist ) {
    			money.remove( tempc );
    		}
        	templist.toArray( array );
    		setChanged();
    		notifyObservers( "Withdraw " + realAmount + " Baht");
        	return array;
       	} return null;
	}
    
	/**
	 * Returns an immutable list view of the Purse contents.
	 * @return a view of the Purse's list.
	 */
	public List<Valuable> getImmutableList() {
		return Collections.unmodifiableList(money);
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * @return a string description of the purse contents.
     */
    public String toString() {
    	return String.format("%d coins with value %.1f",this.count(),getBalance());
    }
    
    /**
     * Specify the withdraw strategy at run-time.
     * @param withdrawStrategy is an algorithm for withdrawing the money
     */
    public void setWithdrawStrategy( WithdrawStrategy withdrawStrategy ) {
    	this.strategy = withdrawStrategy;
    }
    
}
