class Solution {
public int largestRectangleArea(int[] h) {
    int n = h.length;
    Stack<Integer> st = new Stack<>();
    int max = 0; 
    for (int i = 0; i <= n; i++) {
        int curr = (i == n) ? 0 : h[i];
        while (!st.isEmpty() && curr < h[st.peek()]) {
            int height = h[st.pop()];
            int width = st.isEmpty() ? i : i - st.peek() - 1;
            max = Math.max(max, height * width);
        }
        st.push(i);
    }
    return max; 
}
}