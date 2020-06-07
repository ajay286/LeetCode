/*
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. 
 * Write an algorithm to reconstruct the queue.
 * Note:
 * The number of people is less than 1,100.
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {

	public int[][] reconstructQueue(int[][] people) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		Comparator<int[]> comparator = new java.util.Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0])
					return Integer.compare(a[1], b[1]);
				else
					return Integer.compare(b[0], a[0]);

			}
		};
		Arrays.parallelSort(people, comparator);

		for (int i = 0; i < people.length; ++i) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(people[i][0]);
			row.add(people[i][1]);
			list.add(people[i][1], row);

			System.out.print(
					String.format("Adding %s at Index %s, Array became -> ", Arrays.toString(people[i]), people[i][1]));
			printIntermediate(list);
		}

		int i = 0;
		for (ArrayList<Integer> row : list) {
			people[i][0] = row.get(0);
			people[i][1] = row.get(1);
			++i;
		}

		return people;

	}

	public void printIntermediate(ArrayList<ArrayList<Integer>> list) {
		for (ArrayList<Integer> row : list) {
			System.out.print(row.toString());
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] people = { { 9, 0 }, { 7, 0 }, { 1, 9 }, { 3, 0 }, { 2, 7 }, { 5, 3 }, { 6, 0 }, { 3, 4 }, { 6, 2 },
				{ 5, 2 } };
		QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
		people = queueReconstructionByHeight.reconstructQueue(people);
		
		System.out.println("\nResulted queue is ");
		for (int[] row : people)
			System.out.print(Arrays.toString(row));

	}
}

/*
 * Adding [9, 0] at Index 0, Array became -> [9, 0]
 * Adding [7, 0] at Index 0, Array became -> [7, 0][9, 0]
 * Adding [6, 0] at Index 0, Array became -> [6, 0][7, 0][9, 0]
 * Adding [6, 2] at Index 2, Array became -> [6, 0][7, 0][6, 2][9, 0]
 * Adding [5, 2] at Index 2, Array became -> [6, 0][7, 0][5, 2][6, 2][9, 0]
 * Adding [5, 3] at Index 3, Array became -> [6, 0][7, 0][5, 2][5, 3][6, 2][9, 0]
 * Adding [3, 0] at Index 0, Array became -> [3, 0][6, 0][7, 0][5, 2][5, 3][6, 2][9, 0]
 * Adding [3, 4] at Index 4, Array became -> [3, 0][6, 0][7, 0][5, 2][3, 4][5, 3][6, 2][9, 0]
 * Adding [2, 7] at Index 7, Array became -> [3, 0][6, 0][7, 0][5, 2][3, 4][5, 3][6, 2][2, 7][9, 0]
 * Adding [1, 9] at Index 9, Array became -> [3, 0][6, 0][7, 0][5, 2][3, 4][5, 3][6, 2][2, 7][9, 0][1, 9]
 * 
 * Resulted queue is 
 * [3, 0][6, 0][7, 0][5, 2][3, 4][5, 3][6, 2][2, 7][9, 0][1, 9]
 *  * */
