package hr.ferit.helenaborzan.lv6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import hr.ferit.helenaborzan.lv6.data.RecipeViewModel
import hr.ferit.helenaborzan.lv6.ui.theme.LV6Theme
import hr.ferit.helenaborzan.lv6.ui.RecipesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<RecipeViewModel>()
        setContent {
            LV6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    NavigationController(viewModel)
                }
            }
        }
    }
}

