package system;
/***
 ** @Author JosonLiu
 ** @Date 2016年9月23日
 ** @Version 1.0
 **/
public class HelloRuntime {
	public static void main(String[] args) {
		runNotePad();
	}
	private static void runNotePad(){//打开一个记事本
             Runtime r = Runtime.getRuntime(); 
             Process p = null; 
             try{ 
                     p = r.exec("notepad"); 
             } catch (Exception e) { 
                     System.out.println("Error executing notepad."); 
             } 
	}
}

