package fr.avainfo.m2igrenoble

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.avainfo.m2igrenoble.activities.SecondActivity
import fr.avainfo.m2igrenoble.components.mainpage.Inputs
import fr.avainfo.m2igrenoble.ui.theme.M2IGrenobleTheme


class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val displayMetrics: DisplayMetrics = resources.displayMetrics;
		val height = displayMetrics.heightPixels / displayMetrics.density
		val width = displayMetrics.widthPixels / displayMetrics.density

		val fields = arrayOf("First Name", "Last Name", "Email", "Website");
		val b = Bundle();



		val intent = Intent(this, SecondActivity::class.java)

		enableEdgeToEdge()
		setContent {
			val test = remember { mutableIntStateOf(0) }
			var test2 = 0;
			M2IGrenobleTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					Column(
						Modifier
							.padding(innerPadding)
							.fillMaxWidth(),
						horizontalAlignment = Alignment.CenterHorizontally,
					) {
						Image(
							painterResource(R.drawable.img),
							"",
							Modifier.fillMaxWidth(),
							contentScale = ContentScale.FillWidth
						)
						Spacer(Modifier.height(50.dp))

						Column {
							Text("Registration ${test.intValue} $test2", style = TextStyle(fontSize = 24.sp))
							for (field in fields) {
								Spacer(Modifier.height(50.dp))
								Inputs(field, b)
							}
						}
						Spacer(Modifier.height(50.dp))
						Button(
							onClick = {
								test2++;
//								intent.putExtras(b);
//								startActivity(intent)
							}
						) {
							Row {
								Text("Switch page")
								Icon(
									Icons.Rounded.KeyboardArrowRight,
									contentDescription = "Localized description"
								)
							}
						}
						Button(onClick = { test.intValue++ }) {
							Text("You have clicked ${test.intValue} times")
						}
					}
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	MainActivity()
}