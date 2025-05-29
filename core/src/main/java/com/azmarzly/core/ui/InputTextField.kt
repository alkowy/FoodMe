package com.azmarzly.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azmarzly.core.ui.theme.FoodMeTheme

enum class InputType {
    NAME, EMAIL, PASSWORD
}

@Composable
fun InputTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    errorMessage: String? = null,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    inputType: InputType = InputType.NAME,
    trailingIcon: (@Composable (() -> Unit))? = null,
) {
    var passwordVisible by remember { mutableStateOf(false) }

    val isError = errorMessage != null

    val visualTransformation = when (inputType) {
        InputType.PASSWORD -> if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
        else -> VisualTransformation.None
    }

    val keyboardOptions = when (inputType) {
        InputType.EMAIL -> KeyboardOptions(keyboardType = KeyboardType.Email)
        InputType.PASSWORD -> KeyboardOptions(keyboardType = KeyboardType.Password)
        InputType.NAME -> KeyboardOptions.Default
    }

    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = label,
                    style = TextStyle(
                        fontSize = if (value.isEmpty()) 14.sp else 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            },
            singleLine = true,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            trailingIcon = {
                when (inputType) {
                    InputType.PASSWORD -> {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Filled.Star else Icons.Filled.Home,
                                contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    else -> trailingIcon?.invoke()
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = backgroundColor,
                unfocusedContainerColor = backgroundColor,
                errorContainerColor = backgroundColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                errorLabelColor = MaterialTheme.colorScheme.error,
                cursorColor = MaterialTheme.colorScheme.primary,
                errorCursorColor = MaterialTheme.colorScheme.error,
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                errorTextColor = MaterialTheme.colorScheme.onSurface
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
        )

        if (isError) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 0.dp),
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GenericTextFieldPreview() {
    FoodMeTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            InputTextField(
                value = "",
                onValueChange = {},
                label = "Name",
                inputType = InputType.NAME,
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant
            )

            InputTextField(
                value = "skibidi@gmail.com",
                onValueChange = { },
                label = "Email",
                inputType = InputType.EMAIL,
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant
            )

            InputTextField(
                value = "123123",
                onValueChange = {},
                label = "Password",
                inputType = InputType.PASSWORD,
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant
            )

            InputTextField(
                value = "marcin.hoffman",
                onValueChange = { },
                label = "Email",
                inputType = InputType.EMAIL,
                errorMessage = "error 123123",
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }
    }
}
