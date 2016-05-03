package com.example.thmoviesapp.softwareproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Abed Eid on 01/05/2016.
 */
public class Gadwal extends Fragment {
    Firebase firebase,schedule_doctor;
    String d,d2;
    String Group, Year, Section;
    List<String> dlist;
    Gadwal_adpter gadwal_adpter;
    public static final String DEFAULT = "default";
    ListView list;
String day;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Data", Context.MODE_PRIVATE);
        Group = sharedPreferences.getString("Group", DEFAULT);
        Section = sharedPreferences.getString("Section", DEFAULT);
        Year = sharedPreferences.getString("Year", DEFAULT);
        firebase = new Firebase("https://torrid-torch-3608.firebaseio.com/assistant");
        schedule_doctor = new Firebase("https://torrid-torch-3608.firebaseio.com/schedule_doctor");

        dlist = new ArrayList<String>();
        list = (ListView) getActivity().findViewById(R.id.list3);
        Calendar c = Calendar.getInstance();
        int MINUTE = c.get(Calendar.MINUTE);
        int HOUR=c.get(Calendar.HOUR);
        int Day=c.get(Calendar.DAY_OF_WEEK);
        if (Day == 2) day = "monday";
        else if (Day== 3) day = "tuesday";
        else if (Day == 4) day = "wednesday";
        else if (Day == 5) day = "thursday";
        else if (Day == 6) day = "friday";
        else if (Day == 7) day = "saturday";
        else if (Day == 1) day = "sunday";


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View b = inflater.inflate(R.layout.fragment_gadwal, container, false);

        list = (ListView) b.findViewById(R.id.list3);
        Firebase notification = firebase.child("");
        Firebase doctor = schedule_doctor.child("");

        ChildEventListener childEventListener = notification.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map<String, String> m = dataSnapshot.getValue(Map.class);
                if (m.get("group").equals(Group) && m.get("year").equals(Year) && m.get("section").equals(Section) && m.get("day").toString().equals("sunday")) {
                    d = ((m.get("name").toString()) + " doctor " + (m.get("subject").toString()) + " Subject " + (m.get("begin").toString()) + " begin " + (m.get("end").toString()) + " end " + (m.get("hall").toString()) + " place");
                    dlist.add(d);
                    gadwal_adpter.notifyDataSetChanged();

                }


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });


        ChildEventListener childEventListener1 = doctor.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Map<String, String> m = dataSnapshot.getValue(Map.class);
                if (m.get("group").equals(Group) && m.get("year").equals(Year) && m.get("day").toString().equals("sunday")) {
//                    d2 = ((m.get("doctor").toString()) + " doctor " +  " Subject " + " begin " + " end " + " place");
                    d2 = ((m.get("doctor").toString()) + " doctor " + (m.get("subject").toString()) + " Subject " + (m.get("begin").toString()) + " begin "  + (m.get("end").toString()) + " end " + (m.get("place").toString()) + " place");
                    Log.d("ss",d2);
                    dlist.add(d2);
                    gadwal_adpter.notifyDataSetChanged();

                }


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        gadwal_adpter = new Gadwal_adpter(getActivity(), dlist);
        list.setAdapter(gadwal_adpter);


        return b;
    }

    @Override
    public void onStart() {
        super.onStart();
        dlist.clear();
    }
}
