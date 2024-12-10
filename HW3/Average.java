public class Average {

    // Method to calculate average
    public int average(int k, int[] list) {
        int average = 0;
        
        // Ensure k is not greater than the list length
        int n = Math.min(k, list.length);
        
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                average += list[i];  // Sum elements
            }
            average /= n;  // Calculate average
        }
        return average;
    }
}
