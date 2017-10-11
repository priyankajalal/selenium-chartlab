package com.chartlab.utils;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

public class ListUtils {

	/*
	 * checks if a list is sublist of main list
	 */
	public static Map<String,String> listToMap(List<String> finalList){
		Map<String,String> indicesMap = new HashMap<String,String>();
		//String[] values = new String[]{"price", "change1", "change2"};
		for (String u : finalList){
			//String w = u.replace("\n","-");
			String split[] = u.split("\\n");
			indicesMap.put(split[0],split[1]);
			//System.out.println(indicesMap);
		}
		return(indicesMap);
		
	}
	
	
	public static boolean isSubLst(List<String> subList, List<String> mainList) {
		boolean result = true;
		for (String sub : subList) {
			// System.out.println(peer.getText());
			if (!mainList.contains(sub)) {
				result = false;
				break;
			}

		}
		return result;
	}

	public static List<String> getNames(List<WebElement> uiElements) {
		List<String> listNames = new ArrayList<>();
		for (WebElement ui : uiElements) {
			listNames.add(ui.getText());
		}
		return listNames;
	}
	
	public static List<Integer> getValues(List<WebElement> uiElements) {
		List<Integer> listNames = new ArrayList<>();
		for (WebElement ui : uiElements) {
			listNames.add(Integer.parseInt(ui.getText()) );
		}
		return listNames;
	}
	
	
	

}
