package wip.me.fhdw.de.tenmanager.ToDos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import wip.me.fhdw.de.tenmanager.R;

public class ToDoDetailviewAdapter_Lena extends BaseAdapter {


    private List<String> mContentList;
    private Context mContext;

    public ToDoDetailviewAdapter_Lena(Context context)
        {
            this.mContext=context;
        }


        @Override
        public int getCount() {
            return mContentList.size();
        }

        @Override
        public Object getItem(int position) {
            return mContentList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public List<String> getContentList(){return mContentList;}

        public void setContentList(List<String> contentList){mContentList = contentList;}


        @Override
        public View getView(int position, View v, ViewGroup viewGroup) {
            View view = View.inflate(mContext, R.layout.list_item_tododetailview, null);
            CheckBox checkBox = view.findViewById(R.id.checkbox);
            TextView textview = view.findViewById(R.id.textview);

            textview.setText(mContentList.get(position));
            return view;
        }
    }


