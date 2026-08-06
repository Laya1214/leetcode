import java.util.*;

class UnionFind {
    Map<String, String> parent;

    public UnionFind() {
        parent = new HashMap<>();
    }

    public String find(String s) {
        // Initialize node if it does not exist
        if (!parent.containsKey(s)) {
            parent.put(s, s);
        }
        // Path compression
        if (!parent.get(s).equals(s)) {
            parent.put(s, find(parent.get(s)));
        }
        return parent.get(s);
    }

    public void union(String s1, String s2) {
        String root1 = find(s1);
        String root2 = find(s2);
        if (!root1.equals(root2)) {
            parent.put(root1, root2);
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String, String> emailToName = new HashMap<>();

        // 1. Initialize parents and union emails within the same account
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String currentEmail = account.get(i);
                emailToName.put(currentEmail, name);
                uf.union(firstEmail, currentEmail);
            }
        }

        Map<String, List<String>> mergedGroups = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = uf.find(email);
            mergedGroups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        
        List<List<String>> result = new ArrayList<>();
        for (String root : mergedGroups.keySet()) {
            List<String> emails = mergedGroups.get(root);
            Collections.sort(emails); 
            
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(emailToName.get(root)); 
            mergedAccount.addAll(emails);            
            result.add(mergedAccount);
        }

        return result;
    }
}
