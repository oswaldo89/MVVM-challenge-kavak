/**
 * Created by Oswaldo GH on 15/03/21.
 */

package com.app.oswaldokavak.utils.extensions_functions

import android.widget.ImageView
import com.app.oswaldokavak.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadurl(url: String){
    val glideUrl = GlideUrl(
        url, LazyHeaders.Builder()
            .addHeader(
                "User-Agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit / 537.36(KHTML, like Gecko) Chrome  47.0.2526.106 Safari / 537.36"
            )
            .build()
    )
    Glide.with(context).load(glideUrl).apply( RequestOptions().placeholder(R.drawable.preview)).into(this)
}