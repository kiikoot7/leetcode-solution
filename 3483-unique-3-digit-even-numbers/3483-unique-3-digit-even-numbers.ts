function totalNumbers(digits: number[]): number {
    const freq: number[] = new Array(10).fill(0);
    const uniqEven: boolean[] = new Array(10).fill(false);
    let count: number = 0;

    for (const d of digits) {
        if (d % 2 === 0) {
            uniqEven[d] = true;
        }

        freq[d]++;
    }

    for (let e = 0; e <= 9; e++) {
        if (!uniqEven[e]) {
            continue;
        }

        freq[e]--;

        const keys: number[] = [];

        for (let d = 0; d <= 9; d++) {
            if (freq[d] > 0) {
                keys.push(d);
            }
        }

        for (let i = 0; i < keys.length; i++) {
            for (let j = i + 1; j < keys.length; j++) {
                const a: number = keys[i];
                const b: number = keys[j];

                if (a !== 0) {
                    count++;
                }

                if (b !== 0) {
                    count++;
                }
            }
        }

        for (const num of keys) {
            if (freq[num] >= 2 && num !== 0) {
                count++;
            }
        }

        freq[e]++;
    }

    return count;
}