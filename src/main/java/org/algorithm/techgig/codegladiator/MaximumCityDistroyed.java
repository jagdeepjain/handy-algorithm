/**
 * @author jagdeepjain
 *
 */
package org.algorithm.techgig.codegladiator;

/*
 * As a commander of an army battalion, you have to plan the attach on some enemy cities 
 * which are connected by road-network. Before starting the attach, you have information 
 * about all the cities and roads connecting them. You can start attach from any city but 
 * you must travel from one city to another via roads only. To prevent enemy re-enforcement
 * and block transport through a city, you reach there, destroy if and burn it while leaving
 * behind. This makes it impossible for you return to a city (via any road) destroyed by
 * you in past.
 * 
 * Given a list of all the roads (each connecting a pair of cities), you have to tell what
 * is the maximum number of cities that can be destroyed by the strategy mention above.
 * 
 * Assume that number of cities is 0<=number of cities<=1000.
 * 
 * Input/Output Specifications
 * Input Specification:
 * 
 * List of all the roads(list of pairs x#y which denotes that there exists a direct road 
 * from city 'x' to city 'y').
 * 
 * Output:
 * The maximum of cities that can be destroyed.
 * 
 * Example:
 * Input: (1#2,2#3,1#11,3#11,4#11,4#5,5#6,5#7,6#7,4#12,8#12,9#12,8#10,9#10,8#9)
 * Output: 9
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MaximumCityDistroyed {
 
    
    public static int maxno_city(String[] input1) {
        final String[] input = input1;
        int size = 0;
        
        class LongestPath {
            
            private List<Integer> cityDistroyed = new ArrayList<Integer>();
            private Set<String> uniqueCities = new TreeSet<String>();
            private List<String> cityList = new ArrayList<String>();
            private List<Pair<String, String>> connectingPath = new ArrayList<Pair<String, String>>();
            
            private boolean[][] graph;
            
            private LongestPath() {
            }
            
            class Pair<T, U> {
                private final T from;
                private final U to;
                
                public Pair(T from, U to) {
                    this.from = from;
                    this.to = to;
                }
            }
            
            private void addEdgeInGraph() {
                int numberOfCities = cityList.size();
                int fromCityIndex = 0;
                int toCityIndex = 0;
                graph = new boolean[numberOfCities][numberOfCities];
                for (Pair<String, String> connectPath : connectingPath) {
                    String fromCity = connectPath.from;
                    String toCity = connectPath.to;
                    fromCityIndex = cityList.indexOf(fromCity);
                    toCityIndex = cityList.indexOf(toCity);
                    graph[fromCityIndex][toCityIndex] = true;
                    graph[toCityIndex][fromCityIndex] = true;
                }
            }
            
            private void storePath() {
                for (String inputPath : input) {
                    String cityFrom, cityTo = null;
                    int seperatorIndex = 0;
                    // getting the index of #
                    seperatorIndex = inputPath.indexOf("#");
                    // preparing key, value pair
                    cityFrom = inputPath.substring(0, seperatorIndex);
                    cityTo = inputPath.substring(seperatorIndex + 1,
                            inputPath.length());
                    connectingPath.add(new Pair<String, String>(cityFrom,
                            cityTo));
                }
            }
            
            private void storeCities() {
                for (Pair<String, String> path : connectingPath) {
                    uniqueCities.add(path.from);
                    uniqueCities.add(path.to);
                }
                // store city in array list
                cityList.addAll(uniqueCities);
            }

            public void findDistroyedCityCount() {
                int length = uniqueCities.size();
                int[] cities = new int[length];
                for (int i = 0; i < length; i++) {
                    cities[i] = i;
                }
                getPairOfTwoCities(cities, 2);
            }
            
            // store all possible pair of cities
            private void getPairOfTwoCities(int[] cities, int offSet) {
                int[] pair = new int[offSet];
                makePair(cities, pair, 0, 0, offSet);
            }
            
            private void makePair(int[] cities, int[] pair, int currentIndex,
                    int level, int offSet) {
                if (level == offSet) {
                    // calculating longest path here
                    cityDistroyed.add(getLongestPath(pair[0], pair[1], graph));
                    return;
                }
                for (int i = currentIndex; i < cities.length; i++) {
                    pair[level] = cities[i];
                    makePair(cities, pair, i + 1, level + 1, offSet);
                    // way to avoid duplicates
                    if (i < cities.length - 1 && cities[i] == cities[i + 1]) {
                        i++;
                    }
                }
            }
            
            // get the longest path for the given start and end city
            public int getLongestPath(int from, int to, boolean[][] graph) {
                int n = graph.length;
                int result = 0;
                boolean[][] hasPath = new boolean[1 << n][n];
                hasPath[1 << from][from] = true;
                for (int mask = 0; mask < (1 << n); mask++) {
                    for (int last = 0; last < n; last++) {
                        for (int curr = 0; curr < n; curr++) {
                            if (graph[last][curr] && (mask & (1 << curr)) == 0) {
                                hasPath[mask | (1 << curr)][curr] |= hasPath[mask][last];
                            }
                        }
                    }
                }
                for (int mask = 0; mask < (1 << n); mask++) {
                    if (hasPath[mask][to]) {
                        result = Math.max(result, Integer.bitCount(mask));
                    }
                }
                return result;
            }
            
            public int getMaxCityDistroyedCount() {
                Collections.sort(cityDistroyed);
                return cityDistroyed.get(cityDistroyed.size() - 1);
            }   
        }
        
        LongestPath cityCombat = new LongestPath();
        
        cityCombat.storePath();
        cityCombat.storeCities();
        cityCombat.addEdgeInGraph();
        cityCombat.findDistroyedCityCount();
        
        size = cityCombat.getMaxCityDistroyedCount();
        return size;
    }
    
    public static void main(String args[]) {
        String[] path = { "1#2", "2#3", "1#11", "3#11", "4#11", "4#5", "5#6",
                "5#7", "6#7", "4#12", "8#12", "9#12", "8#10", "9#10", "8#9" };
        System.out.println(maxno_city(path));
        
    }
}
