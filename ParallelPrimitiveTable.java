public class ParallelPrimitiveTable {
    public static void main(String[] args) {
        // Define columns as separate primitive arrays of the same length
        int[] id = {101, 102, 103};
        double[] price = {19.99, 5.49, 120.00};
        boolean[] inStock = {true, false, true};

        // Print table header
        //System.out.printf("%-6s | %-8s | %-10s%n", "ID", "Price", "In Stock");
        System.out.printf("ID     | Price     | In Stock\n");
        System.out.println("--------------------------------");

        // Print rows using a loop
        for (int i = 0; i < id.length; i++) {
            //System.out.printf("%-6d | $%-7.2f | %-10b%n", id[i], price[i], inStock[i]);
            System.out.printf("%d    | %.2f     | %b\n", id[i], price[i], inStock[i]);
        }
    }
}