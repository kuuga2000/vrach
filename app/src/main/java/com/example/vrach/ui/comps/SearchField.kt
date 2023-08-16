package com.example.vrach.ui.comps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun CustomSearchField(
    search: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        TextField(
            value = search,
            onValueChange = onValueChange,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFFf5f5f5),
                placeholderColor = Color(0xFFFBFBDBE),
                textColor = Color(0xFFF212020),
                focusedIndicatorColor = Color.Transparent, cursorColor = Color(0XFF070E14),
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedLeadingIconColor = Color(0XFF888D91),
                unfocusedTrailingIconColor = Color(0xFFF246BFD),

            ),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            trailingIcon = { Icon(imageVector = Icons.Default.List, contentDescription = "") },
            placeholder = { Text(text = "Search") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            )
        )
    }
}
