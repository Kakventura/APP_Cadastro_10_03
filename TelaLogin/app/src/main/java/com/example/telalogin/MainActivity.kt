package com.example.telalogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.telalogin.ui.theme.TelaLoginTheme
import com.example.telalogin.ui.theme.fonte
import com.example.telalogin.ui.theme.gradiente1
import com.example.telalogin.ui.theme.gradiente2


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaLoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tela()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tela() {
    Column (
        Modifier
            .height(700.dp)
            .fillMaxWidth()
    ) {
        Box (
            modifier = Modifier
                .height(150.dp)
                .background(

                    // Efeito da propriedade background, ele faz um gradiente
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            // Variáveis de cor definidas no arquivo "Color.kt" na pasta ui.theme
                            gradiente1, gradiente2, gradiente1
                        )
                    )
                )
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.icone),              contentDescription = "Ícone",
                modifier = Modifier
                    .offset(y = (40).dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))

        Column (
            Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Cadastre-se",
                fontSize = 40.sp, // Aumenta o tamanho da fonte
                color = fonte, // Define a cor do texto para a variável 'fonte'
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        // TEXTFIELDS
        Column(Modifier.align(Alignment.CenterHorizontally)) {
            // Variáveis para armazenar os futuros dados
            var nome by remember { mutableStateOf("") }
            var telefone by remember { mutableStateOf("") }
            var curso by remember { mutableStateOf("") }
            var serie by remember { mutableStateOf("") }
            var senha by remember { mutableStateOf("") }
            var passwordVisible by remember { mutableStateOf(false) } // Variável para controlar a visibilidade da senha

            // Cor da borda
            val borderColor = fonte // Use a variável 'fonte' para a cor da borda

            // Campo para nome
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = {
                    Text(
                        "Nome Completo:",
                        fontSize = 14.sp,
                        color = fonte,
                        fontFamily = FontFamily.Serif
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = borderColor, // Cor da borda quando o campo está focado
                    unfocusedBorderColor = borderColor // Cor da borda quando o campo não está focado
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo para telefone
            OutlinedTextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = {
                    Text(
                        "Telefone:",
                        fontSize = 14.sp,
                        color = fonte,
                        fontFamily = FontFamily.Serif
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = borderColor,
                    unfocusedBorderColor = borderColor
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo para curso
            OutlinedTextField(
                value = curso,
                onValueChange = { curso = it },
                label = {
                    Text(
                        "Curso:",
                        fontSize = 14.sp,
                        color = fonte,
                        fontFamily = FontFamily.Serif
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = borderColor,
                    unfocusedBorderColor = borderColor
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo para série
            OutlinedTextField(
                value = serie,
                onValueChange = { serie = it },
                label = {
                    Text(
                        "Série:",
                        fontSize = 14.sp,
                        color = fonte,
                        fontFamily = FontFamily.Serif
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = borderColor,
                    unfocusedBorderColor = borderColor
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo para senha
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = {
                    Text(
                        "Senha:",
                        fontSize = 14.sp,
                        color = fonte,
                        fontFamily = FontFamily.Serif
                    )
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    val description = if (passwordVisible) "Ocultar senha" else "Mostrar senha"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = borderColor,
                    unfocusedBorderColor = borderColor
                )
            )
            Spacer(modifier = Modifier.height(25.dp))

            // Botão de Cadastrar (Arredondado)
            Button(
                onClick = { /* Ação de cadastrar */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally) // Ocupa toda a largura disponível
                    .height(60.dp), // Define a altura do botão
                shape = RoundedCornerShape(20.dp), // Define o formato arredondado
                colors = ButtonDefaults.buttonColors(containerColor = fonte) // Define a cor do botão
            ) {
                Text("Enviar",
                    fontFamily = FontFamily.Serif
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaPreview() {
    TelaLoginTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Tela()
        }
    }
}