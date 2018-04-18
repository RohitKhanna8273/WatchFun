package com.project.watchfun.essential;

public class ConstantGenerator {
	public static String generateId(String name) {
		return name.trim().replace(' ','-').toLowerCase();
	}
}
