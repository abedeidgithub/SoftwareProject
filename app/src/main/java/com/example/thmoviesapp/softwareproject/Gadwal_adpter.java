package com.example.thmoviesapp.softwareproject;

/**
 * Created by Abed Eid on 03/05/2016.
 */
//public class Gadwal_adpter extends BaseAdapter {
//    private Context context;
//    private LayoutInflater inflater;
//    private List<String> Items;
//    String m;
//
//
//    public Gadwal_adpter(Context context, List<String> Items) {
//        this.context = context;
//        this.Items = Items;
//
//    }
//
//    @Override
//    public int getCount() {
//        return Items.size();
//    }
//
//    @Override
//    public Object getItem(int location) {
//        return Items.get(location);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if (inflater == null)
//            inflater = (LayoutInflater) context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        if (convertView == null)
//            convertView = inflater.inflate(R.layout.gadwal_item, parent, false);
//        TextView doctor = (TextView) convertView.findViewById(R.id._name);
//        m = Items.get(position);
//        doctor.setText(m.toString());
//
//
//        return convertView;
//    }
//
//
//
//}
