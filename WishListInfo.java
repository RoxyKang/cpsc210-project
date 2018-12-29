package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WishListInfo extends Module{
    private int wishListid;
    private String wishListName;
    private HashMap<String, WishInfo> wishInfoHashMap = new HashMap<>();
    private List<Module> moduleList = new ArrayList<>();

    public int getWishListid() {
        return wishListid;
    }

    public void setWishListid(int wishListid) {
        this.wishListid = wishListid;
    }

    public String getWishListName() {
        return wishListName;
    }

    public void setWishListName(String wishListName) {
        this.wishListName = wishListName;
    }

    public HashMap<String, WishInfo> getWishInfoHashMap() {
        return wishInfoHashMap;
    }

    public void setWishInfoHashMap(HashMap<String, WishInfo> wishInfoHashMap) {
        this.wishInfoHashMap = wishInfoHashMap;
    }

    public void addModule(Module module){
        moduleList.add(module);
    }

    public void display(String indentValue){
        System.out.println(indentValue+wishListName);
        for (Module module:moduleList){
            module.display(indentValue+indentValue);
        }
    }
}
