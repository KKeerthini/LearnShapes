package colan.com.learnshapes.guesstheshape;

import colan.com.learnshapes.R;

/**
 * Created by KEERTHINI on 7/20/2016.
 */

public enum DifferentShapes {

    OVAL(new int[]{R.drawable.oval_mirror, R.drawable.oval_ruby, R.drawable.oval_coin}),
    RHOMBUS(new int[]{R.drawable.rhombus_search, R.drawable.rhombus_sign, R.drawable.rhombus_kite}),
    CIRCLE(new int[]{R.drawable.circle_cd, R.drawable.circle_ball, R.drawable.circle_coins}),
    SQUARE(new int[]{R.drawable.square_chess, R.drawable.square_saltine, R.drawable.square_cushion}),
    TRIANGLE(new int[]{R.drawable.triangle_billiards, R.drawable.triangle_melon, R.drawable.triangle_riskwarning}),
    RECTANGLE(new int[]{R.drawable.rect_diary, R.drawable.rect_mobile, R.drawable.rect_creditcard});

    private final int[] drawables;

    private DifferentShapes(int[] drawable) {
        this.drawables = drawable;
    }

    public int[] getDrawable() {
        return drawables;
    }
    public void getShape()
    {

    }
}
