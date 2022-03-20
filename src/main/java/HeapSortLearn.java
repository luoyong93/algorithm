/**
 * 堆排序练习
 * 大根堆 :每一个二叉树 任意非终端节点值 不小于其子节点值
 *
 * heapInsert：插入一个元素实现大根堆
 * heapify ：在指定位置实现大根堆
 *
 */
public class HeapSortLearn {
    /**
     * 局部大根堆 某数在index 位置能否往下移动
     * 思路：
     *     在左孩子和右孩子中 选取较大那个largest 与index 比较
     *          如果 largest大  交换index 与 largest 继续往下比较
     *     终止条件：index到二叉树尾 或者 index 大于largest
     * @param arr
     * @param index
     * @param heapsize
     */
    public static void heapify(int[] arr,int index,int heapsize) {
        int left = 2 * index + 1;//左孩子位置
        while (left < heapsize) {
//            int largest = arr[left] > arr[left + 1] ? left : left +1 ;//子孩子中最大那个孩子位置
            int largest = left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1:left;
            largest = arr[index] >= arr[largest] ? index : largest ; //子节点最大位置和index 比较
            if(largest == index) {
                break;
            }
            swap(arr,index,largest);
            index = largest; //改变index 位置
            left = 2 * index + 1; //改变left 位置

        }
    }

    /**
     * 某数在index位置 往上移动
     *  index > (index - 1)/2 往上移动
     *
     * @param arr
     * @param index
     */
    public  static  void  heapInsert(int[] arr,int index) {
        while (arr[index] > arr[(index - 1) /2]) { //边界条件
            swap(arr,index,(index - 1)/2);
            index = (index - 1 ) /2;
        }
    }

    /**
     * 排序
     *    大根堆 堆顶 一定是最大的 因此只需要不断将堆顶元素交换到数组对应末尾 就可实现排序
     * @param arr
     */
    public  static  void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        //完成大根堆排序
        for(int i =0; i < arr.length ; i ++) {
            heapInsert(arr,i);
        }

        int heapsize = arr.length ;
        swap(arr,0,--heapsize);
        while (heapsize > 0) {
            heapify(arr,0,heapsize);
            swap(arr,0,--heapsize);
        }



    }



    //交换数组两个数位置
    public static void swap(int[] arr,int index1, int index2) {
        if(index1 == index2) return;
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];

    }

    public static void main(String[] args) {
        //git修改
        int[] arr = new int[]{1,9,2,10,4,11,5,7,9};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }
}
