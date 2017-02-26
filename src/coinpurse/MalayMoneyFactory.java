package coinpurse;

/**
 * Class for creating Malaysia's currency (Sen and Riggit).
 * @author Issaree Srisomboon
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	private final String CURRENCY_COIN = "Sen";
	private final String CURRENCY_BANKNOTE = "Ringgit";
	
	/**
	 * Create money in Malaysia's currency.
	 * If money is 0.05,0.10,0.20 or 0.50. It will create in Coin in currency "Sen"
	 * and it will create Banknote when money is 1,2,5,10,20,50 or 100 in currency "Ringgit".
	 * @param money that users want to create.
	 * @return valuable in Coin or Banknote from the condition.
	 * @throws IllegalArgumentException if user put other values of money. 
	 */
	@Override
	protected Valuable createMoney( double money ) throws IllegalArgumentException {
		Valuable valuable;
		if ( money == 0.05 || money == 0.10 || money == 0.20 || money == 0.50 ) {
			valuable = new Coin( money,CURRENCY_COIN );
		} else if ( money == 1 || money == 2 || money == 5 || money == 10 ||
				money == 20 || money == 50 || money == 100 ) {
			valuable = new BankNote( money, CURRENCY_BANKNOTE );
		} else throw new IllegalArgumentException();
		return valuable;
	}
	
//	/**
//	 * For testing MalayMoneyFactory Class
//	 * @param args
//	 */
//	public static void main (String[] args) {
//		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
//		MoneyFactory factory = MoneyFactory.getInstance();
//		Valuable m = factory.createMoney(5);
//		System.out.println(m.toString());
//		Valuable m3 = factory.createMoney(0.05);
//		System.out.println(m3.toString());
//		Valuable m2 = factory.createMoney("1000.0");
//	}
	
}
