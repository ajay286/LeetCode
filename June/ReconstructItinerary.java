package com.serverless.June;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ReconstructItinerary {

	HashMap<String, SortedArrayList<String>> stations = new HashMap<String, SortedArrayList<String>>();
	List<String> result = new ArrayList<String>();

	public List<String> findItinerary(List<List<String>> tickets) {
		for (List<String> ticket : tickets) {
			if (stations.containsKey(ticket.get(0))) {
				stations.get(ticket.get(0)).insertSorted(ticket.get(1));
			} else {
				SortedArrayList<String> fromToList = new SortedArrayList<String>();
				fromToList.insertSorted(ticket.get(1));
				stations.put(ticket.get(0), fromToList);
			}
		}

		this.dfs("JFK");
		Collections.reverse(result);

		return result;

	}

	public void dfs(String current) {
		while (this.stations.containsKey(current) && this.stations.get(current).size() > 0) {
			String removed = stations.get(current).remove(0);
			this.dfs(removed);
		}
		this.result.add(current);

	}
}

@SuppressWarnings("serial")
class SortedArrayList<T> extends ArrayList<T> {

	@SuppressWarnings("unchecked")
	public void insertSorted(T value) {
		add(value);
		Comparable<T> cmp = (Comparable<T>) value;
		for (int i = size() - 1; i > 0 && cmp.compareTo(get(i - 1)) < 0; i--)
			Collections.swap(this, i, i - 1);
	}
}
