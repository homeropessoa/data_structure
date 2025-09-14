/**
 * 
 * Your DynamicArray class should support the following operations:
 *
 * DynamicArray(int capacity) will initialize an empty array with a capacity of capacity, where capacity > 0.
 * int get(int i) will return the element at index i. Assume that index i is valid.
 * void set(int i, int n) will set the element at index i to n. Assume that index i is valid.
 * void pushback(int n) will push the element n to the end of the array.
 * int popback() will pop and return the element at the end of the array. Assume that the array is non-empty.
 * void resize() will double the capacity of the array.
 * int getSize() will return the number of elements in the array.
 * int getCapacity() will return the capacity of the array.
 * If we call void pushback(int n) but the array is full, we should resize the array first.
 * 
 * Example 1:
 * 
 * Input:
 * ["Array", 1, "getSize", "getCapacity"]
 * 
 * Output:
 * [null, 0, 1]
 * Example 2:
 * 
 * Input:
 * ["Array", 1, "pushback", 1, "getCapacity", "pushback", 2, "getCapacity"]
 * 
 * Output:
 * [null, null, 1, null, 2]
 * Example 3:
 * 
 * Input:
 * ["Array", 1, "getSize", "getCapacity", "pushback", 1, "getSize", "getCapacity", "pushback", 2, "getSize", "getCapacity", "get", 1, "set", 1, 3, "get", 1, "popback", "getSize", "getCapacity"]
 * 
 * Output:
 * [null, 0, 1, null, 1, 1, null, 2, 2, 2, null, 3, 3, 1, 2]
 * Note:
 * 
 * The index i provided to get(int i) and set(int i) is guaranteed to be greater than or equal to 0 and less than the number of elements 
 * in the array.
 * 
 */

//Implementing the solution.

class DynamicArray {
    int capacity;
    int length;
    int[] arr;

    public DynamicArray(int capacity) {
        length = 0;
        capacity = 2;
        arr[] = new Array[capacity];
    }

    public int get(int i) {
        if(i < length) {
            return arr[i];
        }
        return -1;
    }

    public void set(int i, int n) {
        if(i < length){
            arr[i] = n;
            return;
        }
        return;
    }

    public void pushback(int n) {
        if(length == capacity){
            this.resize();
        }
        arr[length] = n;
    }

    public int popback() {
        if(length > 0){
            return arr[length];
            arr[length] = 0;
            length --;
        }
        return -1;
    }

    private void resize() {
        capacity = 2 * capacity;
        int[] newArr = new int[capacity]

        for (int i = 0; i < newArr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
