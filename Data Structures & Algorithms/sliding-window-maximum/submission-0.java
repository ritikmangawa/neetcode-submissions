

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0, j = 0;
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        while (j < n) {

            // Step 1: Remove smaller elements from the back
            while (!dq.isEmpty() && dq.peekLast() < nums[j]) {
                dq.pollLast();
            }
            dq.offerLast(nums[j]);

            // Step 2: Check window size
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {

                // Step 3: Front contains maximum
                list.add(dq.peekFirst());

                // Step 4: Remove outgoing element
                if (nums[i] == dq.peekFirst()) {
                    dq.pollFirst();
                }

                i++;
                j++;
            }
        }

        int[] ans = new int[list.size()];
        for (int x = 0; x < list.size(); x++) {
            ans[x] = list.get(x);
        }

        return ans;
    }
}
