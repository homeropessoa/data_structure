public class DynamicArray {
    int capacity;
    int length;
    int[] arr;

    public DynamicArray() {
        capacity = 2;
        length = 0;
        arr = new int[2];
    }

    // Insert n in the last position of the array
    public void pushback(int n) {
        if (length == capacity) {
            this.resize();
        }
               
        // insert at next empty position
        arr[length] = n;
        length++;
    }

    public void resize() {
        // Create new array of double capacity
        capacity = 2 * capacity;
        int[] newArr = new int[capacity]; 
        
        // Copy elements to newArr
        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
/**
 * Por que a linha acima eh tao importante?
 * Resposta: Até esse ponto, todos os dados continuam em newArr, mas o campo arr da sua classe ainda está apontando para o array antigo, 
 * que é pequeno! Se você não fizer arr = newArr;, todas as operações futuras (inserção, busca, etc.) continuarão acessando e modificando 
 * o array antigo, que não tem espaço suficiente para novos elementos. Ou seja, o resize não teria efeito prático. 
 * */        
    }  

    // Remove the last element in the array
    public void popback() {
        if (length > 0) {
            length--;
        }  
    }     

    // Get value at i-th index
    public int get(int i) {
        if (i < length) {
            return arr[i];
        }    
        // Here we would throw an out of bounds exception
        return -1;
    }    

    // Insert n at i-th index
    public void insert(int i, int n) {
        if (i < length) {
            arr[i] = n;
            return;
        }    
        return;
        // Here we would throw an out of bounds exception  
    }        

    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }
} 
