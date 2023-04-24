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
