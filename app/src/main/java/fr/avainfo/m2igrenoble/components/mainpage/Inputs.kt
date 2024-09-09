package fr.avainfo.m2igrenoble.components.mainpage

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Inputs(placeholder: String) {
	var text by remember { mutableStateOf("") }
	return OutlinedTextField(
		value = text,
		onValueChange = { text = it },
		placeholder = { Text(placeholder) }
	)
}