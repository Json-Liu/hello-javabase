/**
 * 字符串的一些常见用法：获取字符串长度，判断开头结尾、指定字符串格式、字符串分割、字符串大小写转换、子字符串获取与判定、字符串与正则表达式的匹配、基础类型转换为字符串的方法 等
 * @author JosonLiu
 * @see String
 */
public class HelloString {
    public static void main(String[] args){
        String testStr1 = "Hello World";
        System.out.println("String length:"+testStr1.length());//获取字符串长度
        System.out.println("lastIndexof:o :"+testStr1.lastIndexOf('o'));//获取字符串中最后出现某一字符的位置，没有时返回 －1
        System.out.println("startsWith He:"+testStr1.startsWith("He"));//判断字符串是否以某一字符串开头
        System.out.println("endWith d:"+testStr1.endsWith("d"));//判断字符串是否以某一字符串结尾
        System.out.println("subStr: "+testStr1.substring(1));//从第2个字符起的子串
        System.out.println("subStr: "+testStr1.substring(0, 5));//从第一个字符到第5个字符之间的子串
        System.out.println("toLowCase:"+testStr1.toLowerCase());//将字符串中的所有大写字符转换为小写字符
        System.out.println("toUpCase:"+testStr1.toUpperCase());//将字符串中的所有小写字符转换为大写字符
        String intStr = String.valueOf(520);//通过valueOf()方法将基础类型转换为字符串对象
        System.out.println("int transfer to String :"+intStr);
        System.out.println("contains or :"+testStr1.contains("or"));//判断字符串是否包含指定的子串
        String[] splitStr = testStr1.split(" ");//利用split()函数 结合正则表达式分隔字符串为字符串数组
        System.out.println("分隔后的数组元素有："+splitStr[0]+" , "+splitStr[1]);
        String testStr2 = "1231241";
        String regex = "^-?[0-9]+$";
        System.out.println("testStr1 is number or not:"+testStr1.matches(regex)+" testStr2 is number or not : "+testStr2.matches(regex));
        String testStr3 = "I want to Say %s,My name is %s ";
        String name = "JosonLiu";
        Object[] params = new Object[]{testStr1,name};
        String result = String.format(testStr3, params);//替换格式字符串的格式点位符
        System.out.println(" format String :"+result);
        System.out.println(" replace :"+result.replaceAll("World", "Java"));//替换字符串中的World为Java
        String testStr4 = "";
        System.out.println("testStr4:"+testStr4.isEmpty());//判断字符串是否为空
    }
}
