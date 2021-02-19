package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


class Edge
{
	int so, de, we;

	public Edge(int so, int de, int we) {
		this.de = de;
		this.we = we;
		this.so = so;

	}
}

class Node {
	int ve, we;

	public Node(int ve, int we) {
		this.we = we;
		this.ve = ve;

	}
}

class Graph
{
	List<List<Edge>> al = null;

	Graph(List<Edge> edges, int N)
	{
		al = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			al.add(new ArrayList<>());
		}


		for (Edge edge: edges) {
			al.get(edge.so).add(edge);
		}
	}
}

public class ccc21s4
{
	private static void gr(int[] prev, int i, List<Integer> rou)
	{
		if (i >= 0) {
			gr(prev, prev[i], rou);
			rou.add(i);
		}
	}

	public static void sp(Graph graph, int so, int N)
	{
		PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.we));
		minHeap.add(new Node(so, 0));
		List<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));

		dist.set(so, 0);

		boolean[] done = new boolean[N];
		done[so] = true;

		int[] prev = new int[N];
		prev[so] = -1;

		List<Integer> rou = new ArrayList<>();

		while (!minHeap.isEmpty())
		{



			Node node = minHeap.poll();
			int u = node.ve;

			for (Edge edge: graph.al.get(u))
			{
				int we = edge.we;
				int v = edge.de;


				if (!done[v] && (dist.get(u) + we) < dist.get(v))
				{
					dist.set(v, dist.get(u) + we);
					prev[v] = u;
					minHeap.add(new Node(v, dist.get(v)));
				}
			}

			done[u] = true;
		}

		int i= N-1;
		if (i != so && dist.get(i) != Integer.MAX_VALUE) {
			gr(prev, i, rou);

			System.out.println(dist.get(i));
			rou.clear();
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
	{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] nwd = in.readLine().split(" ");
		int n = Integer.parseInt(nwd[0]);
		int w = Integer.parseInt(nwd[1]);
		int d = Integer.parseInt(nwd[2]);

		ArrayList<Edge> edges = new ArrayList<Edge>();
		ArrayList<Edge> originalEdge = new ArrayList<Edge>();
		ArrayList<Integer[]> copyEdge = new ArrayList<Integer[]>();

		String[] walkways;
		for (int i = 0; i < w; i++) {
			walkways = in.readLine().split(" ");
			//originalEdge.add(new Edge(Integer.parseInt(walkways[0]) - 1, Integer.parseInt(walkways[1]) - 1, 1));
			copyEdge.add(new Integer[] {Integer.parseInt(walkways[0]) - 1, Integer.parseInt(walkways[1]) - 1});
		}

		String[] s = in.readLine().split(" ");

		ArrayList<Integer> stations = new ArrayList<Integer>();

		for (int i = 0; i < s.length; i++) {
			stations.add(Integer.parseInt(s[i]));
		}

		String[] swapping;

		for (int i = 0; i < d; i++) {
			//if (edges != null) {
			edges.clear();
			//}

			for (int k = 0; k < copyEdge.size(); k++) {
				edges.add(new Edge(copyEdge.get(k)[0], copyEdge.get(k)[1], 1));
			}
			//edges.addAll(originalEdge);

			swapping = in.readLine().split(" ");
			Collections.swap(stations, Integer.parseInt(swapping[0]) - 1, Integer.parseInt(swapping[1]) - 1);
			for (int j = 0; j < stations.size() - 2; j++) {
				edges.add(new Edge(stations.get(j) - 1, stations.get(j + 1) - 1, 1));
			}

			final int N = stations.size();

			Graph graph = new Graph(edges, N);

			int so = 0;
			sp(graph, so, N);

			//
			//edges.subList(edges.size()-stations.size(), edges.size()-1).clear();
			//			for (int j = 0; j < edges.size() -2; j++) {
			//				//edges.size() - stations.size() +1; j < edges.size(); j++) {
			//				edges.remove(edges.size() - stations.size() +1+j);
			//			}

		}



	}
}
