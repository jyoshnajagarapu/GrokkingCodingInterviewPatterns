package BinarySearch;

 class GFG {

     static boolean candist(int[] arr, int s, int sum){
         int s1 = 0 ;
         int n = 1  ;
         for(int a : arr){
             s1 +=a ;
             if(s1 > sum){
                 n++;
                 s1 = a;
             }
         }

         return n<=s;
     }
    // method to find minimum pages
    static int findPages(int arr[], int n, int m)
    {
        if(n < m) return -1 ;
        int l = arr[0];
        int h = 0 ;
        for(int a : arr){
            h+=a;
            l = Math.max(l,a);
        }
        if(n == m) return l;
        int res = -1;
        while(l<=h){
            int mid = l + (h-l)/2;
            System.out.println("m" + mid);
            if(candist(arr,m, mid)){
                res = mid ;
                h = mid-1;
            }else l = mid+1;
        }
        return res;
    }

    // Driver Method
    public static void main(String[] args)
    {

        int arr[] = { 67,23 }; // Number of pages in books

        int m = 2; // No. of students

        System.out.println("Minimum number of pages = "
                + findPages(arr, arr.length, m));
    }
}
