package com.example.mirko.mergecastle;

import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageView clickBoardView;
    ImageView i1;
    ImageView i2;
    ImageView i3;
    ImageView i4;
    ImageView i5;
    ImageView i6;
    ImageView i7;
    ImageView i8;
    ImageView i9;
    ImageView ia;
    ImageView ib;
    ImageView ic;
    TextView clickCounterView;
    TextView logView;
    int click=0;
    String log1="";
    String log2="";
    String longLog="";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
        }
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);

        findViewById(R.id.i1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.i2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.i3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.i4).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.i5).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.i6).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.i7).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.i8).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.i9).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.ia).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.ib).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.ic).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.Quadro1).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadro2).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadro3).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadro4).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadro5).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadro6).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadro7).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadro8).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadro9).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadroa).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadrob).setOnDragListener(new MyDragListener());
        findViewById(R.id.Quadroc).setOnDragListener(new MyDragListener());

        RelativeLayout Quadro1 = (RelativeLayout)findViewById(R.id.Quadro1);

         i1 = (ImageView)findViewById(R.id.i1);
         i2 = (ImageView)findViewById(R.id.i2);
         i3 = (ImageView)findViewById(R.id.i3);
         i4 = (ImageView)findViewById(R.id.i4);
         i5 = (ImageView)findViewById(R.id.i5);
         i6 = (ImageView)findViewById(R.id.i6);
         i7 = (ImageView)findViewById(R.id.i7);
         i8 = (ImageView)findViewById(R.id.i8);
         i9 = (ImageView)findViewById(R.id.i9);
         ia = (ImageView)findViewById(R.id.ia);
         ib = (ImageView)findViewById(R.id.ib);
         ic = (ImageView)findViewById(R.id.ic);

        TagImage();
        GridBuilder(i1);
        GridBuilder(i2);
        GridBuilder(i3);
        GridBuilder(i4);
        GridBuilder(i5);
        GridBuilder(i6);
        GridBuilder(i7);
        GridBuilder(i8);
        GridBuilder(i9);
        GridBuilder(ia);
        GridBuilder(ib);
        GridBuilder(ic);




        logView = (TextView)findViewById(R.id.logView);

        ImageView clickBoardView = (ImageView)findViewById(R.id.clickBoardView);
        final TextView clickCounterView = (TextView)findViewById(R.id.clickCounterView);

/*
        clickBoardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            click++;
                clickCounterView.setText("click: " + click);

            }
        });
*/

        clickBoardView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    click++;
                    clickCounterView.setText("click: " + click);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    CreazionePezzoListener(click);
                }

                return true;
            }
        });



    }



    private void TagImage(){
        i1.setTag(R.drawable.quadrovuoto);
        i2.setTag(R.drawable.quadrovuoto);
        i3.setTag(R.drawable.quadrovuoto);
        i4.setTag(R.drawable.quadrovuoto);
        i5.setTag(R.drawable.quadrovuoto);
        i6.setTag(R.drawable.quadrovuoto);
        i7.setTag(R.drawable.quadrovuoto);
        i8.setTag(R.drawable.quadrovuoto);
        i9.setTag(R.drawable.quadrovuoto);
        ia.setTag(R.drawable.quadrovuoto);
        ib.setTag(R.drawable.quadrovuoto);
        ic.setTag(R.drawable.quadrovuoto);
    }

    private void GridBuilder(ImageView iv){

        Integer integer = (Integer) iv.getTag();
        integer = integer == null ? 0 : integer;

        
        switch(integer) {
            case R.drawable.quadrovuoto:
                iv.setImageResource(R.drawable.quadrovuoto);
                //logView.setText(integer);
                break;
            case R.drawable.armaturaprova:
                iv.setImageResource(R.drawable.armaturaprova);
                //logView.setText(integer);
                break;
            case R.drawable.provaarma:
                iv.setImageResource(R.drawable.provaarma);
                //logView.setText(integer);
                break;
            default:
                iv.setImageResource(R.drawable.quadro);
                iv.setTag(R.drawable.quadro);
                //logView.setText(" "+integer);
                break;

        }

    }

    private void CreazionePezzoListener(int click1){
        int count=1;
        if(click1%5==0){

            if (i1.getTag().equals(R.drawable.quadro))
            {
                count = 1;
            }
            if (i2.getTag().equals(R.drawable.quadro))
            {
                count = 2;
            }
            if (i3.getTag().equals(R.drawable.quadro))
            {
                count = 3;
            }
            if (i4.getTag().equals(R.drawable.quadro))
            {
                count = 4;
            }
            if (i5.getTag().equals(R.drawable.quadro))
            {
                count = 5;
            }
            if (i6.getTag().equals(R.drawable.quadro))
            {
                count = 6;
            }
            if (i7.getTag().equals(R.drawable.quadro))
            {
                count = 7;
            }
            if (i8.getTag().equals(R.drawable.quadro))
            {
                count = 8;
            }
            if (i9.getTag().equals(R.drawable.quadro))
            {
                count = 9;
            }
            if (ia.getTag().equals(R.drawable.quadro))
            {
                count = 10;
            }
            if (ib.getTag().equals(R.drawable.quadro))
            {
                count = 11;
            }
            if (ic.getTag().equals(R.drawable.quadro))
            {
                count = 12;
            }

            switch(count)
                     {
                case 1:
                        // libero
                        i1.setImageResource(R.drawable.provaarma);
                        i1.setTag(R.drawable.provaarma);
                        break;
                case 2:
                        // libero
                        i2.setImageResource(R.drawable.provaarma);
                        i2.setTag(R.drawable.provaarma);
                        break;
                case 3:
                        // libero
                        i3.setImageResource(R.drawable.provaarma);
                        i3.setTag(R.drawable.provaarma);
                        break;
                case 4:

                        // libero
                        i4.setImageResource(R.drawable.provaarma);
                        i4.setTag(R.drawable.provaarma);
                        break;
                case 5:
                        // libero
                        i5.setImageResource(R.drawable.provaarma);
                        i5.setTag(R.drawable.provaarma);
                        break;
                case 6:
                        // libero
                        i6.setImageResource(R.drawable.provaarma);
                        i6.setTag(R.drawable.provaarma);
                        break;
                case 7:
                        // libero
                        i7.setImageResource(R.drawable.provaarma);
                        i7.setTag(R.drawable.provaarma);
                        break;
                case 8:

                        // libero
                        i8.setImageResource(R.drawable.provaarma);
                        i8.setTag(R.drawable.provaarma);
                        break;
                case 9:

                        // libero
                        i9.setImageResource(R.drawable.provaarma);
                        i9.setTag(R.drawable.provaarma);
                        break;
                case 10:
                        // libero
                        ia.setImageResource(R.drawable.provaarma);
                        ia.setTag(R.drawable.provaarma);
                        break;
                case 11:
                        // libero
                        ib.setImageResource(R.drawable.provaarma);
                        ib.setTag(R.drawable.provaarma);
                        break;
                case 12:
                        // libero
                        ic.setImageResource(R.drawable.provaarma);
                        ic.setTag(R.drawable.provaarma);
                        break;
                    default:
                        break;
            }

        }
    }


    private final class MyTouchListener implements OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);

                Log.wtf("View 1", view.toString());
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements OnDragListener {
        Drawable enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape);
        View viewS;

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    viewS = (View) event.getLocalState();
                    //log1=v.getResources().getResourceName(v.getId());
                    //longLog=longLog + ImageTagIsolator(log);
                    //logView.setText(" " +longLog);
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    View viewEn = (View) event.getLocalState();

                    //log=" " + viewEn;
                    //longLog=longLog + ImageTagIsolator(log);
                    //logView.setText(" " +longLog);
                    v.setBackgroundDrawable(enterShape);
                    Log.wtf("Manager","ENTRA IN CASELLA " + v.getResources().getResourceName(v.getId()));

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    View viewEX = (View) event.getLocalState();
                    log1=v.getResources().getResourceName(v.getId());
                    //log=" " + viewEX;
                    //longLog=longLog + ImageTagIsolator(log);
                    //logView.setText(" " +longLog);
                    v.setBackgroundDrawable(normalShape);
                    Log.wtf("Manager","ESCE DA CASELLA  " + v.getResources().getResourceName(v.getId()));
                    break;
                case DragEvent.ACTION_DROP:

                    log2=v.getResources().getResourceName(v.getId());

                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    //LinearLayout container = (LinearLayout) v;
                    view.setVisibility(View.INVISIBLE);
                    RelativeLayout dropTarget = (RelativeLayout) v;
                    dropTarget.addView(view);
                    ImageView dropped = (ImageView) view;

 /*
                    //handle the dragged view being dropped over a target view
                    View view = (View) event.getLocalState();
                    //stop displaying the view where it was before it was dragged
                    view.setVisibility(View.INVISIBLE);
                    //view dragged item is being dropped on
                    RelativeLayout dropTarget = (RelativeLayout) v;
                    //view being dragged and dropped
                    ImageView dropped = (ImageView) view;
                    */

                    Integer integer = (Integer) dropped.getTag();
                    integer = integer == null ? 0 : integer;

                    //update the text in the target view to reflect the data being dropped



                    for(int i = 0; i < dropTarget.getChildCount(); i++) {
                        View child = dropTarget.getChildAt(i);
                        // your processing...

                        String imagePartenza ="";
                        String imageArrivo="";
                        Log.wtf("View 1", view.toString());
                        Log.wtf("Manager","DROP           " +child.toString() ); // v.getResources().getResourceName(v.getId()) + String.valueOf(v = ((ViewGroup)owner).getChildAt(0)));
                        imagePartenza=ImageTagIsolator(view.toString());
                        imageArrivo=ImageTagIsolator(child.toString());
                        Log.wtf("Partenza", imagePartenza);
                        Log.wtf("Arrivo",imageArrivo ); // v.getResources().getResourceName(v.getId()) + String.valueOf(v = ((ViewGroup)owner).getChildAt(0)));



                        //TODO non arriva il layout giusto log1 e log2, quando si preme su una cella si crea una sovrapposizione perchè vede che l'id è lo stesso
                        GestoreMovimenti(dropped, (ImageView) child, log1, log2);
                        log1="";

                    }
                    //i1.setImageResource(integer);
                    //make it bold to highlight the fact that an item has been dropped



/*
                    View viewD = (View) event.getLocalState();
                    log=" " + viewD;
                    longLog=longLog + ImageTagIsolator(log);
                    logView.setText(" " +longLog);
                    ViewGroup owner = (ViewGroup) viewD.getParent();

                    longLog=printViewHierarchy(owner,"ciao");
                    logView.setText(" " +longLog);
                    owner.removeView(viewD);
                    RelativeLayout container = (RelativeLayout) v;
                    container.addView(viewD);
                    viewD.setVisibility(View.VISIBLE);
*/
                    //Log.wtf("Manager","DROP           " +rootView.toString() ); // v.getResources().getResourceName(v.getId()) + String.valueOf(v = ((ViewGroup)owner).getChildAt(0)));

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }

    private String ImageTagIsolator(String log){
        if (log.length() !=0) {
            log=log.substring(log.length()-3);
            log=log.substring(0,2);
            logView.setText(" "+ log);
        } else {
            // whatever is appropriate in this case
            throw new IllegalArgumentException("word has less than 3 characters!");
        }
        return log;
    }

    private String LayoutTagIsolator(String log){
        if (log.length() !=0) {
            log=log.substring(log.length()-7);
            logView.setText(" "+ log);
        } else {
            // whatever is appropriate in this case
            throw new IllegalArgumentException("word has less than 3 characters!");
        }
        return log;
    }

    public static String printViewHierarchy(ViewGroup vg, String prefix) {
        String desc="";
        for (int i = 0; i < vg.getChildCount(); i++) {
            View v = vg.getChildAt(i);
             desc =desc +  prefix + " | " + "[" + i + "/" + (vg.getChildCount()-1) + "] "+ v.getClass().getSimpleName() + " " + v;
            Log.v("x", desc);

            if (v instanceof ViewGroup) {
                printViewHierarchy((ViewGroup)v, desc);
            }
        }
        return desc;
    }

    public void GestoreMovimenti(ImageView dropped, ImageView dropTarget, String layoutPartenza, String layoutArrivo){
        Integer drop = (Integer) dropped.getTag();
        drop = drop == null ? 0 : drop;
        Integer dropT = (Integer) dropTarget.getTag();
        dropT = dropT == null ? 0 : dropT;

        Log.wtf("+++++++++++++++++++++++++++--------------------------------", drop.toString() +" "+ dropT.toString()+" "+ layoutPartenza+ " "+layoutArrivo);

        if(dropT.equals(drop) && !(layoutArrivo.equals(layoutPartenza)) ){
            dropped.setTag(R.drawable.quadrovuoto);
            dropTarget.setTag(R.drawable.armaturaprova);
            GridBuilder(dropped);
            GridBuilder(dropTarget);
            dropTarget.setVisibility(View.VISIBLE);
            Log.wtf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++", dropped.toString() +" "+ layoutPartenza+ " "+layoutArrivo);
        }
    }

    /**
     * Release memory when the UI becomes hidden or when system resources become low.
     * @param level the memory-related event that was raised.
     */
    public void onTrimMemory(int level) {

        // Determine which lifecycle or system event was raised.
        switch (level) {

            case ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN:

                /*
                   Release any UI objects that currently hold memory.

                   The user interface has moved to the background.
                */

                break;

            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE:
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW:
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL:

                /*
                   Release any memory that your app doesn't need to run.

                   The device is running low on memory while the app is running.
                   The event raised indicates the severity of the memory-related event.
                   If the event is TRIM_MEMORY_RUNNING_CRITICAL, then the system will
                   begin killing background processes.
                */

                break;

            case ComponentCallbacks2.TRIM_MEMORY_BACKGROUND:
            case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
            case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:

                /*
                   Release as much memory as the process can.

                   The app is on the LRU list and the system is running low on memory.
                   The event raised indicates where the app sits within the LRU list.
                   If the event is TRIM_MEMORY_COMPLETE, the process will be one of
                   the first to be terminated.
                */

                break;

            default:
                /*
                  Release any non-critical data structures.

                  The app received an unrecognized memory level value
                  from the system. Treat this as a generic low-memory message.
                */
                break;
        }
    }
}



