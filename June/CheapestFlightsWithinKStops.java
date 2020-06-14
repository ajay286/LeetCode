/*
 * There are n cities connected by m flights. 
 * Each flight starts from city u and arrives at v with a price w.
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. 
 * If there is no such route, output -1.
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
	private int price = Integer.MAX_VALUE;

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int[] flight : flights) {
			graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
		}

		queue.add(new int[] { src, 0 });

		boolean[] visited = new boolean[n];
		visited[src] = true;
		dfs(graph, src, dst, K, 0, visited);

		return price == Integer.MAX_VALUE ? -1 : price;
	}

	private void dfs(Map<Integer, List<int[]>> graph, int src, int dst, int K, int cost, boolean[] visited) {
		if (src == dst) {
			price = Math.min(price, cost);
			return;
		}
		if (K < 0) {
			return;
		}

		List<int[]> list = graph.get(src);
		if (list != null) {
			for (int[] next : graph.get(src)) {
				if (!visited[next[0]] && cost + next[1] < price) {
					visited[next[0]] = true;
					dfs(graph, next[0], dst, K - 1, cost + next[1], visited);
					visited[next[0]] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		CheapestFlightsWithinKStops soluWithinKStops = new CheapestFlightsWithinKStops();
		System.out.println(soluWithinKStops.findCheapestPrice(10,
				new int[][] { { 0, 1, 20 }, { 1, 2, 20 }, { 2, 3, 30 }, { 3, 4, 30 }, { 4, 5, 30 }, { 5, 6, 30 },
						{ 6, 7, 30 }, { 7, 8, 30 }, { 8, 9, 30 }, { 0, 2, 9999 }, { 2, 4, 9998 }, { 4, 7, 9997 } },
				0, 9, 4));

	}

}
