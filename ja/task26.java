package src.java;

public class task26 {
    public static int index(int[] l, int arg){
        for(int i=0; i<l.length; i++){
            if(l[i]==arg){
                return i;
            }
        }
        return -1;
    }
    public static int cou(int num){
        int i = 1;
        int[] l=new int[num+1];
        int k=0;
        while (i!=0) {
            while (i < num) {
                i *= 10;
            }
            i = i%num;
            if(index(l,i)!=-1) {
                return (k - index(l, i));
            }
            l[k] = i;
            k++;
        }
        return 1;
    }
    public static void main(String[] args) {
        int m=0;
        int n=0;
        for (int d = 1; d <=1000; d++) {
            int c=cou(d);
            if(c>m){
                m=c;
                n=d;
            }
        }
        System.out.println(n);
    }
}
