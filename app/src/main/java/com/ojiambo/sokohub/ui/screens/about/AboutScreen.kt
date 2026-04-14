package com.ojiambo.sokohub.ui.screens.about

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// ---------------- DATA MODEL ----------------
data class BusinessCard(
    val name: String,
    val title: String,
    val phone: String,
    val email: String,
    val color: Color
)

// ---------------- MAIN SCREEN ----------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {

    var search by remember { mutableStateOf("") }

    val cards = remember {
        mutableStateListOf(
            BusinessCard(
                "John Smith",
                "Business Consultant",
                "+1 234 567 890",
                "johnsmith@gmail.com",
                Color(0xFF64B5F6)
            ),
            BusinessCard(
                "Amanda Black",
                "Dentist",
                "+1 356 225 364",
                "amandablack@gmail.com",
                Color(0xFFE57373)
            ),
            BusinessCard(
                "David Hill",
                "Designer",
                "+1 189 235 894",
                "davidhill@gmail.com",
                Color(0xFFFFB74D)
            )
        )
    }
    Scaffold(

        // ---------------- TOP BAR ----------------
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Business Cards",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF3AB170),

                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = null,
                            tint = Color(0xFF3AB170)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color(0xFF333333),
                    navigationIconContentColor = Color(0xFF333333)
                )
            )
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            // ---------------- LIST ----------------
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 14.dp)
            ) {
                items(cards) { card ->
                    BusinessCardItem(card = card, onUpdate = { updatedCard ->
                        val index = cards.indexOf(card)
                        if (index != -1) {
                            cards[index] = updatedCard
                        }
                    })
                }
            }
        }
    }
}

// ---------------- CARD UI ----------------
@Composable
fun BusinessCardItem(
    card: BusinessCard,
    onUpdate: (BusinessCard) -> Unit
) {

    val context = LocalContext.current

    var showEdit by remember { mutableStateOf(false) }
    var showInfo by remember { mutableStateOf(false) }

    // ---------------- EDIT STATE ----------------
    var name by remember { mutableStateOf(card.name) }
    var title by remember { mutableStateOf(card.title) }
    var phone by remember { mutableStateOf(card.phone) }
    var email by remember { mutableStateOf(card.email) }

    // ---------------- INFO DIALOG ----------------
    if (showInfo) {
        AlertDialog(
            onDismissRequest = { showInfo = false },
            confirmButton = {
                TextButton(onClick = { showInfo = false }) {
                    Text("Close")
                }
            },
            title = { Text(card.name) },
            text = {
                Column {
                    Text("Role: ${card.title}")
                    Text("Phone: ${card.phone}")
                    Text("Email: ${card.email}")
                }
            }
        )
    }

    // ---------------- EDIT DIALOG ----------------
    if (showEdit) {
        AlertDialog(
            onDismissRequest = { showEdit = false },
            confirmButton = {

                TextButton(onClick = {
                    onUpdate(
                        card.copy(
                            name = name,
                            title = title,
                            phone = phone,
                            email = email
                        )
                    )
                    showEdit = false
                }) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(onClick = { showEdit = false }) {
                    Text("Cancel")
                }
            },
            title = { Text("Edit Business Card") },
            text = {
                Column {

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") }
                    )

                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Title") }
                    )

                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = { Text("Phone") }
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") }
                    )
                }
            }
        )
    }

    // ---------------- CARD UI ----------------
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = card.color)
    ) {

        Column(modifier = Modifier.padding(12.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(name, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text(title, fontSize = 15.sp, color = Color.White.copy(alpha = 0.85f))
                }

                Row {

                    // ✏️ EDIT
                    IconButton(onClick = {
                        showEdit = true
                    }) {
                        Icon(Icons.Default.Edit, contentDescription = null, tint = Color.White)
                    }

                    // ℹ️ INFO
                    IconButton(onClick = {
                        showInfo = true
                    }) {
                        Icon(Icons.Default.Info, contentDescription = null, tint = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 📞 CALL
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$phone")
                    }
                    context.startActivity(intent)
                }
            ) {
                Icon(Icons.Default.Call, contentDescription = null, tint = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text(phone, color = Color.White)
            }

            Spacer(modifier = Modifier.height(6.dp))

            // ✉️ EMAIL
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:$email")
                    }
                    context.startActivity(intent)
                }
            ) {
                Icon(Icons.Default.Email, contentDescription = null, tint = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text(email, color = Color.White)
            }
        }
    }
}

private fun Nothing?.startActivity(shareIntent: Intent) {}

// ---------------- PREVIEW ----------------
@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    AboutScreen(rememberNavController())
}