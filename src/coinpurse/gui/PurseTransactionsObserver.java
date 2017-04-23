package coinpurse.gui;

import java.awt.Dimension;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import coinpurse.Purse;

/**
 * Using JTable to Display Transactions.
 * @author Issaree Srisomboon
 *
 */
public class PurseTransactionsObserver extends JFrame implements Observer {
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane pane;

	/** Constructor for PurseTransactionsObserver */
	public PurseTransactionsObserver() {
		super( "Purse Transactions" );
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}

	/** Initialize components in the window. */
	private void initComponent() {
		model = new DefaultTableModel();
		// our table data will have 3 columns
		model.addColumn( "Date/Time" );
		model.addColumn( "Description" );
		model.addColumn( "Balance" );
		
		table = new JTable( model );
		pane = new JScrollPane( table );
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pane.setMinimumSize( new Dimension(80,30) );
		
		this.add(pane);
		this.pack();
	}

	/** Display the graphics window. */
	public void run() {
		setVisible(true);
	}

	/** Update receives notification from the purse. */
	@Override
	public void update(Observable subject, Object info) {
		if ( subject instanceof Purse ) {
			Purse purse = (Purse) subject;
			DateFormat date = new SimpleDateFormat( "HH:mm:ss" );
			model.addRow( new String[] { date.format(new Date()) + "" , info.toString() , purse.getBalance() + ""  });
		}
	}

}