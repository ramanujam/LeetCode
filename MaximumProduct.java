/**
 * Created by rohansingh on 6/24/17.
 */
public class MaximumProduct {
    public static void main(String[] args) {
        System.out.println("Given an integer array, find three numbers whose product is maximum and output the maximum product.");
        System.out.println("Input : 7 3 1 0 0 6");
        int[] arr = {7,3,1,0,0,6};
        int max = MaxProd(arr);
        System.out.printf("Max Prod: %d\n", max);
        System.out.println("All test cases passed on Leetcode");
    }

    public static int MaxProd(int[] arr)
    {
        int[] sorted_arr;
        if(arr.length == 0) return 0;
        else sorted_arr = sort(arr);

        if(sorted_arr.length == 1) return sorted_arr[0];
        else if(sorted_arr.length == 2) return sorted_arr[1] * sorted_arr[0];
        else if(sorted_arr.length == 3) return sorted_arr[0] * sorted_arr[1] * sorted_arr[2];
        else {
            int maxProd = getMaxProd(sorted_arr);
            return maxProd;
        }
    }

    public static int getMaxProd(int[] a){
        int min1 = a[0];
        int min2 = a[1];
        int min3 = a[2];

        int max1 = a[a.length - 1];
        int max2 = a[a.length - 2];
        int max3 = a[a.length - 3];

        if(min1>0) return max1*max2*max3;
        if(min2>0 && min1<0) return max1*max2*max3;
        else return min1*min2*max1 > max1*max2*max3 ? min1*min2*max1 : max1*max2*max3;

    }
    public static int[] sort(int[] a){
        int temp;
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (a[i] > a[j])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}

