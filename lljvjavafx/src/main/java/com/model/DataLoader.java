
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import clojure.uuid__init;

public class DataLoader extends DataConstants {

    public static ArrayList<User> getUSers() {
        ArrayList<User> users = new ArrayList<User>();

        try { 
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                UUID id = UUID.fromString((String)personJSON.get(USER_ID));
                String userName = (String)personJSON.get(USER_USER_NAME);
                String firstName = (String)personJSON.get(USER_LAST_NAME);
                String favSongs = (String)personJSON.get(USER_FAVORITE_SONGS);
                String publishedSongs = (String)personJSON.get(USER_PUBLISHED_SONGS);

                users.add(new User(id, userName, firstName, favSongs, publishedSongs));

            }

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}
