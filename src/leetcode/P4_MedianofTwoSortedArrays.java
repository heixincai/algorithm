package leetcode;

/**
 * Created by krosshuang on 2018/11/18.
 */
public class P4_MedianofTwoSortedArrays {

    public static void main(String[] args) {
        P4_MedianofTwoSortedArrays s = new P4_MedianofTwoSortedArrays();

        s.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            if (nums1 != null && nums1.length > 0 && nums2 != null && nums2.length > 0) {
                return both(nums1, nums2);
            }

            if (nums1.length == 0 && nums2.length > 0) {
                return one(nums2);
            }

            if (nums1.length > 0 && nums2.length == 0) {
                return one(nums1);
            }

            return 0;

        }

        private double one(int[] nums) {
            if (nums.length % 2 == 0) {
                return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2d;
            } else {
                return nums[nums.length / 2];
            }
        }

        private double both(int[] nums1, int[] nums2) {
            int currentIndex = 0;
            int i = 0;
            int j = 0;

            boolean foundM1 = false;
            boolean foundM2 = false;
            int m1 = 0;
            int m2 = 0;

            int m1Index = 0;
            int m2Index = 0;

            m2Index = (nums1.length + nums2.length) / 2;
            m1Index = m2Index - 1;
            if (m1Index < 0) {
                m1Index = m2Index;
            }

            while (!foundM1 || !foundM2) {
                int smallOne = 0;
                if (i >= nums1.length) {
                    smallOne = nums2[j];
                    j++;
                } else if (j >= nums2.length) {
                    smallOne = nums1[i];
                    i++;
                } else {
                    if (nums1[i] < nums2[j]) {
                        smallOne = nums1[i];
                        i++;
                    } else {
                        smallOne = nums2[j];
                        j++;
                    }
                }

                if (currentIndex == m1Index) {
                    foundM1 = true;
                    m1 = smallOne;
                } else if (currentIndex == m2Index) {
                    foundM2 = true;
                    m2 = smallOne;
                }

                currentIndex++;
            }

            if ((nums1.length + nums2.length) % 2 == 0) {
                return (m1 + m2) / 2d;
            } else {
                return m2;
            }
        }
}
