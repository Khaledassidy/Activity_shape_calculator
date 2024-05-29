package com.example.shapecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Area extends AppCompatActivity {
    Spinner spinner;
    EditText width,height,height2,base,redius;
    Button calculate;
    TextView finalanswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        //inflate
        spinner=findViewById(R.id.group_spinner_shape);
        width=findViewById(R.id.group_edittext_width);
        height=findViewById(R.id.group_edittext_height);
        height2=findViewById(R.id.group_edittext_height2);
        base=findViewById(R.id.group_edittext_base);
        redius=findViewById(R.id.group_edittext_redius);
        calculate=findViewById(R.id.group_button_calculate);
        finalanswer=findViewById(R.id.group_textview_result);


        //circle:pie * r * r
        //rectangle:W * h
        //Tringle:0.5 * base *h


        //spinner la 3abe l data b2alba fe tare2ten ya besta3mel xml mn 5elel string file 2aw tare2a tenye dynamic


        //bas nokbous 3ala l items b2alb l spinner fe tare2a
        //mna3mel on item selected listener yaene bas tekbous 3ala item b2alb l spinner
        //function1:onitemselected:bas tokbous 3ala item b2alb l spinner
        //function2:bas ma tekbous 3ala wala wa7de m lm item le b2alb l spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //bas nokbous 3ala l wa7de mn item btestad3a hay l function w byestad3a ma3a 4 eshay l houne l parameter
                //int position:l index ta3et l item le kabst 3lyha 7asab keef m3abayen b tadrej mn 0....etc


                //2awl she eza 7abet etba3 l index la la kel item ya3ne kel ma ekbous 3a wa7de etba3a bsta3mel class esmo (Toast) btetba3 resele b time m3ayane momken 7adedo wa2t 2alel dala resele la wa2t tawel
                //b2alb toast class fe method esma maketext hayde l method heye static ya3ne ma ba3mel object mena bas bestad3eha directly mn esm l class


                //hayde l method bte5od 3 eshaya l (context,stting:le bade eba3o,w length ta3et l toast adesh modeta)
                //context:howe l me7tawa eno ween mawjoude ya3ne masaln ne7na mawjouden hala2 b hay l activity fa lezm t2olo eno ne7na b hya l activity
                //context 3ebara 3an 3 eshya :esmlclass.this(Area.this),getBaseContext(),getApplicationContext() ba3den mneshra7oun
                //text:le badak tetba3o
                //e5er parameter howe howe integer length  ta3et l toast momken tkoun sha8lten:Toast.LENGTH_SHORT(mode 2alele),Toast.LENGTH_LONG(mode tawele)
                //w e5er she lezm 7ot .show bala l (.show)l toast metl 2elto ma bebeyen
                Toast.makeText(getBaseContext(), ""+position, Toast.LENGTH_SHORT).show();

                //ba3d ma 3refna kel heda hala2 badna na3mel eno iza keen position 0 so howe circle so 5fele 5asa2es ta3welet rectangle w tringle l houne base,height,height2
                //iza keen tringle ya3ne position 3 5fele 5asa2es l rectangle,wl circle
                //iza keen  rectangle ya3ne postion 2 5fele 5asa2es l tringle wl circle
                //so ya best3mle if else aw switch bas l a7san switch l2no l variable sebet

                switch (position){
                    case 0:
                        redius.setVisibility(View.VISIBLE);
                        width.setVisibility(view.GONE);
                        height.setVisibility(View.GONE);
                        base.setVisibility(View.GONE);
                        height2.setVisibility(View.GONE);
                        break;
                    case 1:
                        redius.setVisibility(View.GONE);
                        width.setVisibility(view.VISIBLE);
                        height.setVisibility(View.VISIBLE);
                        base.setVisibility(View.GONE);
                        height2.setVisibility(View.GONE);
                        break;
                    case 2:
                        redius.setVisibility(View.GONE);
                        width.setVisibility(view.GONE);
                        height.setVisibility(View.GONE);
                        base.setVisibility(View.VISIBLE);
                        height2.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //hala2 mar7let l 7ebesebt
        //kamen 3ande switch kamen bade 2a3ref eno ana aye 5terta bene2an 3lee ba3mel l 3amlye l 7esebeye
        //3ande 4 eshya:
        //            spinner.getSelectedItem();btredelak l item le enta kabst 3lee
        //            spinner.getSelectedItemId();btredelak l id lal item le enta kabst 3lee
        //            spinner.getSelectedItemPosition(); btredele l position lal item le enta kabst 3lee
        //            spinner.getSelectedView(); btredelak l view l howe l item le enta kabst 3lee


        //bas ana bade esta3mel spinner.getSelectedItemPosition(); btredele l position le ana ba3rfo w ba3mel switch w 7asab iza circle nateje pie*r*r,iza rectangle:width*height,iza rectangle 0.5*base *heigtt2


        calculate.setOnClickListener((view)->{
            int selecteditem = spinner.getSelectedItemPosition();
            double area=0;
            switch (selecteditem) {
                case 0:
                    //circle
                    String r = redius.getText().toString();
                    double rediuscalculation = Double.parseDouble(r);
                    double result = Math.PI * rediuscalculation * rediuscalculation;
                    area = result;
                    break;
                case 1:
                    //rectangle
                    String w = width.getText().toString();
                    String h = height.getText().toString();
                    double widthcalculation = Double.parseDouble(w);
                    double heightcalculation = Double.parseDouble(h);
                    double result1 = widthcalculation * heightcalculation;
                    area = result1;

                    break;
                case 2:
                    //tringle
                    String b = base.getText().toString();
                    String h2 = height2.getText().toString();
                    double basecalculation = Double.parseDouble(b);
                    double height2calculation = Double.parseDouble(h2);
                    double result2 = 0.5 * basecalculation * height2calculation;
                    area = result2;
                    break;


            }
            finalanswer.setText("" + area);


        });




    }


}