#include <stdbool.h>

bool isRectangleOverlap(int* rect1, int rect1Size, int* rect2, int rect2Size) {
    // 1. Extract boundary coordinates for the first rectangle.
    int const rect1x1 = rect1[0];
    int const rect1y1 = rect1[1];
    int const rect1x2 = rect1[2];
    int const rect1y2 = rect1[3];

    // 2. Extract boundary coordinates for the second rectangle.
    int const rect2x1 = rect2[0];
    int const rect2y1 = rect2[1];
    int const rect2x2 = rect2[2];
    int const rect2y2 = rect2[3];

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