package aion.tools.data;

public class MaterialRequirement
{
	public int amount;
	public Item material;
	
	public MaterialRequirement( int amount, Item material )
	{
		this.amount = amount;
		this.material = material;
	}
	
	public String toString()
	{
		return "" + amount + " x " + material + ", cost: " + getCost() + "\n";
	}
	
	public int getCost()
	{
		return material.price * amount;
	}
	
	public boolean equals( Object o )
	{
		MaterialRequirement mr = (MaterialRequirement) o;
		
		return ( mr.material.equals(this.material) );
	}
}
