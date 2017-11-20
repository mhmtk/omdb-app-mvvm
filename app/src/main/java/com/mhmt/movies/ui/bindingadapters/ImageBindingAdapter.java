package com.mhmt.movies.ui.bindingadapters;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageBindingAdapter {

  @BindingAdapter(value={"imageUrl", "placeholder"}, requireAll=false)
  public static void setImageUrl(ImageView imageView, String url, Drawable placeholder) {
    if (url == null) {
      imageView.setImageDrawable(null);
    } else {
      Picasso.with(imageView.getContext()).load(url).placeholder(placeholder).into(imageView);
    }
  }

}
