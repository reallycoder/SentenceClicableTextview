package com.reallycoder.sentenceclicabletextview.bean;

import java.io.Serializable;

/**
 * author：armyjust on 2016/11/2 00:24
 * email：armyjust@126.com
 */
public class RawContent implements Serializable {
    public final static int Bold = 0;
    public final static int Italy = 1;

    public int style;
    public String content;

    public RawContent(int style, String content) {
        this.style = style;
        this.content = content;
    }
}
