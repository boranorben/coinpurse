package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Issaree Srisomboon
 */
public class Coin extends AbstractValuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	private double newValue;
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
    	this.newValue = value;
    }

    /**
     * Get a string representation of coins and currency.
     * @return string representation of coins and currency.
     */
    public String toString() {
    	setSenCurrency( this.value );
    	return String.format( "%.0f-%s coin", this.newValue,this.currency ); 
    }
    
    /**
     * For changing the performance when users creating a coin in Malaysia's currency.
     * @param value of money.
     */
    public void setSenCurrency( double value ) {
    	if ( value < 1 ) this.newValue = this.value * 100;
    }
}

