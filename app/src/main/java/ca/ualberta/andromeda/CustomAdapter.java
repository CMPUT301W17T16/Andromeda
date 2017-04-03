package ca.ualberta.andromeda;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by brettgarbitt on 2017-03-31.
 */
public class CustomAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> list = new ArrayList<String>();
    private Context context;
    private UserController userController;
    private String username;


    /**
     * Instantiates a new Custom adapter.
     *
     * @param list    the list
     * @param context the context
     * @param user    the user
     */
    public CustomAdapter(ArrayList<String> list, Context context, String user) {
        this.list = list;
        this.context = context;
        this.username = user;
        this.userController = ModelManager.getUserController();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.notification_list, null);
        }

        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position));

        Button acceptButton = (Button)view.findViewById(R.id.acceptButton);
        Button declineButton = (Button)view.findViewById(R.id.declineButton);
        //Button userName = (Button)view.findViewById(R.id.userName);

        declineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                User user = userController.getUserByUsername(username);
                userController.declineFollowRequest(list.get(position), user);
                //list.remove(position);
                notifyDataSetChanged();
            }
        });

        acceptButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String requestname = list.get(position);
                User requester = userController.getUserByUsername(requestname);
                userController.acceptFollowRequest(requester, username);
                list.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }

}
