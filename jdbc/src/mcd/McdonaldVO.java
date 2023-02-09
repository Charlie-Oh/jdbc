package mcd;


public class McdonaldVO {
	
	private int prod_num; //itemId; //상품번호
	private String prod_name; //itemName; //상품명
	private int price; //상품가격
	private String prod_info; //itemInfo; //상품정보
	private String value; //itemType; //상품종류
	
//생성자
	public McdonaldVO(int prod_num, String prod_name, int price, String prod_info, String value) {
		super();
		this.prod_num = prod_num;
		this.prod_name = prod_name;
		this.price = price;
		this.prod_info = prod_info;
		this.value = value;
	}
	
//getter setter
	public int getItemId() {
		return prod_num;
	}
	public void setItemId(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getItemName() {
		return prod_name;
	}
	public void setItemName(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItemInfo() {
		return prod_info;
	}
	public void setItemInfo(String prod_info) {
		this.prod_info = prod_info;
	}
	public String getItemType() {
		return value;
	}
	public void setItemType(String value) {
		this.value = value;
	}
	
//toString
	@Override
	public String toString() {
		return "McdonaldVO [prod_num=" + prod_num + ", prod_name=" + prod_name + ", price=" + price + ", prod_info=" + prod_info
				+ ", value=" + value + "]";
	}	
	
}
