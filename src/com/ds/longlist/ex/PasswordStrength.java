package com.ds.longlist.ex;

import java.util.ArrayList;
import java.util.Map;

public class PasswordStrength {

	String[] getPasswordStrength(String pwdList, String[] weakPwdArr) {
		ArrayList<String> resultArr = new ArrayList<String>();

		for(String str : resultArr) {
			// Condition 1 : Length must be greater than 6
			if(str.length()<=6){
				resultArr.add("weak");
				continue;
			}

			String lwCase = str.toLowerCase();
			String upCase = str.toUpperCase();
			/* Condition 2 : All Characters should not be
				- Upper case
				- Lower case
			 */
			if(lwCase.equals(str) || upCase.equals(str)) {
				resultArr.add("weak");
				continue;
			}

			for(char c : str.toCharArray())

		}


		return resultArr;
	}


	public static void main(String[] args) {

	}
}
