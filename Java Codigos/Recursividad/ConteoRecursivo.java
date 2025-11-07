public class ConteoRecursivo {
    public static void main(String[] args){
        int number = 7;
        countUpTo (number);
    }
    public static void countUpTo(int n) {
        ConteoRecursivo(1, n);
    }

    private static void ConteoRecursivo (int current, int target)
    {
        if (current > target) {
        } else {
            System.out.println(current);
            ConteoRecursivo(current + 1, target); 
        }
    }
}