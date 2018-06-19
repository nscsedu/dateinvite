package com.braincraft.social.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.braincraft.social.R;
import com.braincraft.social.activity.FFmpegRecorderActivity;

import java.util.ArrayList;
import java.util.List;

import static com.braincraft.social.activity.FFmpegRecorderActivity.flag_delete;

/**
 * View that shows different sections of progress and how they add up to the total progress.
 */
public class ProgressSectionsView extends View
{float[] store = new float[1000];
	float[] itemstore = new float[10];
float max=0;
int drawflag=0,invalidateflag=0;
	private long mMinProgress = 0;
	public int in=0;
	private long mMaxProgress = 8000;
	private int mCursorFlashIntervalMillis = 500;
	private int mCursorWidthPixels;
	private int mSeparatorWidthPixels;
	private Paint mCursorPaint,CursorPaint;
	private Paint mMinProgressPaint;
	private Paint mSeparatorPaint;
	private Paint mDeletePaint;
	private Paint mProgressPaint;
	private static final String TAG = "MyActivity";
	private ProgressSectionsProvider mProvider;
	private boolean mIsCursorVisible = true;
	private long mCursorLastChangeMillis = 0;
	int colorAccent;
	int colorPrimary ;
	int colorPrimaryDark;
	int tmpsection;
	int colorflag=0;
	int sizelist;
	int flag_add=0;
	int inc=0;
	float boundary;
	float segmentend=0,tmp_segmentend;
	float segmentstart=0,tmp_segmentstart=0;
	float allsegment=0;
	float lastsegment=0;
	float sumsegment=0,tmp1=0,tmp2=0,tmp3=0,tmp4=0;
	float tmp=0;
	int flag1=0;
	int flagnumber=0;
	float sectionWidthnew;
	List<Float> listsegment = new ArrayList<Float>();

	List<Float> listsectionwidthnew = new ArrayList<Float>();

	float drawnWidth_tmp=0,sectionWidth_tmp=0;
	float drawnWidth_tmp1=0,sectionWidth_tmp1=0;
	int height_tmp=0;
	int j=0;
	float sectionWidth;
	ArrayList<Float> sectionitem=new ArrayList<Float>();


	//List<Integer> list = Arrays.asList(arr);
	//canvas.drawRect(drawnWidth, 0, drawnWidth + sectionWidth, height, mProgressPaint);


	public ProgressSectionsView(Context context) {
		this(context, null, 0);
	}

	public ProgressSectionsView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ProgressSectionsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);


		DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
		mCursorWidthPixels = Math.round(16 * displayMetrics.density);
        mSeparatorWidthPixels = Math.round(1 * displayMetrics.density);

		Resources.Theme theme = getContext().getTheme();
		 colorAccent = ViewUtil.getThemeColorAttribute(theme, R.attr.colorAccent);
		 colorPrimary = ViewUtil.getThemeColorAttribute(theme, R.attr.colorPrimary);
		 colorPrimaryDark = ViewUtil.getThemeColorAttribute(theme, R.attr.colorPrimaryDark);

		mProgressPaint = new Paint();
		mProgressPaint.setStyle(Paint.Style.FILL);
		//mProgressPaint.setColor(colorAccent);
		mProgressPaint.setColor(ContextCompat.getColor(getContext(), R.color.white));
		Log.i(TAG, "progressclass:" );
		mCursorPaint = new Paint();
		mCursorPaint.setStyle(Paint.Style.FILL);
		mCursorPaint.setColor(colorAccent);
		//mCursorPaint.setColor(ContextCompat.getColor(getContext(), R.color.white));

		mMinProgressPaint = new Paint();
		mMinProgressPaint.setStyle(Paint.Style.FILL);
		//mMinProgressPaint.setColor(colorPrimary);
		mMinProgressPaint.setColor(ContextCompat.getColor(getContext(), R.color.white));

		mSeparatorPaint = new Paint();
		mSeparatorPaint.setStyle(Paint.Style.FILL);
		mSeparatorPaint.setColor(ContextCompat.getColor(getContext(), R.color.dark_gray));

		mDeletePaint = new Paint();
		mDeletePaint.setStyle(Paint.Style.FILL);
		mDeletePaint.setColor(ContextCompat.getColor(getContext(), R.color.red));

		CursorPaint  = new Paint();
		CursorPaint .setStyle(Paint.Style.FILL);
		CursorPaint .setColor(ContextCompat.getColor(getContext(), R.color.white));
	}

	public ProgressSectionsProvider getProvider() {
		return mProvider;
	}

	public void setProvider(ProgressSectionsProvider provider) {
		mProvider = provider;
	}

	public long getMinProgress() {
		return mMinProgress;
	}

	public void setMinProgress(long minProgress) {
		this.mMinProgress = minProgress;
	}

	public long getMaxProgress() { return mMaxProgress; }

	public void setMaxProgress(long time){
		mMaxProgress = time;
	}

	public int getCursorFlashInterval() {
		return mCursorFlashIntervalMillis;
	}

	public void setCursorFlashInterval(int cursorFlashIntervalMillis) {
		this.mCursorFlashIntervalMillis = cursorFlashIntervalMillis;
	}

	public int getCursorWidth() {
		return mCursorWidthPixels;
	}

	public void setCursorWidth(int cursorWidthPixels) {
		this.mCursorWidthPixels = cursorWidthPixels;
	}

	public int getSeparatorWidth() {
		return mSeparatorWidthPixels;
	}

	public void setSeparatorWidth(int separatorWidthPixels) {
		this.mSeparatorWidthPixels = separatorWidthPixels;
	}

	public Paint getCursorPaint() {
		return mCursorPaint;
	}

	public void setCursorPaint(Paint cursorPaint) {
		this.mCursorPaint = cursorPaint;
	}

	public void setCursorColor(@ColorInt int color) {
		mCursorPaint.setColor(color);
	}

	public Paint getMinProgressPaint() {
		return mMinProgressPaint;
	}

	public void setMinProgressPaint(Paint minProgressPaint) {
		this.mMinProgressPaint = minProgressPaint;
	}

	public void setMinProgressColor(@ColorInt int color) {
		mMinProgressPaint.setColor(color);
	}

	public Paint getSeparatorPaint() {
		return mSeparatorPaint;
	}

	public void setSeparatorPaint(Paint separatorPaint) {
		this.mSeparatorPaint = separatorPaint;
	}

	public void setSeparatorColor(@ColorInt int color) {
		mSeparatorPaint.setColor(color);
	}

	public Paint getProgressPaint() {
		return mProgressPaint;
	}

	public void setProgressPaint(Paint progressPaint) {
		this.mProgressPaint = progressPaint;
	}

	public void setProgressColor(@ColorInt int color) {
		mProgressPaint.setColor(color);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		boolean hasCurrentProgress = mProvider.hasCurrentProgress();
		List<Integer> sections = mProvider.getProgressSections();
		int totalProgress = 0;
		/*for (Integer progress : sections) {
			//progress=progress-100;
			//Log.i(TAG, "2progress ::" + progress);
			totalProgress += progress;
		}*/

		int height = getMeasuredHeight();
		int width = getMeasuredWidth();
		long maxProgress = 0;
		if (mMaxProgress > 0) {
			maxProgress = mMaxProgress;
			Log.i(TAG, "maxProgress1:" + maxProgress);
		} else {
			maxProgress = (totalProgress / 4000 + 1) * 4000 + 1000;
			Log.i(TAG, "maxProgress2:" + maxProgress);
		}
		float pixelsPerProgress =
				(float) (width - sections.size() * mSeparatorWidthPixels) / maxProgress;
		pixelsPerProgress = pixelsPerProgress;
		Log.i(TAG, "pixelsPerProgress:" + pixelsPerProgress);

		// Draw the current sections
		int listsize = sections.size() - 1;

		//Log.i(TAG, "listsize:" + listsize);

		float drawnWidth = 0;


		/*drawnWidth_tmp=0;
		sectionWidth_tmp=0;*/
		//listsegment.add(0f);

		listsectionwidthnew.clear();
		/*if(FFmpegRecorderActivity.button_click==1&&checkcolor==1) {
			//flag_delete=0;
			canvas.drawRect(tmp_segmentstart, 0,
					tmp_segmentend, height, mProgressPaint);

		}*/

		//sections.clear();
		//if(drawflag==0){
			drawflag=1;
		for (int progress : sections) {


			//progress=progress-100;

			int sectionsize = sections.size();
			Log.i(TAG, "sectionsize:" + sectionsize);
			//progress=progress-1000;


			in++;
			//progress=progress-1000;

			//Log.i(TAG, "1progress ::" + progress);

			Log.i(TAG, "Progressflag_delete:" + flag_delete);

			//	Log.i(TAG, "progress:" + progress);
			//Log.i(TAG, "in:" + in);


			/*if(in<2)
			{
				mProgressPaint.setColor(colorPrimary);
			}*/
			progress = progress;
			//Log.i(TAG, "tmpsection:" + tmpsection);

			//sizelist=sections.size() - 1;
			Log.i(TAG, "progress1" + progress);
			Log.i(TAG, "pixelsPerProgress1" + pixelsPerProgress);
			sectionWidth = progress * pixelsPerProgress;


			for (int i = 0; i < sections.size(); i++) {
				//System.out.println(sections.get(i));sectionWidth = progress * pixelsPerProgress;
				Log.i(TAG, "sections.get(i):" + sections.get(i));
				sectionWidthnew = sections.get(i) * pixelsPerProgress;


				if (!listsectionwidthnew.contains(sectionWidthnew)) {
					listsectionwidthnew.add(sectionWidthnew);


				}


				// listsectionwidthnew.add(sectionWidthnew);
				//sections.get(i) = sections.get(i) * pixelsPerProgress;
				//Log.i(TAG, "newsections.get(i):" + sections.get(i));
			}
			Log.i(TAG, " listsectionwidthnew.size():" + listsectionwidthnew.size());

			for (int i = 0; i < listsectionwidthnew.size(); i++) {

				Log.i(TAG, "listsectionwidthnew.get(i):" + listsectionwidthnew.get(i));

			}

			/*for (int i = 0; i < 1000; i++) {
				store[i] = sectionWidth;
			}

			for (int i = 0; i < 1000; i++) {
				//Log.i(TAG, "array" + store[i]);
				if (store[i] > max) {
					max = store[i];
				}

			}
			Log.i(TAG, "max" + max);*/
			//listsegment.add(max);
			//if(flag==0||max>sectionitem.get(sectionitem.size() - 1)) {


			//{
		/*	for (int k = 0; k < 10; k++) {
				if (itemstore[k] == max) {
					flag_add = 0;
				} else {
					flag_add = 1;
				}
			}
			if (flag_add == 1)
			{
				itemstore[j] = max;
			j++;
		}*/
			//}
			/*if (listsegment.contains(max)) {
				System.out.println("Account found");
			} else {
				Log.i(TAG, "max1:" + max);

				listsegment.add(max);
				System.out.println("Account not found");
			}*/


			//Log.i(TAG, "sectionitem.get(sectionitem.size() - 1):" + sectionitem.get(sectionitem.size() - 1));


			//}

			/*if(!listsegment.contains(sectionWidth)) {
				listsegment.add(sectionWidth);



			}*/


		/*	if (listsegment.contains(sectionWidth)) {

			} else {	Log.i(TAG, "abc" + sectionWidth );

				listsegment.add(sectionWidth);
				sumsegment=sumsegment+sectionWidth;


			}*/


			Log.i(TAG, "sectionWidth1" + sectionWidth);
			Log.i(TAG, "FFmpegRecorderActivity.checkpress" + FFmpegRecorderActivity.checkpress);
			//mProgressPaint.setColor(colorPrimary);
			//	if(FFmpegRecorderActivity.checkpress==1) {

			canvas.drawRect(drawnWidth, 0, drawnWidth + sectionWidth, height, mProgressPaint);
			drawnWidth += sectionWidth;
			// }
			if (listsectionwidthnew.size() > 0) {
				tmp1 = drawnWidth;
				Log.i(TAG, "firsttemp1:" + tmp1);
			}

			/*if(flag==1)
			{
				drawnWidth_tmp=0;
				sectionWidth_tmp=0;
			}*/

			/*if (drawnWidth > drawnWidth_tmp) {
				//flag=1;

				drawnWidth_tmp = drawnWidth;
			}
			if (drawnWidth + sectionWidth >  sectionWidth_tmp) {
			    sectionWidth_tmp = drawnWidth + sectionWidth;
				//flag=1;
		   }*/

			if (drawnWidth > drawnWidth_tmp) {
				//flag=1;
				Log.i(TAG, " drawnWidth_tmp" + drawnWidth_tmp);
				drawnWidth_tmp = drawnWidth;
			}
			if (drawnWidth + sectionWidth > sectionWidth_tmp) {
				Log.i(TAG, " sectionWidth_tmp" + sectionWidth_tmp);
				sectionWidth_tmp = drawnWidth + sectionWidth;
				//flag=1;
			}


			//if(flag==0)
			//{//in++;
			drawnWidth_tmp1 = drawnWidth;
			sectionWidth_tmp1 = drawnWidth + sectionWidth;
			//flag=1;
			//}


			height_tmp = height;

			Log.i(TAG, "drawnWidth:" + drawnWidth);
			Log.i(TAG, "sectionWidth:" + sectionWidth);

			Log.i(TAG, "left:drawnWidth_tmp:" + drawnWidth_tmp);
			Log.i(TAG, "right:sectionWidth_tmp:" + sectionWidth_tmp);


			lastsegment = sectionWidth;
			allsegment = allsegment + sectionWidth;
			segmentend = segmentend + sectionWidth;


			//Log.i(TAG, "height_tmp:" + height_tmp);


			//  drawnWidth += sectionWidth;
			if (drawnWidth > tmp) {
				tmp = drawnWidth;
			}
			canvas.drawRect(drawnWidth, 0,
					drawnWidth + mSeparatorWidthPixels, height, mSeparatorPaint);

			Log.i(TAG, "drawnWidth123:" + drawnWidth);
			Log.i(TAG, "mSeparatorWidthPixels23:" + (drawnWidth + mSeparatorWidthPixels));
			tmp1 = drawnWidth + mSeparatorWidthPixels;
			/*if(tmp1==drawnWidth +mSeparatorWidthPixels && flagsegment==1)
			{flagsegment=0;
				tmp2=tmp1;
				Log.i(TAG, "tmp1:" +tmp1);
				Log.i(TAG, "tmp2:" +tmp2);
				listsegment.add(tmp2);
				//flagsegment=1;

			}*/
			Log.i(TAG, "listsegment.size():" + listsegment.size());
			drawnWidth += mSeparatorWidthPixels;


			//listsegment.add(drawnWidth);

			/*if (listsegment.contains(tmp )) {

			} else {	Log.i(TAG, "abc" + tmp );

				listsegment.add(tmp);
				sumsegment=sumsegment+tmp;


			}*/

			//Log.i(TAG, "listsegment.size():" +listsegment.size());
			sectionitem.add(sectionWidth + mSeparatorWidthPixels);
			Log.i(TAG, "flagsec:" + sectionWidth + mSeparatorWidthPixels);

			/*if(FFmpegRecorderActivity.flag_delete==1) {
				Log.i(TAG, "last" + listsectionwidthnew.size());
				Log.i(TAG, "FFmpegRecorderActivity.flag_delete:" + FFmpegRecorderActivity.flag_delete);

				Log.i(TAG, "inleft:" + drawnWidth_tmp);
				Log.i(TAG, "inright:" + sectionWidth_tmp);

				Log.i(TAG, "drawnWidth_tmp1:" + drawnWidth_tmp1);
				Log.i(TAG, "sectionWidth_tmp1:" + sectionWidth_tmp1);

				if ((drawnWidth_tmp1 >= drawnWidth_tmp) && (sectionWidth_tmp1 >= sectionWidth_tmp)){


					canvas.drawRect(drawnWidth_tmp1, 0,
							sectionWidth_tmp1, height, mSeparatorPaint);
					Log.i(TAG, "lastsegment:" +sectionWidth);

					drawnWidth_tmp=drawnWidth_tmp-sectionWidth;
					sectionWidth_tmp=sectionWidth_tmp-sectionWidth;

			}


				segmentstart=segmentend-lastsegment;





			}*/



			/*Complete Code
			if(FFmpegRecorderActivity.flag_delete==1) {
				Log.i(TAG, "FFmpegRecorderActivity.flag_delete:" + FFmpegRecorderActivity.flag_delete);

				Log.i(TAG, "inleft:" + drawnWidth_tmp);
				Log.i(TAG, "inright:" + sectionWidth_tmp);

				Log.i(TAG, "drawnWidth_tmp1:" + drawnWidth_tmp1);
				Log.i(TAG, "sectionWidth_tmp1:" + sectionWidth_tmp1);

				Float e = listsectionwidthnew.get(listsectionwidthnew.size() - 1);

				float sumarray = 0;
				Log.i(TAG, "size123" +listsectionwidthnew.size());
				for (int i = 0; i < listsectionwidthnew.size()-1; i++)
				{
					Log.i(TAG, "listsectionwidthnew.get(i)" + listsectionwidthnew.get(i));
				sumarray += listsectionwidthnew.get(i);
			}
			//	segmentend=sumarray;
				segmentstart=sumarray-e;
				segmentstart=sumarray;
				Log.i(TAG, "sumarray:" +sumarray);

					canvas.drawRect(segmentstart, 0,
							sumarray+e, height, mSeparatorPaint);


				//segmentstart=segmentend-lastsegment;





			}*/
			if (flag_delete == 1) {

				//if(!(FFmpegRecorderActivity.button_click==1&&checkcolor==1)) {
				Log.i(TAG, "FFmpegRecorderActivity.flag_delete:" + flag_delete);

				Log.i(TAG, "inleft:" + drawnWidth_tmp);
				Log.i(TAG, "inright:" + sectionWidth_tmp);

				Log.i(TAG, "drawnWidth_tmp1:" + drawnWidth_tmp1);
				Log.i(TAG, "sectionWidth_tmp1:" + sectionWidth_tmp1);

				Float e = listsectionwidthnew.get(listsectionwidthnew.size() - 1);

				float sumarray = 0;
				Log.i(TAG, "size123" + listsectionwidthnew.size());
				for (int i = 0; i < listsectionwidthnew.size(); i++) {
					Log.i(TAG, "listsectionwidthnew.get(i)" + listsectionwidthnew.get(i));
					sumarray += listsectionwidthnew.get(i);
				}
				//	segmentend=sumarray;
				segmentstart = sumarray - e;
				segmentend = sumarray;
				Log.i(TAG, "sumarray:" + sumarray);

				canvas.drawRect(segmentstart, 0,
						segmentend, height, mDeletePaint);
				tmp_segmentstart = segmentstart;
				tmp_segmentend = segmentend;
				//}


				//segmentstart=segmentend-lastsegment;


				/*if(FFmpegRecorderActivity.button_click==1&&checkcolor==1) {
					canvas.drawRect(segmentstart, 0,
							segmentend, height, mProgressPaint);

				}*/


			}
			/*if(FFmpegRecorderActivity.button_click==1&&checkcolor==1) {
				canvas.drawRect(segmentstart, 0,
						segmentend, height, mProgressPaint);

			}*/
			/*canvas.drawRect(drawnWidth_tmp, 0,
					sectionWidth_tmp, height, mProgressPaint);*/
			//Log.i(TAG, "drawnWidth:" + drawnWidth);
			//Log.i(TAG, "sectionWidth:" + sectionWidth);
			//Log.i(TAG, "height:" + height);
			//Log.i(TAG, "mProgressPaint:" + drawnWidth);
		}

		//Log.i(TAG, " listsectionwidthnew.size1():" + listsectionwidthnew.size());
		//flag=0;
		//listsegment.add(max);

		// Draw the minimum time indicator
		if (totalProgress <= mMinProgress) {
			float minProgressX = pixelsPerProgress * mMinProgress;
			canvas.drawRect(0, 0,
					0, height, mMinProgressPaint);
		}

		if (!hasCurrentProgress) {
			// Show and hide the cursor every mCursorFlashIntervalMillis
			long currMillis = SystemClock.uptimeMillis();
			if (currMillis - mCursorLastChangeMillis >= mCursorFlashIntervalMillis) {
				mIsCursorVisible = !mIsCursorVisible;
				mCursorLastChangeMillis = currMillis;
			}

			/*if (listsectionwidthnew.size() > 0)
			{
				canvas.drawRect(drawnWidth , 0,
						drawnWidth + mCursorWidthPixels, height, mCursorPaint);
			}*/

			if(listsectionwidthnew.size()>0) {
				tmp1 = drawnWidth;
				Log.i(TAG, "firsttemp1:" + tmp1);
			}

			/*canvas.drawRect(drawnWidth - (sectionWidth * (0.2f)), 0,
					drawnWidth, height,mCursorPaint);*/

			/*if(FFmpegRecorderActivity.maxlimit==1)
			{
				canvas.drawRect(drawnWidth - (sectionWidth * (0.3f)), 0,
						drawnWidth, height,CursorPaint);
			}*/

			if (mIsCursorVisible){

				/*canvas.drawRect(drawnWidth-20, 0,
						drawnWidth + mCursorWidthPixels-20, height, mCursorPaint);*/

				if(flag_delete!=1)
				{
					canvas.drawRect(drawnWidth, 0,
							drawnWidth + mCursorWidthPixels, height, mCursorPaint);


					/*if(FFmpegRecorderActivity.maxlimit==1)
					{
						canvas.drawRect(drawnWidth, 0,
								drawnWidth + mCursorWidthPixels, height, CursorPaint);
					}*/
				}
			}
		}
		/*new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				invalidate();
			}
		}, 45000);*/
			invalidate();


		/*drawnWidth_tmp1 = 0;
		sectionWidth_tmp1 = 0;*/

	}


	public interface ProgressSectionsProvider {
		boolean hasCurrentProgress();
		List<Integer> getProgressSections();
	}
}