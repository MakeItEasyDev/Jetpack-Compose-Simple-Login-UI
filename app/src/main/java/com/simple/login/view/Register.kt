package com.simple.login.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.simple.login.R
import com.simple.login.ui.theme.Purple500

@Composable
fun Register(navController: NavController) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val nameVal = remember { mutableStateOf("") }
    val emailVal = remember { mutableStateOf("") }
    val phoneVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }
    val confirmPasswordVal = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false)}
    val confirmPasswordVisibility = remember { mutableStateOf(false)}

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(R.drawable.register_img),
                    contentDescription = "Register Image",
                    modifier = Modifier
                        .width(175.dp)
                        .height(175.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.LightGray)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = nameVal.value,
                            onValueChange = { nameVal.value = it },
                            label = { Text(text = "Name") },
                            placeholder = { Text(text = "Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )

                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = { emailVal.value = it },
                            label = { Text(text = "Email Address") },
                            placeholder = { Text(text = "Email Address") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )

                        OutlinedTextField(
                            value = phoneVal.value,
                            onValueChange = { phoneVal.value = it },
                            label = { Text(text = "Phone Number") },
                            placeholder = { Text(text = "Phone Number") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                        )

                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = { passwordVal.value = it },
                            label = { Text(text = "Password") },
                            placeholder = { Text(text = "Password") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        passwordVisibility.value = !passwordVisibility.value
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.password_eye),
                                        contentDescription = "Password Eye",
                                        tint = if (passwordVisibility.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                                                    else PasswordVisualTransformation()
                        )

                        OutlinedTextField(
                            value = confirmPasswordVal.value,
                            onValueChange = { confirmPasswordVal.value = it },
                            label = { Text(text = "Password") },
                            placeholder = { Text(text = "Password") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.password_eye),
                                        contentDescription = "Password Eye",
                                        tint = if (confirmPasswordVisibility.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation()
                        )

                        Spacer(modifier = Modifier.padding(10.dp))

                        Button(
                            onClick = {
                                if (nameVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter the name!", Toast.LENGTH_SHORT).show()
                                } else if (emailVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter the email address!", Toast.LENGTH_SHORT).show()
                                } else if (phoneVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter the phone number!", Toast.LENGTH_SHORT).show()
                                } else if (passwordVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter password!", Toast.LENGTH_SHORT).show()
                                } else if (confirmPasswordVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter confirm password!", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, "Successfully Registered!", Toast.LENGTH_SHORT).show()
                                }
                            }
                        ) {
                            Text(text = "Sign Up", fontSize = 20.sp)
                        }

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(text = "Login Instead",
                            modifier = Modifier.clickable {
                                navController.navigate("login_page")
                            }
                        )
                    }
                }
            }
        }
    }
}