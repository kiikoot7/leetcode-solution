function largestOverlap(img1: number[][], img2: number[][]): number {
    const n = img1.length;
    let best = 0;

    for (let dx = -n + 1; dx <= n - 1; dx++) {
        for (let dy = -n + 1; dy <= n - 1; dy++) {
            let score = 0;
            for (let i = 0; i < n; i++) {
                for (let j = 0; j < n; j++) {
                    let c = 0;
                    if (dx + i >= 0 && dx + i < n && dy + j >= 0 && dy + j < n) {
                        c = img1[dx + i][dy + j];
                    }
                    score += img2[i][j] & c;
                }
            }
            best = Math.max(best, score);
        }
    }

    return best;
}