package leetcodeSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]

time: O(n)
space: O(p) where p is the number of sub-sequences.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i <= s.length() - 10; i++){
            String sub = s.substring(i, i + 10);
            if(map.containsKey(sub)){
                map.put(sub, map.get(sub) + 1);
            }else{
                map.put(sub, 1);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                res.add(entry.getKey());
            }
        }
        return res;
    }

    }
