package com.example.littlelemon.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.DarkHighlight

@Composable
fun CustomTextField(label: String, value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
    Column {
        Text(text = label, modifier = Modifier.padding(bottom = 8.dp, top = 32.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = DarkHighlight, shape = RoundedCornerShape(12.dp))
                .padding(12.dp),
            textStyle = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun CustomTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column {
        Text(text = label, modifier = Modifier.padding(bottom = 8.dp, top = 32.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = DarkHighlight, shape = RoundedCornerShape(12.dp))
                .padding(12.dp),
            textStyle = MaterialTheme.typography.bodyLarge
        )
    }
}