package mcd;

import java.sql.*;

public class OrderVO {
	private int order_no; //주문번호(시퀀스)
	private String name;  //고객명
	private String phnum; //전화번호
	private String address; //주소
	private String order_info; //메뉴 상세정보
	private int order_count; //주문 수량
	private int tot_price; //총 주문금액
	private Date order_time; //주문일
	private String cancle_yn; //취소여부
	
	
	public OrderVO (int order_no, String name, String phnum, String adress, String order_info, int count, int tot_price, Date order_time, String cancle_yn) {
		super(); 
		this.order_no = order_no;
		this.name =name;
		this.phnum = phnum;
		this.address = adress;
		this.order_info = order_info;
		this.order_time=order_time;
		this.cancle_yn = cancle_yn; 
		
	}
		public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhnum() {
		return phnum;
	}
	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrder_info() {
		return order_info;
	}
	public void setOrder_info(String order_info) {
		this.order_info = order_info;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public int getTot_price() {
		return tot_price;
	}
	public void setTot_price(int tot_price) {
		this.tot_price = tot_price;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public String getCancle_yn() {
		return cancle_yn;
	}
	public void setCancle_yn(String cancle_yn) {
		this.cancle_yn = cancle_yn;
	}
	@Override
	public String toString() {
		return "OrderVO [order_no=" + order_no + ", name=" + name + ", phnum=" + phnum + ", address=" + address
				+ ", order_info=" + order_info + ", order_count=" + order_count + ", tot_price=" + tot_price
				+ ", order_time=" + order_time + ", cancle_yn=" + cancle_yn + "]";
	}
	
	
}
	