package fr.avainfo.m2igrenoble.components.secondpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Task(modifier: Modifier = Modifier, title: String, completed: Boolean) {
	return Box(
		Modifier
			.clip(RoundedCornerShape(CornerSize(10.dp)))
			.fillMaxWidth()
			.height(75.dp)
			.background(Color(0xFF201F1F))
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Start,
			modifier = Modifier
				.height(75.dp)
		) {
			Checkbox(completed, onCheckedChange = {})
			Text(
				title,
				style = TextStyle(
					if (completed) Color.Gray else Color.White,
					textDecoration = if (completed) TextDecoration.LineThrough else null,
					fontSize = 20.sp
				),
			)
		}
	};
}