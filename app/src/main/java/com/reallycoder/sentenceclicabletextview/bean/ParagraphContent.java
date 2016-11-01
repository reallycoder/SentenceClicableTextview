package com.reallycoder.sentenceclicabletextview.bean;

import java.io.Serializable;
import java.util.List;

/**
 * author：armyjust on 2016/11/2 00:29
 * email：armyjust@126.com
 */
public class ParagraphContent implements Serializable {

    public List<RawContent> rawContents;

    public ParagraphContent(List<RawContent> rawContents) {
        this.rawContents = rawContents;
    }
}
