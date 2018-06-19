package com.braincraft.social.activity;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import static com.braincraft.social.activity.Page_Activity.firstpage;
import static com.braincraft.social.activity.Page_Activity.nextBtn;
import static com.braincraft.social.activity.Page_Activity.prevBtn;

public class Paginator {
    public static final int TOTAL_NUM_ITEMS=200;
    public static final int ITEMS_PER_PAGE=4;
    public static final int ITEMS_REMAINING=TOTAL_NUM_ITEMS % ITEMS_PER_PAGE;
    public static final int LAST_PAGE=TOTAL_NUM_ITEMS/ITEMS_PER_PAGE;
    private static final String TAG = "PRANJAL";
    public static int startItem;


    public ArrayList<String> generatePage(int currentPage)
    {
        startItem=currentPage*ITEMS_PER_PAGE+1;
        int numOfData=ITEMS_PER_PAGE;
        ArrayList<String> pageData=new ArrayList<>();
        Log.i(TAG, "cur123:" + currentPage);
        if (currentPage==LAST_PAGE && ITEMS_REMAINING>0)
        {nextBtn.setVisibility(View.GONE);
            firstpage.setVisibility(View.VISIBLE);
            for (int i=startItem;i<startItem+ITEMS_REMAINING;i++)
            {
                pageData.add(""+i);
            }
        }
        else if(currentPage==0)
        {
            for (int i=startItem;i<startItem+numOfData;i++)
            {
                pageData.add(""+i);
            }
            firstpage.setVisibility(View.GONE);
        }
        /*else if(currentPage==3)
        {
          // nextBtn.setVisibility(View.GONE);
        }*/
        else
        {firstpage.setVisibility(View.VISIBLE);
            for (int i=startItem;i<startItem+numOfData;i++)
            {
                pageData.add(""+i);
            }
        }
        return pageData;
    }
}