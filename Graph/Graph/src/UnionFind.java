public class UnionFind {
    int size;
    int[]union;

    UnionFind(int n) {
        size = n;
        union = new int[size];

        for (int i = 0; i < size; i++) {
            union[i] = i;
        }
    }
    public int find(int element) {
        return union[element];
    }

    public boolean isConnected(int element1, int element2) {
        return find(element1) == find(element2);
    }

    public void unionTwoelement(int element1, int element2) {

        int firstFather = find(element1);
        int secondFather = find(element2);

        if (firstFather != secondFather) {
            for (int i = 0; i < size; i++) {
                if (union[i] == firstFather) {
                    union[i] = secondFather;
                }
            }
        }
    }
}
