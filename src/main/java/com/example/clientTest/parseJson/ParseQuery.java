package com.example.clientTest.parseJson;

import com.example.clientTest.model.Image;
import com.example.clientTest.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class ParseQuery {
    private JSONArray jsonObject;

    public JSONArray getResults(String urls) throws ParseException {
        jsonObject = (JSONArray) new JSONParser().parse(urls);

        return jsonObject;
    }

    public List<User> getUsers(JSONArray results){
        ArrayList<User> users = new ArrayList<>();
        for (int i=0; i<results.size(); i++){
            JSONObject information = (JSONObject) results.get(i);
            Image image = createImage(information);
            User user = new User();
            user.setId(isNull(information.get("id")));
            user.setBio(isNull(information.get("bio")));
            user.setImage(image);
            user.setUserName(isNull(information.get("userName")));
            user.setName(isNull(information.get("name")));
            user.setLastName(isNull(information.get("lastName")));
            user.setLocation(isNull(information.get("location")));
            users.add(user);
        }
        return users;
    }

    private String isNull(Object data){
        String dataString = "null";
        if (data==null){
            dataString = "null";
        }else {
            dataString = data.toString();
        }
        return dataString;
    }

    private Image createImage(JSONObject information){
        JSONObject image = (JSONObject) information.get("image");
        return new Image(isNull(image.get("id")), Integer.parseInt(isNull(image.get("width"))), Integer.parseInt(isNull(image.get("height"))), isNull(image.get("description")), isNull(image.get("altDescription")), isNull(image.get("urlRaw")), isNull(image.get("urlFull")));
    }
}
