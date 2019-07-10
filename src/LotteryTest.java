import java.util.*;
import java.util.Map.Entry;
 
/**
 * 不同概率抽卡测试类
 * 
 */
public class LotteryTest {
	public static void main(String[] args) {
		List<Card> cards = new ArrayList<Card>();
		// Card（序号，等级，卡名，概率）
		cards.add(new Card(1, "N", "N1", 0.12d)); 
		cards.add(new Card(2, "N", "N2", 0.12d));
		cards.add(new Card(3, "N", "N3", 0.12d));
		cards.add(new Card(4, "N", "N4", 0.12d));
		cards.add(new Card(5, "N", "N5", 0.12d));
		cards.add(new Card(6, "R", "R1", 0.045d));  
		cards.add(new Card(7, "R", "R2", 0.045d));
		cards.add(new Card(8, "R", "R3", 0.045d));
		cards.add(new Card(9, "R", "R4", 0.045d));
		cards.add(new Card(10, "R", "R5", 0.045d));
		cards.add(new Card(11, "SR", "SR1", 0.01d));
		cards.add(new Card(12, "SR", "SR2", 0.01d));
		cards.add(new Card(13, "SR", "SR3", 0.01d));
		cards.add(new Card(14, "SSR", "SSR", 0.0003d));
 
 
		//读card的概率p，构造原始概率列表Rates
		List<Double> Rates = new ArrayList<Double>(cards.size());
		for (Card card : cards) {
			double p = card.getP();
			if (p < 0) {
				p = 0;
			}
			Rates.add(p);
		}
		System.out.println("概率列表："+Rates);
		
		// 统计
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		// 设置一次抽卡数量
		double num = 10;
		
		for (int i = 0; i < num; i++) {
			int Index = LotteryUtil.lottery(Rates);
 			Integer value = count.get(Index);
			count.put(Index, value == null ? 1 : value + 1);
		}
 
		// 输出：抽到的数量和实际概率
		for (Entry<Integer, Integer> entry : count.entrySet()) {
			System.out.println(cards.get(entry.getKey()) + ", 抽到数量=" + entry.getValue() + ", 实际概率="+ entry.getValue() / num);
		}
	}
}