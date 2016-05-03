package com.example.thmoviesapp.softwareproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Abed Eid on 01/05/2016.
 */
public class Gadwal extends Fragment {
    Firebase firebase;
    String stringday;
    String Group, Year, Section;
    ArrayList<Student> students;
    Student s;
    public static final String DEFAULT = "default";

    public void Gadwal() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Calendar c = Calendar.getInstance();
        int seconds = c.get(Calendar.SECOND);
        int minute = c.get(Calendar.MINUTE);
        int Hour = c.get(Calendar.HOUR);
        int day = c.get(Calendar.DAY_OF_WEEK);
        if (day == 1) {
            stringday = "sunday";
        } else if (day == 2) {

            stringday = "monday";
        } else if (day == 3) {

            stringday = "tuesday";
        } else if (day == 4) {

            stringday = "wednesday";
        } else if (day == 5) {

            stringday = "thursday";
        }

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Data", Context.MODE_PRIVATE);
        Group = sharedPreferences.getString("Group", DEFAULT);
        Section = sharedPreferences.getString("Section", DEFAULT);
        Year = sharedPreferences.getString("Year", DEFAULT);


      //  Toast.makeText(getActivity(), Hour + ": " + minute, Toast.LENGTH_SHORT).show();
//        firebase = new Firebase("https://torrid-torch-3608.firebaseio.com/schedule_assistant");
//        s = new Student();
//        firebase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.d("hiiiiiiii", " " + dataSnapshot.getValue());
//                for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
//                    Map<String, String> m = dataSnapshot.child(i + "").getValue(Map.class);
//                    //section
//                    if (m.get("day").equals(stringday.trim()) && m.get("group").equals(Group) && m.get("year").equals(Year) && m.get("section").equals(Section))
//                        //Log.d("hiiiiiiii", "" +  +" "++" "++" "++);
//                        s.setBegin(m.get("begin"));
//                    s.setSubject(m.get("subject"));
//                    s.setPlace(m.get("place"));
//                    s.setEnd(m.get("end"));
//                    s.setDoctor(m.get("doctor"));
//                    students.add(s);
//                }
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gadwal, container, false);

    }
}
