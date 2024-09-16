package fr.avainfo.m2igrenoble.activities

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import fr.avainfo.m2igrenoble.components.secondpage.Task
import fr.avainfo.m2igrenoble.ui.theme.M2IGrenobleTheme
import java.net.URL


class SecondActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val SDK_INT = Build.VERSION.SDK_INT
		if (SDK_INT > 8) {
			val policy = ThreadPolicy.Builder().permitAll().build()
			StrictMode.setThreadPolicy(policy)
		}


		setContent {
			var text by remember { mutableStateOf("En attente de données...") }

			var tasks by remember { mutableStateOf(arrayOf(Todo(0, 0, "", false))) }

			val url = URL("https://jsonplaceholder.typicode.com/todos")
			val jsonString = url.readText()
			val gson = Gson()
			tasks = gson.fromJson(jsonString, Array<Todo>::class.java)

			M2IGrenobleTheme {
				Scaffold(Modifier) { innerPadding ->
					Column(
						Modifier
							.padding(innerPadding)
							.fillMaxSize()
					) {
						Box(
							Modifier
								.weight(1f)
								.background(Color(0xFF09A59B))
						) {
							Row(
								Modifier
									.fillMaxSize()
									.padding(horizontal = 15.dp),
								horizontalArrangement = Arrangement.SpaceBetween,
								verticalAlignment = Alignment.CenterVertically
							) {
								IconButton(
									onClick = {}, Modifier.size(50.dp)
								) {
									Icon(
										Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
										"",
										Modifier.size(50.dp)
									)
								}
								Text(
									"Todo List",
									fontSize = 25.sp,
									fontWeight = FontWeight.SemiBold,
								)
								IconButton(
									onClick = {}, Modifier.size(40.dp)
								) {
									Icon(
										Icons.Rounded.MoreVert, "", Modifier.size(40.dp)
									)
								}

							}
						}
						Column(
							Modifier
								.weight(6f)
								.background(Color(0xFF151515))
								.fillMaxSize()
						) {
							Box(
								Modifier
									.weight(1f)
									.fillMaxSize()
							)
							LazyColumn(
								Modifier
									.weight(4f)
									.fillMaxSize()
									.padding(horizontal = 20.dp),
								verticalArrangement = Arrangement.spacedBy(25.dp),
							) {
								items(tasks) { item ->
									Task(title = item.title, completed = item.completed)
								}
							}
							Box(
								Modifier
									.weight(1f)
									.fillMaxSize()
							) {
								Row(
									Modifier
										.fillMaxSize()
										.padding(end = 20.dp, bottom = 20.dp),
									verticalAlignment = Alignment.Bottom,
									horizontalArrangement = Arrangement.End
								) {
									Button(
										{},
										Modifier
											.size(75.dp)
											.clip(CircleShape)
									) {
										Icon(Icons.Rounded.Add, "")
									}
								}
							}
						}
					}
				}
			}
		}
	}
}

data class Todo(
	val userId: Int, val id: Int, val title: String, val completed: Boolean,
)