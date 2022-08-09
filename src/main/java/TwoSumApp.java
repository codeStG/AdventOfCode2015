public class TwoSumApp {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        int[] arr = twoSum.twoSum(new int[]{2, 11, 7, 15}, 9);
        int[] arr2 = twoSum.twoSum(new int[]{3, 2, 4}, 6);
        int[] arr3 = twoSum.twoSum(new int[]{5, 2, 9, 7, 8}, 10);

        System.out.println("[" + arr[0] + ", " + arr[1] + "]");
        System.out.println("[" + arr2[0] + ", " + arr2[1] + "]");
        System.out.println("[" + arr3[0] + ", " + arr3[1] + "]");
    }
}
