package leetcodeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

time: O(m * nlogn)
space: O(n)
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if(strs == null || strs.length == 0) return res;
        List<String> com = new ArrayList<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if(map.containsKey(s)){
                List<String> list = res.get(map.get(s));
                list.add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, res.size());
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams res = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(res.groupAnagrams(strs));
    }
    }

