package com.lockedme.ascending;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class Ascending {

		static String directory= "Database/";
		public static void ascendingOrder() {
			
			File[] files = new File(directory).listFiles();
			Set<String> a = new TreeSet<>();
			for(File file : files) {
				if (!file.isFile()) {
					continue;
				}
				a.add(file.getName());
			}
			a.forEach(i->System.out.println(i));

		}
	}



