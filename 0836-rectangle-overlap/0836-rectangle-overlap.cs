public class Solution {
    public bool IsRectangleOverlap(int[] rect1, int[] rect2) {
        // 1. Extract boundary coordinates for the first rectangle.
        int rect1x1 = rect1[0];
        int rect1y1 = rect1[1];
        int rect1x2 = rect1[2];
        int rect1y2 = rect1[3];
        
        // 2. Extract boundary coordinates for the second rectangle.
        int rect2x1 = rect2[0];
        int rect2y1 = rect2[1];
        int rect2x2 = rect2[2];
        int rect2y2 = rect2[3];
        
        // 3. Verify if rectangles lack overlap by finding any separating axis.
        return !(
            // First rectangle is strictly to the left.
            rect1x2 <= rect2x1 ||
            // First rectangle is strictly to the right.
            rect1x1 >= rect2x2 ||
            // First rectangle is strictly below.
            rect1y2 <= rect2y1 ||
            // First rectangle is strictly above.
            rect1y1 >= rect2y2
        );
    }
}