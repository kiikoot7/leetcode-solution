var reverseDegree = function(s) {
    let sum = 0;

    for(let i = 0; i < s.length; i++) {
        sum += (('z'.charCodeAt(0) - s.charCodeAt(i)) + 1) * (i + 1);
    }

    return sum;
};