package coinpurse;

/**
 * Bank note with a fixed value and currency.
 * @author Issaree Srisomboon
 *
 */
public class BankNote extends AbstractValuable {
	private static long nextSerialNumber = 1000000;
	private static final String DEFAULT_CURRENCY = "Baht";
	private long serialNumber;
	
	 /**
     * A bank note with given value using the default currency.
     * @param value of bank note.
     */
	public BankNote( double value ) {
		this( value,DEFAULT_CURRENCY );
	}
	
	/**
     * A bank note with given value and currency.
     * @param value of bank note.
     * @param currency of bank note.
     */
	public BankNote( double value,String currency ) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}
	
	 /**
	 * Get the serial number of bank note.
	 * @return bank note's serial number.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
     * Get a string representation of bank notes and currency.
     * @return string representation of bank notes and currency.
     */
	public String toString() {
		return String.format( "%.2f-%s note [%s]",this.value,this.currency,this.serialNumber );
	}
}

