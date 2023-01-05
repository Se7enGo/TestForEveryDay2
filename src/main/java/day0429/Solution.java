package day0429;

public class Solution {
    public static int pivotIndex(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        for (int i = 0; i < length; i++) {

            if (i == 0) {
                int left = 0;
                int right = 0;
                for (int l = 1; l < length; l++) {
                    right += nums[l];
                }
                if (left == right) {
                    return i;
                }
            } else if (i == length - 1) {
                int left = 0;
                int right = 0;
                for (int l = i-1; l >= 0; l--) {
                    left += nums[l];
                }
                if (left == right) {
                    return i;
                }
            } else {
                int left = 0;
                int right = 0;
                for (int l = 0; l < i; l++) {
                    left += nums[l];
                }
                for (int p = i+1 ; p < length; p++) {
                    right += nums[p];
                }
                if (left == right) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        // 二分法
        int tail = nums.length -1;
        int head = 0;
        int half = nums.length /2 ;

        while(head <= tail){
            if (target == nums[half]){
                return half ;
            }else if (target < nums[half]){
                tail = half -1;

            }else if(target > nums[half]){
                head = half + 1;
            }
            half = (tail + head)/2;
        }
        return head;
    }

    public static int[][] merge(int[][] intervals) {

        // 假如 intervals 是按照二维中第一个数字递增的
        int length = intervals.length * 2;
        int[] temp = new int[intervals.length ];
        // 排完顺序之后 先决定第一个数字 再决定是否吞掉 所以要声明一个已经访问过的列表
        int start = 0;
        int tail = 1;
        int i = 0;

        while (start< length){
            if (intervals[i][1] < intervals[i+1][1]){
                intervals[i][0] = intervals[i][0];
            }else{
                intervals[i][0] = intervals[i+1][0];
            }
            if (intervals[i][1] >= intervals[i][0]){

            }
            i++;
        }
        //Arrays.copyOfRange()
        // 如果合并就需要 copy 不合并就需要从下一个坐标开始对比

        return intervals;
    }

    public static void main(String[] args) {
        /*int[] nums = {1,3,5,6};
        int i = searchInsert(nums,2);
        System.out.println(i);
*/
        /*int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        intervals = merge(intervals);
        System.out.println(intervals);*/
    }
}