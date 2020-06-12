import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

	private ArrayList<Integer> array;
	private HashMap<Integer, Integer> position;
	private Random random;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		array = new ArrayList<Integer>();
		position = new HashMap<Integer, Integer>();
		random = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {

		if (!this.position.containsKey(val)) {
			this.position.put(val, this.array.size());
			this.array.add(val);
			return true;
		}

		return false;

	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {

		if (!this.position.containsKey(val)) {
			return false;
		}

		int index = this.position.remove(val);

		if (index != this.array.size() - 1) {
			Integer last = this.array.get(this.array.size() - 1);
			this.array.set(this.array.size() - 1, val);
			this.array.set(index, last);
			this.position.put(last, index);
		}
		this.array.remove(this.array.size() - 1);
		return true;

	}

	/** Get a random element from the set. */
	public int getRandom() {

		int index = this.random.nextInt(this.array.size());
		return this.array.get(index);

	}

	public static void main(String[] args) {
		RandomizedSet solution = new RandomizedSet();
		System.out.println(solution.insert(1));
		System.out.println(solution.remove(2));
		System.out.println(solution.insert(2));
		System.out.println(solution.getRandom());
		System.out.println(solution.remove(1));
		System.out.println(solution.insert(2));
		System.out.println(solution.getRandom());

	}

}
