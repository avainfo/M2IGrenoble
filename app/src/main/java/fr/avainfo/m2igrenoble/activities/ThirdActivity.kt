package fr.avainfo.m2igrenoble.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import fr.avainfo.m2igrenoble.ui.theme.M2IGrenobleTheme

class ThirdActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)


		setContent {
			var tab by remember {
				mutableStateOf(
					arrayOf(
						"coucou0",
						"coucou1",
						"coucou2",
						"coucou3",
						"coucou4",
						"coucou5",
						"coucou6",
						"coucou7",
						"coucou8",
						"coucou9",
						"coucou10",
						"coucou11",
						"coucou12",
						"coucou13",
						"coucou14",
						"coucou15",
						"coucou16",
						"coucou17",
						"coucou18",
						"coucou19",
					)
				)
			}
			var newTab by remember { mutableStateOf(tab) }
			var textFieldValue by remember { mutableStateOf("") }

			M2IGrenobleTheme {
				Scaffold { innerPadding ->
					Column(Modifier.padding(innerPadding)) {
						Text("Third page")
						TextField(textFieldValue, {
							textFieldValue = it;
							newTab = tab.filter {
								filterValue -> filterValue.contains(it)
							}.toTypedArray()
						})

						Column { newTab.forEach { Text(it) } }

						Button(onClick = {
							tab += "coucou" + tab.size
							newTab = tab;
						}) {
							Text("Ajouter un coucou")
						}


						Button(onClick = {
							newTab =
								tab.filter { it.replace("coucou", "").toInt() >= 3 }.toTypedArray()
						}) {
							Text("Filter les coucous")
						}
					}
				}
			}
		}
	}
}