package fr.avainfo.m2igrenoble.components.mainpage

import android.util.DisplayMetrics
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RedInput(displayMetrics: DisplayMetrics) {
	return Box(
		Modifier
			.clip(shape = RoundedCornerShape(15.dp))
			.background(Color.Red)
			.fillMaxWidth()
			.height((displayMetrics.heightPixels / displayMetrics.density / 20).dp)
			.border(
				width = 5.dp,
				color = Color.Blue,
				shape = RoundedCornerShape(15.dp)
			)
	)
}