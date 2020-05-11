import java.util.*;

class Test{
//boss
	public static void main(String[] args) {
		
		List<List<Integer>> list = new ArrayList<>();

		List<Integer>[] mylist = new ArrayList[3];

		for(int i=0;i<3;i++)
			mylist[i] = new ArrayList<>();

		mylist[0].add(10);
		mylist[0].add(130);
		mylist[0].add(140);
		mylist[1].add(10);
		mylist[1].add(43);
		mylist[1].add(5);
		mylist[2].add(3);
		mylist[2].add(56);
		mylist[2].add(9);

		list.add(mylist[0]);
		list.add(mylist[0]);		
		for(List<Integer> l : list)
			System.out.print(l);
	}
}