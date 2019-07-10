import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
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
	public static int lottery(List<Double> Rates) {
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
 
		// ����ÿ����Ʒ���ܸ��ʵĻ����µĸ����������ʵ�ʸ���
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
	
}