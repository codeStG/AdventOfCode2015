class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] myArray = new int[2];

        for(int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            for(int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
                if(nums[firstIndex] + nums[secondIndex] == target) {
                    myArray[0] = firstIndex;
                    myArray[1] = secondIndex;
                    break;
                }
            }
        }
        return myArray;
    }

}
