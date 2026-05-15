class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length-1;
        int carry = 0;
        while(index >= 0){
            if(digits[index] < 9){
                digits[index] += 1;
                return digits;
            } else {
                digits[index] = 0;
                carry = 1;
            }
            index--;
        }
        
        int[] newArray = new int[digits.length + 1];
        if(carry == 1){
            newArray[0] = 1;
            System.arraycopy(digits, 0, newArray, 1, digits.length);
        }
        return newArray;
    }
}
