/**
 * ����
 */
public class Card {
	
	private int index;//���
	private String Id;//�ȼ�
	private double p;//����
 
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
		return "�� [���=" + index + ", �ȼ�=" + Id + ", ����="+ p + "]";
	}
 
}