package com.codewithmehyo.androidtestatg.manager

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages the user's subscription status.
 *
 * @property context The application context.
 */
@Singleton
class SubscriptionManager @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    // The shared preferences file to store the subscription status.
    private val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    /**
     * Whether the user is subscribed or not.
     */
    var isSubscribed: Boolean
        get() = prefs.getBoolean("is_subscribed", false)
        set(value) = prefs.edit { putBoolean("is_subscribed", value) }
}