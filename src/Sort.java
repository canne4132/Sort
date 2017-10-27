/**
 * Created by shixi_anqi8 on 2017/10/22.
 */
import java.util.ArrayList;
import java.util.Iterator;
public class Sort {
        //选择排序
        public int[] sort1(int[] arr){
            for (int i = 0; i < arr.length; i++) {
                int temp,pos=i;
                int mininum=arr[i];
                for (int j = i; j < arr.length; j++) {
                    if (mininum >arr[j]) {
                        mininum=arr[j];
                        pos=j;
                    }
                }
                temp=arr[i];
                arr[i]=mininum;
                arr[pos]=temp;
            }
            return arr;
        }
        //冒泡排序
        public int[] sort2(int[] arr){
            for (int i = 0; i < arr.length-1; i++) {
                int temp;
                for (int j = 0; j < arr.length-1-i; j++) {
                    if (j+1==arr.length-i) {
                        break;
                    }else {
                        if(arr[j]>arr[j+1]){
                            temp=arr[j];
                            arr[j]=arr[j+1];
                            arr[j+1]=temp;
                        }
                    }
                }
            }
            return arr;
        }
        //二分插入排序(递归)
        public int[] sort3(int[] arr,int begin,int end){
            if (end==1) {
                return arr;
            }else {
                arr=sort3(arr, begin, end/2);
                for (int i = end/2; i < end; i++) {
                    int temp;
                    for (int j = 0; j < i; j++) {
                        if (arr[i]<=arr[j]) {
                            temp=arr[i];
                            for (int k = i-1; k >j-1; k--) {
                                arr[k+1]=arr[k];
                            }
                            arr[j]=temp;
                        }else {

                        }
                    }
                }

            }
            return arr;
        }
        //二分插入排序(递归)
        public static ArrayList<Integer> sort3integer(ArrayList<Integer> arr,int begin,int end){
            if (end==1) {
                return arr;
            }else {
                arr=sort3integer(arr, begin, end/2);
                for (int i = end/2; i < end; i++) {
                    int temp;
                    for (int j = 0; j < i; j++) {
                        if (arr.get(i)<=arr.get(j)) {
                            temp=arr.get(i);
                            for (int k = i-1; k >j-1; k--) {
                                arr.set(k+1,arr.get(k));
                            }
                            arr.set(j, temp);
                        }else {

                        }
                    }
                }

            }
            return arr;
        }
        //直接插入排序
        public int[] sort4(int[] arr){
            for (int i = 1; i < arr.length; i++) {
                int temp;
                for (int j = 0; j < i; j++) {
                    if (arr[i]>arr[j]) {

                    }else {
                        temp=arr[i];
                        for (int k = i-1; k >j-1; k--) {
                            arr[k+1]=arr[k];
                        }
                        arr[j]=temp;
                    }
                }
            }
            return arr;
        }
        //希尔排序（递归）
        public int[] sort5(int[] arr,int gap){
            if(gap==1){
                arr=sort3(arr, 0, arr.length);
                return arr;
            }else {
                int gap1=(gap%2==1?gap/2+1:gap/2);
                ArrayList<Integer>list=new ArrayList<Integer>();
                ArrayList<Integer>poslist=new ArrayList<Integer>();
                for (int i = 0; i < gap; i++) {//对每一个子序列进行插入排序
                    int temp2=i;
                    while(temp2<arr.length){
                        poslist.add(temp2);
                        list.add(arr[temp2]);
                        temp2+=gap;
                    }
                    list=sort3integer(list, 0, list.size());
                    for (int j = 0; j < list.size(); j++) {
                        arr[poslist.get(j).intValue()]=list.get(j);
                    }
                    list.clear();
                    poslist.clear();
                }
                printlist(arr);
                System.out.println("-->");
                arr=sort5(arr, gap1);
            }
            return arr;
        }
        //归并排序
        public ArrayList<Integer> sort6(ArrayList<Integer> arr,int begin,int end){
            if (begin==end-1) {
                return arr;
            }else {
                int mid=(begin+end)/2;
                ArrayList<Integer>arr1=new ArrayList<Integer>();
                ArrayList<Integer>arr2=new ArrayList<Integer>();
                for(int i=begin;i<mid;i++){
                    arr1.add(arr.get(i));
                }
                for(int i=mid;i<end;i++){
                    arr2.add(arr.get(i));
                }
                arr=merge(sort6(arr1, begin, mid),sort6(arr2, 0, end-mid));
                return arr;
            }
        }
        //快速排序
        public ArrayList<Integer> sort7(ArrayList<Integer> arr,int begin,int end){
            if (begin==end-1||end==begin) {
                return arr;
            }else {
                int temp=0,key=arr.get(begin),i=begin,j=end-1;
                while (i!=j) {
                    while(arr.get(j)>=key){
                        if (j>begin) {
                            j--;
                        }
                        if (i==j) {
                            break;
                        }
                    }
                    if (i==j) {
                        break;
                    }
                    temp=arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                    while(arr.get(i)<key){
                        if (i<end-1) {
                            i++;
                        }
                        if (i==j) {
                            break;
                        }
                    }
                    if (i==j) {
                        break;
                    }
                    temp=arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
                sort7(arr,0,i);
                sort7(arr,i+1,end);
                return arr;
            }
        }
        //堆排序
        public int[] sort8(int[] arr){
            if (arr.length==1) {
                return arr;
            }else {
                for(int i=0;i<arr.length;i++){
                    int temp=0,leftChild=-1,rightChild=-1,end=arr.length-i;
                    if (end>1) {//有左孩子
                        leftChild=1;
                    }
                    if (end>2) {//有右孩子
                        rightChild=2;
                    }
                    getMaxHeap(arr, leftChild, rightChild, end);
                    temp=arr[0];
                    arr[0]=arr[end-1];
                    arr[end-1]=temp;
                }
                return arr;
            }
        }
        //基数排序
        public ArrayList<Integer> sort9(ArrayList<Integer> arr,int radix){
            ArrayList<ArrayList<Integer>> binarr=new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < 10; i++) {
                ArrayList<Integer>tmpArrayList=new ArrayList<Integer>();
                binarr.add(tmpArrayList);
            }
            int rd=1,ra=1;
            while(true){
                rd*=10;
                if (ra>radix) {
                    break;
                }
                for (int i = 0; i < arr.size(); i++) {
                    switch((arr.get(i)%rd)/(rd/10)){
                        case 0:
                            binarr.get(0).add(arr.get(i));
                            break;
                        case 1:
                            binarr.get(1).add(arr.get(i));
                            break;
                        case 2:
                            binarr.get(2).add(arr.get(i));
                            break;
                        case 3:
                            binarr.get(3).add(arr.get(i));
                            break;
                        case 4:
                            binarr.get(4).add(arr.get(i));
                            break;
                        case 5:
                            binarr.get(5).add(arr.get(i));
                            break;
                        case 6:
                            binarr.get(6).add(arr.get(i));
                            break;
                        case 7:
                            binarr.get(7).add(arr.get(i));
                            break;
                        case 8:
                            binarr.get(8).add(arr.get(i));
                            break;
                        case 9:
                            binarr.get(9).add(arr.get(i));
                            break;
                    }
                }
                arr.clear();
                for(int i=0;i<10;i++){
                    for (int k = 0; k < binarr.get(i).size(); k++) {
                        arr.add(binarr.get(i).get(k));
                    }
                    binarr.get(i).clear();
                }
                ra++;
            }
            return arr;
        }
        //构造最大堆
        public static int[] getMaxHeap(int[] arr,int leftChild,int rightChild,int end){
            if (leftChild==-1&&rightChild==-1||rightChild==0) {//rightChild==0防止把最终父节点作为一个右孩子处理
                return arr;
            }else {
                int lleftChild=-1,rrightChild=-1,rleftChild=-1,lrightChild=-1;
                //左孩子的子节点
                if (leftChild*2+1<end) {
                    lleftChild=leftChild*2+1;
                }
                if (leftChild*2+2<end){
                    lrightChild=leftChild*2+2;
                }
                //右孩子的子节点
                if (rightChild*2+1<end) {
                    rleftChild=rightChild*2+1;
                }
                if (rightChild*2+2<end){
                    rrightChild=rightChild*2+2;
                }
                if (leftChild!=-1&&rightChild!=-1) {
                    int parent=(leftChild-1)/2,temp=0;
                    while(parent>=0){
                        temp=arr[parent];
                        if (arr[leftChild]>arr[rightChild]) {
                            if (arr[leftChild]>arr[parent]) {
                                arr[parent]=arr[leftChild];
                                arr[leftChild]=temp;
                            }
                        }else {
                            if (arr[rightChild]>arr[parent]) {
                                arr[parent]=arr[rightChild];
                                arr[rightChild]=temp;
                            }
                        }
                        if(parent%2==1){//位于父节点的左孩子处
                            leftChild=parent;
                            rightChild=parent+1;
                        }else {//位于父节点的右孩子处
                            leftChild=parent-1;
                            rightChild=parent;
                        }
                        parent=(leftChild-1)/2;
                    }
                }else {
                    if (leftChild!=-1&&rightChild==-1) {//只会出现只有左孩子没有右孩子的情况，不会出现相反的情况
                        int parent=(leftChild-1)/2,temp=0;
                        temp=arr[parent];
                        if (arr[leftChild]>arr[parent]) {
                            arr[parent]=arr[leftChild];
                            arr[leftChild]=temp;
                        }
                        if(parent%2==1){//位于上一个的左孩子处
                            leftChild=parent;
                            rightChild=parent+1;
                        }else {
                            leftChild=parent-1;
                            rightChild=parent;
                        }
                        parent=(leftChild-1)/2;
                        while(parent>=0){
                            temp=arr[parent];
                            if (arr[leftChild]>arr[rightChild]) {
                                if (arr[leftChild]>arr[parent]) {
                                    arr[parent]=arr[leftChild];
                                    arr[leftChild]=temp;
                                }
                            }else {
                                if (arr[rightChild]>arr[parent]) {
                                    arr[parent]=arr[rightChild];
                                    arr[rightChild]=temp;
                                }
                            }
                            if(parent%2==1){//位于父节点的左孩子处
                                leftChild=parent;
                                rightChild=parent+1;
                            }else {//位于父节点的右孩子处
                                leftChild=parent-1;
                                rightChild=parent;
                            }
                            parent=(leftChild-1)/2;
                        }
                    }else {
                    }
                }
                getMaxHeap(arr, lleftChild, lrightChild, end);
                getMaxHeap(arr, rleftChild, rrightChild, end);
                return arr;
            }
        }
        //合并两个有序子序列并返回一个有序的序列
        public static ArrayList<Integer> merge(ArrayList<Integer>list1,ArrayList<Integer>list2){
            ArrayList<Integer>newList=new ArrayList<Integer>();
            if (list1==null||list1.size()==0) {
                return list2;
            }
            if (list2==null||list2.size()==0) {
                return list1;
            }
            if(list1.get(list1.size()-1)<=list2.get(0)){
                newList.addAll(list1);
                newList.addAll(list2);
            }else {
                if (list2.get(list2.size()-1)<=list1.get(0)) {
                    newList.addAll(list2);
                    newList.addAll(list1);
                }else {
                    Iterator<Integer>iterator1=list1.iterator();
                    Iterator<Integer>iterator2=list2.iterator();
                    boolean flag=true;
                    Integer num1=iterator1.next();
                    Integer num2=iterator2.next();
                    if (num1<num2) {
                        newList.add(num1);
                        flag=true;
                    }else {
                        newList.add(num2);
                        flag=false;
                    }
                    while (true) {
                        if (flag) {
                            if (!iterator1.hasNext()) {
                                break;
                            }
                            num1=iterator1.next();
                        }else {
                            if (!iterator2.hasNext()) {
                                break;
                            }
                            num2=iterator2.next();
                        }
                        if (num1<num2) {
                            newList.add(num1);
                            flag=true;
                        }else {
                            newList.add(num2);
                            flag=false;
                        }
                    }
                    if (flag) {
                        newList.add(num2);
                    }else {
                        newList.add(num1);
                    }
                    while (iterator1.hasNext()) {
                        newList.add(iterator1.next());
                    }
                    while (iterator2.hasNext()) {
                        newList.add(iterator2.next());
                    }
                }
            }
            return newList;
        }
        //打印数组
        public void printlist(int [] arr){
            System.out.println("the result:");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+"->");
            }
            System.out.println("END");
        }
        //打印list
        public void printlist2(ArrayList<Integer> arr){
            System.out.println("the result:");
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i)+"->");
            }
            System.out.println("END");
        }
        public static void main(String args[]){
            Sort mysort=new Sort();
            int arr[]={4,3,22,565,2,566,77,5,3,9};
            ArrayList<Integer>list=new ArrayList<Integer>();
            list.add(4);list.add(3);list.add(22);list.add(565);list.add(2);list.add(566);list.add(77);list.add(5);list.add(3);list.add(9);
//      mysort.printlist(mysort.sort1(arr));

//      mysort.printlist(mysort.sort2(arr));

//      mysort.printlist(mysort.sort3(arr,0,arr.length));

//      mysort.printlist(mysort.sort4(arr));

//      mysort.printlist2(mysort.sort3integer(list, 0, list.size()));

//      int gap1=arr.length%2==1?arr.length/2+1:arr.length/2;
//      mysort.printlist(mysort.sort5(arr,gap1));

//      mysort.printlist2(mysort.sort6(list,0,list.size()));

        mysort.printlist2(mysort.sort7(list,0,list.size()));

//      mysort.printlist(mysort.sort8(arr));

//      mysort.printlist2(mysort.sort9((list),3));
        }
}
