package leetcodeSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

Example 1:

Input: "aabb"
Output: ["abba", "baab"]
Example 2:

Input: "abc"
Output: []
 */
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        HashMap<Character, Integer> map = new HashMap<>();
        int odd = 0;
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
            odd += map.get(c) % 2 == 0? -1:1;
        }
        if(odd > 1) return res;
        List<Character> list = new ArrayList<>();
        String a = "";
        for(HashMap.Entry<Character, Integer> entry : map.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            if(value % 2 != 0) a += key;
            for(int i = 0; i < value/2; i++){
                list.add(key);
            }
        }

        dfs(res, list, a, new boolean[list.size()], new StringBuilder());
        return res;
    }

    public void dfs(List<String> res, List<Character> list, String a, boolean[] visited, StringBuilder sb){
        if(sb.length() == list.size()){
            res.add(sb.toString() + a + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for(int i = 0; i < list.size(); i++){
            if(i > 0 && list.get(i) == list.get(i - 1) && !visited[i - 1]) continue;
            if(!visited[i]){
                visited[i] = true;
                sb.append(list.get(i));
                dfs(res, list, a, visited, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePermutationII res = new PalindromePermutationII();
        String s = "aabb";
        System.out.println(res.generatePalindromes(s));
    }
    }

