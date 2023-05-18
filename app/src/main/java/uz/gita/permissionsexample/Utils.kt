package uz.gita.permissionsexample

import android.app.Activity
import android.util.Log
import android.widget.Toast

fun logger(msg: String) {
    Log.d("AAA", msg)
}

fun Activity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}