package BLL;

import Model.UserInfo;
import SQLController.SQLHelper;

import java.io.IOException;
import java.util.Map;

public class BLogin {

    public boolean match(UserInfo u){
        Map<String, UserInfo> userInfoMap;
        userInfoMap = SQLHelper.getUserInfo();
        String key = u.getUsername();
        return userInfoMap.get(key).getPassword().equals(u.getPassword());
    }

}
