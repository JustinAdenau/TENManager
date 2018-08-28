package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wip.me.fhdw.de.tenmanager.R;

public class ToDoDetailviewAdapter_Lena extends BaseAdapter {


    private List<String> mContentList;
    private Context mContext;
    private Activity mActivity;
    private String mCheckboxActivated;
    private List<CheckBox> mCheckboxList;

    private ApplicationLogicToDoDetailview_Mona mApplicationlogic;

    public ToDoDetailviewAdapter_Lena(Context context)
        {
            this.mContext=context;
            mCheckboxList = new ArrayList<>();
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

        public List<CheckBox> getCheckboxList(){return mCheckboxList;}

        public void setContentList(List<String> contentList){mContentList = contentList;}

        public void setActivity(Activity activity){mActivity = activity;}

        public void setApplicationLogic(ApplicationLogicToDoDetailview_Mona applicationLogic){mApplicationlogic = applicationLogic;}

        public void setCheckboxActivated(String checkboxActivated){mCheckboxActivated = checkboxActivated;
        Log.d("LOGTAG", "checkBoxActivated wurde in DetailviewAdapter gesetzt: "+mCheckboxActivated+"!!!!!!!!!!!!!!!!!!!!!");}


        @Override
        public View getView(final int position, View v, ViewGroup viewGroup) {
            View view = View.inflate(mContext, R.layout.list_item_tododetailview, null);
            final CheckBox checkBox = view.findViewById(R.id.checkbox);
            final EditText editText = (EditText)view.findViewById(R.id.textview);
            Log.d("LOGTAG", "getView content: "+mContentList.get(position)+"!!!!!!!!!!!!!!!!!!!!!!!");
            editText.setText(mContentList.get(position));
            if(mCheckboxActivated.length()>position && mCheckboxActivated.substring(position, position+1).equals("1")) checkBox.setChecked(true);
            mCheckboxList.add(checkBox);
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {mApplicationlogic.onCheckboxClicked(view, position);}
            });

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    mContentList.set(position, editText.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            return view;
        }

        public void refresh(List<String> contentList)
        {
            mContentList = contentList;
            for (String content: mContentList) {
                Log.d("LOGTAG", "content im Adapter: "+content+"!!!!!!!!!!!!!!!!!!!!");
            }
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    notifyDataSetChanged();
                }
            });
        }
    }


