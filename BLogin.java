package BLL;

import SQLController.SQLHelper;

import java.util.Map;

public class BLogin {

    public boolean match(UserInfo u) {
        Map<String, UserInfo> userInfoMap;
        userInfoMap = SQLHelper.getUserInfo();
        String key = u.getName();
        return userInfoMap.get(key).getPassWd().equals(u.getPassWd());
    }

}
