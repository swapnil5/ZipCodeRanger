package com.nisum.service;

import java.util.ArrayList;
import java.util.List;

public class ZipCode {
	
	
	public List<List<Integer>> FindZipCodeRang(List<List<Integer>> zipcodes){       //throws NullPointegerException,ArrayOutOfBoundException
		
		   // If the list is empty then return original list 
		   if(zipcodes.isEmpty()){
			   return zipcodes;
		   }
		
		   //Holds manipulated list which is merge in another list 
		   List<List<Integer>> duplicat = new ArrayList<>();
	       
	          for(int i=0;i<zipcodes.size();i++){
	    	  
	        	       // If the specific list is empty then remove it 
			    	   if(zipcodes.get(i).isEmpty()){
			    		   zipcodes.remove(i);
			    		   return zipcodes;
			    	   }
			    	   
			    	   // If the specific list contains only one element
//			    	   if( zipcodes.get(i).size() == 1){
//			    		   zipcodes.get(i).set(0, 1);
//			    	   }
			    	   
			    	   
			    	   //  get the min amd max value from list (may be the list size is more than two)
			    	   Integer first =  zipcodes.get(i).stream().min(Integer::compare).get(); 
			    	   Integer second =  zipcodes.get(i).stream().max(Integer::compare).get(); 
			    	   
			    	  
			    	   if(validateZipCode(first) || validateZipCode(second)){
			    		   //System.out.println("Invalid Zip code");
			    		   break;
			    	   }
			    	   
			  
			    	   
			    	   // Convert list size more than two into two with min and max value so that it contain range of all element
			    	   List<Integer> newList = new ArrayList<>();
			    	   newList.add(first);
			    	   newList.add(second);
			    	   
			    	   //replace list whose size is more than two.
			    	   if(!newList.isEmpty()){    		  
			    		   zipcodes.set(i, newList);
			    	   }
	    	   
	    	   		for(int j=i+1;j<zipcodes.size();j++){
	    	   		 
	    	   		   // Checking list is empty or not
				       if(!zipcodes.get(j).isEmpty()){
				    	
				    	   
	  	    	        Integer firstElement = zipcodes.get(j).stream().min(Integer::compare).get(); 
	  	    	        Integer secondElement = zipcodes.get(j).stream().max(Integer::compare).get(); 
	  	    	     
	  	    	        
	  	    	        //Checking zip code length or validate zip code
	  	    	        if(validateZipCode(firstElement) || validateZipCode(secondElement)){
			    		   duplicat.add(zipcodes.get(j));	
			    	    }else {
	  	    	        
		  	    	        if( first <= firstElement && firstElement <= second && (secondElement >= second || secondElement <= second)){
		    	   				
		    	   				if(secondElement >= second){
		    	   					
		    	   					zipcodes.get(i).set(1, secondElement);
		    	   				}
		    	   				
		    	   				second = secondElement;
		    	   				
		    	   				//add merge list into this list  
		    	   				duplicat.add(zipcodes.get(j));	
		    	   			}
			    	     }
	    	   		  }
	    	   		}
	    	   	 //remove merge list from original list	
	    	     zipcodes.removeAll(duplicat);
	       }
	       
	     return zipcodes;
		
	}
	
	public boolean validateZipCode(Integer zipcode) {
		
		String s = String.valueOf(zipcode);
		Boolean result = false;
		if(s.length() > 5 || s.length() < 5) {
			result = true;
		}
		return result;
	}

}
