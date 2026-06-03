class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowl = matrix.length;
        int coll = matrix[0].length;    
        //find the row where the element could be present 

        if(target < matrix[0][0] || target > matrix[rowl-1][coll-1])
            return false;

        int searchRowIndex = 0;
        for(int i = 0; i < rowl; ++i){
            if(target <= matrix[i][coll-1]){
                searchRowIndex = i;
                break;
            }
        }

        int l = 0;
        int r = coll;
        int mid = 0;
        while(l <= r){
            mid = l + (r-l)/2;
            if(matrix[searchRowIndex][mid] == target)
                return true;
            else if(matrix[searchRowIndex][mid] < target)
                l = mid + 1;
            else 
                r = mid - 1;
        }
        return false;
    }
}
