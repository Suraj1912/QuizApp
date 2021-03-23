package com.surajprojects.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Questions extends AppCompatActivity {

    Button submit, next;
    TextView que, head_txt, foot_txt, que_no;
    RadioGroup rg;
    RadioButton opt1, opt2, opt3, opt4;
    ArrayList<String> arr;
    String reg = "";

    String queNo[] = {"Que1", "Que2", "Que3", "Que4", "Que5"};

    String questions[] = {
            "How to get a response from an activity in Android?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?"
    };

    String answers[] = {"startActiivtyForResult()", "<=","this","interface","public"};

    String opt[] = {
            "startActivityToResult()","startActiivtyForResult()","Bundle()", "None of these",
            "&","&=","|=","<=",
            "import","this","catch","abstract",
            "Interface","interface","intf","Intf",
            "public","protected","private","All of the mentioned"
    };

    int flag = 0;
    public static int total_marks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        submit = findViewById(R.id.submit);
        next = findViewById(R.id.next);
        que = findViewById(R.id.que);
        que_no = findViewById(R.id.queNo);
        head_txt = findViewById(R.id.textheader);
        foot_txt = findViewById(R.id.textfooter);
        rg = findViewById(R.id.ans);
        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);

        que.setText(questions[flag]);
        que_no.setText(queNo[flag] + ": ");
        opt1.setText(opt[0]);
        opt2.setText(opt[1]);
        opt3.setText(opt[2]);
        opt4.setText(opt[3]);

        final Intent intent = getIntent();

        arr = (ArrayList<String>) intent.getSerializableExtra("reg");

        reg = arr.get(1);

        head_txt.setText("Hello " + arr.get(0));
        foot_txt.setText("Reg. No. " + arr.get(1));


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(rg.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(), "Please select options above", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton ans = findViewById(rg.getCheckedRadioButtonId());
                String anss = ans.getText().toString();
                if(anss.equals(answers[flag])){
                    total_marks++;
                }
                flag++;


                if (flag < questions.length) {
                    que.setText(questions[flag]);
                    que_no.setText(queNo[flag] + ": ");
                    opt1.setText(opt[flag * 4]);
                    opt2.setText(opt[flag * 4 + 1]);
                    opt3.setText(opt[flag * 4 + 2]);
                    opt4.setText(opt[flag * 4 + 3]);
                } else if(flag == questions.length){
                    submit.setVisibility(View.VISIBLE);
                    next.setVisibility(View.INVISIBLE);
                }


                rg.clearCheck();

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr.clear();
                LayoutInflater li = getLayoutInflater();
                View view = li.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast));

                ImageView img = view.findViewById(R.id.img);
                TextView tv = view.findViewById(R.id.tv);

                tv.setText("Marks obtained : " + total_marks);

                total_marks = 0;

                if(reg.equals("11811654"))
                    img.setImageResource(R.drawable.dummy1);
                else if(reg.equals("11811754"))
                    img.setImageResource(R.drawable.dummy2);
                else if(reg.equals("11809654"))
                    img.setImageResource(R.drawable.dummy3);
                else if(reg.equals("11862074"))
                    img.setImageResource(R.drawable.dummy1);
                else if(reg.equals("11892090"))
                    img.setImageResource(R.drawable.dummy2);
                else if(reg.equals("11811800"))
                    img.setImageResource(R.drawable.dummy3);
                else if(reg.equals("11809011"))
                    img.setImageResource(R.drawable.dummy1);
                else if(reg.equals("11899123"))
                    img.setImageResource(R.drawable.dummy2);


                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 0,30);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(view);
                toast.show();

                Intent i = new Intent(getApplicationContext(), Result.class);
                startActivity(i);
            }
        });
    }
}