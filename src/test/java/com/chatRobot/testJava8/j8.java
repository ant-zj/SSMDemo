package com.chatRobot.testJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;



public class j8 {
	public static void main(String[] args) {
		System.out.println("主线程输出"+1111);
		new Thread(()-> System.out.println("子线程开启"+222)).start();
		
		
	}
	
	//@Test
	public void Test(){
		
		List<String> languages = Arrays.asList("java","c","scala","c++");
		//常规操作
		/*for(String language : languages){
			System.out.println(language);
		}*/
		//java8 循环操作
		languages.forEach(x -> System.out.println(x));
		languages.forEach(System.out::println);
		// 使用 java 8 排序
		//Collections.sort(languages, (s1, s2) -> s1.compareTo(s2));
		 //languages.stream()
		String.format("名字：%s，年纪：%s，薪水：%s", languages.get(0), languages.get(1), languages.get(2));
	}
	
	@Test
	public void Test1() {
		new Random().ints().limit(10).forEach(System.out::println);
		//创建线程 内部类的方式
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("11111");
			}
		}).start();
		
		//java8 lambda 实现
		new Thread(() -> System.out.println(Thread.currentThread().getId()+"java8线程")).start();
	}
}


