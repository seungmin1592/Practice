package com.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {
	
	public static void main(String[] args) {
		crawler("마포구%20헬스장");
	}
	
	public static JSONObject jsonParser(String content) {

		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {

			Object obj = parser.parse(content);

			jsonObject = (JSONObject) obj;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	public static void crawler(String search) {
		Document doc2 = null;
		try {
			doc2 = Jsoup.connect("https://m.map.naver.com/search2/search.nhn?query=" + search + "&sm=hty&style=v5").timeout(10000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements scripts = doc2.getElementsByTag("script");
	    
	    String a = null;
	    int idx = 0;
	    
	    for (Element element : scripts) {
	    		idx += 1;
		       if (element.data().contains("var searchResult")) {
		           Pattern pattern = Pattern.compile(".*var searchResult = ([^;]*);");
		           Matcher matcher = pattern.matcher(element.data());
		           if (matcher.find()) {
		        	   a = matcher.group(1);
		        	   break;
		           } else {
		               System.err.println("No match found!");
		           }
		           break;
		       }
		}
	    
		for (Object i : (ArrayList<Object>)jsonParser(jsonParser(a).get("site").toString()).get("list")){
			System.out.println(jsonParser(i.toString()).get("id").toString());
			System.out.println(jsonParser(i.toString()).get("name").toString());
			System.out.println(jsonParser(i.toString()).get("abbrAddress").toString());
			System.out.println(jsonParser(i.toString()).get("address").toString());
			System.out.println(jsonParser(i.toString()).get("roadAddress").toString());
			System.out.println(jsonParser(i.toString()).get("category").toString());
			System.out.println(idx);
			System.out.println();
		}
	}
}

