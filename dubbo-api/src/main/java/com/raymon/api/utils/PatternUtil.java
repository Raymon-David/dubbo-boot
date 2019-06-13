package com.raymon.api.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {
	/**
	 * 参数值注入验证正则
	 */
	private static String regexStr = new String();
	static{
		StringBuilder sb = new StringBuilder();
		sb.append(".*[A|a][L|l][E|e][R|r][T|t]\\s*\\(.*\\).*").append(";;");
		sb.append(".*[W|w][I|i][N|n][D|d][O|o][W|w]\\.[L|l][O|o][C|c][A|a][T|t][I|i][O|o][N|n]\\s*=.*").append(";;");
		sb.append(".*[S|s][T|t][Y|y][L|l][E|e]\\s*=.*[X|x]:[E|e][X|x].*[P|p][R|r][E|e][S|s]{1,2}[I|i][O|o][N|n]\\s*\\(.*\\).*").append(";;");
		sb.append(".*[D|d][O|o][C|c][U|u][M|m][E|e][N|n][T|t]\\.[C|c][O|o]{2}[K|k][I|i][E|e].*").append(";;");
		sb.append(".*[E|e][V|v][A|a][L|l]\\s*\\(.*\\).*").append(";;");
		sb.append(".*[U|u][N|n][E|e][S|s][C|c][A|a][P|p][E|e]\\s*\\(.*\\).*").append(";;");
		sb.append(".*[E|e][X|x][E|e][C|c][S|s][C|c][R|r][I|i][P|p][T|t]\\s*\\(.*\\).*").append(";;");
		sb.append(".*[M|m][S|s][G|g][B|b][O|o][X|x]\\s*\\(.*\\).*").append(";;");
		sb.append(".*[C|c][O|o][N|n][F|f][I|i][R|r][M|m]\\s*\\(.*\\).*").append(";;");
		sb.append(".*[P|p][R|r][O|o][M|m][P|p][T|t]\\s*\\(.*\\).*").append(";;");
		sb.append(".*<.*|.*>.*").append(";;");
		sb.append("[.&[^;]]*;.*").append(";;");
		sb.append("[.&[^']]*'.*]").append(";;");
		sb.append("[[.&[^a]]|[|a|\n|\r\n|\r|\u0085|\u2028|\u2029]]*<[S|s][C|c][R|r][I|i][P|p][T|t]>.*</[S|s][C|c][R|r][I|i][P|p][T|t]>[[.&[^a]]|[|a|\n|\r\n|\r|\u0085|\u2028|\u2029]]*");
		regexStr = sb.toString();
	}
	public static boolean validateDataByRegex(String str, String regex) {
		String split = ";;";
		boolean flag =true;
		if(regex.indexOf("||")>0){
			split = "\\|\\|";
			flag = false;
		}
		String[] regexArray = regex.split(split);
		if(null!=regexArray && regexArray.length>0){
			for(String reg:regexArray){
				Pattern p = Pattern.compile(reg);
				Matcher m = p.matcher(str);
				if(flag){
					/**
					 * 且的情况,有一个不满足则直接返回
					 */
					if(!m.matches()){
						return false;
					}
				}else{
					/**
					 * 或的情况,有一则满足刚返回
					 */
					if(m.matches()){
						return true;
					}
				}
			}
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean validateParamByRegex(String str){
		String[] regexArray = regexStr.split(";;");
		for(String reg:regexArray){
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(str);
			if(m.matches()){
				return false;
			}
		}
		return true;
	}
//	public static void main(String[] args) {
//		String str = "1000Xxxyy1122";
//        str = "X123";//测试用数据
//        String regex = "([A-Z]+[a-z]+[0-9]+[\\d\\w]*)|([A-Z]+[0-9]+[a-z]+[\\d\\w]*)|([0-9]+[a-z]+[A-Z]+[\\d\\w]*)" +
//                        "|([0-9]+[A-Z]+[a-z]+[\\d\\w]*)|([a-z]+[0-9]+[A-Z]+[\\d\\w]*)|([a-z]+[A-Z]+[0-9]+[\\d\\w]*)";
//        //([a-z]+[0-9]+[\\d\\w]*)|([A-Z]+[0-9]+[\\d\\w]*)|([A-Z]+[a-z]+[0-9]+[\\d\\w]*)
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(str);        
//        if (m.find()) {
//            if (str.equals(m.group())){
//                System.out.println("符合要求的密码"); 
//            }else {
//                System.out.println("不符合要求的密码"); 
//            }
//        }else {
//            System.out.println("不符合要求的密码");
//        }
//        
//        String testStr = "1";  
//        System.out.println(testStr.matches("^(([1-2]){1})$") );
//	}
}
