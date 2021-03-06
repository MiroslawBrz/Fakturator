package API;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.json.JSONArray;
import org.json.JSONObject;


public class JSON {

    private StringProperty name = new SimpleStringProperty();
    private StringProperty street = new SimpleStringProperty();
    private StringProperty postalCode = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();
    private StringProperty nip = new SimpleStringProperty();

    CURL curl = new CURL();


    public void getStringFromAPIbyNIPAndParseJson(String NIP) {
        nip.setValue(NIP);
        JSONObject jsonObject = new JSONObject(curl.getDataFromApiByNIP(NIP));
        JSONArray jsonArray = (JSONArray) jsonObject.get("items");
        for (int i = 0; i < jsonArray.length(); i++){
        name.setValue(jsonArray.getJSONObject(i).getString("name"));
        JSONObject jsonAddress = jsonArray.getJSONObject(i).getJSONObject("address");
        city.setValue(jsonAddress.getString("city"));
        postalCode.setValue(jsonAddress.getString("code"));
        street.setValue(jsonAddress.getString("street"));
        }

    }

    public StringProperty getName() {
        return name;
    }
    public StringProperty getStreet() {
        return street;
    }
    public StringProperty getPostalCode() {
        return postalCode;
    }
    public StringProperty getCity() {
        return city;
    }
    public StringProperty getNip(){return nip;}
}
