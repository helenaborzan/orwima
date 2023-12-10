package hr.ferit.helenaborzan.lv6.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.zad1.Recipe
import hr.ferit.helenaborzan.lv6.NavigationController
import hr.ferit.helenaborzan.lv6.R
import hr.ferit.helenaborzan.lv6.Routes
import hr.ferit.helenaborzan.lv6.data.recipes
import hr.ferit.helenaborzan.lv6.ui.theme.DarkGray
import hr.ferit.helenaborzan.lv6.ui.theme.LightGray
import hr.ferit.helenaborzan.lv6.ui.theme.Pink
import hr.ferit.helenaborzan.lv6.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview(showBackground = true)
fun RecipesScreen(navigation : NavController){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        ScreenTitle(title = "What would you like to cook today?",
            subtitle = "Good morning, Helena")
        SearchBar(iconResource = R.drawable.ic_search, labelText = "Search")
        RecipeCategories()
        RecipeList(navigation=navigation, recipes = recipes )
        Spacer(modifier = Modifier.size(12.dp))
        IconButton(iconResource = R.drawable.ic_plus, text = "Add new recipe"){}
    }
}

@Composable
@Preview(showBackground = true)
fun ShowRecipeScreen(){
    NavigationController()
}

@Composable
fun ScreenTitle(
    title : String,
    subtitle: String
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ){
        Text(
            text=subtitle,
            style = TextStyle(color = Color.Magenta, fontSize = 12.sp,
                fontWeight = FontWeight.Light, fontStyle = FontStyle.Italic
            ),
            modifier = Modifier.padding(horizontal = 15.dp)

        )
       Text(
           text = title,
           style=TextStyle(color = Color.Black, fontSize = 26.sp,
               fontWeight = FontWeight.Bold),
           modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
           )

    }
}

@ExperimentalMaterial3Api
@Composable
fun SearchBar(
    @DrawableRes iconResource: Int,
    labelText : String,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        placeholderColor = DarkGray,
        textColor = DarkGray,
        unfocusedLabelColor = DarkGray,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )
){
    var searchInput by remember { mutableStateOf("") }
    TextField(
        value = searchInput,
        onValueChange = { searchInput = it },
        label = {
            Text(text = labelText)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = labelText,
                tint = DarkGray,
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
        },
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun TabButton(
    text: String,
    isActive : Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(24.dp),
        elevation = null,
        colors = if (isActive) ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Pink
        )
        else ButtonDefaults.buttonColors(
            contentColor = DarkGray,
            containerColor = LightGray
        ),
        modifier = Modifier.fillMaxHeight(),
        onClick = { onClick() },
    ) {
        Text(text = text)
    }
}

@Composable
fun RecipeCategories(){
    var currentActiveButton by remember { mutableStateOf(0) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(44.dp)
    ){
        TabButton(
            text = "All",
            isActive = currentActiveButton == 0,
            modifier = Modifier.weight(1f)
        ) {
            currentActiveButton = 0
        }
        TabButton(
            text = "Breakfast",
            isActive = currentActiveButton == 1,
            modifier = Modifier.weight(1f)
        ) {
            currentActiveButton = 1
        }
        TabButton(
            text = "Lunch",
            isActive = currentActiveButton == 2,
            modifier = Modifier.weight(1f)
        ) {
            currentActiveButton = 2
        }
    }
}


@Composable
fun IconButton(
    @DrawableRes iconResource: Int,
    text : String,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Pink),
        onClick = {onClick()}
    ) {
        Row {
            Icon(
                painterResource(id = iconResource),
                contentDescription = text
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = text,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light)
            )
        }
    }
}

@Composable
fun Chip(
    text: String,
    backgroundColor: Color = White,
    textColor: Color = Pink
){
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ){
        Text(
            text = text,
            style = TextStyle( color = textColor, fontSize = 12.sp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeCard(
    @DrawableRes imageResource : Int,
    title : String,
    onClick: () -> Unit
){
    Box(modifier = Modifier
        .width(215.dp)
        .height(326.dp)){
        Card (shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxSize(),
            onClick = {onClick()}
        ){
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop

                )
        }
        Column (verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxHeight()
                .padding(12.dp)){
            Text(
                text = title,
                style = TextStyle (color = White,
                    fontSize = 12.sp, fontWeight = FontWeight.Bold
                )
            )
            Row{
                Chip(text = "30 min")
                Spacer(modifier = Modifier.size(4.dp))
                Chip(text = "4 ingredients")
            }
        }

    }
}
@Composable
fun RecipeList(
    recipes: List<Recipe>,
    navigation: NavController
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = "7 recipes",
                style = TextStyle(color = Color.DarkGray, fontSize =
                14.sp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_flame),
                contentDescription = "Flame",
                tint = Color.DarkGray,
                modifier = Modifier
                    .width(18.dp)
                    .height(18.dp)
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(recipes.size) {
                RecipeCard(
                    imageResource = recipes[it].imageResource,
                    title = recipes[it].title
                ){
                    navigation.navigate(Routes.getRecipeDetailsPath(it))
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

