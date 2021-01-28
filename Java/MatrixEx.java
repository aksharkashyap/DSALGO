package Java;

class S {
   static public int countNegatives(int[][] grid) {
        int count=0;
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]<0)
                    count ++;
            }
        }
        return count;
    }

    public static void main(String args[])
    {   //grid.length = column
        //grid[i].length = row
        int [][]grid = {
            {1,2,-7,4},
            {2,3,-9,5},
            {4,5,6,7}
        };

        System.out.print(countNegatives(grid));
    }
}