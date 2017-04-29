package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

/**
 * Some test in greedy withdraw strategy may fail though it's possible to withdraw,
 * so this class is used to check every cases to withdraw the money as far as it possible.
 * @author Issaree Srisomboon
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	/** @see WithdrawStategy#withdraw */
	@Override
	public List<Valuable> withdraw( double amount, List<Valuable> money ) {
		List<Valuable> list = new ArrayList<Valuable>();
		if ( money.size() == 0 && amount == 0 ) return list;
		if ( money.size() == 0 && amount != 0 ) return null;
		if ( amount < 0 ) return null;
		if (( list = withdraw( amount-money.get(0).getValue() , money.subList( 1,money.size() ) )) != null ) {
			list.add( money.get(0) );
			return list;
		} else if (( list = withdraw( amount , money.subList( 1,money.size() ) )) != null ) {
			return list;
		} return null;
	} 
	
}
