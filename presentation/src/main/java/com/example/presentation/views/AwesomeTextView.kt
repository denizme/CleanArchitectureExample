package com.example.presentation.views

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.TextViewCompat
import com.example.presentation.R
import com.google.android.material.textview.MaterialTextView

class AwesomeTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : MaterialTextView(context, attrs, defStyleAttr, defStyleRes) {

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.AwesomeTextView)
            //val titleStyleRes = typedArray.getResourceId(R.styleable.AwesomeTextView_awesomeTitleTextAppearance, R.style.TextAppearance_AppCompat_Title)
            val titleStyleRes = typedArray.getResourceId(
                R.styleable.AwesomeTextView_awesomeTitleTextAppearance,
                R.style.TextAppearance_MaterialComponents_Overline
            )
            TextViewCompat.setTextAppearance(this, titleStyleRes)
            typedArray.recycle()
        }
    }
}