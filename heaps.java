
// package Heaps;
import java.util.*;

public class Classroom {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int child = arr.size() - 1;
            int par = (child - 1) / 2;

            while (arr.get(child) < arr.get(par)) {
                int temp = arr.get(child);
                arr.set(child, arr.get(par));
                arr.set(par, temp);

                child = par;
                par = (child - 1) / 2;
            }
        }

        public int remove() {
            // swap 1st and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // remove last element
            int data = arr.remove(arr.size() - 1);

            // heapify
            heapify(0);
            return data;
        }

        private void heapify(int idx) {
            int left = (2 * idx) + 1;
            int right = (2 * idx) + 2;
            int minIdx = idx;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }
            // swap to make parent
            if (minIdx != idx) {
                // swap
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        public void heapSort(int arr[]) {
            // step 1 : call heapify for the non leaf nodes
            int n = arr.length;
            for (int i = (n / 2); i >= 0; i--) {
                heapify(arr, i, n);
            }

            // step 2 : swap
            for (int i = n - 1; i >= 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify(arr, 0, i);
            }
        }

        public void heapify(int arr[], int idx, int size) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int maxIdx = idx;

            if (left < size && arr[left] > arr[maxIdx]) {
                maxIdx = left;
            }

            if (right < size && arr[right] > arr[maxIdx]) {
                maxIdx = right;
            }

            if (maxIdx != idx) {
                int temp = arr[idx];
                arr[idx] = arr[maxIdx];
                arr[maxIdx] = temp;

                heapify(arr, maxIdx, size);
            }
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        int[] arr = { 1, 2, 4, 5, 3 };
        h.heapSort(arr);
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);

        // while (!h.isEmpty()) {
        //     System.out.print(h.remove() + " ");
        // }
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
