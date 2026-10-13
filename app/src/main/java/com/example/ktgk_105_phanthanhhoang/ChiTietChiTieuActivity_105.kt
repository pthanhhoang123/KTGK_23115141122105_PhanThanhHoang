
package com.example.ktgk_105_phanthanhhoang

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Chi tiết khoản chi"

        // Nhận dữ liệu từ MainActivity
        val tenKhoanChi_105 =
            intent.getStringExtra("tenKhoanChi_105").orEmpty().trim()

        val soTienText_105 =
            intent.getStringExtra("soTien_105").orEmpty().trim()

        val ghiChu_105 =
            intent.getStringExtra("ghiChu_105").orEmpty().trim()

        // Kiểm tra tên khoản chi
        if (tenKhoanChi_105.isEmpty()) {
            Toast.makeText(
                this,
                "Tên khoản chi không được để trống!",
                Toast.LENGTH_LONG
            ).show()

            finish()
            return
        }

        // Kiểm tra số tiền
        val soTien_105 = soTienText_105.toDoubleOrNull()

        if (soTien_105 == null || !soTien_105.isFinite() || soTien_105 <= 0) {
            Toast.makeText(
                this,
                "Số tiền không hợp lệ! Vui lòng nhập số lớn hơn 0.",
                Toast.LENGTH_LONG
            ).show()

            finish()
            return
        }

        // Tạo giao diện
        val layout_105 = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(48, 32, 48, 32)
        }

        val tieuDe_105 = TextView(this).apply {
            text = "CHI TIẾT KHOẢN CHI"
            textSize = 24f
            gravity = Gravity.CENTER
        }

        val noiDung_105 = TextView(this).apply {
            text = "Tên khoản chi: $tenKhoanChi_105\n\n" +
                    "Số tiền: $soTien_105 VNĐ\n\n" +
                    "Ghi chú: " +
                    if (ghiChu_105.isBlank()) "Không có" else ghiChu_105

            textSize = 18f
            setPadding(0, 32, 0, 32)
        }

        // Nút quay lại màn hình chính
        val btnQuayLai_105 = Button(this).apply {
            text = "Quay lại"
            setOnClickListener {
                finish()
            }
        }

        layout_105.addView(tieuDe_105)
        layout_105.addView(noiDung_105)
        layout_105.addView(btnQuayLai_105)

        setContentView(layout_105)
    }
}
