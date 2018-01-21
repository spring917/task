package test;



 
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
 
 /**
  * 
  * @author spring
  * 
  */
public class LoadBalance {
	 //测试
    public static void main(String[] args) {
        String[] str1 = {"5","5555"}; //权重为5
        String[] str2 = {"4","4444"}; //权重为4
        String[] str3 = {"3","3333"}; //权重为3
       
        List<String[]> list = new ArrayList<String[]>();
        list.add(str1);
        list.add(str2);
        list.add(str3);
       

        Long s = System.currentTimeMillis();
        String str = null;
        for(int i=0;i<10000000;i++){
            str = new LoadBalance().getMax(list);
        }
        Long e = System.currentTimeMillis();
        System.out.println("耗时："+(e-s));
        System.out.println(str);
    }

    
    public String getMax(List<String[]> list){      
        int len = list.size();
        int total = 0;//总权重
        //以权重区间段的后面的值作为key存当前信息
        TreeMap<Integer,String> map = new TreeMap<Integer, String>(); 
        for(int i=0; i<len; i++){
            String[] array = list.get(i);
            total += Integer.parseInt(array[0]);
            map.put(total, array[1]); 
        }

        int random = (int)(Math.random()*total);
        Integer key = map.ceilingKey(random);
        return map.get(key);
    }
 
}
