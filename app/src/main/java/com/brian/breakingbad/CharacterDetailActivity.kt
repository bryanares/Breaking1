package com.brian.breakingbad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class CharacterDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        val characterImage = findViewById<ImageView>(R.id.bBadDetailImageView)
        val characterName = findViewById<TextView>(R.id.bBadDetailName)
        val characterBirthday = findViewById<TextView>(R.id.bBadDetailBirthday)
        val characterNickname = findViewById<TextView>(R.id.bBadDetailNickname)
        val characterOccupation = findViewById<TextView>(R.id.bBadDetailOccupation)
        val characterShows = findViewById<TextView>(R.id.bBadDetailAppearance)
        val characterActor = findViewById<TextView>(R.id.bBadDetailActor)
        val characterStatus = findViewById<TextView>(R.id.bBadDetailStatus)


        Picasso.get().load(intent.getStringExtra("CharacterImage")).into(characterImage)
        characterName.text = intent.getStringExtra("CharacterName").toString()
        characterBirthday.text = intent.getStringExtra("CharacterBirthday").toString()
        characterNickname.text = intent.getStringExtra("CharacterNickname").toString()
        characterOccupation.text = intent.getStringExtra("CharacterOccupation").toString()
        characterShows.text = intent.getStringExtra("CharacterShows").toString()
        characterActor.text = intent.getStringExtra("CharacterActor").toString()
        characterStatus.text = intent.getStringExtra("CharacterStatus").toString()
    }
}