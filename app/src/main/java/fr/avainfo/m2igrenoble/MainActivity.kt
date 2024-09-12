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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import fr.avainfo.m2igrenoble.activities.SecondActivity
import fr.avainfo.m2igrenoble.activities.ThirdActivity
import fr.avainfo.m2igrenoble.components.mainpage.Inputs
import fr.avainfo.m2igrenoble.ui.theme.M2IGrenobleTheme


class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val displayMetrics: DisplayMetrics = resources.displayMetrics;
		val height = displayMetrics.heightPixels / displayMetrics.density
		val width = displayMetrics.widthPixels / displayMetrics.density

		val bundle = Bundle()

		val fields = arrayOf("First Name", "Last Name", "Email", "Website");

		enableEdgeToEdge()
		setContent {
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

						Column {
							Text("Registration", style = TextStyle(fontSize = 24.sp))
							for (field in fields) {
								Inputs(field, bundle)
							}
						}
						Button(onClick = {
//							val toThirdActivity =
//								Intent(this@MainActivity, ThirdActivity::class.java);
//							toThirdActivity.putExtras(bundle);
//							startActivity(toThirdActivity)
							val toSecondActivity =
								Intent(this@MainActivity, SecondActivity::class.java);
							toSecondActivity.putExtras(bundle);
							startActivity(toSecondActivity)
						}) {
							Row {
								Text("Switch page")
								Icon(
									Icons.Rounded.KeyboardArrowRight,
									contentDescription = "Localized description"
								)
							}
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