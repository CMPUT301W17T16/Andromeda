package ca.ualberta.andromeda;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by Jeff on 2/27/2017.
 */
public class ElasticSearchManager {

    private static JestDroidClient client;

    /**
     * The type Add user task.
     */
    public static class AddUserTask extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {
            verifySettings();

            for (User user: users) {
                Index index = new Index.Builder(user).index("cmput301w17t16").type("user").build();

                try {
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()){
                        user.setId(result.getId());
                    }else {
                        Log.i("Error","Elasticsearch was not able to add the user");
                    }
                }
                catch (Exception e) {
                    Log.i("Error", "The application failed to build and send the users");
                }

            }
            return null;
        }
    }

    /**
     * The type Get user task.
     */
    public static class GetUserTask extends AsyncTask<String, Void, ArrayList<User>> {
        @Override
        protected ArrayList<User> doInBackground(String... search_parameters) {
            verifySettings();

            ArrayList<User> users = new ArrayList<User>();

            String query = "{ \"query\": { \"term\": { \"username\": \""+ search_parameters[0] +"\"}}}";
                    //"{\"query\": {\"exists\": {\"field\": \"username\" }}}";
            Search search = new Search.Builder("")
                    .addIndex("cmput301w17t16")
                    .addType("user")
                    .build();

            try {
                SearchResult result = client.execute(search);

                if (result.isSucceeded()){
                    List<User> foundUsers = result.getSourceAsObjectList(User.class);
                    Log.i("Search",String.valueOf(foundUsers.size()));
                    users.addAll(foundUsers);
                }else{
                    Log.i("Error", "The search query failed to find any users that matched " + query);
                    //Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }
            Log.i("Found Users: ", String.valueOf(users.size()));
            Log.i("With Query: ", query);
            return users;
        }
    }

    public static class GetUsersTask extends AsyncTask<Void, Void, ArrayList<User>> {

        @Override
        protected ArrayList<User> doInBackground(Void... users) {
            verifySettings();

            ArrayList<User> userList = new ArrayList<User>();
            Search search = new Search.Builder("")
                    .addIndex("cmput301w17t16")
                    .addType("user")
                    .build();

            try {
                SearchResult result = client.execute(search);

                if (result.isSucceeded()){
                    List<User> foundUsers = result.getSourceAsObjectList(User.class);
                    Log.i("Search",String.valueOf(foundUsers.size()));
                    userList.addAll(foundUsers);
                }else{
                    Log.i("Error", "The search query failed to find any users");
                    //Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }
            Log.i("Found Users: ", String.valueOf(userList.size()));
            return userList;
        }

    }

    /**
     * The type Add mood task.
     */
// TODO we need a function which add Mood from elastic search
    public static class AddMoodTask extends AsyncTask<Mood, Void, Void> {

        @Override
        protected Void doInBackground(Mood... moods) {
            verifySettings();

            for (Mood mood: moods) {
                Index index = new Index.Builder(mood).index("cmput301w17t16").type("mood").build();

                try {
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()){
                        // TODO: fix
                    }else {
                        Log.i("Error","Elasticsearch was not able to add the mood");
                    }
                }
                catch (Exception e) {
                    Log.i("Error", "The application failed to build and send the mood");
                }

            }
            return null;
        }
    }

    /**
     * The type Get mood task.
     */
// TODO we need a function which gets Mood from elastic search
    public static class GetMoodTask extends AsyncTask<String, Void, ArrayList<Mood>> {

        @Override
        protected ArrayList<Mood> doInBackground(String... search_parameters) {
            verifySettings();

            ArrayList<Mood> moods = new ArrayList<Mood>();

            String query = "{\n" +
                    "    \"query\" : {\n" +
                    "        \"term\" : { \"mood\" : \"" +search_parameters[0]+ "\" }\n" +
                    "    }\n" +
                    "}";

            Search search = new Search.Builder(query)
                    .addIndex("cmput301w17t16")
                    .addType("mood")
                    .build();

            try {
                SearchResult result = client.execute(search);
                if (result.isSucceeded()){
                    List<Mood> foundMoods = result.getSourceAsObjectList(Mood.class);
                    moods.addAll(foundMoods);
                }else{
                    Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return moods;
        }
    }

    /**
     * The type Delete mood task.
     */
// TODO we need a function which deletes Mood from elastic search
    public static class DeleteMoodTask extends AsyncTask<String, Void, ArrayList<Mood>> {
        @Override
        protected ArrayList<Mood> doInBackground(String... search_parameters) {

            return null;
        }
    }

    /**
     * Verify settings.
     */
    public static void verifySettings() {
        if (client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
}