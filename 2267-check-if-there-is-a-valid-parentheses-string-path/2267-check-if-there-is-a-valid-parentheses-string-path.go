func hasValidPath(grid [][]byte) bool {
    m, n := len(grid), len(grid[0])
    length := m + n - 1

    if length%2 != 0 || grid[0][0] != '(' ||
        grid[m-1][n-1] != ')' {
        return false
    }

    // 0: unknown, 1: false, 2: true
    memo := make([][][]uint8, m)
    for row := range memo {
        memo[row] = make([][]uint8, n)
        for col := range memo[row] {
            memo[row][col] = make([]uint8, length+1)
        }
    }

    var dfs func(row, col, balance int) bool
    dfs = func(row, col, balance int) bool {
        if grid[row][col] == '(' {
            balance++
        } else {
            balance--
        }

        remaining := (m - 1 - row) + (n - 1 - col)
        if balance < 0 || balance > remaining {
            return false
        }
        if row == m-1 && col == n-1 {
            return balance == 0
        }

        if memo[row][col][balance] != 0 {
            return memo[row][col][balance] == 2
        }

        possible :=
            (row+1 < m && dfs(row+1, col, balance)) ||
                (col+1 < n && dfs(row, col+1, balance))

        if possible {
            memo[row][col][balance] = 2
        } else {
            memo[row][col][balance] = 1
        }
        return possible
    }

    return dfs(0, 0, 0)
}