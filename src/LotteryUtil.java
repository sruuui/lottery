import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
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
	public static int lottery(List<Double> Rates) {
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
 
		// 计算每个物品在总概率的基础下的概率情况，即实际概率
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
	
}