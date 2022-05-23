package com.example.presentation.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.core.extensions.load
import com.example.presentation.R

class AwesomeCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val imgContainer: AppCompatImageView
    private val tvTitle: AppCompatTextView
    private val tvSubTitle: AppCompatTextView

    private var awesomeImage: Drawable? = null
        set(value) {
            if (value == null) {
                imgContainer.visibility = View.GONE
            } else {
                imgContainer.setImageDrawable(value)
                imgContainer.visibility = View.VISIBLE
            }
            field = value
        }

    private var title: String = ""
        set(value) {
            tvTitle.text = value
            field = value
        }

    private var subTitle: String = ""
        set(value) {
            tvSubTitle.text = value
            field = value
        }

    init {
        val view = View.inflate(context, R.layout.layout_awesome_custom_view, this)
        imgContainer = view.findViewById(R.id.imgContainer)
        tvTitle = view.findViewById(R.id.tvTitle)
        tvSubTitle = view.findViewById(R.id.tvSubTitle)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.AwesomeCustomView)
            awesomeImage = typedArray.getDrawable(R.styleable.AwesomeCustomView_awesomeImage)
            title = typedArray.getString(R.styleable.AwesomeCustomView_awesomeTitle) ?: title
            subTitle = typedArray.getString(R.styleable.AwesomeCustomView_awesomeSubTitle) ?: subTitle
            typedArray.recycle()
        }
    }

    fun setImage(path: Drawable) {
        imgContainer.setImageDrawable(path)
    }

    fun setImage(path: Int) {
        imgContainer.setImageResource(path)
    }

    fun setImage(path: String) {
        imgContainer.load(path)
        imgContainer.visibility = View.VISIBLE
    }
}