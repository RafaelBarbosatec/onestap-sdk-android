/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.view.ui.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.onestap.onestap.R;

/**
 * Created on 17/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class OSTButton extends AppCompatButton implements View.OnClickListener {


    public OSTButton(Context context) {
       this(context, null);
    }

    public OSTButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.buttonStyle);
    }

    public OSTButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void onClick(View view) {

    }

    protected void init(){
        setOnClickListener(this);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.onestap_button_selector));
        setTextColor(ContextCompat.getColor(getContext(), android.R.color.white));
    }


}
