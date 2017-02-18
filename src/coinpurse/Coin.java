package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Issaree Srisomboon
 */
public class Coin implements Comparable<Coin>,Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value of coin.
     */
    public Coin( double value ) {
        this.value = value;
        this.currency = DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value of coin.
     * @param currency of coin.
     */
    public Coin( double value, String currency ) {
    	this.value = value;
    	this.currency = currency;
    }

    /**
     * Get the valuable of coin.
     * @return the valuable of coin.
     */
    public double getValue() {
    	return this.value;
    } 

    /**
     * Get the currency of coin.
     * @return currency of coin.
     */
    public String getCurrency() {
    	return this.currency;
    }
    
    /**
     * @param obj is an another object to compare to this one.
     * @return true if they have the same value and currency,
     * return false if they have not the same value or currency. Or obj is null 
     * or is not in the same class. 
     */
    @Override
    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	if (obj.getClass() != this.getClass()) return false;
    	Coin other = (Coin) obj;
    	if (other.getValue() == this.value && other.getCurrency() == this.currency) {
    		return true;
    	}
    	return false;
    }
  
    /**
     * Order coins by value so that the smaller value comes first.
     * @return <0 when this value is less than other value,
     * return 0 when this value equals other value and
     * return >0 when this value is more than other value.
     */
    @Override
    public int compareTo(Coin other) {
    	if (other == null) return -1;
    	return (int) Math.signum(this.value - other.value);
    }
    
    /**
     * Get a string representation of coins and currency.
     * @return string representation of coins and currency.
     */
    public String toString() { 
    	return String.format("%.2f-%s", this.value,this.currency); 
    }
}

