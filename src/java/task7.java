package src.java;

public class task7 {
    public static boolean pr(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int kol = 0;
        int num = 2;
        while (kol<10001){
            if(pr(num)){
                kol++;
            }
            num++;
        }
        System.out.println(num-1);
    }
}
