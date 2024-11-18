package com.example.catalogue_app

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private lateinit var thumbnailContainer: LinearLayout

    // Data for the catalogue
    private val titles = listOf(
        "Animal Catalogue: Guinea Pig",
        "Animal Catalogue: Wombat",
        "Animal Catalogue: Capybara",
        "Animal Catalogue: Chinchilla"
    )

    private val descriptions = listOf(
        "Imagine a furry little potato with legs, a snout that's basically a built-in snack detector. That's the guinea pig – nature's pocket-sized bundle of joy.\n\nDon't let their pudgy appearance fool you – guinea pigs are fierce explorers. Give them a maze, and they'll navigate it with the determination of a detective solving a case. And don't even get me started on their vocal talents – these little chatterboxes have a repertoire of squeaks, chirps, and wheeks that could rival a choir of angels.",
        "Adorable creature that's part teddy bear, part tank, and entirely adorable. That's the wombat – the furry bulldozer of the Australian outback.\n\nThese rotund rascals are like the engineers of the animal kingdom, with a talent for digging burrows that would make even the most seasoned miners jealous. Seriously, they're like the underground architects of the bush, crafting cozy homes with all the comforts of a luxury cave.",
        "Ever heard of a creature that looks like a guinea pig got super-sized and decided to take up yoga? That's the capybara for you! Capybaras are the ultimate socialites of the animal kingdom, forming tight-knit groups and casually hanging out in hot springs like they're having a spa day.\n\nIf there's one lesson to learn from these oversized hamsters, it's to live life at your own pace. So, just channel your inner capybara, find a sunny spot, and take a nap like a pro.",
        "A fuzzball so soft, it feels like you're petting a cloud, with eyes so big and adorable, they could melt the heart of even the grumpiest of grumps. That's the chinchilla – nature's equivalent of a living, breathing stuffed animal.\n\nThese tiny bundles of joy are like the Energizer Bunnies of the rodent world, bouncing around with boundless enthusiasm like they've had one too many espressos. Seriously, they've got moves that would put even the most hyperactive toddler to shame."
    )

    private val images = listOf(
        R.drawable.guinea_pig,  // Replace with actual drawable names
        R.drawable.wombat,
        R.drawable.capybara,
        R.drawable.chinchilla
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        viewPager = findViewById(R.id.viewPager)
        prevButton = findViewById(R.id.prevButton)
        nextButton = findViewById(R.id.nextButton)
        thumbnailContainer = findViewById(R.id.thumbnailContainer)

        // Set up ViewPager with the adapter
        val adapter = ViewPagerAdapter(titles, descriptions, images)
        viewPager.adapter = adapter

        // Navigation Buttons
        prevButton.setOnClickListener {
            val prevItem = viewPager.currentItem - 1
            if (prevItem >= 0) viewPager.currentItem = prevItem
        }

        nextButton.setOnClickListener {
            val nextItem = viewPager.currentItem + 1
            if (nextItem < titles.size) viewPager.currentItem = nextItem
        }

        // Add empty space at the start of the thumbnails
        val emptySpace = ImageView(this).apply {
            layoutParams = LinearLayout.LayoutParams(350, 350).apply {
                marginEnd = 16
            }
        }
        thumbnailContainer.addView(emptySpace)

        // Add thumbnails to the bottom navigation bar

        for (i in images.indices) {
            val thumbnail = ImageView(this).apply {
                setImageResource(images[i])
                layoutParams = LinearLayout.LayoutParams(350, 350).apply {
                    marginEnd = 16 // Adds spacing between thumbnails
                }

                setOnClickListener {
                    viewPager.currentItem = i // Navigate to the corresponding page
                }
            }
            thumbnailContainer.addView(thumbnail)
        }
    }
}
