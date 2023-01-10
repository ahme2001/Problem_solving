import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams49 {
    public boolean isAnagram(String s, String t) {
        int[] temp = new int[26];
        if (s.length() != t.length())
            return false;
        Arrays.fill(temp,0);
        for (int i=0;i<s.length();i++){
            temp[s.charAt(i)%97]++;
            temp[t.charAt(i)%97]--;
        }
        for (int i=0;i<26;i++) {
            if (temp[i] != 0)
                return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>(){static {
                String s = "";
            }};
        }
        Boolean[] flags = new Boolean[strs.length];
        Arrays.fill(flags,false);
        List<List<String>> res = new ArrayList<>();
        for (int i=0;i< strs.length;i++){
            List<String> temp = new ArrayList<>();
            if (!flags[i]) {
                temp.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (!flags[j]) {
                        boolean flag = isAnagram(strs[i], strs[j]);
                        if (flag) {
                            temp.add(strs[j]);
                            flags[j] = true;
                        }
                    }
                }
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams49 t = new GroupAnagrams49();
        System.out.println(t.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    /*
    List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add(strs[0]);
        res.add(temp);
        for (int i=1;i< strs.length;i++){
            Boolean flag = true;
            System.out.println("temp : " + Arrays.toString(new List[]{temp}));
            for (int j=0;j<temp.size();j++){
                flag = isAnagram(strs[i],temp.get(j));
                if (flag){
                    System.out.println("str: "+ strs[i]);
                    List<String> templist = res.get(j);
                    res.remove(j);
                    templist.add(strs[i]);
                    res.add(j,templist);
                    break;
                }
            }
            System.out.println("res = " + Arrays.toString(new List[]{res}));
            if(!flag){
                System.out.println(strs[i]);
                temp.add(strs[i]);
                List<String> temp2 = new ArrayList<>();
                temp2.add(strs[i]);
                res.add(temp2);
            }
        }
     */
}
