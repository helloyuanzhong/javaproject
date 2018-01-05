package com.mianshi.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.mianshi.pojo.User;

public class StringTest {

	@Test
	public void strTest() {
		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program";
		String s4 = "ming";
		String s5 = "Program" + "ming";
		String ss = s3 + "ming";
		String s6 = s3 + s4;
		// System.out.println(s1 == s2); // false
		// System.out.println(s1 == s5); // true
		// System.out.println(s1 == s6); // false
		// System.out.println(s1 == s6.intern()); // true
		// System.out.println(s2 == s2.intern()); // false
		System.out.println(ss == s1);// false
		System.out.println(ss == s5);// false
		System.out.println(ss == s6);// false
		System.out.println(s4 == "ming");// true

	}

	@Test
	public void carTest() {
		Calendar instance = Calendar.getInstance();

		long millis = Calendar.getInstance().getTimeInMillis();
		System.out.println(millis);
	}

	@Test
	public void carTest2() {
		SimpleDateFormat format = new SimpleDateFormat();

		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为 1 号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		System.out.println("===============first:" + first);
	}

	/**
	 * map集合的排序
	 */
	@Test
	public void collTest() {
		HashMap<Integer, User> users = new HashMap<>();
		users.put(1, new User("张三", 25));
		users.put(2, new User("王五", 28));
		users.put(3, new User("李四", 22));
		System.out.println(users);
		HashMap<Integer, User> sortHashMap = sortHashMap(users);
		System.out.println(sortHashMap);

	}

	public HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
		// 首先拿到 map 的键值对集合
		Set<Entry<Integer, User>> entrySet = map.entrySet();
		// 将 set 集合转为 List 集合，为什么，为了使用工具类的排序方法
		List<Entry<Integer, User>> list = new ArrayList<Entry<Integer, User>>();
		for (Entry<Integer, User> entry : entrySet) {
			list.add(entry);
		}
		// 使用 Collections 集合工具类对 list 进行排序，排序规则使用匿名内部类来实现
		Collections.sort(list, new Comparator<Entry<Integer, User>>() {
			@Override
			public int compare(Entry<Integer, User> o1, Entry<Integer, User> o2) {
				// 按照要求根据 User 的 age 的倒序进行排

				// return o1.getValue().getAge() - o2.getValue().getAge();
				return o2.getKey() - o1.getKey();
			}
		});
		// 创建一个新的有序的 HashMap 子类的集合
		LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
		// 将 List 中的数据存储在 LinkedHashMap 中
		for (Entry<Integer, User> entry : list) {
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		// 返回结果
		return linkedHashMap;
	}

	@Test
	public void testCollection() {
		ArrayList<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		System.out.println(list);
		Hashtable hashtable = new  Hashtable();
		Collection<Integer> coll = Collections.synchronizedCollection(list);
         LinkedList linkedList = new  LinkedList();
         
         
	}
}
