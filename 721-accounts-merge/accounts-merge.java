import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int idCounter = 0;
        
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, idCounter++);
                    emailToName.put(email, name);
                }
            }
        }

        int[] parent = new int[idCounter];
        for (int i = 0; i < idCounter; i++) {
            parent[i] = i;
        }

        for (List<String> account : accounts) {
            if (account.size() < 2) continue;
            int firstEmailId = emailToId.get(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                int currentEmailId = emailToId.get(account.get(i));
                union(parent, firstEmailId, currentEmailId);
            }
        }

        Map<Integer, List<String>> mergedGroups = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToId.entrySet()) {
            String email = entry.getKey();
            int id = entry.getValue();
            int root = find(parent, id);
            
            mergedGroups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : mergedGroups.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            
            String name = emailToName.get(emails.get(0));
            
            List<String> mergedAccount = new ArrayList<>(emails.size() + 1);
            mergedAccount.add(name);
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
        }

        return result;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }

    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}
