package MyArrayList;


public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private T[] myArray;

    public MyArrayList() {
        this.myArray = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int defaultCapacity) {
        this.myArray = (T[]) new Object[defaultCapacity];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getLength() {
        return myArray.length;
    }

    public void add(T element) {
        if (size == myArray.length) {
            resize();
        }
        myArray[size] = element;
        size++;
    }

    private void resize() {
        int newDefaultCapacity = myArray.length * 2;
        T[] newMyArray = (T[]) new Object[newDefaultCapacity];
        System.arraycopy(myArray, 0, newMyArray, 0, myArray.length);
        myArray = newMyArray;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return myArray[index];

    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<Integer>(4);
        myArrayList1.add(1);
        myArrayList1.add(12);
        myArrayList1.add(8);
        System.out.println(myArrayList1.get(1));
        System.out.println(myArrayList1.getSize());
        System.out.println(myArrayList1.isEmpty());
        myArrayList1.resize();
        System.out.println(myArrayList1.getLength());

        MyArrayList<String> myArrayList12 = new MyArrayList<String>();
        myArrayList12.add("Понедельник");
        myArrayList12.add("Вторник");
        myArrayList12.add("Среда");
        System.out.println(myArrayList12.get(2));
        System.out.println(myArrayList12.getLength());
    }
}