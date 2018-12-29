package BLL;

import Model.WishInfo;
import Model.WishListInfo;
import SQLController.SQLHelper;

public class BWishEdit {

    private WishListInfo wishListInfo;

    public void initWishList(int listId) {
        wishListInfo = SQLHelper.getWishList(listId);
    }

    public boolean addWishInfo(int listId, WishInfo wishInfo) {
        boolean b = true;
        if (wishInfo != null) {
            if (SQLHelper.checkWishInfoName(wishInfo)) {
                b = SQLHelper.insertWishListById(listId, wishInfo);
                this.getWishListInfo().getWishInfoHashMap().put(Integer.toString(listId), wishInfo);
            } else {
                b = false;
            }
        }
        return b;
    }

    public WishListInfo getWishListInfo() {
        return wishListInfo;
    }
}
