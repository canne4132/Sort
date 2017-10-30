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
            while ( low<high && numbers[high]>=temp){
                high--;
            }
            numbers[low]=numbers[high];
            while ( low<high && numbers[low]<=temp){
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

    //堆排序
    public static void heapSort(int[] numbers){
        int size=numbers.length;
        //循环建堆
        for(int i=0;i<size-1;i++){
            //建堆
            buildMaxHeap(numbers,size-1-i);
            //交换堆顶和最后一个元素
            swap(numbers,0,size-1-i);
            printArr(numbers);
        }
    }
    //对数组从0到lastIndex建立最大顶堆
    public static void buildMaxHeap(int[] numbers,int lastIndex){
        //从lastIndex处节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k=i;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){
                    //如果右子节点的值较大
                    if(numbers[biggerIndex]<numbers[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if(numbers[k]<numbers[biggerIndex]){
                    //交换
                    swap(numbers,k,biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }
    //交换
    private static void swap(int[] numbers,int i,int j){
        int tmp=numbers[i];
        numbers[i]=numbers[j];
        numbers[j]=tmp;
    }
    //测试
    public static void main(String[] args){
        int[] numbers={12,2,21,2,13,3,32};
        //BubbleSort(numbers);
        //quick(numbers);
        //selectSort(numbers);
        //insertSort(numbers);
        //shellSort(numbers);
        //int[] arr=sort(numbers,0,numbers.length-1);
        heapSort(numbers);
        printArr(numbers);
    }

}
