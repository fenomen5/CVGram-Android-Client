package com.barkov.ais.cvgram.services.parsers;

import com.barkov.ais.cvgram.entity.CvStatus;
import com.barkov.ais.cvgram.entity.Industry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CvStatusesParser implements JsonParser{

    @Override
    public ArrayList parse(JSONObject obj) {
        ArrayList<CvStatus> list = new ArrayList<>();
        try {
            JSONArray jsArray = obj.getJSONArray("items");

            for (int i=0; i< jsArray.length(); i++) {
                JSONObject jsonObject=jsArray.getJSONObject(i);
                list.add(new CvStatus(jsonObject.getInt("id"),
                        jsonObject.getString("name")));
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

}
