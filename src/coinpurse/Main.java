package coinpurse;
 
import java.util.ResourceBundle;

import coinpurse.gui.PurseBalanceObserver;
import coinpurse.gui.PurseListModel;
import coinpurse.gui.PurseStatusObserver;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Issaree Srisomboon
 */
public class Main {
	private static int CAPACITY = 10;

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	// Create a ResourceBundle from file "purse.properties" on the classpath
    	// the ".properties" extension is automatically appended to the name
    	ResourceBundle bundle = ResourceBundle.getBundle( "purse" );
    	// Get value of "moneyfactory" property
    	String factoryclass = bundle.getString( "moneyfactory" );
    	// If factoryclass is null the use a default class name
    	MoneyFactory factory = null;
    	try {
    		factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
    	} catch (ClassCastException cce) {
			// The object could not be cast to type MoneyFactory
    		System.out.println( factoryclass + "is not type MoneyFactory" );
		} catch (Exception ex) {
			// Any other exception means we could not create an object
			System.out.println( "Error creating MoneyFactory " + ex.getMessage() );
		}
    	// If no factory then quit
    	if ( factory == null ) {
    		System.exit(1);
    	} else { MoneyFactory.setMoneyFactory(factory); }
    	
    	Purse purse = new Purse(CAPACITY);
    	ConsoleDialog ui = new ConsoleDialog( purse );
    	
//    	PurseBalanceObserver balance = new PurseBalanceObserver();
//    	purse.addObserver( balance );
//    	balance.run();
//
//    	PurseStatusObserver status = new PurseStatusObserver();
//    	purse.addObserver( status );
//    	status.run();
    	
    	PurseListModel listModel = new PurseListModel(purse);
    	purse.addObserver(listModel);
    	listModel.run();
    	ui.run();
    }
}

