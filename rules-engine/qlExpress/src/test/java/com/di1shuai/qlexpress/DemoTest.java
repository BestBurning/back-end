package com.di1shuai.qlexpress;

import org.junit.jupiter.api.Test;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * @author shea
 * @since 2022/11/8
 */
public class DemoTest {


    @Test
    public void quick_start() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);
        //下面五个参数意义分别是 表达式，上下文，errorList，是否缓存，是否输出日志
        Object result = runner.execute("a+b+c", context, null, true, false);
        System.out.println("a+b+c=" + result);
    }

    @Test
    public void test_basic_use_for() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "n=100;sum=0;" +
                "for(i=1;i<=n;i++){" +
                "sum = sum+i;" +
                "}" +
                "return sum;";
        Object result = runner.execute(express, context, null, true, false);
        System.out.println("1...100的和是: " + result);
    }

    @Test
    public void test_basic_use_three_var() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a", 5);
        context.put("b", 10);
        String express = "a>b?a:b";
        Object max = runner.execute(express, context, null, true, false);
        System.out.println("a和b中较大的指是：" + max);
    }


    @Test
    public void test_array_use() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "arr=new int[3];" +
                "arr[0]=1;arr[1]=2;arr[2]=3;" +
                "sum=arr[0]+arr[1]+arr[2];" +
                "return sum;";
        Object arrSum = runner.execute(express, context, null, true, false);
        System.out.println("arrSum: " + arrSum);
    }

    @Test
    public void test_list_use() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "list = new ArrayList();" +
                "list.add(3);list.add(4);list.add(5);" +
                "sum=0;" +
                "for(i=0;i<list.size();i++){" +
                "sum = sum+list.get(i);" +
                "}" +
                "return sum;";
        Object listSum = runner.execute(express, context, null, true, false);
        System.out.println("listSum: " + listSum);
    }

    @Test
    public void test_map_use() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "map=new HashMap();" +
                "map.put('a',2);map.put('b',2);map.put('c',2);" +
                "sum=0;" +
                "keySet=map.keySet();" +
                "keyArray=keySet.toArray();" +
                "for(i=0;i<keyArray.length;i++){" +
                "sum=sum+map.get(keyArray[i]);" +
                "}" +
                "return sum;";
        Object mapValueSum = runner.execute(express, context, null, true, false);
        System.out.println("mapValueSum: " + mapValueSum);
    }

    @Test
    public void test_NewList() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "abc=NewList(1,2,3);return abc.get(0)+abc.get(1)+abc.get(2);";
        Object listSum = runner.execute(express, context, null, true, false);
        System.out.println("listSum: " + listSum);
    }

    @Test
    public void test_NewMap() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "abc=NewMap('a':1,'b':2,'c':3);return abc.get('a')+abc.get('b')+abc.get('c');";
        Object mapSum = runner.execute(express, context, null, true, false);
        System.out.println("mapSum: " + mapSum);
    }

}
