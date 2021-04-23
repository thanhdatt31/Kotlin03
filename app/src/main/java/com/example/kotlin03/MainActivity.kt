package com.example.kotlin03

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin03.adapter.SendAgainAdapter
import com.example.kotlin03.adapter.StatusAdapter
import com.example.kotlin03.model.Sender
import com.example.kotlin03.model.Status
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(),StatusAdapter.ClickListener {
    private var listSender: ArrayList<Sender> = arrayListOf()
    private var listStatus: ArrayList<Status> = arrayListOf()
    private var senderAdapter: SendAgainAdapter = SendAgainAdapter()
    private var statusAdapter: StatusAdapter = StatusAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false
        addDumpData()
        card.setOnClickListener {
            val intentCard = Intent(this@MainActivity,CardActivity::class.java)
            startActivity(intentCard)
        }
        recycler_view_send_again.apply {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(context, 4)
            adapter = senderAdapter
        }

        recycler_view_status.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = statusAdapter
        }

    }

    private fun addDumpData() {
        listSender.add(
            Sender(
                "Carlos Roca",
                "https://duckienad.com/wp-content/uploads/2020/04/son-tung-mtp-512x384.jpg"
            )
        )
        listSender.add(
            Sender(
                "Ruby Sanz",
"https://media.ex-cdn.com/EXP/media.travelmag.vn/files/thanhhuyen/2020/07/28/son-tung-mtp-lo-anh-dung-do-doi-voi-thieu-bao-tram-9-15848102443021860636400-1717.jpg"            )
        )
        listSender.add(
            Sender(
                "Mary Rich",
                "https://yt3.ggpht.com/ytc/AAUvwnhileP33kZPKIVRjrA9y6z0nwYIWXQpl7E7zWe0lg=s900-c-k-c0x00ffffff-no-rj"
            )
        )
        listSender.add(
            Sender(
                "José Porto",
                "https://i.pinimg.com/originals/8e/34/e3/8e34e3e4a570228fecaf7ce3c81328f0.jpg"
            )
        )
        senderAdapter.setData(listSender)
        listStatus.add(
            Status(
                "Maria Lujan",
                "Pago aceptado",
                50
            )
        )
        listStatus.add(
            Status(
                "Maria Lujan",
                "Pago aceptado",
                50
            )
        )
        listStatus.add(Status("El corte inglés", "Pago aceptado", -50))
        statusAdapter.setData(listStatus)

    }

    override fun onClickListener() {
        val intentPay = Intent(this@MainActivity,PayActivity::class.java)
        startActivity(intentPay)
    }
}