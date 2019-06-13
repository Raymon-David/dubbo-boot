package com.raymon.api.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDecoderUtil {
	public static String decode(String str,String encode){
		try {
			return URLDecoder.decode(str, encode);
		} catch (UnsupportedEncodingException e) {
		}
		return str;
	}
}
