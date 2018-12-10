package leetcodeSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

time: O(m * n) where m is avg length of each string and n is the length of string array
space: O(n)
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if(strings == null || strings.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : strings){
            int offset = str.charAt(0) - 'a';
            String key = "";
            for(int i = 0; i < str.length(); i++){
                char c = (char) (str.charAt(i) - offset);
                if(c < 'a'){
                    c += 26;
                }
                key += c;
            }
            if(map.containsKey(key)){
                List<String> list = res.get(map.get(key));
                list.add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, res.size());
                res.add(list);
            }
        }

        return res;
    }

    }
