package mcd;

public class IngreVO {
	private double p_num; //  상품번호 
	private double gram; //	중량(G)
	private double ml; //	중량(ML)
	private double kcal; //	열량
	private double sugar; //	당
	private double protein; //	단백질
	private double fat; //	포화지방
	private double natrium; //	나트륨
	private double caffeine; //	카페인
		
	public IngreVO(double p_num, double gram, double ml, double kcal, double sugar, double protein, double fat, double natrium, double caffeine) {
		super();
		this.p_num = p_num;
		this.gram = gram;
		this.ml = ml;
		this.kcal = kcal;
		this.sugar = sugar;
		this.protein = protein;
		this.fat = fat;
		this.natrium = natrium;
		this.caffeine = caffeine;
	}
	public double getP_num() {
		return p_num;
	}
	public void setP_num(double p_num) {
		this.p_num = p_num;
	}
	public double getGram() {
		return gram;
	}
	public void setGram(double gram) {
		this.gram = gram;
	}
	public double getMl() {
		return ml;
	}
	public void setMl(double ml) {
		this.ml = ml;
	}
	public double getKcal() {
		return kcal;
	}
	public void setKcal(double kcal) {
		this.kcal = kcal;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getNatrium() {
		return natrium;
	}
	public void setNatrium(double natrium) {
		this.natrium = natrium;
	}
	public double getCaffeine() {
		return caffeine;
	}
	public void setCaffeine(double caffeine) {
		this.caffeine = caffeine;
	}
	
	@Override
	public String toString() {
		return " 영양정보\n 중량(g)\t 중량(ml) 열량 \t 당\t단백질\t포화지방\t나트륨\t카페인 \n" +
				"===============================================================\n"
				+ " " + gram + " \t "+ ml+ " \t " + kcal+ " \t " + sugar	+ " \t "+ protein 
				+ " \t "+ fat+ " \t " + natrium + " \t "+ caffeine;
	}
}