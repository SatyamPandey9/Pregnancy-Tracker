package com.project.satyam.preganancytester.ui.component.vitals

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.satyam.preganancytester.R
import com.project.satyam.preganancytester.model.VitalsData
import com.project.satyam.preganancytester.ui.theme.LightPurple
import com.project.satyam.preganancytester.ui.theme.Purple
import com.project.satyam.preganancytester.ui.theme.PurpleDark
import com.project.satyam.preganancytester.utils.VSpacer


// Reusable composable for vitals card
@Composable
fun VitalsItem(vitals: VitalsData) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(LightPurple)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    InfoRow(R.drawable.ic_heart, "${vitals.heartRate} bpm")
                    VSpacer(8.dp)
                    InfoRow(R.drawable.ic_weight, "${vitals.weight} kg")
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    InfoRow(R.drawable.ic_bp, vitals.bloodPressure)
                    VSpacer(8.dp)
                    InfoRow(R.drawable.ic_kick, "${vitals.kicks} kicks")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PurpleDark)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = vitals.timestamp,
                    color = Color.White,
                    fontSize = 14.sp,
                )
            }
        }
    }
}

// Row with icon and text
@Composable
fun InfoRow(iconRes: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

// Preview function
@Preview(showBackground = true)
@Composable
fun VitalsItemPreview() {
    VitalsItem(
        vitals = VitalsData(
            id=0,
            heartRate = 90,
            weight = 68,
            bloodPressure = "120/80 mmHg",
            kicks = 15,
            timestamp = "Mon, 13 Jan 2025 03:45 pm"
        )
    )
}
