package cn.tedu.sp04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class TestClass {
	@Test
	public void Test01() {
		List<String> list = new ArrayList<>();
		list.add("邓圣");
		list.add("邓圣");
		list.add("黄振");
		list.add("老王");
		list.add("黄振");
		
		Object[] array = list.toArray();
		
		Set<String> set = new HashSet<>(list);
		set.forEach(set1 -> System.out.println(set1) );
		
		
		for (String set1 : set) {
			System.out.println(set1);
		};
	
	}
}
