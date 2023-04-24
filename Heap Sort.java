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
