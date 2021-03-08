import java.util.*;


class Solution{
    
    
    public static void main(String... args){
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int t=1;t<=T;t++){
            
            long l = in.nextLong();
            long r = in.nextLong();
            
            solve(t,l,r);
        }
    }
    
    private static void solve(int t, long l, long r){
        
        
        long diff = Math.abs(l-r);
        long intial = find(diff);
        

        // System.out.println(diff+" "+intial);

        if(l>r){
            l-=intial*(intial+1)/2;
        }else{
            r-=intial*(intial+1)/2;
        }

        // System.out.println(l+" "+r);
        // System.out.println("l:"+l+" r:"+r+" intial:"+intial);

        long people = 0L;
        
        if(l>=r){
            // intial+1 + intial+3 + intial+5 ln
            
            //intial*ln + ln^2 
            
            
            long ln = find2a(intial,l);

            // System.out.println("ln:"+ln);
            
            
            //intial + 2 + intial + 4 + intial + 6 rn
            
            // intial*rn + rn*(rn+1) 2*2+2*3=10

            long rn = find2b(intial,r);
            
            // System.out.println("rn:"+rn);
            people = intial+ln+rn;
            
            
            // l - (intial +1 + intial+3 + ... )
            l-=intial*ln + ln*ln;
            r-=intial*rn + rn*(rn+1);
            // r-=(intial+1)*rn + (long)Math.pow(rn,2);
            
        }else{

            long ln = find2b(intial,l);
            long rn = find2a(intial,r);


            people = intial+ln+rn;
            
            
            // l - (intial +1 + intial+3 + ... )
            l-=(intial)*ln + ln*(ln+1); 
            // l-=(intial+1)*ln + (long)Math.pow(ln,2); 
            r-=intial*rn + rn*rn;
        }
        
       

        System.out.println("Case #"+t+": "+people+" "+
        l+" "+r);
        
    }
    
    private static long find2a(long n, long lstack){
        long l = 0;
        long r = (long) 2e9;
        while(l<r){
            long m = l + (r-l)/2;
            // System.out.println(m+"||"+(n*m + m*(m+1))+" "+lstack);
            if(lstack<(n*m + m*m)){
                r=m;
            }else{
                l=m+1;
            }
        }    
        return l-1;
    }

    private static long find2b(long n, long rstack){
        long l = 0;
        long r = (long) 2e9;
        while(l<r){
            long m = l + (r-l)/2;
            // System.out.println(m+"||"+(n*m + m*(m+1))+" "+rstack);
            if(rstack<(n*m + m*(m+1))){
            // if(rstack<((n+1)*m + Math.pow(m,2))){
            
                r=m;
            }else{
                l=m+1;
            }
        }    
        return l-1;
    }
    
    private static long find(long n){
        
        long l = 0;
        long r = (long) 2e9;
        
        while(l<r){
            
            long m = l+(r-l)/2;
            if(n<m*(m+1)/2){
                r=m;
            }else{
                l=m+1;
            }
        }
        
        return l-1;
        
    }
    
    
    
}
