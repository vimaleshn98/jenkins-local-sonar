package entity;

public class Item {
	private int id;
	private String name;
	private float price;
	private int quantity;
	private float totalprice;
	public Item() {
		
	}
	
	public Item(int id, String name, float price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}



	public Item(int itemId, int quntity, float totalprice) {
		// TODO Auto-generated constructor stub
		this.id =itemId;
		this.quantity = quntity;
		this.totalprice=totalprice;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, price=%s, quantity=%s]", id, name, price, quantity);
	}
	
}
