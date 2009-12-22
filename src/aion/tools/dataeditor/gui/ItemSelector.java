package aion.tools.dataeditor.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTree;

import aion.tools.data.Design;
import aion.tools.data.Item;
import aion.tools.data.ItemFactory;
import aion.tools.dataeditor.data.DesignComboBoxModel;

public class ItemSelector extends javax.swing.JPanel implements ActionListener
{
	JComboBox m_cbItems;
	JButton m_btCalc;
	JTextArea m_taOutput;
	DesignTree m_tree;
	
	public ItemSelector()
	{
		super();
		
		m_cbItems = new DesignComboBox();
		m_btCalc = new JButton( "Calc" );
		m_taOutput = new JTextArea();
		m_tree = new DesignTree();
	
		add( m_cbItems );
		add( m_btCalc );
		add( m_taOutput );
		add( m_tree );
		
		m_btCalc.addActionListener( this );
	}
	
	
	public Item getSelectedItem()
	{
		return (Item) m_cbItems.getSelectedItem();
	}

	
	private void calculate()
	{
		Design d = (Design) getSelectedItem();
		
		m_taOutput.setText( d + " requires:\n" + d.getRequiredSummary() + d.getCost() );
		
		m_tree.setRootDesign( d );		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		calculate();
	}
}
