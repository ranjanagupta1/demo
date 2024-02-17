package resources;

import com.basic.RESTautomationtraining.POJOSerialization.AddPlaceMainPojo;
import com.basic.RESTautomationtraining.POJOSerialization.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuildREST {
    public AddPlaceMainPojo addPlacePayload(){
        //In body will send serialized objects for the convertion of java obj into json and pass to api req body

        AddPlaceMainPojo serObj = new AddPlaceMainPojo();

        serObj.setAccuracy(109);
        serObj.setAddress("SN 123 Address 120917 West");
        serObj.setLanguage("English");
        serObj.setName("Raghv");
        serObj.setWebsite("www.insta.com");
        serObj.setPhone_number("123-00-8710-1567");

        List<String> types = new ArrayList<>();
        types.add("Street");
        types.add("shop new");
        serObj.setTypes(types);

        Location locObj = new Location();
        locObj.setLat(0.5467);
        locObj.setLng(6.8752);
        serObj.setLocation(locObj);

        return serObj;
    }
}
