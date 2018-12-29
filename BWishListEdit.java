package BLL;

import Model.WishInfo;
import Model.WishListInfo;
import SQLController.SQLHelper;

import java.util.HashMap;

public class BWishListEdit {

    private HashMap<String, WishInfo> wishInfoHashMap = new HashMap<>();

    public boolean addWishList(WishListInfo wishListInfo) {
        wishListInfo.setWishInfoHashMap(wishInfoHashMap);
        return SQLHelper.insertWishList(wishListInfo);
    }

    public HashMap<String, WishInfo> initWishInfoHashMap() {
        return SQLHelper.getAllWishInfo();
    }

    public void setWishInfoHashMap(HashMap<String, WishInfo> wishInfoHashMap) {
        this.wishInfoHashMap = wishInfoHashMap;
    }


}
