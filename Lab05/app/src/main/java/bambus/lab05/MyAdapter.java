package bambus.lab05;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hubik_000 on 2016-12-18.
 */


public class MyAdapter extends ArrayAdapter<PeopleList> {
    Context ctx;

    public MyAdapter(Context context, List<PeopleList> objects) {
        super(context, R.layout.my_list, objects);
        ctx = context;
    }

    public View getView(int pos, View v, ViewGroup p) {
        View my_list = v;

        if (my_list == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            my_list = inflater.inflate(R.layout.my_list, null);
        }
        PeopleList people = getItem(pos);
        ((TextView) my_list.findViewById(R.id.name)).setText(people.getName());
        ((TextView) my_list.findViewById(R.id.lastName)).setText(people.getLastName());
        ((TextView) my_list.findViewById(R.id.phone)).setText(people.getPhoneNumber());
        ImageView genderImg = (ImageView) my_list.findViewById(R.id.gender);
        if (people.isMale()) {
            genderImg.setImageResource(R.drawable.m);
        } else {
            genderImg.setImageResource(R.drawable.f);
        }
        checkNationality(people, my_list);
        return my_list;
    }

    private void checkNationality(PeopleList people, View my_list) {
        ImageView nationalityImg = (ImageView) my_list.findViewById(R.id.nationality);
        switch (people.getNationality()) {
            case "Poland":
                nationalityImg.setImageResource(R.drawable.polska);
                break;
            case "Canada":
                nationalityImg.setImageResource(R.drawable.canada);
                break;
            case "German":
                nationalityImg.setImageResource(R.drawable.german);
                break;
            case "Russian":
                nationalityImg.setImageResource(R.drawable.russian);
                break;
            default:
                nationalityImg.setImageResource(R.drawable.usa);
                break;
        }
    }
}
