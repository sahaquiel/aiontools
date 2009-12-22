package aion.tools.dataeditor.data;

import javax.swing.event.ListDataListener;

import aion.tools.data.Item;
import aion.tools.data.ItemFactory;

public class DesignComboBoxModel implements javax.swing.ComboBoxModel
{
	private Item m_selectedItem;
	
	public DesignComboBoxModel()
	{
		super();
	
		m_selectedItem = ItemFactory.instance().getDesignsOnly().elementAt(0);
	}
	
	@Override
	public Object getSelectedItem() {
		return m_selectedItem;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		m_selectedItem = (Item) anItem;
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return ItemFactory.instance().getDesignsOnly().elementAt(arg0);
	}

	@Override
	public int getSize() {
		
		return ItemFactory.instance().getDesignsOnly().size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
