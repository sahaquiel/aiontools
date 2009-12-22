package aion.tools.dataeditor.data;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import aion.tools.data.Design;
import aion.tools.data.Item;
import aion.tools.data.ItemFactory;
import aion.tools.data.MaterialRequirement;

public class DesignTreeModel implements TreeModel {

	private Design m_root;
	
	public DesignTreeModel()
	{
		super();
		
		m_root = ItemFactory.instance().getDesignsOnly().elementAt(0);
	}
	
	public void setRoot( Design d )
	{
		m_root = d;
	}
	
	@Override
	public void addTreeModelListener(TreeModelListener arg0) {
		
	}

	@Override
	public Object getChild(Object arg0, int arg1)
	{
		if ( arg0 == m_root )
		{
			return ( (Item) arg0 ).getRequirements().elementAt(arg1);			
		}
		else
		{
			return ( (MaterialRequirement) arg0 ).material.getRequirements().elementAt(arg1);
		}		
	}

	@Override
	public int getChildCount(Object arg0)
	{
		int ret = 0;
		
//		if ( arg0.getClass().isInstance( m_root ) )
		if ( arg0 == m_root )
		{
			ret = ((Item) arg0).getRequirements().size(); 
		}
		else
		{
			ret = ( (MaterialRequirement) arg0 ).material.getRequirements().size();
		}
		
		return ret;
	}

	@Override
	public int getIndexOfChild(Object arg0, Object arg1) {
		return ( (Item) arg0 ).getRequirements().indexOf(arg1);
	}

	@Override
	public Object getRoot() {
		return m_root;
	}

	@Override
	public boolean isLeaf(Object arg0)
	{
		Item it;
		
		if ( arg0 == m_root )
		{
			it = (Item) arg0; 
		}
		else
		{
			it = ( (MaterialRequirement) arg0 ).material;
		}
		return ( it.hasRequirements() == false );
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
