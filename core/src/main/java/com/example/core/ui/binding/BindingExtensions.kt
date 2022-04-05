package com.example.core.ui.binding

import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> fragmentViewBinding(
    viewBinder: (View) -> T
): FragmentViewBindingProperty<T> = FragmentViewBindingProperty(viewBinder)

fun <T : ViewBinding> activityViewBinding(
    bindingInitializer: (LayoutInflater) -> T
): ActivityViewBindingProperty<T> = ActivityViewBindingProperty(bindingInitializer)