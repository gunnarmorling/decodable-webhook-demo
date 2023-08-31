/*
 *  Copyright 2021 The original authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package dev.morling.demos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class App {

    public String hello(String name) {
        return "Hello, " + name;
    }
    
    public static void main(String[] args) {
    	List<Committer> committers = Arrays.asList(
    			new Committer("Catalina Lehner", "catalina.lehner@example.com", 0.3),
    			new Committer("Omer Kreiger", "omer.kreiger@example.com", 0.10),
    			new Committer("Thuy Schamberger", "thuy.schamberger@example.com", 0.20),
    			new Committer("Gerry Marquardt", "gerry.marquardt@example.com", 0.05),
    			new Committer("Edward Kuhlman", "edward.kuhlman@example.com", 0.03),
    			new Committer("Kent Weissnat", "kent.weissnat@example.com", 0.07),
    			new Committer("Denver Rosenbaum", "denver.rosenbaum@example.com", 0.09),
    			new Committer("Ruben Runolfsson", "ruben.runolfsson@example.com", 0.02),
    			new Committer("Jone Collier", "jone.collier@example.com", 0.08),
    			new Committer("Alexander Davis", "alexander.davis@example.com", 0.06)
        );
    	
    	double sum = 0;
    	Map<Committer, Double> accumulatedWeight = new LinkedHashMap<>(); 
    	for (Committer committer : committers) {
    		sum += committer.weight;
    		accumulatedWeight.put(committer, sum);
		}
    	
    	Random random = new Random();
    	double value = random.nextDouble();
		
		for (Entry<Committer, Double> committer : accumulatedWeight.entrySet()) {
			if(value < committer.getValue()) {
				System.out.println(committer.getKey().name() + " <" + committer.getKey().email + ">");
				break;
			}
		}
    	
//    	Map<Committer, Long> results = new HashMap<Committer, Long>();
//    	Random random = new Random();
//    	for(int i = 0; i < 100000; i++) {
//    		double value = random.nextDouble();
//    		
//    		for (Entry<Committer, Double> committer : accumulatedWeight.entrySet()) {
//    			if(value < committer.getValue()) {
//    				results.put(committer.getKey(), results.getOrDefault(committer.getKey(), 0L) + 1);
//    				break;
//    			}
//    		}
//    	}
//    	
//    	System.out.println("##### Results");
//    	
//    	for (Entry<Committer, Double> committer : accumulatedWeight.entrySet()) {
//			System.out.println(committer.getKey().name() + " " + results.get(committer.getKey()));
//		}
//    	
//    	
    	
//		for(int i = 0; i < 10; i++) {
//			String firstName = faker.name().firstName();
//			String lastName = faker.name().lastName();
//			System.out.println("new Committer(\"" + firstName + " " + lastName + "\", \"" + firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com\"),");
//		}
	}
    
    private record Committer(String name, String email, double weight) {
    	
    }
}
