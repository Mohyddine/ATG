package com.codewithmehyo.androidtestatg.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Switch
import androidx.tv.material3.Text
import com.codewithmehyo.androidtestatg.R

@Composable
fun SubscriptionCard(
    onSubscriptionClick: () -> Unit,
    isSubscribed: Boolean,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.widthIn(max = 320.dp),
        onClick = { onSubscriptionClick() }
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(R.string.subscription_switch_label),
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = isSubscribed,
                onCheckedChange = {}
            )
        }
    }
}
