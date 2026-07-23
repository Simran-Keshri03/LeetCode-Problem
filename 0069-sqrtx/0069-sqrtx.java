class Solution {
    public int mySqrt(int x) {
        long s =0, e = x;
        long ans = 0 ;
        long mid;
        while(s<=e){
          mid = s + (e-s)/2;
          if(mid*mid<=x){
            ans = mid;
            s = mid +1;
          }else
            e = mid-1;
        }
        return (int) ans;
    }
}