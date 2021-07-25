package com.sample.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    lateinit var campaignPagerAdapter: CampaignPagerAdapter
    lateinit var campaingPager: ViewPager2
    lateinit var indicator: CircleIndicator3
    lateinit var peopleRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        campaingPager = findViewById(R.id.campaign_pager)
        indicator = findViewById(R.id.indicator)
        peopleRecyclerView = findViewById(R.id.people_rv)

        campaignPagerAdapter = CampaignPagerAdapter(this)
        campaingPager.adapter = campaignPagerAdapter
        indicator.setViewPager(campaingPager)

        val peopleList =
            arrayListOf<PeopleItem>(
                PeopleItem(
                    "Maya is interested in",
                    "Sr. Business Manager... \\n Chief of Staff ",
                    "London \\u25CF Remotely "
                ),
                PeopleItem(
                    "Gabriela is interested in",
                    "Flutter Developer",
                    "London \\u25CF Remotely , \\n " +
                            "€ 400/day \\u25CF \\u2730 100%"
                ),
                PeopleItem(
                    "Maya is interested in",
                    "Sr. Business Manager... \\n Chief of Staff ",
                    "London \\u25CF Remotely "
                )
            )

        val adapter = PeopleListAdapter(peopleList)
        peopleRecyclerView.adapter = adapter
        val linearLayout = LinearLayoutManager(this)
        linearLayout.orientation = LinearLayoutManager.HORIZONTAL
        peopleRecyclerView.layoutManager = linearLayout

    }
}