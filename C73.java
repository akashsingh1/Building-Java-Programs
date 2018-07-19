import java.util.HashSet;

public class C73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] myIntArray = new int[]{1,2,3,4,5,67,6,7,5,1,89};
		int[] myIntArray2 = new int[] {1,2,3};
		
		/*int[] result = append( myIntArray, myIntArray2 );
		for(int i = 0; i< result.length; i++) {
			System.out.println(result[i]);
		}*/
		
		/*int [] result = collapse(myIntArray);
		for(int i = 0; i< result.length; i++) {
			System.out.println(result[i]);
		}*/
		
		//System.out.println(contains(myIntArray, myIntArray2));
		
		//System.out.println(longestSortedSequence(myIntArray));
	
		//System.out.println(priceIsRight(myIntArray, 88));
		
		//System.out.println(percentEven(myIntArray));

		//System.out.println(isUnique(myIntArray));

		//System.out.println(minGap(myIntArray));

		//System.out.println(median(myIntArray));

		//System.out.println(kthLargest(1,myIntArray));
	
		//System.out.println(stdev(myIntArray));

		//System.out.println(mode(myIntArray));

		//System.out.println(isSorted(myIntArray2));
		
		//System.out.println(countInRange(myIntArray,0,44));

		//System.out.println(range(myIntArray));

		//System.out.println(lastIndexOf(myIntArray,5));

		int[] result =vowelCount("Stringibwfljkalfhlksljdsgjhsdgu");
		  for(int i = 0; i< result.length; i++) {
			System.out.println(result[i]);
		}
		 
	}
	// EXERCISE 1
	public static int lastIndexOf(int[] arr, int val) {
	    for(int i = arr.length - 1; i >= 0; i--) {
	        if(arr[i] == val)
	            return i;
	    }
	    return -1;
	}
	//EXERCISE 2
	public static int range(int[] arr) {
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    
	    for(int i = 0; i < arr.length; i++) {
	        if(arr[i] < min) {
	            min = arr[i];
	        }
	        
	        if(arr[i] > max) {
	            max = arr[i];
	        }
	    }
	    
	    return max - min + 1;
	}
	// EXERCISE 3
	public static int countInRange(int[] arr, int min, int max) {
	    int count = 0;
	    for(int i = 0; i < arr.length; i++) {
	        if(min <= arr[i] && arr[i] <= max)
	            count++;
	    }
	    
	    return count;
	}
	
	//EXERCISE 4
	public static boolean isSorted(int[] arr) {
	    for(int i = 0; i <= arr.length - 2; i++) {
	        if(arr[i + 1] < arr[i])
	            return false;
	    }
	    return true;
	    // if next one is smaller then return false cuz array is not sorted
	}
	//EXERCISE 5
	public static int mode(int[] n) {
	    int[] counts = new int[101];
	    int maxCount = 0;
	    int maxKey = -1;
	    
	    for(int i = 0; i < n.length; i++) {
	        counts[n[i]]++;
	        if(counts[n[i]] > maxCount) {
	            maxCount = counts[n[i]];
	            maxKey = n[i];
	        }
	    }
	    
	    return maxKey;
	}
	//EXERCISE 6 
	public static double stdev(int[] a) {
	    double avg = 0;
	    double num = 0;
	    
	    for(int i = 0; i < a.length; i++) {
	        avg += a[i];
	    }
	    
	    avg /= a.length;
	    
	    for(int i = 0; i < a.length; i++) {
	        num += (a[i] - avg) * (a[i] - avg);
	    }
	    
	    return Math.sqrt(num / (a.length - 1));
	}
	
	//EXERCISE 7 
	public static int kthLargest(int k, int[] a) {
	    return select(a, 0, a.length - 1, a.length - k);
	}

	public static int select(int[] a, int p, int r, int i) {
	    int q = partition(a, p, r);
	    int k = q - p + 1;
	    
	    if(k == i)
	        return a[q];
	        
	    if(i < k)
	        return select(a, p, q - 1, i);
	        
	    return select(a, q + 1, r, i - k);
	}

	public static int partition(int[] a, int p, int r) {
	    int temp;
	    int x = a[r];
	    int i = p - 1;
	    
	    for(int j = p; j <= r - 1; j++) {
	        if(a[j] <= x) {
	            i++;
	            temp = a[i];
	            a[i] = a[j];
	            a[j] = temp;
	        }
	    }

	    temp = a[i + 1];
	    a[i + 1] = a[r];
	    a[r] = temp;
	    return i + 1;
	}
//EXERCISE 8
	public static int median(int[] a) {
	    int med = a.length/2;
	    return a[med];
	}

//EXERCISE 9
	public static int minGap(int[] a) {
	    if(a.length < 2)
	        return 0;
	        
	    int min = a[1] - a[0];
	    
	    for(int i = 1; i <= a.length - 2; i++) {
	        if(a[i+1] - a[i] < min)
	            min = a[i+1] - a[i];
	    }
	    
	    return min;
	}
	//EXERCISE 10
	public static double percentEven(int[] a) {
	    if(a.length == 0)
	        return 0.0;
	        
	    int count = 0;
	    
	    for(int i = 0; i < a.length; i++) {
	        if(a[i] % 2 == 0)
	            count++;
	    }
	    
	    return count * 100.0 / a.length;
	}
	//EXERCISE 11
	public static boolean isUnique(int[] a) {
	    HashSet<Integer> set = new HashSet<Integer>();
	    
	    for(int i = 0; i < a.length; i++) {
	        if(set.contains(a[i]))
	            return false;
	            
	        set.add(a[i]);
	    }
	    
	    return true;
	}
	//EXERCISE 12
	public static int priceIsRight(int[] bids, int price) {
	    int bid = -1;
	    
	    for(int i = 0; i < bids.length; i++) {
	        if(price - bids[i] >= 0 && bids[i] > bid)
	            bid = bids[i];
	    }
	    
	    return bid;
	}
	//EXERCISE 13
	public static int longestSortedSequence(int[] a) {
	    if(a.length == 0)
	        return 0;

	    int maxLen = 1;
	    int len = 1;
	    
	    for(int i = 1; i < a.length; i++) {
	        if(a[i-1] <= a[i]) {
	            len++;
	        } else {
	            if(len > maxLen) {
	                maxLen = len;
	            }
	            
	            len = 1;
	        }
	    }
	    
	    return Math.max(maxLen, len);
	}
	//EXERCISE 14
	public static boolean contains(int[] a1, int[] a2) {
	    for(int i = 0; i <= a1.length - a2.length; i++) {
	        boolean c = true;
	        
	        for(int j = 0; j < a2.length; j++) {
	            if(a1[i + j] != a2[j]) {
	                c = false;
	                break;
	            }
	        }
	        
	        if(c)
	            return true;
	    }
	    
	    return false;
	}
	//EXERCISE 15
	public static int[] collapse(int[] a) {
	    int[] r = new int[(a.length + 1) / 2];
	    int i = 0;
	    
	    for(int j = 0; j <= a.length - 2; j += 2) {
	        r[i] = a[j] + a[j+1];
	        i++;
	    }
	    
	    if(i != r.length)
	        r[i] = a[a.length - 1];
	        
	    return r;
	}
	//EXERCISE 16
	public static int[] append(int[] list1, int[] list2) {
	    int[] a = new int[list1.length + list2.length];
	    int i = 0;
	    
	    for(int j = 0; j < list1.length; j++) {
	        a[i] = list1[j];
	        i++;
	    }
	    
	    for(int j = 0; j < list2.length; j++) {
	        a[i] = list2[j];
	        i++;
	    }
	    
	    return a;
	}
	//EXERCISE 17
	public static int[] vowelCount(String str) {
	    int[] counts = new int[5];
	    
	    for(int i = 0; i < str.length(); i++) {
	        switch(str.charAt(i)) {
	            case 'a':
	            counts[0]++;
	            break;
	            
	            case 'e':
	            counts[1]++;
	            break;
	            
	            case 'i':
	            counts[2]++;
	            break;
	            
	            case 'o':
	            counts[3]++;
	            break;
	            
	            case 'u':
	            counts[4]++;
	            break;
	        }
	    }
	    
	    return counts;
	}
}


