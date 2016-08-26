import java.util.Stack;
/**
 * 本例主要实现了栈的基本操作：入栈、出栈  栈的特点：后进先出
 * @author JosonLiu
 * @see push(Element e) 将元素  e 压入栈中 ，后压入栈的元素位于栈顶
 * @see peek() 取出位于栈顶的元素 不修改栈
 * @see pop() 取出栈顶元素并删除栈顶元素
 */
public class HelloStack {
    public static void main(String[] args){
        Stack<Integer> helloStack = new Stack<Integer>();//创建一个栈对象
        for(int i = 0; i< 10 ;i++ ){//入栈 初始化
            helloStack.push(i);
        }
        System.out.println("Stack elements:");
        if ( ! helloStack.empty() ) {//栈不为空
            for(Integer intVal : helloStack ){//遍历栈
                System.out.println(intVal + ", ");
            }
        }
        if( !helloStack.empty()){//栈不为空
            Integer topVal = helloStack.peek();//取出栈顶元素但不删除
            System.out.println("helloStack's topValue : "+topVal);
            helloStack.pop();//删除栈顶元素
            topVal = helloStack.peek();//取出新的栈顶元素
            System.out.println("helloStack's new topValue : "+topVal);
        }
        
    }
}
