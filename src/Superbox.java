import java.lang.reflect.Array;

public class Superbox<T> {
    private Object[] array;
    private int size;

    //构造方法设定数组长度，默认是10
    public Superbox(int size) {
        this.size=size;
        if (size < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + size);
        }
        this.array = new Object[size];
    }
    public Superbox() {
        this.size = 10;
        this.array = new Object[this.size];
    }


    //元素的改变，默认改变第一个元素
    public void change(T a){
        array[0] = a;
    }

    //改变固定位置元素，如果范围不够，则扩充成最后一个
    public  void change(int a,T b){
        extendarray(a);
        array[a-1]=b;
    }


    //元素的增加,默认在最后增加
    public void add(T a){
        extendarray(this.size+1);
        array[this.size]=a;
        this.size+=1;
    }
    //增加插入到固定位置
    public void add(int address,T a){
        //如果插入位置大于数组长度，扩展数组到相应位置后再插入
        if(address>this.size){
            extendarray(address);
            this.size=address;
        }
        Object[] newarray = new Object[this.size +1];
        copyarray(1,(address-1),array,1,newarray);
        newarray[address-1]=a;
        copyarray(address,(size+1-address),array,address+1,newarray);
        this.array=newarray;
    }

    //元素的删除
    //默认删除最后一个
    public void delete(){
        array[0] = null;
    }
    public  void delete(int a){
        array[a] = null;
    }
    //删除指定元素
    public void elementdelete(T a){
        int k = -1;
        for(int i =0;i<array.length;i++){
            if(array[i].equals(a)){
                k = i;
                array[k]=null;
            }
        }
        if(k==-1) System.out.println("您输入的元素不存在");
    }


    //元素的查询
    //查询固定位置元素
    public void find(int a ){
        if(a>this.size) System.out.println("第"+a+"个元素不存在");
        else{
            System.out.println("第"+a+"个元素为："+array[a-1]);
        }
    }
    //查询某个元素是否存在
    public boolean findelement(T a){
        int j =0;
        for (int i =0;i<this.size;i++){
            if(a.equals(array[i])) j=1;
        }
        if(j==1) return true;
        else return false;
    }



    //扩展数组
    public void extendarray(int newsize){
        if(newsize>this.size){
            Object[] newnewarray = new Object[newsize];
            for (int i =0;i<this.array.length;i++){
                newnewarray[i] = this.array[i];
            }
            array = newnewarray;
        }
    }

    //复制数组
    public void copyarray(int begin,int longsize,Object[] oldarray,int newbegin,Object[] newarray){
        for(int i =0;i<longsize;i++){
            newarray[newbegin-1+i] = oldarray[begin-1+i];
        }
    }


    //输出
    public void print(){
        for(int i =0;i<array.length;i++){
            System.out.print(array[i]+"、");
        }
        System.out.println();
    }
}
