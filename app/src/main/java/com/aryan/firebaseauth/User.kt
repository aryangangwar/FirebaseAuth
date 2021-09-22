package com.aryan.firebaseauth

data class User(val username: String? = null) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}
