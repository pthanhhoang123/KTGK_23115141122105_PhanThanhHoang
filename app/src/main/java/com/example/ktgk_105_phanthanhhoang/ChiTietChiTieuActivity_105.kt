
package com.example.ktgk_105_phanthanhhoang

import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Chi tiết khoản chi"

        val tenKhoanChi_105 =
            intent.getStringExtra("tenKhoanChi_105").orEmpty()

        val soTien_105 =
            intent.getStringExtra("soTien_105").orEmpty()

        val ghiChu_105 =
            intent.getStringExtra("ghiChu_105").orEmpty()

        val layout_105 = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(24, 24, 24, 24)
        }

        val noiDung_105 = TextView(this).apply {
            text = "Tên khoản chi: $tenKhoanChi_105\n\n" +
                    "Số tiền: $soTien_105 VNĐ\n\n" +
                    "Ghi chú: $ghiChu_105"
            textSize = 18f
        }

        layout_105.addView(noiDung_105)
        setContentView(layout_105)
    }
}
