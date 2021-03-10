import java.util.*;


class Solution{
    
    
    public static void main(String... args){
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int t=1;t<=T;t++){
           

           int n = in.nextInt();

        

           int x[] = new int[n];
           int y[] = new int[n];

           for(int i=0;i<n;i++){
               x[i] = in.nextInt();
               y[i] = in.nextInt();
           }
           System.out.print("Case #"+t+": ");
           
           if(n==1 || n==2){
               System.out.println(n);
               continue;
           }
           solve(n,x,y);
        }
    }
    
    private static void solve(int n, int x[], int y[]){
        

        int ans = 0;
        
        for(int i1=0;i1<n;i1++){
            for(int i2=i1+1;i2<n;i2++){

                long a = (y[i2]-y[i1]);
                long b = (x[i2]-x[i1]);

                HashMap<Long, Integer> count = new HashMap<>();    

                for(int i=0;i<n;i++){

                    long c = b*y[i] - a*x[i];
                    count.put(c, count.getOrDefault(c,0)+1);

                }

                // System.out.println(count);

                int codd = 0;
                int ceven = 0;
                int cstand = 0;

                for(long key: count.keySet()){


                    if(count.get(key)==1){
                        cstand++;
                    }else if(count.get(key)%2==0){
                        ceven+=count.get(key);
                    }else{
                        codd+=count.get(key);
                    }


                }

                int res = 0;
                if((codd+ceven)%2==0){
                    res = codd+ceven+Math.min(2,cstand);
                }else{
                    res = codd+ceven+Math.min(1,cstand);
                }

                ans = Math.max(ans, res);

            }

            

        }
        System.out.println(ans);
        
    }
    
    
    
}
