package collection;

public class Stack<T> implements IStack<T>{

    private Object[] mArr;

    private static final int INIT_SIZE = 4;

    private int mTop = -1;

    public Stack() {
        mArr = new Object[INIT_SIZE];
    }

    @Override
    public void push(T data) {
        if (mTop >= mArr.length - 1) {
            resize();
        }
        mArr[++mTop] = data;
    }

    private void resize() {
        Object[] newArr = new Object[mArr.length * 2];
        System.arraycopy(mArr, 0, newArr, 0, mArr.length);
        mArr = newArr;
    }

    @Override
    public T pop() {
        if (mTop < 0) {
            return null;
        } else {
            Object obj = mArr[mTop];
            mArr[mTop--] = null;
            return (T)obj;
        }
    }

    @Override
    public boolean isEmpty() {
        return mTop < 0;
    }

    @Override
    public int size() {
        return mTop + 1;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("abcd");
        stack.push("1234");
        stack.push("qqqqqqq");
        stack.push("wwwwwww");
        stack.push("eeeeeeee");

        System.out.println(stack.pop());

        System.out.println(stack.pop());

        System.out.println(stack.pop());

        System.out.println(stack.size());
    }
}
