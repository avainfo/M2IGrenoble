package fr.avainfo.m2igrenoble.components.mainpage

import android.os.Bundle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.toLowerCase
import java.util.Locale

@Composable
fun Inputs(placeholder: String, b: Bundle) {
	var text by remember { mutableStateOf("") }

	val id = placeholder.replace(" ", "").lowercase(Locale.getDefault()); // First Name -> firstname

	return OutlinedTextField(
		value = text,
		onValueChange = {
			text = it;
			b.putString(
				id, it
			)
		},
		placeholder = { Text(placeholder) },
	)
}