package coinpurse;

import java.util.List;
import java.util.ArrayList;
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
public class Purse {
	
    /** Collection of objects in the purse. */
    private List<Valuable> money;
    
    /** Capacity is maximum number of coins the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
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
    	List<Valuable> templist = new ArrayList<Valuable>();
		if ( amount > 0 ) {	
			for ( int i=0 ; i<=money.size()-1 ; i++ ) {
				double values = money.get(i).getValue();
				if ( values <= amount ) {
					amount -= values;
					templist.add( money.get(i) );
					money.remove( money.get(i) );
				}
			}
			if ( amount!=0 ) {
				for ( Valuable withdraw : templist ) {
					insert( withdraw );
				}
				return null;
			}
		}
		Valuable[] array = new Valuable[ templist.size() ];
		templist.toArray( array );
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
