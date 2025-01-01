package Github._463IslandPerimeter;
//463. Island Perimeter
//https://leetcode.com/problems/island-perimeter/description/
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
    static int islandPerimeter(int[][] grid) {
        int perimeter=0;
        int n=grid.length,m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int p=4;
                if(grid[i][j]==1){
                    if(i>0&&grid[i-1][j]==1){
                        p=p-1;
                    }
                    if(j>0&&grid[i][j-1]==1){
                        p=p-1;
                    }
                    if(j<m-1&&grid[i][j+1]==1){
                        p=p-1;
                    }
                    if(i<n-1&&grid[i+1][j]==1){
                        p=p-1;
                    }
                    perimeter=perimeter+p;
                }
            }
        }
        return perimeter;
    }
}
