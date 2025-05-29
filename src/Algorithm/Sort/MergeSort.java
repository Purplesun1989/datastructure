package Algorithm.Sort;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2023-05-11 15:53
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] du = new int[arr.length];
        m_Sort(arr, du, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void m_Sort(int[] arr, int[] dupli, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            m_Sort(arr, dupli, left, mid);
            m_Sort(arr, dupli, mid + 1, right);
            Merge(arr, dupli, left, mid, right);
        }
    }

    static void Merge(int[] arr, int[] dupli, int head, int mid, int tail) {
        int rightP = mid + 1;
        int leftP = head;
        int dI = 0;
        while (leftP <= mid && rightP <= tail) {
            if (arr[leftP] < arr[rightP]) {
                dupli[dI++] = arr[leftP++];
            } else {
                dupli[dI++] = arr[rightP++];
            }
        }
        while (leftP <= mid) {
            dupli[dI++] = arr[leftP++];
        }
        while (rightP <= tail) {
            dupli[dI++] = arr[rightP++];
        }
        for (int i = 0; i < dI; i++) {
            arr[head + i] = dupli[i];
        }
    }
}
