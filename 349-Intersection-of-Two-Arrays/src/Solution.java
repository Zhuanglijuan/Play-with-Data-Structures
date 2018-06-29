import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        //将nums1中元素不重复放入TreeSet
        for(int num : nums1){
            set.add(num);
        }
        //遍历nums2，看在集合中是否能找到
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);//找到移除
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0;i< list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
