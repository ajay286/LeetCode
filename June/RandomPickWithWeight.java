/*
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 * Note:
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * */


import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight {
	int sum;
	private TreeMap<Integer, Integer> map;
	public Random random;

	public RandomPickWithWeight(int[] w) {
		random = new Random();
		map = new TreeMap<>();

		for (int i = 0; i < w.length; i++) {
			sum += w[i];
			map.put(sum, i);
		}
	}

	public int pickIndex() {
		int k = map.higherKey(random.nextInt(sum));
		return map.get(k);
	}

	public static void main(String[] args) {

		RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[] { 1, 3 });

		System.out.print("[");
		for (int i = 0; i < 5; ++i)
			System.out.print(randomPickWithWeight.pickIndex() + " ");
		System.out.print("]");
	}

}
