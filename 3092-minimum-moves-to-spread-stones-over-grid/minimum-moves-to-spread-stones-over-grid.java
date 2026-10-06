class Solution {
    public int minimumMoves(int[][] grid) {
        List<Pair<Integer, Integer>> zeroes, extras;
        zeroes = new ArrayList<>();
        extras = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[i][j]==0){
                    zeroes.add(new Pair(i, j));
                }
                if(grid[i][j] > 1){
                    extras.add(new Pair(i,j));
                }
            }
        }
        return solve(grid, zeroes, extras, 0);
    }
    public int solve(int[][] grid, List<Pair<Integer, Integer>> zeroes, List<Pair<Integer, Integer>> extras, int currIndex){
        if(currIndex==zeroes.size()){
            return 0;
        }
        int n = extras.size();
        int currZeroX = zeroes.get(currIndex).getKey();
        int currZeroY = zeroes.get(currIndex).getValue();
        int ans = 1000000;
        for(int i = 0; i < n; i++){
            int currX = extras.get(i).getKey();
            int currY = extras.get(i).getValue();
            if(grid[currX][currY] > 1){
                grid[currX][currY]--;
                grid[currZeroX][currZeroY] = 1;
                ans = Math.min(ans, Math.abs(currZeroX - currX) + Math.abs(currZeroY - currY) + solve(grid, zeroes, extras, currIndex + 1));
                grid[currX][currY]++;
                grid[currZeroX][currZeroY] = 0;
            }
        }
        return ans;
    }
}