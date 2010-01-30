package aion.tools.data;

public class MaterialRequirement implements ItemGetter
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
		// we equal is our base material equals.
		// The amount is irrelevant for that.
		MaterialRequirement mr = (MaterialRequirement) o;
		return ( mr.getItem().equals( this.getItem() ) );
	}
	
	@Override
	public Item getItem()
	{
		return this.material;
	}	
}
