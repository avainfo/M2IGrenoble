package fr.avainfo.m2igrenoble.components.mainpage

import android.os.Bundle
import androidx.compose.foundation.border
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Inputs(placeholder: String, bundle: Bundle) {
	var text by remember { mutableStateOf("") }

	return OutlinedTextField(
		value = text,
		onValueChange = {
			text = it;
			bundle.putString(placeholder, it);
		},
		placeholder = { Text(placeholder) },
		modifier = Modifier.border(
			width = 3.dp,
			color = androidx.compose.ui.graphics.Color.Black
		),
	);
}

@Preview
@Composable
private fun TextFieldPreview() {
	Inputs("coucou", Bundle())
}