import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
 
/**
 * �鿨������
 */
public class LotteryUtil {
	/**
	 * �鿨
	 *
	 * @param Rates ԭʼ�ĸ����б���֤˳���ʵ����Ʒ��Ӧ
	 * @return ��Ʒ��������r�������б���λ�ã�
	 */
	public static int lottery(List<Card> cards, Double pro) {

		if (cards.isEmpty()) {
			// Card����ţ��ȼ������������ʣ�
			cards.add(new Card(0, "0", pro)); 
			cards.add(new Card(1, "1", 1-pro));
		}
				
		//��card�ĸ���p������ԭʼ�����б�Rates
		List<Double> Rates = new ArrayList<Double>(cards.size());
		for (Card card : cards) {
			double p = card.getP();
			if (p < 0) {
				p = 0;
			}
			Rates.add(p);
		}
		
		if (Rates == null || Rates.isEmpty()) {
			return -1;
		}
 
		// ͳ������������=������
		int size = Rates.size();
 
		// �����ܸ��ʣ��ܸ��ʲ�һ����1
		double sumRate = 0d;
		for (double rate : Rates) {
			sumRate += rate;
		}
 
		// ����ÿ����Ʒ���ܸ��ʵĻ����µĸ������
		List<Double> sortRates = new ArrayList<Double>(size);
		Double realSumRate = 0d;
		for (double rate : Rates) {
			realSumRate += rate;
			sortRates.add(realSumRate / sumRate);
		}
 
		// ��������ֵ����ȡ��ȡ���Ŀ�Ƭ����
		double r = Math.random();
		sortRates.add(r);
		Collections.sort(sortRates);
 
		return sortRates.indexOf(r);
	}
	
	
	
	public static void main(String[] args) {
		List<Card> cards = new ArrayList<Card>();
		Scanner input=new Scanner(System.in);
		System.out.println("�����ø��ʣ�");
		double pro=input.nextDouble();//����һ������

		
		// ͳ��
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		// ����һ�γ鿨����
		double num = 100000;
		
		for (int i = 0; i < num; i++) {
			int Index = LotteryUtil.lottery(cards,pro);
			//int Index = LotteryUtil.lottery_easy(cards,pro);
 			Integer value = count.get(Index);
			count.put(Index, value == null ? 1 : value + 1);
		}
 
		// ������鵽��������ʵ�ʸ���
		for (Entry<Integer, Integer> entry : count.entrySet()) {
			System.out.println(cards.get(entry.getKey()) + ", �鵽����=" + entry.getValue() + ", ʵ�ʸ���="+ entry.getValue() / num);
		}
		 
	}
	
	
	
//	public static int lottery_easy(List<Card> cards, Double pro) {
//		
//		if (cards.isEmpty()) {
//			// Card����ţ��ȼ������������ʣ�
//			cards.add(new Card(0, "0", pro)); 
//			cards.add(new Card(1, "1", 1-pro));
//		}
//				
//		//��card�ĸ���p������ԭʼ�����б�Rates
//		List<Double> Rates = new ArrayList<Double>(cards.size());
//		for (Card card : cards) {
//			double p = card.getP();
//			if (p < 0) {
//				p = 0;
//			}
//			Rates.add(p);
//		}
//		
//		if (Rates == null || Rates.isEmpty()) {
//			return -1;
//		}
//
//		// ��������ֵ����ȡ��ȡ���Ŀ�Ƭ����
//		double r = Math.random();
//		if(r<=pro) {
//			return 0;
//		}
//		else {
//			return 1;
//		}
//		
//	}
	
}