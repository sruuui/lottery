/**
 * ����
 */
public class Card {
	
	private int index;//���
	private String Id;//�ȼ�
	private String Name;//����
	private double p;//����
 
	public Card(int index, String Id, String Name, double p) {
		this.index = index;
		this.Id = Id;
		this.Name = Name;
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
 
	public String getName() {
		return Name;
	}
 
	public void setName(String Name) {
		this.Name = Name;
	}
 
	public double getP() {
		return p;
	}
 
	public void setP(double p) {
		this.p = p;
	}
 
	@Override
	public String toString() {
		return "�� [���=" + index + ", �ȼ�=" + Id + ", ����=" + Name + ", ����="+ p + "]";
	}
 
}