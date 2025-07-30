package com.project.satyam.preganancytester.ui.component.vitals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.project.satyam.preganancytester.ui.theme.PreganancyTesterTheme
import com.project.satyam.preganancytester.ui.theme.PurpleDark
import com.project.satyam.preganancytester.ui.theme.PurpleDark1
import com.project.satyam.preganancytester.utils.VSpacer

@Preview
@Composable
private fun PreviewDailog() {
    PreganancyTesterTheme {
        AddVitalsDialog(onDismiss = {}) { _,_,_,_,_ ->

        }
    }
}

@Composable
fun AddVitalsDialog(
    onDismiss: () -> Unit,
    onSubmit: (String, String, String, String, String) -> Unit
) {
    var sysBp by remember { mutableStateOf("") }
    var diaBp by remember { mutableStateOf("") }
    var heartRate by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var babyKicks by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 8.dp,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text("Add Vitals", style = MaterialTheme.typography.titleLarge, color = PurpleDark1, fontWeight = FontWeight.Bold)

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = sysBp, onValueChange = { sysBp = it },
                        label = { Text("Sys BP") },
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = diaBp, onValueChange = { diaBp = it },
                        label = { Text("Dia BP") },
                        modifier = Modifier.weight(1f)
                    )
                }

                OutlinedTextField(
                    value = heartRate, onValueChange = { heartRate = it },
                    label = { Text("Heart Rate") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = weight, onValueChange = { weight = it },
                    label = { Text("Weight (kg)") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = babyKicks, onValueChange = { babyKicks = it },
                    label = { Text("Baby Kicks") },
                    modifier = Modifier.fillMaxWidth()
                )

                if (error != null) {
                    Text(text = error!!, color = Color.Red, style = MaterialTheme.typography.bodySmall)
                }

                VSpacer(20.dp)
                Button(
                    onClick = {
                        val valid = listOf(sysBp, diaBp, heartRate, weight, babyKicks).all { it.isNotBlank() }
                                && sysBp.toIntOrNull() != null
                                && diaBp.toIntOrNull() != null
                                && heartRate.toIntOrNull() != null
                                && weight.toIntOrNull() != null
                                && babyKicks.toIntOrNull() != null

                        if (valid) {
                            onSubmit(sysBp, diaBp, heartRate, weight, babyKicks)
                            onDismiss()
                        } else {
                            error = "Please fill all fields correctly"
                        }
                    },
                    modifier = Modifier.fillMaxWidth(.6f).align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PurpleDark)
                ) {
                    Text("Submit")
                }
            }
        }
    }
}
