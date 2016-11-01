package com.reallycoder.sentenceclicabletextview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.reallycoder.sentenceclicabletextview.R;
import com.reallycoder.sentenceclicabletextview.bean.ParagraphContent;
import com.reallycoder.sentenceclicabletextview.bean.RawContent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<RawContent> rawContents;

    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        showData();
    }

    private void initViews(){
        tvContent = (TextView) findViewById(R.id.tv_content);
    }

    private void initData() {
        rawContents = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int style = i % 2;
            if (style == RawContent.Bold) {
                RawContent rawContent = new RawContent(style, "我是加粗的内容------" + i + "------");
                rawContents.add(rawContent);
            } else if (style == RawContent.Italy) {
                RawContent rawContent = new RawContent(style, "我是倾斜的内容------" + i + "------");
                rawContents.add(rawContent);
            }
        }
    }

    private void showData(){
        tvContent.setText("");
        for (RawContent rawContent : rawContents) {
            SentenceSpan span = new SentenceSpan(rawContent);
            SpannableString spannable = new SpannableString(rawContent.content);
            spannable.setSpan(span, 0, spannable.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            tvContent.append(spannable);
        }
        tvContent.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public class SentenceSpan extends ClickableSpan{
        private RawContent rawContent;

        public SentenceSpan(RawContent content) {
            this.rawContent = content;
        }

        @Override
        public void onClick(View widget) {
            Toast.makeText(widget.getContext(), rawContent.content, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            if (rawContent.style == rawContent.Bold){
                ds.setFakeBoldText(true);
            } else if (rawContent.style == rawContent.Italy){
                ds.setTextSkewX(-0.3f);
            }
        }
    }
}
