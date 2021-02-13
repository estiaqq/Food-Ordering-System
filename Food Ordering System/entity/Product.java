package entity;

import java.lang.*;

public class Product
{
	private String id;
	private String name;
	private int quantity;
	private Double price;

	public void setId(String id)
	 {
		this.id = id;
	 }

	public String getId()
    {
		return id;
	}

    public void setName(String name)
    {
		this.name = name;
	}
    public String getName()
    {
		return name;
	}
    public void setQuantity(int quantity)
    {
		this.quantity = quantity;
	}
    public int getQuantity()
    {
		return quantity;
	}
	public void setPrice(Double price)
	{
		this.price = price;
	}
    public double getPrice()
    {
		return price;
	}

    public Product(){}

	public Product(String id, String name, int quantity, Double price)
	{
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}


}
