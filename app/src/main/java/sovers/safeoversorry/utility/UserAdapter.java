package sovers.safeoversorry.utility;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sovers.safeoversorry.LoginActivity;
import sovers.safeoversorry.MainActivity;
import sovers.safeoversorry.Overview;
import sovers.safeoversorry.R;
import sovers.safeoversorry.UserListActivity;
import sovers.safeoversorry.models.User;

import static android.widget.Toast.LENGTH_LONG;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private static final String TAG = "EmployeesAdapter";

    private ArrayList<User> mUsers;
    private Context mContext;
    private String mUserId;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "onClick: openMessageDialog: " + mUsers.get(getAdapterPosition()));

                    ((UserListActivity)mContext).openMessageDialog(mUsers.get(getAdapterPosition()).getUser_id());

                     }
            });
        }
    }

    public UserAdapter(Context context, ArrayList<User> users) {
        mUsers = users;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //inflate the custom layout
        View view = inflater.inflate(R.layout.layout_user_listitem, parent, false);

        //return a new holder instance
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) throws NullPointerException {
        holder.name.setText(mUsers.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }



}
