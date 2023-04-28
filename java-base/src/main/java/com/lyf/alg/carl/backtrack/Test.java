import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
public class Test{
    // static boolean[]hash = new boolean[5000*1000];
    // static{
    //     // 筛法打表素数
    //     hash[0] = hash[1] = hash[2] = false;// 是素数false
    //     for(int i=2;i<5000*1000;i++){
    //             if(!hash[i]){
    //                 for(int j=i;j<5000*1000;j+=i){
    //                     hash[j] = true;
    //                 }
    //             }
    //     }
    //     System.out.print("ok");
    // }
    final static int N = 5000*1000;
    static boolean[]prime = new boolean[N];
    static void init(){
        for(int i=2;i*i<N;i++){
            if(!prime[i]){
                for(int j=i;j<N;j+=i){
                    prime[j] = true;
                }
            }
        }
        //System.out.print("ok");
    }

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        init();
        while(in.hasNextInt()){
            int n = in.nextInt();
            int k = in.nextInt();
            int[]arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = in.nextInt();
            }
            choiceList = new LinkedList<>();
            isUsed = new boolean[n];
            dfs(arr,0,k);
            System.out.println(res);
        }
    }
    static int res = 0;
    static int sum = 0;
    static boolean[]isUsed;
    static LinkedList choiceList;
    static void dfs(int[]arr,int index,int k){
        if(index>=arr.length){
            return;
        }
        if(choiceList.size()==k){
            System.out.println(sum);
            System.out.println(choiceList.toString());
            if(!prime[sum]){
                res++;
            }
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(isUsed[i]){continue;}
            choiceList.add(arr[i]);
            isUsed[i] = true;
            sum+=arr[i];
            dfs(arr,i+1,k);
            sum-= (Integer) choiceList.removeLast();
            isUsed[i] = false;
        }

    }
}
