package LLD.InventoryManagement;

import java.util.Map;

public interface IPackageManager {
    void addPackage(Package pack);

    void removePackage(int id);

    int getTotalWeight();

    Map<String,Integer> getPackages();  // package name → count

    Map<String,Integer> categoryWeight();   // category → total weight
}
