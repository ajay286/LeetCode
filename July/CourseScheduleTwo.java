import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class CourseScheduleTwo {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] resultList = new int[numCourses];
		LinkedHashSet<Integer> setNoIncomingEdge = new LinkedHashSet<Integer>();
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		int indegree[] = new int[numCourses];

		for (int i = 0; i < numCourses; ++i)
			adjList.put(i, new ArrayList<Integer>());

		for (int[] edge : prerequisites) {
			adjList.get(edge[1]).add(edge[0]);
		}

		int result = 0;

		for (int i = 0; i < numCourses; i++) {
			List<Integer> temp = adjList.get(i);
			for (int node : temp) {
				indegree[node]++;
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				setNoIncomingEdge.add(i);
		}

		while (!setNoIncomingEdge.isEmpty()) {
			Iterator<Integer> i = setNoIncomingEdge.iterator();
			Integer n = (Integer) i.next();
			resultList[result] = n;
			i.remove();

			for (Integer node : adjList.get(n)) {
				if (--indegree[node] == 0)
					setNoIncomingEdge.add(node);
			}

			++result;

		}

		if (result != numCourses)
			resultList = new int[0];

		return resultList;

	}

	public static void main(String[] args) {

		CourseScheduleTwo solCourseScheduleTwo = new CourseScheduleTwo();
		int result[] = solCourseScheduleTwo.findOrder(2, new int[][] { { 1, 0 }, { 0, 1 } });
		System.out.println(Arrays.toString(result));

	}
}
