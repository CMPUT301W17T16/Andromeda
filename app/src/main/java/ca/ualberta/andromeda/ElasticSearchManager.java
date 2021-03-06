package ca.ualberta.andromeda;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.Delete;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.Update;

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

    public static class EditUserTask extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {
            verifySettings();

            for (User user: users) {
                //Update update = new Update.Builder(user).index("cmput301w17t16").type("user").id(user.getId()).build();
                Index index = new Index.Builder(user).index("cmput301w17t16").type("user").id(user.getId()).build();
                try {
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()){
                        Log.i("Success", "Edited User");
                    }else {
                        Log.i("Error","Elasticsearch was not able to update the user");
                    }
                }
                catch (Exception e) {
                    Log.i("Error", "The application failed to update the user");
                }

            }
            return null;

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
                        mood.setId(result.getId());
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

    public static class GetMoodsTask extends AsyncTask<Void, Void, ArrayList<Mood>> {

        @Override
        protected ArrayList<Mood> doInBackground(Void... search_parameters) {
            verifySettings();

            ArrayList<Mood> moods = new ArrayList<Mood>();

            Search search = new Search.Builder("")
                    .addIndex("cmput301w17t16")
                    .addType("mood")
                    .build();

            try {
                SearchResult result = client.execute(search);
                if (result.isSucceeded()){
                    List<Mood> foundMoods = result.getSourceAsObjectList(Mood.class);
                    moods.addAll(foundMoods);
                }else{
                    Log.i("Error", "Search found no Moods");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }
            Log.i("Found Moods: ", String.valueOf(moods.size()));
            return moods;
        }
    }

    public static class EditMoodTask extends AsyncTask<Mood, Void, Void> {

        @Override
        protected Void doInBackground(Mood... moods) {
            verifySettings();

            for (Mood mood: moods) {
                Update update = new Update.Builder(mood).index("cmput301w17t16").type("mood").id(mood.getId()).build();
                Index index = new Index.Builder(mood).index("cmput301w17t16").type("mood").id(mood.getId()).build();
                try {
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()){
                        Log.i("Success", "Edited Mood");
                    }else {
                        Log.i("Error","Elasticsearch was not able to update the mood");
                    }
                }
                catch (Exception e) {
                    Log.i("Error", "The application failed to update the mood");
                }

            }
            return null;

        }
    }

    /**
     * The type Delete mood task.
     */
// TODO we need a function which deletes Mood from elastic search
    public static class DeleteMoodTask extends AsyncTask<String, Void, ArrayList<Mood>> {
        @Override
        protected ArrayList<Mood> doInBackground(String... ids) {
            verifySettings();

            for (String id: ids) {
                Delete delete = new Delete.Builder(id).index("cmput301w17t16").type("mood").build();
                try {
                    DocumentResult result = client.execute(delete);
                    if (result.isSucceeded()){
                        Log.i("Success", "Deleted Mood");
                    }else {
                        Log.i("Error","Elasticsearch was not able to delete the mood");
                    }
                }
                catch (Exception e) {
                    Log.i("Error", "The application failed to delete the mood");
                }

            }
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