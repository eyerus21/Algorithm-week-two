import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]); 
		RandomizedQueue<String> strs = new RandomizedQueue<>();
		while (!StdIn.isEmpty()) {
			strs.enqueue(StdIn.readString()); // accept from user and push to the queue
		}
		for (int i = 0; i < k; i++) {
			StdOut.println(strs.dequeue()); // pop randomly from th queue
		}
	}
}