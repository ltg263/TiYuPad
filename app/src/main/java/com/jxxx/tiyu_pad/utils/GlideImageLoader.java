package com.jxxx.tiyu_pad.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.jxxx.tiyu_pad.R;
import com.youth.banner.loader.ImageLoader;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


/**
 * Created by ShiXL on 2018/1/31.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //具体方法内容自己去选择，次方法是为了减少banner过多的依赖第三方包，所以将这个权限开放给使用者去选择
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Log.w("--->>","path:"+path);
        GlideImgLoader.loadImageViewRadius(context,(String) path,10,imageView);
    }
    public static void loadOneTimeGif(Context context, Object model, final ImageView imageView, final GifListener gifListener) {
        Glide.with(context).asGif().load(model).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     * Gif播放完毕回调
     */
    public interface GifListener {
        void gifPlayComplete();
    }
    /**
     *  Glide加载gif, 占满宽高
     * @param context
     * @param imageUrl
     * @param imageView
     */
    public void loadGifFixXY(Context context, Object imageUrl, final ImageView imageView) {
        //我这里是先获取屏幕的宽高，然后把屏幕的宽设为imageView的宽。
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = width;
        params.height = height;
        imageView.setLayoutParams(params);

        //glide是在listener()方法中传入一个RequestListener来设置当图片资源准备好了以后自定义的操作的。
        Glide.with(context).load(imageUrl).diskCacheStrategy(DiskCacheStrategy.NONE)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        //首先设置imageView的ScaleType属性为ScaleType.FIT_XY，让图片不按比例缩放，把图片塞满整个View。
                        imageView.setScaleType(ImageView.ScaleType.CENTER);
//                        if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
//                        }
                        // 得到当前imageView的宽度（我设置的是屏幕宽度），获取到imageView与图片宽的比例，然后通过这个比例去设置imageView的高
                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
                        int vw = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
                        float scale = (float) vw / (float) resource.getIntrinsicWidth();
                        int vh = Math.round(resource.getIntrinsicHeight() * scale);
                        params.height = vh + imageView.getPaddingTop() + imageView.getPaddingBottom();
                        imageView.setLayoutParams(params);
                        return false;
                    }
                })
//                .placeholder(R.drawable.bg_launch)
//                .error(R.drawable.bg_launch)
                .into(imageView);
    }
}