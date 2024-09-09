package fr.avainfo.m2igrenoble.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import fr.avainfo.m2igrenoble.ui.theme.M2IGrenobleTheme

class SecondActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			M2IGrenobleTheme {
				Scaffold(Modifier) { innerPadding ->
					Column(Modifier.padding(innerPadding)) {
						for (key in intent.extras?.keySet()!!) {
							Text(key)
							intent.getStringExtra(key)?.let { Text(it) }
						}
						Button(onClick = { finish() }) {
							Text("back")
						}
					}
				}
			}
		}
	}
}