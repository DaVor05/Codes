public class NumerosR {
    
  public static void main(String[] args) {
      int n = 7;
      num(n);
  }

  public static void num(int n) {
      if (n == 1) {
          System.out.print(n);
      } else {
        System.out.print(n + ",");
        num(n - 1);
      }
  }
}
