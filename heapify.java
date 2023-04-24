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
