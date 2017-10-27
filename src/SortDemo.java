/**
 * Created by shixi_anqi8 on 2017/10/26.
 */
public class SortDemo {
    //打印数组
    public static void printArr(int[] numbers){
        int size=numbers.length;
        for (int i=0;i<size;i++){
            System.out.print(numbers[i]+",");
        }
        System.out.println("");
    }
    //冒泡排序
    public static void BubbleSort(int[] numbers){
        int temp=0;
        int size=numbers.length;
        for(int i=0;i<size-1;i++){
            for(int j=0;j<size-1-i;j++){
                if(numbers[j]>numbers[j+1]){
                    temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
    }

    //快速排序
    public static int getMiddle(int[] numbers,int low,int high){
        int temp=numbers[low];
        while (low<high){
            while ( low<high && numbers[high]>temp){
                high--;
            }
            numbers[low]=numbers[high];
            while ( low<high && numbers[low]<temp){
                low++;
            }
            numbers[high]=numbers[low];
        }
        numbers[low]=temp;
        return low;
    }

    public static void quickSort(int[] numbers,int low,int high){
        if(low<high){
            int mid=getMiddle(numbers,low,high);
            quickSort(numbers,low,mid-1);
            quickSort(numbers,mid+1,high);
        }
    }

    public static void quick(int[] numbers){
        if(numbers.length>1){
            quickSort(numbers,0,numbers.length-1);
        }
    }

    //选择排序
    public static void selectSort(int[] numbers){
        int size=numbers.length;
        int tmp=0;
        for(int i=0;i<size;i++){
            int k=i;
            for(int j=size-1;j>i;j--){
                if(numbers[j]<numbers[k]){
                    k=j;
                }
            }
            tmp=numbers[i];
            numbers[i]=numbers[k];
            numbers[k]=tmp;
        }
    }

    //插入排序
    public static void insertSort(int[] numbers){
        int size=numbers.length;
        int temp=0;
        int j=0;
        for(int i=0;i<size;i++){
            temp=numbers[i];
            for (j=i;j>0 && temp<numbers[j-1];j--){
                numbers[j]=numbers[j-1];
                printArr(numbers);
            }
            numbers[j]=temp;
        }
    }

    //希尔排序
    public static void shellSort(int[] numbers){
        int temp=0;
        int j=0;
        for(int increment=numbers.length/2;increment>0;increment/=2){
            for(int i=increment;i<numbers.length;i++){
                temp=numbers[i];
                for(j=i;j>=increment;j-=increment){
                    if(temp>numbers[j-increment]){
                        numbers[j]=numbers[j-increment];
                    }else{
                        break;
                    }
                }
                numbers[j]=temp;
            }
        }
    }

    //归并排序
    public static void merge(int[] numbers,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=high){
            if(numbers[i]<numbers[j]){
                temp[k++]=numbers[i++];
            }else{
                temp[k++]=numbers[j++];
            }
        }
        while(i<=mid){
            temp[k++]=numbers[i++];
        }
        while(j<=high){
            temp[k++]=numbers[j++];
        }
        for(int k2=0;k2<temp.length;k2++){
            numbers[k2+low]=temp[k2];
        }
    }
    public static int[] sort(int[] numbers,int low,int high){
        int mid=(low+high)/2;
        if(low<high){
            sort(numbers,low,mid);
            sort(numbers,(mid+1),high);
            merge(numbers,low,mid,high);
        }
        return numbers;
    }
    //测试
    public static void main(String[] args){
        int[] numbers={12,2,21,13,3,32};
        //BubbleSort(numbers);
        //quick(numbers);
        //selectSort(numbers);
        //insertSort(numbers);
        //shellSort(numbers);
        int[] arr=sort(numbers,0,numbers.length-1);
        printArr(arr);
    }

}
