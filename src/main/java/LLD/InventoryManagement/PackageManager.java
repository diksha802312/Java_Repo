package LLD.InventoryManagement;

import java.util.HashMap;
import java.util.Map;

public class PackageManager implements IPackageManager{
    Map<Integer, Package> packageMap;
    Map<String,Integer> packageCountMap;
    Map<String, Integer> categoryWeightMap;
    int totalWeight = 0;

    public PackageManager(){
        packageMap = new HashMap<>();
        packageCountMap = new HashMap<>();
        categoryWeightMap = new HashMap<>();
    }

    @Override
    public void addPackage(Package pack){
        if(packageMap.containsKey(pack.getId())){
            System.out.println("Package with id " + pack.getId() + " already exists");
            return;
        }else{
            packageMap.put(pack.getId(), pack);
        }

        String packageName = pack.getName();
        String category = pack.getCategory();
        totalWeight += pack.getWeight();

        packageCountMap.put(packageName, packageCountMap.getOrDefault(packageName, 0) + 1);

        categoryWeightMap.put(category, packageCountMap.getOrDefault(category, 0) +1);
    }

    @Override
    public void removePackage(int id){
        if(!packageMap.containsKey(id)){
            System.out.println("Package with id " + id + " does not exist");
            return;
        }

        Package pack = packageMap.get(id);

        String packageName = pack.getName();
        String category = pack.getCategory();

        packageCountMap.put(packageName, packageCountMap.get(packageName)-1);

        if(packageCountMap.get(packageName) == 0){
            packageCountMap.remove(packageName);
        }

        categoryWeightMap.put(category, packageCountMap.get(category)-1);

        if(packageCountMap.get(packageName) == 0){
            packageMap.remove(id);
        }
    }

    @Override
    public Map<String,Integer> getPackages(){
        return packageCountMap;
    }

    @Override
    public Map<String,Integer> categoryWeight(){
        return categoryWeightMap;
    }

    public int getTotalWeight(){
        return totalWeight;
    }

}
