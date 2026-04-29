package com.example.petjetpackcomposeapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * second param of func - ColumnScope
 * it helps us (in this lambda) use certain modifiers which we could use specifically in Columns
 */
@Preview
@Composable
fun PreviewContainer(){

}

@Composable
fun ContainerColumn(name: String /*= "Test name"*/, content: @Composable ColumnScope.() -> Unit /*= {}*/) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(24.dp))/*, shape = RectangleShape*/
    ) {
        Column() {
            Text(name, fontSize = 23.sp, modifier = Modifier.padding(16.dp))
            content()
        }
    }
}