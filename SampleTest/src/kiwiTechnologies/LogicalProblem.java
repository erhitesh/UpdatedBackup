package kiwiTechnologies;

import java.util.ArrayList;
import java.util.List;

public class LogicalProblem {
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(18);
		list.add(11);
		list.add(13);
		list.add(10);
		list.add(16);
		System.out.println(list);
		int count = 1;
		/*for (int i = 0; i < list.size(); i++){
			for (int j = 1; j < list.size(); j++){
				if (list.get(i) > list.get(j)){
					count++;
				}
			}
		}*/
		int i = 0 , j = 1;
		while (i < list.size()){
			
				if (list.get(i) < list.get(j)){
					i = j;
					count++;
					j++;
				}
				else
				{
					j++;
				}
		}
		System.out.println("count value..."+count);
	}
	
}
