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
