package LeetcodeJava;

import java.util.*;

public class SmallestCommonRegion {

    public String smallestCommonRegion(List<List<String>> regions, String region1, String region2){
        HashMap<String, String> regionMap = new HashMap<>();
        for (List<String> region: regions){
            for (int i=1; i < region.size(); i++){
                regionMap.put(region.get(i), region.get(0));
            }
        }
        Set<String> region1Set = new HashSet<>();
        while (regionMap.containsKey(region1)){
            region1Set.add(region1);
            region1 = regionMap.get(region1);
        }

        //Set<String> region2Set = new HashSet<>();
        while (regionMap.containsKey(region2)){
            if (region1Set.contains(region2)){
                return region2;
            }
            //region2Set.add(region2);
            region2 = regionMap.get(region2);
        }
        return region1;
    }

    public static void main(String[] args) {
        List<List<String>> regionList = Arrays.asList(
                Arrays.asList("Earth","North America","South America"),
                Arrays.asList("North America","United States","Canada"),
                Arrays.asList("United States","New York","Boston"),
                Arrays.asList("Canada","Ontario","Quebec"),
                Arrays.asList("South America","Brazil")
        );
        String region1 = "Quebec";
        String region2 = "New York";

        SmallestCommonRegion obj = new SmallestCommonRegion();
        System.out.println(obj.smallestCommonRegion(regionList, region1, region2));

        System.out.println(obj.smallestCommonRegion(regionList, "Canada", "South America"));
    }
}
