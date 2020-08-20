import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void remove() {
             removed = true;   
        }

        public boolean isRemoved() {
             return removed;   
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            // put your code here
            int idx = findKey(key);
//            int agn = idx;

            if (idx == -1) {
//                System.out.println("\n - calling rehash() at this key:value pair: " + key + ":" + value);
                rehash();
                return put(key, value);
            }
// linear probing here:
           /* do {
                if (table[idx] == null) {*/
            table[idx] = new TableEntry(key, value);
                   /* return true;
                } else {
                    idx = (idx + 1) % size;
                }
            } while (idx != agn);*/

            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            // put your code here
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return;
            }

            table[idx].remove();
//            rehash();
        }

        private int findKey(int key) {
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        private void rehash() {
            // put your code here
            size = size * 2;        //scaling factor is 2
            TableEntry[] oldTable = table;
            table = new TableEntry[size];
            for (TableEntry tableEntry : oldTable) {
                put(tableEntry.getKey(), (T) tableEntry.getValue());
            }
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                                                + ", value=" + table[i].getValue()
                                                + ", removed=" + table[i].isRemoved());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashTable<String> table = new HashTable<>(5);

        for (int i = 0; i < n; i++) {
            table.put(sc.nextInt(), sc.nextLine().trim());
        }

        for (int i = 0; i < m; i++) {
            table.remove(sc.nextInt());
        }

        System.out.println(table.toString());
    }
}