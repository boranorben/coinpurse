package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Issaree Srisomboon
 */
public class Coin extends AbstractValuable {
	public static final String DEFAULT_CURRENCY = "Baht";
    /**
     * A coin with given value using the default currency.
     * @param value of coin.
     */
    public Coin( double value ) {
        this(value, DEFAULT_CURRENCY);
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
     * Get a string representation of coins and currency.
     * @return string representation of coins and currency.
     */
    public String toString() { 
    	return String.format( "%.2f-%s", this.value,this.currency ); 
    }
}

