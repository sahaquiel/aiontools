package aion.tools.dataeditor.gui;

import javax.swing.JComboBox;

import aion.tools.dataeditor.data.DesignComboBoxModel;

public class DesignComboBox extends JComboBox
{
	public DesignComboBox()
	{
		super(  new DesignComboBoxModel()  );
	}
}
