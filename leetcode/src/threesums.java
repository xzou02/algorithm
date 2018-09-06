
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

        Note:

        The solution set must not contain duplicate triplets.

        Example:

        Given array nums = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]




public class threesums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // check nums[i + 1] to be different than nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                    //avoid repeating check lo < hi first ow out of bound
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (nums[hi] + nums[lo] < target) lo++;
                else hi--;
            }
        }
        return res;
    }
}