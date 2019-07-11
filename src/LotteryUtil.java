import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
 
/**
 * 抽卡工具类
 */
public class LotteryUtil {
	/**
	 * 抽卡
	 *
	 * @param Rates 原始的概率列表，保证顺序和实际物品对应
	 * @return 物品的索引（r在排序列表后的位置）
	 */
	public static int lottery(List<Card> cards, Double pro) {

		if (cards.isEmpty()) {
			// Card（序号，等级，卡名，概率）
			cards.add(new Card(0, "0", pro)); 
			cards.add(new Card(1, "1", 1-pro));
		}
				
		//读card的概率p，构造原始概率列表Rates
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
 
		// 统计数量：卡数=概率数
		int size = Rates.size();
 
		// 计算总概率，总概率不一定是1
		double sumRate = 0d;
		for (double rate : Rates) {
			sumRate += rate;
		}
 
		// 计算每个物品在总概率的基础下的概率情况
		List<Double> sortRates = new ArrayList<Double>(size);
		Double realSumRate = 0d;
		for (double rate : Rates) {
			realSumRate += rate;
			sortRates.add(realSumRate / sumRate);
		}
 
		// 根据区块值来获取抽取到的卡片索引
		double r = Math.random();
		sortRates.add(r);
		Collections.sort(sortRates);
 
		return sortRates.indexOf(r);
	}
	
	
	
	public static void main(String[] args) {
		List<Card> cards = new ArrayList<Card>();
		Scanner input=new Scanner(System.in);
		System.out.println("请设置概率：");
		double pro=input.nextDouble();//输入一个整数

		
		// 统计
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		// 设置一次抽卡数量
		double num = 100000;
		
		for (int i = 0; i < num; i++) {
			int Index = LotteryUtil.lottery(cards,pro);
			//int Index = LotteryUtil.lottery_easy(cards,pro);
 			Integer value = count.get(Index);
			count.put(Index, value == null ? 1 : value + 1);
		}
 
		// 输出：抽到的数量和实际概率
		for (Entry<Integer, Integer> entry : count.entrySet()) {
			System.out.println(cards.get(entry.getKey()) + ", 抽到数量=" + entry.getValue() + ", 实际概率="+ entry.getValue() / num);
		}
		 
	}
	
	
	
//	public static int lottery_easy(List<Card> cards, Double pro) {
//		
//		if (cards.isEmpty()) {
//			// Card（序号，等级，卡名，概率）
//			cards.add(new Card(0, "0", pro)); 
//			cards.add(new Card(1, "1", 1-pro));
//		}
//				
//		//读card的概率p，构造原始概率列表Rates
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
//		// 根据区块值来获取抽取到的卡片索引
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