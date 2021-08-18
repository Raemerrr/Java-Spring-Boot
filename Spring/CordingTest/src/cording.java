import java.util.*;

public class cording {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = null;
		List<Integer> list = new ArrayList<Integer>();
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		for (String q : query) {
			List<String> splits = new ArrayList<>(Arrays.asList(q.split(" and ")));;
			String tempStr = splits.get(3);
			String[] tempSplits = tempStr.split(" ");
			//너무 위험하지만.. 시간이 부족해서..
			splits.set(3, tempSplits[0]);
			splits.add(tempSplits[1]);
			int cnt = 0;
			ArrayList<String> sList = new ArrayList<String>();
			if (!splits.get(0).equals("-")) {
				sList.add(splits.get(0));
			}
			if (!splits.get(1).equals("-")) {
				sList.add(splits.get(1));
			}
			if (!splits.get(2).equals("-")) {
				sList.add(splits.get(2));
			}
			if (!splits.get(3).equals("-")) {
				sList.add(splits.get(3));
			}
			for (String i : info) {
				boolean flag = true;
				String[] infoSplit = i.split("\\s");
				if (Integer.parseInt(infoSplit[4]) >= Integer.parseInt(splits.get(4))) {
					for (String comp : sList) {
						if (!i.contains(comp)) {
							flag = false;
							break;
						}
					}
					if (flag) {
						cnt++;
					}
				}
			}
			list.add(cnt);
		}
		for(Integer i : list) 
		{
			System.out.println(i);
		}
		answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) 
		{
			answer[i] = list.get(i);
		}
		for(int i : answer) {System.out.println(i);}
	}

}

//
//
//class Solution {
//    public String solution(String new_id) {
//        String answer = "";
//        return answer;
//    }
//}
//
//
//
//public class cording {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String new_id = "-_.~!@#$%^&*()=+[{]}:?,<>/"; 
//		new_id = new_id.toLowerCase();
//		new_id = new_id.replaceAll("[~!@#$%^&*\\\\(\\\\)=+\\\\[\\\\{\\\\]\\\\}:?,\\\\<\\\\>/]", "");
//		new_id = new_id.replaceAll("[\\[\\]]", "");
//		System.out.println("new_id : " + new_id);
//		while(true) 
//		{
//			String tnew_id = new_id;
//			new_id = new_id.replace("..", ".");
//			if(tnew_id.equals(new_id)) 
//			{
//				break;
//			}
//		}
//		if(new_id.charAt(0) == '.') 
//		{
//			if(new_id.length() > 1) 
//			{
//				new_id = new_id.substring(1,new_id.length());
//			}else 
//			{
//				new_id = "";
//			}
//		}
//		if	(new_id.length() > 1 && new_id.charAt(new_id.length()-1) == '.' ) 
//		{
//			if(new_id.length() > 1) 
//			{
//				new_id = new_id.substring(0,new_id.length()-1);
//			}else 
//			{
//				new_id = "";
//			}
//		} 
//		if(new_id.isEmpty()) 
//		{
//			new_id = "a";
//		}else 
//		{
//			if(new_id.length() > 15) 
//			{
//				new_id = new_id.substring(0,15);
//				if	(new_id.length() > 1&&new_id.charAt(new_id.length()-1) == '.' ) 
//				{
//					new_id = new_id.substring(0,new_id.length()-1);
//				} 
//			}
//			
//		}
//		while(new_id.length() < 3) 
//		{
//			new_id = new_id+new_id.charAt(new_id.length()-1);
//		}
//		System.out.println(new_id);
//	}
//
//}
