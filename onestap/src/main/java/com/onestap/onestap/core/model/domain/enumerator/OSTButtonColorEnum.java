/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.model.domain.enumerator;

import com.onestap.onestap.R;

/**
 * Created on 17/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public enum OSTButtonColorEnum {
    BLACK(R.color.black, android.R.color.white),
    GRAY_LIGH(R.color.gray_light, android.R.color.white),
    GRAY_DARK(R.color.green_dark, android.R.color.white),
    GREEN_LIGHT(R.color.green_normal, android.R.color.white),
    GREEN_NORMAL(R.color.green_normal, android.R.color.white),
    GREEN_DARK(R.color.green_dark, android.R.color.white);


    private int background;
    private int text;


    OSTButtonColorEnum(int background, int text) {
        this.background = background;
        this.text = text;
    }

    public int getBackgroundColor() {
        return background;
    }

    public int getTextColor() {
        return text;
    }
}
