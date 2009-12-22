package aion.tools.dataeditor.gui;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;

import aion.tools.data.Design;
import aion.tools.dataeditor.data.DesignTreeModel;

public class DesignTree extends JTree
{
	public DesignTree()
	{
		super( new DesignTreeModel() );
		this.setCellRenderer( new ItemTreeCellRenderer() );
	}
	
	public void setRootDesign( Design d )
	{
		DesignTreeModel newModel = new DesignTreeModel();
		newModel.setRoot( d );
		setModel(newModel);
//		( (DesignTreeModel) getModel()).setRoot( d );
//		setModel(getModel());
		
//		this.validate();	
//		this.fireValueChanged( new TreeSelectionEvent( this, null, false, null, null ) );
	}
}
