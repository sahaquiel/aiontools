package aion.tools.data;

import java.util.Vector;

public class Item
{
	protected String name;
	protected int price;
	protected Vector<MaterialRequirement> requiredMaterials;
	
	public Item( String name )
	{
		this.name = name;
		
		requiredMaterials = new Vector<MaterialRequirement>();
	}
	
	public Item( String name, int price )
	{
		this.name = name;
		this.price = price;
		
		requiredMaterials = new Vector<MaterialRequirement>();
	}
	
	public String toString()
	{
		return name;
	}
	
	public boolean hasRequirements()
	{
		return ( requiredMaterials.size() > 0 );
	}
	
	public Vector<MaterialRequirement> getRequirements()
	{
		return requiredMaterials;
	}
	
	public Vector<MaterialRequirement> getRequiredFlattened()
	{
		return null;
	}
}
