/**
 * 卡类
 */
public class Card {
	
	private int index;//序号
	private String Id;//等级
	private double p;//概率
 
	public Card(int index, String Id, double p) {
		this.index = index;
		this.Id = Id;
		this.p = p;
	}
 
	public int getIndex() {
		return index;
	}
 
	public void setIndex(int index) {
		this.index = index;
	}
 
	public String getId() {
		return Id;
	}
 
	public void setId(String Id) {
		this.Id = Id;
	}
  
	public double getP() {
		return p;
	}
 
	public void setP(double p) {
		this.p = p;
	}
 
	@Override
	public String toString() {
		return "卡 [序号=" + index + ", 等级=" + Id + ", 概率="+ p + "]";
	}
 
}