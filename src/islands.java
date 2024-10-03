class Solution1 {
    int[] parent;
    int[] rank;
    int count = 0;
    public  int numIslands(char[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        parent = new int[r*c];
        rank = new int[r*c];
        for(int i = 0 ; i<r;i++){
            for(int j = 0 ; j< c;j++){
                if(grid[i][j] == '1'){
                    count+=1;
                }
                int index = i*c+j;
                parent[index] = index;
                rank[index] = 1;
            }
        }

        for(int i = 0 ; i< r; i++){
            for(int j = 0 ; j < c; j++){
                System.out.println("i" + i);
                System.out.println("j" + j);
                if(grid[i][j] == '1'){
                    if(i+1 < r && grid[i+1][j] == '1'){
                        connection(i*c+j , (i+1)*c+j);
                    }
                    if(j+1 < c && grid[i][j+1] == '1'){
                        connection(i*c+j, i*c+(j+1));
                    }
                }
            }
        }

        return count ;
    }

    public void connection(int v1 , int v2){
        System.out.println("v1" + v1);
        System.out.println("v2" + v2);

        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 == p2) return ;
        if(rank[p1] >= rank[p2]){
            parent[p2] = parent[p1];
            rank[p1] += rank[p2];
        } else {
            parent[p1] = parent[p2];
            rank[p2]+= rank[p1];
        }
        count -=1;
        return ;
    }

    public int find(int p1){
        if(p1!= parent[p1]){
            parent[p1] = find(parent[p1]);
        }
        return parent[p1];
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        char[][] input = {{'1'} , {'1'}};
        s.numIslands(input);
    }
}
