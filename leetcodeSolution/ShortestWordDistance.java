package leetcodeSolution;
/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1

time: O(n)
space: O(1)
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                index1 = i;
            }
            if(words[i].equals(word2)){
                index2 = i;
            }
            if(index1 != -1 && index2 != -1){
                if(min > Math.abs(index1 - index2)){
                    min = Math.abs(index1 - index2);
                }
            }
        }
        return min;

    }

    public static void main(String[] args) {
        ShortestWordDistance res = new ShortestWordDistance();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "practice";
        String word2 = "coding";
        System.out.println(res.shortestDistance(words, word1, word2));
    }
}
