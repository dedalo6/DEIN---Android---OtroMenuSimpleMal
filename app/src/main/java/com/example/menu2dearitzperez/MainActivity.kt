package com.example.menu2dearitzperez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image: ImageView = findViewById(R.id. image)
        registerForContextMenu(image)

        val moreButton: ImageView = findViewById(R.id.more_actions_button)
        moreButton.setOnClickListener { view ->
            showMoreActionsMenu(view)
        }


    }


    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
        menu.setHeaderTitle(R.string.descripcion_imagen)
    }

    override fun onContextMenuClosed(menu: Menu) {
        Toast.makeText(this, "Menu cerrado", Toast.LENGTH_SHORT).show()
    }

    private fun showMoreActionsMenu (button: View) {
        val popupMenu = PopupMenu(this, button)
        menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.show()

    }
}