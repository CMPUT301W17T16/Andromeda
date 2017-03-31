package ca.ualberta.andromeda;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by brettgarbitt on 2017-03-31.
 */

public class customAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> list = new ArrayList<String>();
    private Context context;
    private UserController userController;
    private String username;



    public customAdapter(ArrayList<String> list, Context context, String user) {
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
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.notification_list, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position));

        //Handle buttons and add onClickListeners
        Button acceptButton = (Button)view.findViewById(R.id.acceptButton);
        Button declineButton = (Button)view.findViewById(R.id.declineButton);

        declineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                User user = userController.getUserByUsername(username);
                userController.declineFollowRequest(list.get(position), user);
                list.remove(position); //or some other task
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
