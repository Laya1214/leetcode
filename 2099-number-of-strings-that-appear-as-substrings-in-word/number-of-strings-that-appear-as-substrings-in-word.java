class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count=0;
        for(String ch:patterns){
            if(word.contains(ch)){
                count++;
            }
        }
        return count;
    }
}