package com.dikin.assignment2.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.dikin.assignment2.R

class AddPostFragment : Fragment(R.layout.add_post) {

    private lateinit var imageIV: ImageView
    private lateinit var captionET: EditText
    private lateinit var submitButton: Button
    private val PICK_IMAGE = 1
    private var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageIV = view.findViewById(R.id.add_post_image)
        captionET = view.findViewById(R.id.add_post_edit_text)
        submitButton = view.findViewById(R.id.add_post_submit)

        imageIV.setOnClickListener {
            openGallery()
        }

        submitButton.setOnClickListener {
            submitPost()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            imageUri = data.data
            imageIV.setImageURI(imageUri)
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE)
    }

    private fun submitPost() {
        val caption = captionET.text.toString()

        if (imageUri != null && caption.isNotEmpty()) {
            println("Uploading post with caption: $caption and image URI: $imageUri")
            imageIV.setImageResource(0)
            captionET.text.clear()
            imageUri = null
        } else {
            println("Please select an image and enter caption")
        }
    }
}