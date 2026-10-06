class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String k=new String(ch);
            if(!map.containsKey(k)){
                map.put(k,new ArrayList<>());
            }
            map.get(k).add(s);
        }
        ans.addAll(map.values());
        return ans;
    }
}