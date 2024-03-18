/*
Copyright 2022 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.example.makeitso.common.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shifat.smarthallcatering.model.user.UserType

@Composable
fun BasicTextButton(@StringRes text: Int, modifier: Modifier, action: () -> Unit) {
  TextButton(onClick = action, modifier = modifier) { Text(text = stringResource(text)) }
}

@Composable
fun BasicButton(@StringRes text: Int, modifier: Modifier, action: () -> Unit) {
  Button(
    onClick = action,
    modifier = modifier,
    colors =
      ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
      )
  ) {
    Text(text = stringResource(text), fontSize = 16.sp)
  }
}

@Composable
fun UserTypeRadioButton( userType: UserType, onUserTypeChange: (UserType) -> Unit, modifier: Modifier ){

  Row(
    modifier= modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = "User Type:",
      style = MaterialTheme.typography.body1.merge(),
      modifier = Modifier.padding(start = 16.dp)
    )

    RadioButton(
      selected = (userType == UserType.Customer),
      onClick = { onUserTypeChange(UserType.Customer) }
    )
    Text(
      text = UserType.Customer.name,
      style = MaterialTheme.typography.body1.merge(),
      modifier = Modifier.padding(start = 0.dp)
    )

    RadioButton(
      selected = (userType == UserType.Provider),
      onClick = { onUserTypeChange(UserType.Provider) }
    )
    Text(
      text = UserType.Provider.name,
      style = MaterialTheme.typography.body1.merge(),
      modifier = Modifier.padding(start = 0.dp)
    )
  }

}
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun prev(){
 // UserTypeRadioButton(userType = UserType.Customer, onUserTypeChange = {})
}